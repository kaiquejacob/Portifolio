<div align="center">

<img src="https://readme-typing-svg.demolab.com?font=JetBrains+Mono&weight=600&size=18&duration=2500&pause=700&color=2F81F7&center=true&vCenter=true&width=780&lines=%5BSYSTEM%5D+BANKING+SYSTEM+ONLINE;%5BSYSTEM%5D+LOADING+ACCOUNTS+MODULE...;%5BSYSTEM%5D+EXCEPTION+HANDLER+ACTIVE;%5BSYSTEM%5D+READY+FOR+TRANSACTIONS..." alt="Typing Animation">

<img src="https://capsule-render.vercel.app/api?type=waving&height=160&color=0:05070A,50:0B1F3A,100:061A36&text=SISTEMA%20BANC%C3%81RIO&fontSize=40&fontColor=E6F1FF&fontAlignY=40&desc=KAIQUE%20JACOB%20%7C%20JAVA%20CONSOLE%20PROJECT&descAlignY=65&descSize=15" width="100%" alt="Sistema Bancário Banner">

</div>

---

<div align="center">

![Java](https://img.shields.io/badge/Java%2021%2B-0B0F14?style=for-the-badge&logo=openjdk&logoColor=2F81F7)
![Status](https://img.shields.io/badge/Status-Evolving-0B0F14?style=for-the-badge&logo=github&logoColor=2F81F7)
![Focus](https://img.shields.io/badge/Focus-Exce%C3%A7%C3%B5es%2C%20Valida%C3%A7%C3%A3o%20%26%20Persist%C3%AAncia-0B0F14?style=for-the-badge&logo=java&logoColor=2F81F7)

</div>

## SOBRE`

Sistema de gerenciamento de contas bancárias via console, desenvolvido em **Java**. Permite criar contas (Corrente, Poupança ou Investimento), depositar, sacar, consultar extrato, listar e remover contas — com validação de dados, tratamento de exceções customizadas e persistência em arquivo, garantindo que os dados sobrevivam ao encerrar o programa.

Projeto usado como aplicação prática dos conceitos estudados na Maratona Java (DevDojo), evoluindo de forma incremental conforme novos módulos do curso são concluídos.

---

## CONCEITOS APLICADOS`

```text
SISTEMA BANCÁRIO

[✓] Herança e classes abstratas (ContaBancaria → Corrente, Poupança, Investimento)
[✓] Polimorfismo (calcularExtrato() e sacar() sobrescritos por subclasse)
[✓] Encapsulamento
[✓] Enumeração (TipoConta)
[✓] Exceções customizadas checked
[✓] Expressões regulares (validação de nome e email)
[✓] Validação de CPF (algoritmo de dígito verificador)
[✓] Regra de negócio para remoção de conta (saldo zerado obrigatório)
[✓] Data de abertura da conta (LocalDate + DateTimeFormatter)
[✓] Persistência de dados em arquivo (IO: BufferedReader/BufferedWriter + try-with-resources)
[✓] Sobrecarga de construtor (preservação de dados originais ao recarregar)

[→] Próximos módulos e melhorias
```

---

## FUNCIONALIDADES`

| Operação | Descrição |
|---|---|
| 📝 Criar conta | Corrente, Poupança ou Investimento — com validação de nome, CPF e email |
| 💰 Depositar | Adiciona valor à conta, localizada pelo CPF |
| 💸 Sacar | Debita valor da conta; Conta Corrente aplica taxa combinada de R$10 |
| 📊 Ver extrato | Exibe saldo e informações específicas do tipo de conta |
| 📋 Listar contas | Lista todas as contas cadastradas no banco |
| ❌ Remover conta | Remove conta pelo CPF — só permitido com saldo zerado |

---

## EXCEÇÕES CUSTOMIZADAS`

| Exceção | Motivo |
|---|---|
| `SaldoInsuficienteException` | Saldo não cobre o valor do saque (+ taxa, na Conta Corrente) |
| `ContaNaoEncontradaException` | CPF informado não corresponde a nenhuma conta |
| `CpfInvalidoException` | CPF não passa na validação de dígito verificador |
| `EmailInvalidoException` | Email não corresponde ao formato esperado |
| `CpfJaCadastradoException` | CPF já vinculado a outra conta no banco |
| `ContaComSaldoException` | Tentativa de remover conta com saldo positivo |

Todas checked — representam condições esperadas do domínio bancário, não falhas de programação.

---

## PERSISTÊNCIA`

Os dados são salvos em `contas.txt`, um registro por linha, campos separados por `;`:

```text
CORRENTE;João Silva;1500.0;12345678900;joao@gmail.com;2026-09-03
```

- **Salvamento**: ocorre após cada operação que modifica dados (criar, depositar, sacar, remover conta).
- **Carregamento**: ocorre uma única vez, ao iniciar o programa, reconstruindo todas as contas salvas.
- Implementado com `BufferedWriter`/`BufferedReader` dentro de blocos **try-with-resources**, sem dependências externas.
- A data de abertura original é preservada entre execuções por meio de um construtor sobrecarregado em `ContaBancaria`.

---

## ESTRUTURA`

```text
Sistema de Banco/
├── Classes/
│   └── src/
│       ├── Banco.java
│       ├── ContaBancaria.java
│       ├── ContaCorrente.java
│       ├── ContaPoupanca.java
│       ├── ContaInvestimento.java
│       └── Validador.java
├── Exception/
│   └── src/
│       ├── SaldoInsuficienteException.java
│       ├── ContaNaoEncontradaException.java
│       ├── CpfInvalidoException.java
│       ├── EmailInvalidoException.java
│       ├── CpfJaCadastradoException.java
│       └── ContaComSaldoException.java
├── Enum/
│   └── src/
│       └── TipoConta.java
├── mainB.java
└── README.md
```

---

## TECNOLOGIAS`

<div align="center">

<img src="https://skillicons.dev/icons?i=java,idea,git,github&theme=dark" alt="Java Tech Stack">

</div>

---

<div align="center">

```text
[SYSTEM STATUS]

Language  : JAVA
Version   : 21+
Focus     : EXCEPTIONS, VALIDATION & PERSISTENCE
Modules   : OOP, REGEX, CUSTOM EXCEPTIONS, IO
Status    : EVOLVING

```

<a href="https://github.com/kaiquejacob">

<img src="https://img.shields.io/badge/BACK_TO_GITHUB-0B0F14?style=for-the-badge&logo=github&logoColor=2F81F7" alt="GitHub">

</a>

</div>
