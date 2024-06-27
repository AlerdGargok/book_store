package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.*;
import views.AdmView;
import views.EstoqueView;
import controllers.*;

public class Administrador implements interfaceView{
    private final Adm adm = new Adm("adm", null, "administrador", null);
    Cadastro cadastro = new Cadastro();
    List<Cliente> usuarios = cadastro.getUsuarios();
    EstoqueView estoqueView = new EstoqueView();
    AdmView admView = new AdmView();
    Estoque estoque = new Estoque("dados.txt");
    Scanner scanner = new Scanner(System.in);
   

    public boolean validarSenha(String senha) {
        if (senha.equals(adm.getSenha()))
            return true;
        return false;
    }

    public void listUsernames(List<Cliente> usuarios) {
        System.out.println(usuarios);
    }

    public void removerUsuario(String username) {
        for (Cliente usuario : usuarios) {
            if (usuario.getUsername().equalsIgnoreCase(username))
                usuarios.remove(usuario);
            else
                System.out.println("Usuário não encontrado!");
        }
    }

    public void gerenciamentoEstoque() {
        boolean menuLoop = true;
        String procura; // variavel para procurar por autor, genero ou editora

        do {
            estoqueView.Flush();
            Integer escolha = estoqueView.imprimirMenuEstoque();
            switch (escolha) {
                case 1:
                    estoqueView.adicionarLivro();

                    String titulo = estoqueView.get_tituloLivro();
                    Autor autor = estoqueView.get_autorLivro();
                    Genero genero = estoqueView.get_generoLivro();
                    Editora editora = estoqueView.get_editoraLivro();
                    double valorLivro = estoqueView.getValorLivro();

                    Livro novoLivro = new Livro(titulo, autor, genero, editora, valorLivro);
                    estoqueView.Flush();
                    estoque.addLivros(novoLivro);
                    break;

                case 2:
                    estoqueView.removerLivros();
                    titulo = scanner.next();
                    estoque.removeLivros(titulo);
                    break;

                case 3:
                    estoqueView.pesquisarLivro();
                    titulo = scanner.next();
                    estoque.procurarLivro(titulo);

                    break;

                case 4:
                    // pede o tipo de listagem desejada
                    escolha = estoqueView.ListarLivro();
                    if (escolha == 1)
                        estoque.imprimirLivros();
                    if (escolha == 2)
                        estoque.imprimirLivrosOrdenados();
                    if (escolha == 3) {
                        System.out.println("Digite o nome do autor: ");
                        procura = scanner.next();
                        estoque.imprimirLivrosAutor(procura);
                    }
                    if (escolha == 4) {
                        System.out.println("Digite o nome do genero: ");
                        procura = scanner.next();
                        estoque.imprimirLivrosGenero(procura);
                    }
                    if (escolha == 5) {
                        System.out.println("Digite o nome da editora: ");
                        procura = scanner.next();
                        estoque.imprimirLivrosEditora(procura);
                    }

                    break;

                case 5:
                    menuLoop = false;
                    break;

            }

            break;

        } while (menuLoop);
    }

    // Criar listar usuarios ok?
    public void gerenciaUsuario() {
        boolean menuLoop = true;
        do {
            int escolha = admView.menuGerenciaUsuarios();
            String pesquisa;
            switch (escolha) {
                // ListarUsuario
                case 1:
                    admView.Flush();
                    System.out.println("Lista de usuários: ");
                    if (!usuarios.isEmpty()) {
                        for (Cliente cliente : usuarios) {
                            System.out.println(cliente);
                        }
                    } else
                        System.out.println("Ainda nao tem usuarios cadastrados...");

                    System.out.println("Digite qualquer botão para retornar: ");
                    scanner.nextLine();
                    break;

                // Pesquisar Usuario / remover usuario
                case 2:
                    pesquisa = admView.pesquisarUsuario();
                    boolean usuarioExiste = false;
                    int interador = 0;
                    for (Cliente cliente : usuarios) {
                        Cliente usuarioCliente = usuarios.get(interador);
                        if (cliente.getUsername().equals(pesquisa)) {
                            System.out.println("Usuario existe\nDados Usuario:");
                            System.out.println(cliente);
                            System.out.println("deseja remover usuario?\n1- SIM\n2- NÃO");
                            int remover = scanner.nextInt();
                            if (remover == 1) {
                                usuarios.remove(usuarioCliente);
                                System.out.println("Usuario removido!");
                            }
                            usuarioExiste = true;
                            break;
                        }
                        interador += 1;
                    }

                    if (!usuarioExiste)
                        System.out.println("Usuario não existe!");

                    System.out.println("Digite qualquer botão para retornar: ");
                    scanner.nextLine();
                    break;

                default:
                    menuLoop = false;
                    break;
            }
        } while (menuLoop);
    }

    // Acesso a todos os pedidos
    public void listarPedidos() {
        //try {
            ArrayList<String> pedidos = carrinho.getPedidos();
            System.out.println("Lista de pedidos: ");
            if (!pedidos.isEmpty()) {
                for (String string : pedidos) {
                    System.out.println(string);
                }
            }
        //} catch (Exception e) {
            System.out.println("Nenhum pedido foi realizado ainda!");
        //}

        System.out.println("Aperte alguma tecla para voltar");
        scanner.nextLine();

    }

}