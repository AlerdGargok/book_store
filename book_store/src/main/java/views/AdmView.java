package views;

import controllers.Administrador;
import models.*;

public class AdmView extends View implements interfaceView {
    public void imprimirMenuADM() {
        int escolha;
        do {
            Flush();
            System.out.println("==========================================================\n");
            System.out.println("                  [OPÇÕES DO ADM]                         \n");
            System.out.println("==========================================================");
            System.out.println("             [1] Gerenciamento de Estoque                 ");
            System.out.println("             [2] Gerenciar Usuários                       ");
            System.out.println("             [3] Gerenciar Pedidos                        ");
            System.out.println("             [4] Sair da conta                            ");
            System.out.println("==========================================================");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1: // Gerenciador de Estoque
                    administrador.gerenciamentoEstoque();
                    break;
                case 2:// Criar gerencia de usuario
                    administrador.gerenciaUsuario();
                    break;
                case 3: // Criar gerencia de pedidos
                    administrador.listarPedidos();
                    break;
                case 4:
                    return;
            }

        } while (escolha != 0);

    }

    public int menuGerenciaUsuarios(){
        int escolha;
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                  [GERENCIADOR DE USUARIOS]                         \n");
        System.out.println("==========================================================");
        System.out.println("             [1] Listar Usuario                 ");
        System.out.println("             [2] Pesquisar Usuario                       ");
        System.out.println("             [3] Voltar                            ");
        System.out.println("==========================================================");
        escolha = scanner.nextInt();
        return escolha;
    }

    public String pesquisarUsuario(){
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                  [PESQUISAR USUARIO]                         \n");
        System.out.println("==========================================================");
        System.out.println("Digite o nome do Usuario: ");
        String usuario = scanner.next();
        return usuario;
    }



}
