package util.user;
import util.View;

import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    private static List<User> usuarios = new ArrayList<>(); 
    private static final User adm = new User("adm", "12345678901", "administrador");

    public void addUsuario(User novoUsuario){
        usuarios.add(novoUsuario);
    }

    public void addAdm() {
        addUsuario(adm);
    }


    public void listarUsuarios() {
        System.out.println(usuarios);
    }

    public boolean verificaAdm(String username, String senha) {
            if(username.equals("adm") && senha.equals("administrador")) return true;
            return false;
    }

    //criar remover usuario? (para adm)

    public boolean validarUser(String username) {
        for (User usuario : usuarios) {
            if (usuario.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public void listUsernames() {
        for (User user : usuarios) {
            System.out.println(user.getUsername());
        }
    }

    public boolean validarCpf(String cpf){ 

        if(cpf.length() != 11 || !cpf.matches("\\d+") || cpf.matches("(\\d)\\1*")){ 
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
                return false;
            }
        }

    return true;

    }

    // Verificar se a senha tem pelo menos 8 caracteres
    public boolean validarSenha(String senha) {
        View user = new View();
        if (senha.equals("0")) user.recuperarSenha();
        if (senha.length() >= 8) return true;

        return false;
     }

     public boolean validarUser_Senha(String senha) {
        for(User usuario : usuarios) {
            if(usuario.getSenha().equals(senha)){
                return true;
            }
        }
        return false;

        };

        public boolean validarUser_Cpf(String cpf) {
            for(User usuario : usuarios) {
                if(usuario.getCpf().equals(cpf)){
                    return true;
                }
            }
            return false;
    
            };
}   
