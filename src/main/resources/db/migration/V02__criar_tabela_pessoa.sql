CREATE TABLE pessoa (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(80) NOT NULL,
    ativo TINYINT NOT NULL,
    logradouro VARCHAR(100),
    numero VARCHAR(10),
    complemento VARCHAR(100),
    bairro VARCHAR(80),
    cep VARCHAR(12),
    cidade VARCHAR(80),
    estado VARCHAR(80)
)ENGINE=InnoDB CHARSET=utf8;

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES
('George Lucas Bentes Nunes', 1, 'Rua Professor Lázaro Gonçalves', '402', 'BL-B, 2a Etapa', 'Japiim', '69077-747', 'Manaus', 'AM'),
('Maura Augusta Trindade Bentes', 1, 'Rua Professor Lázaro Gonçalves', '402', 'BL-B, 2a Etapa', 'Japiim', '69077-747', 'Manaus', 'AM'),
('Ricardo Henrique Santins', 1, 'Rua Benjamin Lima', '313', '', 'São Jorge', '69000-000', 'Manaus', 'AM'),
('Abraão Melo', 1, 'Rua Tucanos', '212', '', 'Coroado', '69000-000', 'Manaus', 'AM');