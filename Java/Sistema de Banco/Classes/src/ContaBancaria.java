public abstract class ContaBancaria {
    private String titular;
    private double saldo;
    private TipoConta tipoConta;

    public ContaBancaria(String titular, double saldo, TipoConta tipoConta) {
        this.titular = titular;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void sacar(double valor){
        if (saldo < valor) {
            System.out.println("Saldo insuficiente!");
            return;
        }
        this.saldo -= valor;
    }

    public abstract void calcularExtrato();

    @Override
    public String toString() {
        return "\n👤 Titular: " + titular +
                "\n💼 Tipo: " + tipoConta.nome +
                "\n💵 Saldo: R$" + saldo;
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
