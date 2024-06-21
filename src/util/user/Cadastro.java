package util.user;
import util.View;

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

    public List<User> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }

    //criar remover usuario? (para adm)

    public boolean validarUser(String username) {
            for (User usuario : usuarios) {
                if (usuario.getUsername().equalsIgnoreCase(username)) {
                    return false;
                }
            }
            return true;
    }

    public static int contarDigitos(String texto) {
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (Character.isDigit(texto.charAt(i))) {
                contador++;
            }
        }
        return contador;
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

     public boolean consultarCpf(String cpf) {
        for (User usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
}   
