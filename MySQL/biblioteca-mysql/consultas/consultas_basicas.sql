-- ============================================================
--  CONSULTAS BÁSICAS — SELECT, WHERE, ORDER BY, LIKE
--  Conceitos: Aulas 11, 12 e 13 do Curso em Vídeo
-- ============================================================

USE biblioteca;

-- 1. Listar todos os livros
SELECT * FROM livros;

-- 2. Listar todos os autores em ordem alfabética
SELECT nome, nacionalidade
FROM autores
ORDER BY nome ASC;

-- 3. Listar livros publicados depois de 1950
SELECT titulo, ano
FROM livros
WHERE ano > 1950
ORDER BY ano ASC;

-- 4. Buscar livro pelo título (busca parcial com LIKE)
SELECT titulo, ano
FROM livros
WHERE titulo LIKE '%Anéis%';

-- 5. Listar os 5 livros mais antigos
SELECT titulo, ano
FROM livros
ORDER BY ano ASC
LIMIT 5;

-- 6. Contar quantos livros existem no acervo
SELECT COUNT(*) AS total_livros FROM livros;

-- 7. Contar livros por autor
SELECT id_autor, COUNT(*) AS qtd_livros
FROM livros
GROUP BY id_autor
ORDER BY qtd_livros DESC;

-- 8. Ano do livro mais antigo e mais recente
SELECT MIN(ano) AS mais_antigo, MAX(ano) AS mais_recente
FROM livros;

-- 9. Listar usuários com e-mail do Gmail
SELECT nome, email
FROM usuarios
WHERE email LIKE '%@gmail.com';

-- 10. Listar empréstimos ainda não devolvidos
SELECT *
FROM emprestimos
WHERE data_devolucao IS NULL;
