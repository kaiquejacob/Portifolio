public class ContaCorrente extends ContaBancaria{

    public ContaCorrente(String titular, double saldo) {
        super(titular, saldo, TipoConta.CORRENTE);
    }

    @Override
    public void calcularExtrato() {
        System.out.println("\n👤 Titular: " + getTitular());
        System.out.println("💼 Tipo: " + getTipoConta().nome);
        System.out.println("💵 Saldo: R$" + getSaldo());
    }

    @Override
    public void sacar(double valor) {
        super.sacar(valor);
        super.sacar(10);
    }

}
