package util.user;

import java.util.ArrayList;

import model.Livro;

public class Cliente extends User {

    public Cliente(String username, String cpf, String senha) {
        super(username, cpf, senha);
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

    public double getSaldo() {
        return saldo;
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
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
    return "Username: " + username + ", Senha: " + senha + ", CPF: " + cpf;
}
    
    //SERIA INTERESSANTE JOGAR ESSA PARTE PARA UMA OUTRA CLASSE SOMENTE DE COMPRAS \/\/\/\/\/\/\/\/\/\/

    //area relacionada a compra dos livros
    //lista dos livros que ele comprou
    private ArrayList<Livro> livrosComprados = new ArrayList<Livro>();
    //quando comprar um livro adicionar na lista
    public void addLivrosComprado (Livro livro){
        livrosComprados.add(livro);
    }
    //para listar os livros que ele ja comprou
    //preciso que termine a parte de usuario para poder fazer que quando a pessoa tem saldo e compre o livro
    //remova da biblioteca e adicione aqui
    public void listarLivrosComprados(){
        for (Livro livro : livrosComprados) {
            System.out.println(livro);
        }
    }

    public boolean adicionarSaldo(double saldomais){
        try {
            saldo+= saldomais;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    


}