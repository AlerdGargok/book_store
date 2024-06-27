package controllers;

import java.util.List;

import models.Cliente;

public class Administrador {
    private String senhaADM = "administrador";
    private List<Cliente> usuarios;
    
    public boolean validarSenha(String senha){
        if (senha.equals(senhaADM)) return true;
        return false;
    }

    public void listUsernames(List<Cliente> usuarios) {
        System.out.println(usuarios);
    }

    public void removerUsuario(String username){
        for (Cliente usuario : usuarios) {
            if (usuario.getUsername().equalsIgnoreCase(username)) usuarios.remove(usuario);
            else System.out.println("Usuário não encontrado!");
        }
    }

    //Criar listar usuarios ok?

    //Criar remover usuario ok? 

    //Acesso a cadastro/remoção de livros

    //Acesso a todos os pedidos

    
}
