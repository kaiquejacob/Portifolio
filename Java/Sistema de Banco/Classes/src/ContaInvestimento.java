public class ContaInvestimento extends ContaBancaria{

    public ContaInvestimento(String titular, double saldo, String cpf, String email) throws CpfInvalidoException, EmailInvalidoException {
        super(titular, saldo, TipoConta.INVESTIMENTO, cpf, email);
    }

    @Override
    public void calcularExtrato() {
        System.out.println("\n👤 Titular: " + getTitular());
        System.out.println("💼 Tipo: " + getTipoConta().nome);
        System.out.println("💵 Saldo: R$" + getSaldo());
        double rendimento = getSaldo() * 0.012;
        System.out.println("📈 Rendimento mensal: R$" + String.format("%.2f", rendimento));
        System.out.println("📉 Taxa de administração: R$20.0");
    }

}
