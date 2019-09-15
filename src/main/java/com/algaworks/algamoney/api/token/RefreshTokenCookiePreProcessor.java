package com.algaworks.algamoney.api.token;

import org.apache.catalina.util.ParameterMap;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RefreshTokenCookiePreProcessor implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String requestURI = req.getRequestURI();
        String parameter = req.getParameter("grant_type");


        if(requestURI.equalsIgnoreCase("/oauth/token")
            && parameter.equalsIgnoreCase("refresh_token")
            && req.getCookies() != null){

            String refreshToken =
                    Stream.of(req.getCookies())
                    .filter(cookie -> cookie.getName().equalsIgnoreCase("refreshToken"))
                    .findFirst()
                    .map(cookie -> cookie.getValue())
                    .orElse(null);

            req = new MyServletRequestWrapper(req, refreshToken);

        }

        filterChain.doFilter(req, servletResponse);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    static class MyServletRequestWrapper extends HttpServletRequestWrapper{

        private String refreshToken;

        public MyServletRequestWrapper(HttpServletRequest request, String refreshToken) {
            super(request);
            this.refreshToken = refreshToken;
        }


        @Override
        public Map<String, String[]> getParameterMap() {

            ParameterMap<String, String[]> map = new ParameterMap<>(getRequest().getParameterMap());
            map.put("refresh_token", new String[]{this.refreshToken});
            map.setLocked(true);
            return map;
        }
    }


}
