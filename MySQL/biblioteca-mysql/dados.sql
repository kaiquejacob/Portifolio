-- ============================================================
--  DADOS DE EXEMPLO — BIBLIOTECA PESSOAL
--  Execute DEPOIS do schema.sql
-- ============================================================

USE biblioteca;

-- ============================================================
-- GÊNEROS
-- ============================================================
INSERT INTO generos (nome) VALUES
    ('Romance'),
    ('Ficção Científica'),
    ('Fantasia'),
    ('Thriller'),
    ('Não-ficção'),
    ('Terror'),
    ('Aventura');

-- ============================================================
-- AUTORES
-- ============================================================
INSERT INTO autores (nome, nacionalidade) VALUES
    ('Machado de Assis',      'Brasileira'),
    ('Clarice Lispector',     'Brasileira'),
    ('George Orwell',         'Britânica'),
    ('J.R.R. Tolkien',        'Britânica'),
    ('Agatha Christie',       'Britânica'),
    ('Isaac Asimov',          'Americana'),
    ('Stephen King',          'Americana'),
    ('Gabriel García Márquez','Colombiana');

-- ============================================================
-- LIVROS
-- ============================================================
INSERT INTO livros (titulo, ano, id_autor, id_genero) VALUES
    ('Dom Casmurro',                     1899, 1, 1),
    ('Memórias Póstumas de Brás Cubas',  1881, 1, 1),
    ('A Hora da Estrela',                1977, 2, 1),
    ('Perto do Coração Selvagem',        1943, 2, 1),
    ('1984',                             1949, 3, 2),
    ('A Revolução dos Bichos',           1945, 3, 5),
    ('O Senhor dos Anéis',               1954, 4, 3),
    ('O Hobbit',                         1937, 4, 3),
    ('Assassinato no Expresso Oriente',  1934, 5, 4),
    ('E Não Sobrou Nenhum',              1939, 5, 4),
    ('Fundação',                         1951, 6, 2),
    ('Eu, Robô',                         1950, 6, 2),
    ('It — A Coisa',                     1986, 7, 6),
    ('O Iluminado',                      1977, 7, 6),
    ('Cem Anos de Solidão',              1967, 8, 1),
    ('Amor nos Tempos do Cólera',        1985, 8, 1);

-- ============================================================
-- USUÁRIOS
-- ============================================================
INSERT INTO usuarios (nome, email) VALUES
    ('Ana Paula Silva',    'ana.silva@email.com'),
    ('Bruno Costa',        'bruno.costa@email.com'),
    ('Carla Mendes',       'carla.mendes@email.com'),
    ('Diego Ferreira',     'diego.ferreira@email.com'),
    ('Elena Rodrigues',    'elena.rodrigues@email.com');

-- ============================================================
-- EMPRÉSTIMOS
-- ============================================================
INSERT INTO emprestimos (id_livro, id_usuario, data_emprestimo, data_devolucao) VALUES
    -- Devolvidos
    (1,  1, '2024-01-05', '2024-01-19'),
    (5,  2, '2024-01-10', '2024-01-24'),
    (7,  3, '2024-02-01', '2024-02-20'),
    (11, 4, '2024-02-15', '2024-03-01'),
    (15, 5, '2024-03-01', '2024-03-18'),
    (3,  1, '2024-03-10', '2024-03-24'),
    (13, 2, '2024-04-01', '2024-04-20'),
    -- Em aberto (sem devolução)
    (1,  3, '2024-11-01', NULL),
    (5,  4, '2024-11-10', NULL),
    (9,  5, '2024-11-15', NULL),
    (7,  1, '2024-12-01', NULL),
    (13, 2, '2024-12-05', NULL);
