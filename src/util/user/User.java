package util.user;

public class User {
    private String username;
    private String senha;
    private String cpf;

    public User(String username, String cpf, String senha) {
        this.username = username;
        this.senha = senha;
        this.cpf = cpf;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf(){
        return cpf;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
    return "Username: " + username + ", Senha: " + senha + ", CPF: " + cpf;
}
}

