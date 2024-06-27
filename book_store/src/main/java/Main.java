import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controllers.*;
import views.*;
import models.*;

/*Faz um loop para imprimir o menu enquanto o usuário não selecionar a opção de sair ou o programa finalizar
Recebe os valores inseridos pelo usuário na classe interface para adicionar livros e chama o construtor para ser enviado ao arraylist da classe Biblioteca
Recebe os valores de pesquisa e remoção dos itens para serem aplicados na classe bilbioteca
*/

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Inicio do programa");

        // TESTE  ----- RETIRAR DEPOIS ------
        Cadastro cadastro = new Cadastro();
        cadastro.userTESTE();

        MainView mainView = new MainView();
        CadastroView cadastroView = new CadastroView();
        LoginView loginView = new LoginView();
        ClienteView clienteView = new ClienteView();

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




















        /** 
        
        */
    }
        
}
