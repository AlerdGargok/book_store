package views;

import models.*;

public class ClienteView extends View implements interfaceView {
    
    public int imprimirMenuUsuario() {
        int escolha;
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                      [BOOK STORE]                        \n");
        System.out.println("==========================================================");
        System.out.println();
        System.out.printf("                  SEJA BEM VINDO, %s!                 \n", cadastro.getUsuarioAtual().getUsername());
        System.out.println();
        System.out.println("==========================================================");

        try {
            Thread.sleep(1000); // Pausa por 2 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                  [OPÇÕES DO USUÁRIO]                     \n");
        System.out.println("==========================================================");
        System.out.println("             [1] Verificar dados da conta                ");
        System.out.println("             [2] Comprar Livros                          ");
        System.out.println("             [3] Sair da conta                           ");
        System.out.println("==========================================================");
        escolha = scanner.nextInt();
        return escolha;
    }

    public void imprimirDadosUsuario(Cliente usuario){
        System.out.println("==========================================================\n");
        System.out.println("                      [DADOS DA CONTA]                        \n");
        System.out.println("==========================================================");     
        System.out.printf("                    Nome de Usuário: %s                           \n", cadastro.getUsuarioAtual().getUsername());
        System.out.printf("                    Saldo da Conta: R$ %.2f                        \n", cadastro.getUsuarioAtual().getSaldo());
        System.out.println();
        System.out.println("                        [1] Adicionar Saldo                       ");
        System.out.println("                        [2] Retornar ao menu                           ");
        int escolha = scanner.nextInt();
        if (escolha == 1){
            adicionarSaldo();
        }

    }

    public void adicionarSaldo(){
        System.out.println("==========================================================\n");
        System.out.println("                      [SALDO DA CONTA]                        \n");
        System.out.println("==========================================================");
        System.out.printf("                  Você possui :%.2f                      \n", cadastro.getUsuarioAtual().getSaldo()); 
        System.out.println("Adicionar: "); 
        double aumentarSaldo = scanner.nextDouble();
        try {
            cadastro.getUsuarioAtual().adicionarSaldo(aumentarSaldo);
            System.out.println("Saldo adicionado, Retornando...");
        } catch (Exception e) {
            System.out.println("Impossivel adicionar saldo!");
        }
    }

}
