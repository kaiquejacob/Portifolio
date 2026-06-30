public class ContaPoupanca extends ContaBancaria{

    public ContaPoupanca(String titular, double saldo) {
        super(titular, saldo, TipoConta.POUPANCA);
    }

    @Override
    public void calcularExtrato() {
        System.out.println("\n👤 Titular: " + getTitular());
        System.out.println("💼 Tipo: " + getTipoConta().nome);
        System.out.println("💵 Saldo: R$" + getSaldo());
        double rendimento = getSaldo() * 0.005;
        System.out.println("📈 Rendimento mensal: R$" + String.format("%.2f", rendimento));
    }

}
