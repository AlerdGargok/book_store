package models;

public abstract class User {
    protected String username;
    protected String senha;
    protected String cpf;
    protected double saldo;

    public User(String username, String cpf, String senha, Double saldo) {
        this.username = username;
        this.senha = senha;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {

        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
    return "Username: " + username + ", Senha: " + senha + ", CPF: " + cpf + ", Saldo: " + saldo;
}

}
