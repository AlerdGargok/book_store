package util.user;

import java.util.ArrayList;
import java.util.List;


public class Cadastro {
    private static List<User> usuarios;

    public Cadastro(){
        usuarios = new ArrayList<>(); 
    }

    public void addUsuario(User novoUsuario){
        usuarios.add(novoUsuario);
    }

    //criar remover usuario? (para adm)

    public void validarUser(String username) {
        try {
            for (User novoUsuario : usuarios) {
                if (novoUsuario.getUsername().equalsIgnoreCase(username)) {
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("Username inválido!");
        }
    }

    public boolean validaCpf(String cpf){ //ajustar!!!!!!!!!
        if(cpf.length() != 11 || !cpf.matches("\\d+") || cpf.matches("(\\d)\\1*")){ 

        System.out.println("CPF inválido, digite novamente: ");
        return false;
    }

        for(int j = 0; j < 2; j++){
            int soma = 0, resto;
            for(int i = 10 + j; i >= 2; i--){
            soma += i * Integer.parseInt(cpf.charAt(j + 10 - i) + "");
            }
            resto = (soma % 11);

            if(resto < 2) {
                resto = 0;
            }else {
            resto = 11 - resto;
            }

            if(resto != Integer.parseInt(cpf.charAt(j + 9) + "")){
                System.out.println("CPF inválido, digite novamente: ");
                return false;
            }
        }

    return true;

    }

    public void validarSenha(String senha) {
        // Verificar se a senha tem pelo menos 8 caracteres
        if (senha.length() >= 8) {
            return;
        }
        
        //excpetion de erro? fazer o usuario digitar uma senha válida
     }
}   
