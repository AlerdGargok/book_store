package util.user;

public abstract class User {
    protected String username;
    protected String senha;
    protected String cpf;
    protected double saldo;

    public User(String username, String cpf, String senha) {
        this.username = username;
        this.senha = senha;
        this.cpf = cpf;
        this.saldo = 0;
    }

}
