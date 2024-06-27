package views;

import models.*;

public class CadastroView extends View implements interfaceView  {

    private String username;
    private String senha;
    private String cpf;

    public void imprimirCadastroUser() {
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                   [Cadastro - Usuário]                   \n");
        System.out.println("==========================================================");
        System.out.println();
        
        usernameValido = true;
        while(usernameValido){
            System.out.println("                Insira o username desejado:               \n");
            username = scanner.next();
            usernameValido = cadastro.validarUser(username);

            if(usernameValido) {
                System.out.println("     Username não disponível, digite novamente        \n");
            }
        }

        cpfValido = false;
        cpfRegistrado = true;
        while (!cpfValido) {
            System.out.println("            Insira o seu CPF: (Apenas números)            \n");
            cpf = scanner.next();
            cpfValido = cadastro.validarCpf(cpf);
            cpfRegistrado = cadastro.validarUser_Cpf(cpf);

            if (!cpfValido || cpfRegistrado) {
                System.out.println("          CPF inválido, digite novamente              \n");
            }
        }

        senhaValida = false;
        while(!senhaValida) {
            System.out.println("                   Insira uma senha:                      \n");
            senha = scanner.next();
            senhaValida = cadastro.validarSenha(senha);

            if (!senhaValida) {
                System.out.println("          Senha inválida, digite novamente             \n");
            }
        }

        cadastro.addUsuario(username, cpf, senha);

        System.out.println();
        System.out.println("   Cadastro concluído com sucesso! Voltando para o menu...     \n");

        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            logger.error("Programa interrompido" ,e);
            Thread.currentThread().interrupt();
        }
    }


}
