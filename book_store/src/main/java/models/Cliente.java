package models;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controllers.Cadastro;

//Classe responsável por gerenciar as ações do cliente
public class Cliente extends User {

    Logger logger = LogManager.getLogger(Cadastro.class);

    public Cliente(String username, String cpf, String senha, Double saldo) {
        super(username, cpf, senha, saldo);
    }

    //area relacionada a compra dos livros
    //lista dos livros que o usuário comprou
    private ArrayList<Livro> livrosComprados = new ArrayList<Livro>();
    //quando comprar um livro adicionar na lista
    public void addLivrosComprado (Livro livro){
        livrosComprados.add(livro);
    }

    public void listarLivrosComprados(){
        for (Livro livro : livrosComprados) {
            System.out.println(livro);
        }
    }

    public boolean adicionarSaldo(double saldomais){
        try {
            saldo+= saldomais;
            logger.info("Saldo adicionado", saldomais);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Livro> getLivrosComprados() {
        return livrosComprados;
    }

    public void setLivrosComprados(ArrayList<Livro> livrosComprados) {
        this.livrosComprados = livrosComprados;
    }

    

    


}