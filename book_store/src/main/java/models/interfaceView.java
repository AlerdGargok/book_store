package models;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controllers.*;
import views.*;

public interface interfaceView {

    MainView mainView = new MainView();
    CadastroView cadastroView = new CadastroView();
    LoginView loginView = new LoginView();
    ClienteView clienteView = new ClienteView();
    AdmView admView = new AdmView();
    EstoqueView estoqueView = new EstoqueView();
    Estoque estoque = new Estoque("dados.txt");
    Carrinho carrinho = new Carrinho();

    Cadastro cadastro = new Cadastro();
    Administrador administrador = new Administrador();
    Login login = new Login();
    Scanner scanner = new Scanner(System.in);
    Logger logger = LogManager.getLogger();

    public default void Flush() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
