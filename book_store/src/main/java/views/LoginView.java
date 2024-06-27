package views;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.*;

public class LoginView extends View implements interfaceView {

    private String username;
    private String senha;
    private String cpf;

    Logger logger = LogManager.getLogger(LoginView.class);

    public void imprimirLoginAdm(){
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                    [Login - ADM]                         \n");
        System.out.println("==========================================================");

        senhaValida = false;
        while(!senhaValida) {
            System.out.println("                   Insira sua senha:                      \n");
            senha = scanner.next();
            senhaValida = administrador.validarSenha(senha);

            if (!senhaValida) {
                System.out.println("          Senha inválida, digite novamente             \n");
            }

            System.out.println("          Login efetuado com sucesso!            \n");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } 
        }

        admView.imprimirMenuADM();
    }

    public void imprimirLoginUser() {
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                    [Login - Usuário]                     \n");
        System.out.println("==========================================================");
        System.out.println();

        usernameValido = false;
        while(!usernameValido){
            System.out.println("                 Insira o seu username:                   \n");
            username = scanner.next();
            usernameValido = cadastro.validarUser(username);

            if(!usernameValido) {
                System.out.println("       Username não existe, digite novamente          \n");
            }
        }

        senhaValida = false;
        while(!senhaValida) {
            System.out.println("                   Insira sua senha:                      \n");
            System.out.println("        *Caso tenha esquecido sua senha insira '0'*       \n");
            senha = scanner.next();
            if(senha.equals("0")) recuperarSenha();
            senhaValida = cadastro.validarUser_Senha(senha);

            if (!senhaValida) {
                System.out.println("          Senha inválida, digite novamente             \n");
            }
        }

            System.out.println("          Login efetuado com sucesso!            \n");
            login.setUsuarioAtual(username, senha);

            try {
                Thread.sleep(2000); // Pausa por 2 segundos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } 

        clienteView.imprimirMenuUsuario();

    }

    public void recuperarSenha() {
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                    [Recuperar Senha]                     \n");
        System.out.println("==========================================================");
        System.out.println();

        usernameValido = true;
        while(usernameValido){
            System.out.println("                 Insira o seu username:                   \n");
            username = scanner.next();
            usernameValido = cadastro.validarUser_Senha(username);

            if(usernameValido) {
                System.out.println("       Username não existe, digite novamente          \n");
            }
        }

        cpfValido = false;
        while(!cpfValido){
            System.out.println("                   Insira o seu CPF:                      \n");
            cpf = scanner.next();
            cpfValido = cadastro.validarUser_Cpf(cpf);

            if(!cpfValido) {
                System.out.println("          CPF inválido, digite novamente              \n");
            }
        }

        senhaValida = false;
        while(!senhaValida) {
            System.out.println("                  Insira uma nova senha:                  \n");
            senha = scanner.next();
            senhaValida = cadastro.validarSenha(senha);

            if (!senhaValida) {
                System.out.println("          Senha inválida, digite novamente             \n");
            }
        }

        login.recuperarSenha(cpf, senha);

        System.out.println();
        System.out.println("     Senha cadastrada com sucesso! Voltando para o menu...     \n");
        try {
            Thread.sleep(2000); // Pausa por 2 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
