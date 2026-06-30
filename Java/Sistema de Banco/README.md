# 🏦 Sistema Bancário

Sistema de gerenciamento de contas bancárias via console, desenvolvido em Java.

## Funcionalidades

- Criar conta (Corrente, Poupança ou Investimento)
- Depositar valores
- Sacar valores
- Ver extrato da conta
- Listar todas as contas

## Conceitos aplicados

- Herança e classes abstratas (`ContaBancaria` → `ContaCorrente`, `ContaPoupanca`, `ContaInvestimento`)
- Polimorfismo (`calcularExtrato()` com comportamento diferente em cada subclasse)
- Enumeração (`TipoConta`)
- Encapsulamento

## Tecnologias

- Java
