import java.time.LocalDate;

public class ContaPoupanca extends ContaBancaria{

    public ContaPoupanca(String titular, double saldo, String cpf, String email) throws CpfInvalidoException, EmailInvalidoException {
        super(titular, saldo, TipoConta.POUPANCA, cpf, email);
    }

    public ContaPoupanca(String titular, double saldo, String cpf, String email, LocalDate dataAbertura) throws CpfInvalidoException, EmailInvalidoException {
        super(titular, saldo, TipoConta.POUPANCA, cpf, email, dataAbertura);
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
