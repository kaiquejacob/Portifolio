# 🐍 Python

Projetos e exercícios desenvolvidos em Python, cobrindo estruturas de dados, funções, manipulação de arquivos e lógica de programação.

---

## 📂 Projetos

---

### 📒 Sistema de Agenda
**Arquivo:** [`sistema_de_agenda.py`](./sistema_de_agenda.py)

Agenda de contatos completa com menu interativo, operações de CRUD e persistência de dados.

**Funcionalidades:**
- Incluir, alterar, excluir e visualizar contatos
- Suporte a múltiplas formas de contato por pessoa (telefone, e-mail, endereço)
- Exportar agenda para `.txt` e `.json`
- Importar agenda a partir de `.json`

**Conceitos aplicados:**
- Dicionários e listas aninhadas
- `**kwargs` para parâmetros dinâmicos
- Leitura e escrita de arquivos com `open()` e `json`
- Funções documentadas com docstrings

**Como executar:**
```bash
python sistema_de_agenda.py
```

---

### 🎓 Sistema Acadêmico UNIP
**Arquivo:** [`unip.py`](./unip.py)

Sistema de cadastro de alunos e notas seguindo as regras de aprovação da UNIP, com suporte a múltiplas matérias por aluno.

**Funcionalidades:**
- Cadastrar alunos com nome, RA, curso e semestre
- Cadastrar notas (NP1, NP2 e PIM) por matéria
- Cálculo automático de média ponderada
- Lógica de aprovação direta, exame e reprovação
- Busca de aluno por RA

**Conceitos aplicados:**
- Listas de dicionários
- Funções com responsabilidades separadas
- Estruturas de repetição e condicionais

**Como executar:**
```bash
python unip.py
```

---

### ⚡ Exercícios de Funções
**Arquivo:** [`funcao.py`](./funcao.py)

Calculadora de velocidade média e conversor de temperatura com menu interativo.

**Funcionalidades:**
- Calcular velocidade média com unidade de medida configurável
- Converter temperatura entre Celsius e Fahrenheit
- Tratamento de divisão por zero

**Conceitos aplicados:**
- Funções com tipagem explícita de parâmetros
- Parâmetros com valor padrão (`default`)
- Menu interativo com `while`

**Como executar:**
```bash
python funcao.py
```

---

## 🛠️ Requisitos

- Python 3.x
- Nenhuma biblioteca externa necessária
