package views;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.*;


//View/Menu inicial  
public class MainView implements interfaceView {

    Logger logger = LogManager.getLogger(MainView.class);

    Integer opMenu;

    // Chama as listas estáticas de genero e editora (Já previamente selecionadas para o usuário)


    public int imprimirInicio(Integer opMenu) {
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                      [BOOK STORE]                        \n");
        System.out.println("==========================================================");
        System.out.println();
        System.out.println("                     SEJA BEM VINDO!                      \n");
        System.out.println("         -> Faça o login ou cadastre-se abaixo: <-        ");
        System.out.println();
        System.out.println("==========================================================\n");
        System.out.println("                      [1] Login                           ");
        System.out.println("                      [2] Cadastro                        ");
        System.out.println("                      [3] Administrador                   ");
        System.out.println("                      [4] Sair                            ");
        System.out.println("==========================================================");
        System.out.println();
        System.out.println();
        System.out.println("Sua escolha: ");

        try { 
            opMenu = scanner.nextInt();
        } catch(InputMismatchException e) {
            logger.error("Opção Inválida", e);
            scanner.next(); 
        }

        return opMenu;
    }
}