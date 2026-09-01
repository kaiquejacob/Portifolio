public class ContaCorrente extends ContaBancaria{

    public ContaCorrente(String titular, double saldo, String cpf, String email) throws CpfInvalidoException, EmailInvalidoException {
        super(titular, saldo, TipoConta.CORRENTE, cpf, email);
    }

    @Override
    public void calcularExtrato() {
        System.out.println("\n👤 Titular: " + getTitular());
        System.out.println("💼 Tipo: " + getTipoConta().nome);
        System.out.println("💵 Saldo: R$" + getSaldo());
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (getSaldo() >= valor + 10) {
            super.sacar(valor);
            super.sacar(10);
        }else {
            throw new SaldoInsuficienteException("Valor pedido para saque: " + valor + "\nSaldo disponivel: " + getSaldo() + "\nValor do saque com taxa: " + (valor + 10));
        }

    }

}
