package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import models.*;
import models.Livro;
import views.ClienteView;

public class Carrinho implements interfaceView{

    //TA FEITO PORÉM seria legal essa clase ser uma extensão do user, já que faz sentido cada um ter seu carrinho
    //talvez adicionar como classe abstrata sei lá
    private ArrayList<Livro> carrinho;
    private ArrayList<Livro> livrosComprados;
    private double precoCarrinho;
    public ArrayList<String> pedidos = new ArrayList<>();

    ClienteView clienteView = new ClienteView(); 
    Estoque estoque = new Estoque("dadosEstoque.txt");


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
                pedidos.add("Compra do livro: " +livro.getTitulo() + " feita pelo usuario: " + login.getUsuarioAtual().getUsername());
                estoque.removeLivrosSemTexto(livro.getTitulo());
            }
            carrinho.clear();
            System.out.println("Compra confirmada. Livros foram movidos para a lista de comprados.");
        } 
        else {
            System.out.println("O carrinho está vazio ou não há saldo suficiente!");
            scanner.nextLine();
        }
        return saldo;
    }

    public ArrayList<String> getPedidos() {
        return pedidos;
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

    public void comprarLivros(){
        boolean menuLoop = true;
        do {
            int opcao = clienteView.imprimirMenuComprarLivros();
            switch (opcao) {
                //somente listar os livros disponiveis
                case 1:
                    estoque.imprimirLivrosOrdenados();
                    break;
                //comprar e adicionar um livro ao carrinho
                case 2:
                    String procura = clienteView.imprimirCompraLivroNome();
                    if (estoque.pesquisarLivro(procura) != null){
                        Livro livropesquisado = estoque.pesquisarLivro(procura);
                        clienteView.adicionarlivroaoCarrinho(livropesquisado);
                    }
                    break;
                //carrinho onde é possivel comprar os produtos
                case 3:
                    int carrinhoEscolha = clienteView.imprimirMenuCarrinho();
                    switch (carrinhoEscolha) {
                        case 1:

                                try {
                                    double novoSaldo = confirmarCompra(login.getUsuarioAtual().getSaldo());
                                    login.getUsuarioAtual().setSaldo(novoSaldo);

                                } catch (Exception e) {
                                    System.out.println("Nao foi possivel comprar os itens do carrinho!;");
                                }
                            
                            
                            break;

                        case 2:

                            break;
                    
                        default:
                            break;
                    }
                    break;

                default:
                    menuLoop = false;
                    break;
            }

        } while (menuLoop);
    }

}
