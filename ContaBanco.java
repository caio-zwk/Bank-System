public class ContaBanco {
    private String nome;
    private int senha;
    private double saldo;
    private int depositos; // Quantidade de depósitos
    private int saques;    // Quantidade de saques

    public ContaBanco(String nome, int senha, double saldo) {
        this.nome = nome;
        this.senha = senha;
        this.saldo = saldo;
        this.depositos = 0;
        this.saques = 0;
    }

    public String getNome() {
        return nome;
    }

    public boolean checkSenha(int tentativa) {
        return this.senha == tentativa;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getDepositos() {
        return depositos;
    }

    public int getSaques() {
        return saques;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            this.depositos++;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            this.saques++;
            return true;
        }
        return false;
    }
}
