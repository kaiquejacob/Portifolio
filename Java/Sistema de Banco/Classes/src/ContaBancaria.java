public abstract class ContaBancaria {
    private String titular;
    private double saldo;
    private TipoConta tipoConta;
    private String cpf;
    private String email;

    public ContaBancaria(String titular, double saldo, TipoConta tipoConta, String cpf, String email) throws CpfInvalidoException, EmailInvalidoException {
        if (!Validador.validarCpf(cpf)){
            throw new CpfInvalidoException("O CPF " + cpf + " é inválido!");
        }
        if (!Validador.validarEmail(email)){
            throw new EmailInvalidoException("O Email " + email + " é inválido!");
        }

        this.titular = titular;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.cpf = cpf;
        this.email = email;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException("Valor solicitado para saque: " + valor + "\nSaldo da conta: " + saldo);

        }
        this.saldo -= valor;
    }

    public abstract void calcularExtrato();

    @Override
    public String toString() {
        return "\n👤 Titular: " + titular +
                "\n💼 Tipo: " + tipoConta.nome +
                "\n💵 Saldo: R$" + saldo +
                "\n🆔 CPF: " + cpf +
                "\n📧 Email: " + email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }
}
