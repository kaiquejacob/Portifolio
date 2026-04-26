# 📚 Sistema de Gestão de Biblioteca Pessoal

Projeto desenvolvido com **MySQL** para praticar os conceitos estudados no [Curso de Banco de Dados MySQL](https://www.youtube.com/playlist?list=PLHz_AreHm4dkBs-795Dsgvau_ekxg8g1r) do professor **Gustavo Guanabara** — Curso em Vídeo.

---

## 📋 Sobre o Projeto

Um sistema de banco de dados para gerenciar o acervo de uma biblioteca pessoal, incluindo livros, autores, gêneros, usuários e empréstimos.

O projeto aplica na prática todos os principais conceitos do curso:

| Conceito do Curso | Aplicação no Projeto |
|---|---|
| `CREATE TABLE` | 5 tabelas criadas com tipos de dados adequados |
| `FOREIGN KEY` | Livros → Autores, Livros → Gêneros, Empréstimos → Livros/Usuários |
| `INSERT INTO` | Dados reais de livros, autores e usuários |
| `SELECT` + `WHERE` | Filtros por ano, título, status de empréstimo |
| `ORDER BY` / `LIMIT` | Ranking dos mais emprestados, mais antigos etc. |
| `INNER JOIN` | Combinar livros com autores e gêneros |
| `LEFT JOIN` | Encontrar usuários/autores sem registros relacionados |
| `GROUP BY` + `HAVING` | Contagem por gênero, autores com mais de 1 livro |
| `UPDATE` / `DELETE` | Devolver livros, remover registros |
| `BACKUP` | Instruções de exportação no final deste README |

---

## 🗂️ Estrutura do Projeto

```
biblioteca-mysql/
├── schema.sql                   ← Criação do banco e das tabelas
├── dados.sql                    ← Inserção de dados de exemplo
├── queries/
│   ├── consultas_basicas.sql   ← SELECT, WHERE, ORDER BY, LIKE
│   ├── joins.sql               ← INNER JOIN e LEFT JOIN
│   └── relatorios.sql          ← Consultas analíticas completas
└── README.md
```

---

## 🧩 Diagrama Entidade-Relacionamento

```
┌─────────────┐       ┌─────────────┐       ┌─────────────┐
│   generos   │       │    livros   │       │   autores   │
│─────────────│       │─────────────│       │─────────────│
│ id (PK)     │◄──────│ id (PK)     │──────►│ id (PK)     │
│ nome        │  FK   │ titulo      │  FK   │ nome        │
└─────────────┘       │ ano         │       │ nacionalid. │
                      │ id_autor FK │       └─────────────┘
                      │ id_genero FK│
                      └──────┬──────┘
                             │
                      ┌──────▼──────┐       ┌─────────────┐
                      │ emprestimos │       │  usuarios   │
                      │─────────────│       │─────────────│
                      │ id (PK)     │       │ id (PK)     │
                      │ id_livro FK │       │ nome        │
                      │ id_usuario FK◄──────│ email       │
                      │ dt_emprést. │  FK   └─────────────┘
                      │ dt_devol.   │
                      └─────────────┘
```

---

## 🚀 Como Executar

### Pré-requisitos
- [MySQL](https://www.mysql.com/downloads/) 8.0+ instalado
- [XAMPP](https://www.apachefriends.org/) ou [WAMP](https://www.wampserver.com/) (opcional)
- MySQL Workbench ou phpMyAdmin (opcional, para interface visual)

### Passo a passo

**1. Clone o repositório:**
```bash
git clone https://github.com/seu-usuario/biblioteca-mysql.git
cd biblioteca-mysql
```

**2. Acesse o MySQL pelo terminal:**
```bash
mysql -u root -p
```

**3. Execute o schema (cria o banco e as tabelas):**
```bash
source schema.sql
```

**4. Execute os dados de exemplo:**
```bash
source dados.sql
```

**5. Explore as queries:**
```bash
source queries/consultas_basicas.sql
source queries/joins.sql
source queries/relatorios.sql
```

---

## 🔍 Exemplos de Consultas

### Listar livros com autor e gênero
```sql
SELECT
    l.titulo,
    a.nome  AS autor,
    g.nome  AS genero,
    l.ano
FROM livros l
INNER JOIN autores a ON l.id_autor  = a.id
INNER JOIN generos g ON l.id_genero = g.id
ORDER BY g.nome, l.titulo;
```

### Ver empréstimos em aberto
```sql
SELECT
    u.nome       AS usuario,
    l.titulo     AS livro,
    e.data_emprestimo,
    DATEDIFF(CURRENT_DATE, e.data_emprestimo) AS dias
FROM emprestimos e
INNER JOIN usuarios u ON e.id_usuario = u.id
INNER JOIN livros   l ON e.id_livro   = l.id
WHERE e.data_devolucao IS NULL;
```

### Livros mais emprestados
```sql
SELECT
    l.titulo,
    COUNT(e.id) AS total_emprestimos
FROM livros l
LEFT JOIN emprestimos e ON l.id = e.id_livro
GROUP BY l.id, l.titulo
ORDER BY total_emprestimos DESC
LIMIT 5;
```

---

## 💾 Backup e Restauração

**Exportar o banco de dados:**
```bash
mysqldump -u root -p biblioteca > backup_biblioteca.sql
```

**Restaurar o banco de dados:**
```bash
mysql -u root -p biblioteca < backup_biblioteca.sql
```

---

## 📖 Conceitos Abordados

- Criação de banco de dados e tabelas (`CREATE DATABASE`, `CREATE TABLE`)
- Tipos de dados: `INT`, `VARCHAR`, `DATE`, `YEAR`
- Restrições: `NOT NULL`, `UNIQUE`, `AUTO_INCREMENT`, `DEFAULT`
- Chave primária (`PRIMARY KEY`) e chave estrangeira (`FOREIGN KEY`)
- Manipulação de dados: `INSERT INTO`, `UPDATE`, `DELETE`, `TRUNCATE`
- Consultas: `SELECT`, `WHERE`, `ORDER BY`, `LIMIT`, `LIKE`
- Agrupamento: `GROUP BY`, `HAVING`, `COUNT`, `MIN`, `MAX`
- Relacionamentos: `INNER JOIN`, `LEFT JOIN` com múltiplas tabelas
- Funções de data: `DATEDIFF`, `CURRENT_DATE`
- Backup com `mysqldump`

---

## 👨‍🏫 Referência

Curso baseado no conteúdo do professor **Gustavo Guanabara**:  
🔗 [Curso de Banco de Dados MySQL — Curso em Vídeo](https://www.youtube.com/playlist?list=PLHz_AreHm4dkBs-795Dsgvau_ekxg8g1r)

---

## 📄 Licença

Este projeto é de uso livre para fins educacionais.
