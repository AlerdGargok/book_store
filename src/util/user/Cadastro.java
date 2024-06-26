package util.user;
import util.View;

import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    private static List<Cliente> usuarios = new ArrayList<>(); 
    private static final Cliente adm = new Cliente("adm", "12345678901", "administrador"); // Mudar
    private static Cliente usuarioAtual;


    //metodo para atualizar o usuario atual com nick
    //preciso que mude para cpf, quando se logar resgatar o cpf do meliante e colocar aq
    //assim nao da conflito com ninguem valeu



    public void setUsuarioAtual(String nick) {
        for (Cliente usuario : usuarios) {
            if (usuario.getUsername().equalsIgnoreCase(nick)) {
                Cadastro.usuarioAtual = usuario;
            }
        }
    }

    public Cliente getUsuarioAtual() {
        return usuarioAtual;
    }

    //fim da area do usuario atual

    public void addUsuario(Cliente novoUsuario){
        usuarios.add(novoUsuario);
    }

    public void addAdm() {
        addUsuario(adm);
    }

    public boolean verificaAdm(String username, String senha) {
            if(username.equals("adm") && senha.equals("administrador")) return true;
            return false;
    }

    //criar remover usuario? (para adm)

    public boolean validarUser(String username) {
        for (Cliente usuario : usuarios) {
            if (usuario.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
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
        for(Cliente usuario : usuarios) {
            if(usuario.getSenha().equals(senha)){
                return true;
            }
        }
        return false;

        };

        public boolean validarUser_Cpf(String cpf) {
            for(Cliente usuario : usuarios) {
                if(usuario.getCpf().equals(cpf)){
                    return true;
                }
            }
            return false;
    
            };
}   
