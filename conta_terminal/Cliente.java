package conta_terminal;

public class Cliente {
    private int conta;
    private String agencia;
    private String nomeCliente;
    private float saldo;

    public float depositar(float deposito) {
        saldo += deposito;
        return saldo;        
    }

    public float sacar(float saque) {
        saldo = (saldo - saque) >= 0.00f ? saldo - saque : 0.00f;
        return saldo;
    }

    // Getters
    public int getConta() {
        return conta;
    }
    public String getAgencia() {
        return agencia;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public float getSaldo() {
        return saldo;
    }

    // Setters

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public void setConta(int conta) {
        this.conta = conta;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    // Construtores

    public Cliente() {}
    public Cliente(String nomeCliente) {
        setNomeCliente(nomeCliente);
    }
    public Cliente(int conta, String agencia) {
        setConta(conta);
        setAgencia(agencia);
    }
}