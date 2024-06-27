package controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.*;


//Classe responsável pelo Login dos usuários
public class Login {
    Cliente usuarioAtual;
    Cadastro cadastro = new Cadastro();
    List<Cliente> usuarios = cadastro.getUsuarios();
    Logger logger = LogManager.getLogger(Cadastro.class);

    //Define qual usuário está logado
    public void setUsuarioAtual(String username, String senha) {
        String cpf = "0";

        for (Cliente usuario : usuarios) {
            if (usuario.getSenha().equals(senha)) {
                if (usuario.getUsername().equals(username)) {
                    cpf = usuario.getCpf();
                }
            }
        }
        for (Cliente usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                usuarioAtual = usuario;
            }
        }
    }

    //Retorna o usuário logado
    public Cliente getUsuarioAtual() {
        return usuarioAtual;
    }   

    //Cadastra uma nova senha para o usuário
    public void recuperarSenha(String cpf, String novaSenha){
        Boolean cpfValido = cadastro.validarUser_Cpf(cpf);

        if(cpfValido){
            for (Cliente usuario : usuarios) {
                if (usuario.getCpf().equals(cpf)) {
                    usuario.setSenha(novaSenha);
                    logger.info("Senha do usuario alterada", usuario);
                    break;
                }      
            }
        }
    }
}
