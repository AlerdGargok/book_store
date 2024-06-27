package controllers;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Cliente;

public class Cadastro {
    private static List<Cliente> usuarios = new ArrayList<>(); 
    Logger logger = LogManager.getLogger(Cadastro.class);

    public void userTESTE(){
        Cliente userTeste = new Cliente("A", "123", "123", 0.0);
        usuarios.add(userTeste);
    }

    public void addUsuario(String username, String cpf, String senha){
        Cliente novoUsuario = new Cliente(username, cpf, senha, 0.0);
        usuarios.add(novoUsuario);
        logger.info("Cadastro de usuário realizado");
    }

    public boolean validarUser(String username) {
        for (Cliente usuario : usuarios) {
            if (usuario.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean validarCpf(String cpf){ 
        if(cpf.length() != 11 || !cpf.matches("\\d+") || cpf.matches("(\\d)\\1*")) return false;

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

    public boolean validarSenha(String senha) {
        //if (senha.equals("0")) user.recuperarSenha();
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
    }

    public boolean validarUser_Cpf(String cpf) {
        for(Cliente usuario : usuarios) {
            if(usuario.getCpf().equals(cpf)){
            return true;
            }
        }

        return false;
     }

     public List<Cliente> getUsuarios() {
        return usuarios;
    }

        
    

}   
