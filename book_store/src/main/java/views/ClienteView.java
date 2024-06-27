package views;

import models.*;

public class ClienteView extends View implements interfaceView {

    public void imprimirMenuUsuario() {
        int escolha;
        do {
            Flush();
            System.out.println("==========================================================\n");
            System.out.println("                      [BOOK STORE]                        \n");
            System.out.println("==========================================================");
            System.out.println();
            System.out.printf("                  SEJA BEM VINDO, %s!                 \n",login.getUsuarioAtual().getUsername());
            System.out.println();
            System.out.println("==========================================================");

            try {
                Thread.sleep(1000); // Pausa por 2 segundos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("==========================================================\n");
            System.out.println("                  [OPÇÕES DO USUÁRIO]                     \n");
            System.out.println("==========================================================");
            System.out.println("             [1] Verificar dados da conta                ");
            System.out.println("             [2] Comprar Livros                          ");
            System.out.println("             [3] Sair da conta                           ");
            System.out.println("==========================================================");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    imprimirDadosUsuario(login.getUsuarioAtual());
                    break;
                case 2:
                    carrinho.comprarLivros();
                    break;
                default:
                    break;
            }

        } while (escolha != 3);
    }

    public void imprimirDadosUsuario(Cliente usuario) {
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                      [DADOS DA CONTA]                        \n");
        System.out.println("==========================================================");
        System.out.printf("                    Nome de Usuário: %s                           \n",
                login.getUsuarioAtual().getUsername());
        System.out.printf("                    Saldo da Conta: R$ %.2f                        \n",
                login.getUsuarioAtual().getSaldo());
        System.out.println();
        System.out.println("                        [1] Adicionar Saldo                       ");
        System.out.println("                        [2] Retornar ao menu                           ");
        int escolha = scanner.nextInt();
        if (escolha == 1) {
            adicionarSaldo();
        }

    }

    public void adicionarSaldo() {
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                      [SALDO DA CONTA]                        \n");
        System.out.println("==========================================================");
        System.out.printf("                  Você possui :%.2f                      \n",
                login.getUsuarioAtual().getSaldo());
        System.out.println("Adicionar: ");
        double aumentarSaldo = scanner.nextDouble();
        try {
            login.getUsuarioAtual().adicionarSaldo(aumentarSaldo);
            System.out.println("Saldo adicionado, Retornando...");
        } catch (Exception e) {
            System.out.println("Impossivel adicionar saldo!");
        }
    }

    public int imprimirMenuComprarLivros(){
        Flush();
        int escolha;
        System.out.println("==========================================================\n");
        System.out.println("                  [COMPRAR LIVROS]                     \n");
        System.out.println("==========================================================");
        System.out.println("             [1] Mostrar todos livros                ");
        System.out.println("             [2] Comprar livro por nome                          ");
        System.out.println("             [3] Carrinho                           ");
        System.out.println("             [4] Voltar                           ");
        System.out.println("==========================================================");
        escolha = scanner.nextInt();
        return escolha;
    }

    public String imprimirCompraLivroNome(){
        Flush();
        String nome;
        System.out.println("==========================================================\n");
        System.out.println("                  [COMPRAR LIVRO POR NOME]                     \n");
        System.out.println("==========================================================");
        System.out.println("Digite o nome do livro: ");
        nome = scanner.next();
        return nome;
    }
    public boolean adicionarlivroaoCarrinho(Livro livro){
        Flush();
        int escolha;
        System.out.println(livro);
            System.out.println("Deseja adicionar esse livro ao carrinho?\n1- SIM\n2-NAO");
            escolha = scanner.nextInt();
            if (escolha == 1){
                carrinho.adicionarAoCarrinho(livro);
                return true;
            }

        return false;
    }
    public int imprimirMenuCarrinho(){
        Flush();
        int escolha;
        System.out.println("==========================================================\n");
        System.out.println("                  [Carrinho]                     \n");
        System.out.println("==========================================================");
        carrinho.listarCarrinho();
        System.out.printf("             Seu Saldo: %.2f                          \n", login.getUsuarioAtual().getSaldo());
        System.out.println("==========================================================");
        System.out.println("             [1] Comprar                ");
        System.out.println("             [2] Remover do carrinho pelo nome                          ");
        System.out.println("             [3] Voltar                           ");
        escolha = scanner.nextInt();
        return escolha;
    }

    public String removerDoCarrinho(){
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                  [REMOVER DO CARRINHO]                     \n");
        System.out.println("==========================================================");
        System.out.println("Digite o nome do livro que deseja remover: ");
        String escolha = scanner.next();
        return escolha;
    }

}
