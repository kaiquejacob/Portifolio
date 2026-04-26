-- ============================================================
--  JOINS — INNER JOIN, LEFT JOIN, múltiplas tabelas
--  Conceitos: Aulas 14, 15 e 16 do Curso em Vídeo
-- ============================================================

USE biblioteca;

-- 1. Listar livros com o nome do autor (INNER JOIN simples)
SELECT
    l.titulo,
    a.nome AS autor,
    l.ano
FROM livros l
INNER JOIN autores a ON l.id_autor = a.id
ORDER BY l.titulo;

-- 2. Listar livros com autor E gênero (INNER JOIN com 3 tabelas)
SELECT
    l.titulo,
    a.nome      AS autor,
    g.nome      AS genero,
    l.ano
FROM livros l
INNER JOIN autores a ON l.id_autor  = a.id
INNER JOIN generos g ON l.id_genero = g.id
ORDER BY g.nome, l.titulo;

-- 3. Ver empréstimos com nome do usuário e título do livro
SELECT
    u.nome              AS usuario,
    l.titulo            AS livro,
    e.data_emprestimo,
    e.data_devolucao
FROM emprestimos e
INNER JOIN usuarios u ON e.id_usuario = u.id
INNER JOIN livros   l ON e.id_livro   = l.id
ORDER BY e.data_emprestimo DESC;

-- 4. Listar APENAS os empréstimos em aberto
SELECT
    u.nome              AS usuario,
    l.titulo            AS livro,
    e.data_emprestimo   AS desde
FROM emprestimos e
INNER JOIN usuarios u ON e.id_usuario = u.id
INNER JOIN livros   l ON e.id_livro   = l.id
WHERE e.data_devolucao IS NULL
ORDER BY e.data_emprestimo;

-- 5. Usuários que NUNCA pegaram livros (LEFT JOIN)
SELECT
    u.nome,
    u.email
FROM usuarios u
LEFT JOIN emprestimos e ON u.id = e.id_usuario
WHERE e.id IS NULL;

-- 6. Autores que não têm nenhum livro cadastrado (LEFT JOIN)
SELECT
    a.nome,
    a.nacionalidade
FROM autores a
LEFT JOIN livros l ON a.id = l.id_autor
WHERE l.id IS NULL;

-- 7. Livros com autor e quantas vezes foram emprestados
SELECT
    l.titulo,
    a.nome  AS autor,
    COUNT(e.id) AS vezes_emprestado
FROM livros l
INNER JOIN autores a ON l.id_autor = a.id
LEFT JOIN  emprestimos e ON l.id   = e.id_livro
GROUP BY l.id, l.titulo, a.nome
ORDER BY vezes_emprestado DESC;
