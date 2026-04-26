-- ============================================================
--  SISTEMA DE GESTÃO DE BIBLIOTECA PESSOAL
--  Projeto baseado no Curso de MySQL - Gustavo Guanabara
--  Curso em Vídeo | cursoemvideo.com
-- ============================================================

-- Criando e selecionando o banco de dados
CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

-- ============================================================
-- TABELA: generos
-- Armazena os gêneros literários dos livros
-- ============================================================
CREATE TABLE generos (
    id      INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome    VARCHAR(50)  NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ============================================================
-- TABELA: autores
-- Armazena os autores dos livros
-- ============================================================
CREATE TABLE autores (
    id           INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome         VARCHAR(100) NOT NULL,
    nacionalidade VARCHAR(50) DEFAULT 'Desconhecida',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ============================================================
-- TABELA: livros
-- Tabela central: referencia autores e gêneros via FK
-- ============================================================
CREATE TABLE livros (
    id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
    titulo     VARCHAR(150) NOT NULL,
    ano        YEAR         NOT NULL,
    id_autor   INT UNSIGNED NOT NULL,
    id_genero  INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_livro_autor  FOREIGN KEY (id_autor)  REFERENCES autores(id),
    CONSTRAINT fk_livro_genero FOREIGN KEY (id_genero) REFERENCES generos(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ============================================================
-- TABELA: usuarios
-- Pessoas que podem pegar livros emprestados
-- ============================================================
CREATE TABLE usuarios (
    id    INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome  VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ============================================================
-- TABELA: emprestimos
-- Relaciona usuarios com livros + datas de empréstimo
-- ============================================================
CREATE TABLE emprestimos (
    id               INT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_livro         INT UNSIGNED NOT NULL,
    id_usuario       INT UNSIGNED NOT NULL,
    data_emprestimo  DATE         NOT NULL DEFAULT (CURRENT_DATE),
    data_devolucao   DATE                  DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_emp_livro    FOREIGN KEY (id_livro)   REFERENCES livros(id),
    CONSTRAINT fk_emp_usuario  FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
