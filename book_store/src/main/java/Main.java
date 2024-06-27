import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controllers.*;
import views.*;
import models.*;

//Loja de livros com criação de cadastros de usuários/Cadastro de livros e sistema de carrinho de compras

//Redireciona as opções de login e cadastro
public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Inicio do programa");

        MainView mainView = new MainView();
        CadastroView cadastroView = new CadastroView();
        LoginView loginView = new LoginView();

        boolean menuLoop = true;
        Integer opMenu = 0;
   
        do{
            cadastroView.Flush();
            opMenu = mainView.imprimirInicio(opMenu);
                
            switch(opMenu) {
                case 1 : 
                loginView.imprimirLoginUser();
                break;

                case 2 :
                cadastroView.imprimirCadastroUser();
                break;

                case 3 :
                loginView.imprimirLoginAdm();
                break;

                case 4 :
                menuLoop = false;
                break;

            }

        }while(menuLoop);

    }
        
}
