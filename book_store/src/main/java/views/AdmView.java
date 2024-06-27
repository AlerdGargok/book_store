package views;

import models.*;

public class AdmView extends View implements interfaceView {
    public void imprimirMenuADM(){
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                  [OPÇÕES DO ADM]                         \n");
        System.out.println("==========================================================");
        System.out.println("             [1] Gerenciamento de Estoque                 ");
        System.out.println("             [2] Gerenciar Usuários                       ");
        System.out.println("             [3] Gerenciar Pedidos                        ");
        System.out.println("             [4] Sair da conta                            ");
        System.out.println("==========================================================");
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1: 
            estoqueView.imprimirMenuEstoque();
            break;
            case 2:// Criar gerencia de usuario
            break;
            case 3: //Criar gerencia de pedidos
            break;
            case 4:
            return;
        }
    }

    
}
