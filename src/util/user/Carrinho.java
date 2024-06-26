package util.user;

import java.util.ArrayList;

import model.Livro;

public class Carrinho {

    //TA FEITO PORÉM seria legal essa clase ser uma extensão do user, já que faz sentido cada um ter seu carrinho
    //talvez adicionar como classe abstrata sei lá
    private ArrayList<Livro> carrinho;
    private ArrayList<Livro> livrosComprados;
    private double precoCarrinho;

    public Carrinho() {
        this.carrinho = new ArrayList<>();
        this.livrosComprados = new ArrayList<>();
        this.precoCarrinho = 0;
    }

    // Adicionar livro ao carrinho
    public void adicionarAoCarrinho(Livro livro) {
        carrinho.add(livro);
        System.out.println(livro.getTitulo() + " foi adicionado ao carrinho.");
        precoCarrinho += livro.getValor();
    }

    // Remover livro do carrinho
    public void removerDoCarrinho(Livro livro) {
        if (carrinho.remove(livro)) {
            precoCarrinho -= livro.getValor();
            System.out.println(livro.getTitulo() + " foi removido do carrinho.");
        } else {
            System.out.println(livro.getTitulo() + " não está no carrinho.");
        }
    }

    // Listar livros no carrinho
    public void listarCarrinho() {
        if (carrinho.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            System.out.println("Livros no carrinho:");
            for (Livro livro : carrinho) {
                System.out.println(livro);
            }
            System.out.println("Preço do TODO:" +precoCarrinho);
        }
    }

    // Confirmar compra, se o carrinho nao for vazio e tiver dinheiro, compra e retorna o novo saldo atualizado
    public double confirmarCompra(double saldo) {
        if (!carrinho.isEmpty() && saldo >= precoCarrinho) {
            precoCarrinho = 0;
            saldo-= precoCarrinho;
            for (Livro livro : carrinho) {
                livrosComprados.add(livro);
            }
            carrinho.clear();
            System.out.println("Compra confirmada. Livros foram movidos para a lista de comprados.");
        } 
        else {
            System.out.println("O carrinho está vazio ou não há saldo suficiente!");
        }
        return saldo;
    }

    // Listar livros comprados
    public void listarLivrosComprados() {
        if (livrosComprados.isEmpty()) {
            System.out.println("Nenhum livro foi comprado ainda.");
        } else {
            System.out.println("Livros comprados:");
            for (Livro livro : livrosComprados) {
                System.out.println(livro);
            }
        }
    }
}
