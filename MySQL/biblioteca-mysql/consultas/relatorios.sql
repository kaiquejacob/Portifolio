-- ============================================================
--  RELATÓRIOS — Consultas analíticas e de negócio
--  Combinação de: JOIN + GROUP BY + ORDER BY + HAVING
-- ============================================================

USE biblioteca;

-- 1. Livros mais emprestados (top 5)
SELECT
    l.titulo,
    a.nome          AS autor,
    COUNT(e.id)     AS total_emprestimos
FROM livros l
INNER JOIN autores     a ON l.id_autor  = a.id
LEFT JOIN  emprestimos e ON l.id        = e.id_livro
GROUP BY l.id, l.titulo, a.nome
ORDER BY total_emprestimos DESC
LIMIT 5;

-- 2. Usuário mais ativo (quem mais pegou livros)
SELECT
    u.nome,
    u.email,
    COUNT(e.id) AS total_emprestimos
FROM usuarios u
INNER JOIN emprestimos e ON u.id = e.id_usuario
GROUP BY u.id, u.nome, u.email
ORDER BY total_emprestimos DESC
LIMIT 1;

-- 3. Quantidade de livros por gênero
SELECT
    g.nome      AS genero,
    COUNT(l.id) AS qtd_livros
FROM generos g
LEFT JOIN livros l ON g.id = l.id_genero
GROUP BY g.id, g.nome
ORDER BY qtd_livros DESC;

-- 4. Quantidade de livros por nacionalidade do autor
SELECT
    a.nacionalidade,
    COUNT(l.id) AS qtd_livros
FROM autores a
INNER JOIN livros l ON a.id = l.id_autor
GROUP BY a.nacionalidade
ORDER BY qtd_livros DESC;

-- 5. Autores com mais de 1 livro cadastrado
SELECT
    a.nome,
    a.nacionalidade,
    COUNT(l.id) AS qtd_livros
FROM autores a
INNER JOIN livros l ON a.id = l.id_autor
GROUP BY a.id, a.nome, a.nacionalidade
HAVING qtd_livros > 1
ORDER BY qtd_livros DESC;

-- 6. Usuários com empréstimos pendentes há mais de 30 dias
SELECT
    u.nome,
    u.email,
    l.titulo,
    e.data_emprestimo,
    DATEDIFF(CURRENT_DATE, e.data_emprestimo) AS dias_em_atraso
FROM emprestimos e
INNER JOIN usuarios u ON e.id_usuario = u.id
INNER JOIN livros   l ON e.id_livro   = l.id
WHERE
    e.data_devolucao IS NULL
    AND DATEDIFF(CURRENT_DATE, e.data_emprestimo) > 30
ORDER BY dias_em_atraso DESC;

-- 7. Resumo geral do acervo
SELECT
    (SELECT COUNT(*) FROM livros)           AS total_livros,
    (SELECT COUNT(*) FROM autores)          AS total_autores,
    (SELECT COUNT(*) FROM usuarios)         AS total_usuarios,
    (SELECT COUNT(*) FROM emprestimos)      AS total_emprestimos,
    (SELECT COUNT(*) FROM emprestimos
     WHERE data_devolucao IS NULL)          AS emprestimos_abertos;
