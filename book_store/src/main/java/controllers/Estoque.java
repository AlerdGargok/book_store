package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Livro;

//Classe responsável por administrar a adição e remoção de livros, além de listar os mesmos que já foram inseridos

public class Estoque {
    private static List<Livro> livros;
    Logger logger = LogManager.getLogger(Cadastro.class);
    Scanner scanner = new Scanner(System.in);
    private FileManager fileManager;

    // Inicializa a lista de livros no construtor
    public Estoque(String nomeArquivo) {
        livros = new ArrayList<>(); 
        fileManager = new FileManager(nomeArquivo);
    }

    //Adiciona um objeto livro criado na Main em um arraylist 
    public void addLivros(Livro livro){
        livros.add(livro);
        logger.info("Livro adicionado", livro);

        System.out.println("Livro adicionado com sucesso!\n");
        System.out.println("Voltando para o menu...");

        try {
            Thread.sleep(2000); // Pausa por 2 segundos
            } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            }
        salvarDados();

        return;
    
    }

    //Verifica se o arraylist de livros está vazio, caso não esteja imprime todos os Livros armazenados no array, com as suas respectivas informações
    public void imprimirLivros() {
        if (livros.isEmpty()) {
            System.out.println("Não há livros na biblioteca.");
            System.out.println("Retornando ao menu...");
            try {
                Thread.sleep(2000); // Pausa por 2 segundos
                } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                }
            return;
        } 
            System.out.println("Lista de livros na biblioteca:");
            for (Livro livro : livros) {
                int index = livros.indexOf(livro);
                System.out.println("Livro posição: " + index + 1 +" "+livro);
            }
            //os livros ficarao ate apertar qualquer tecla do teclado
            System.out.println("Pressione ENTER para sair: ");
            scanner.nextLine();
                       
    }
    

    //Imprimir Lista Ordenada
    public void imprimirLivrosOrdenados() {
            //verifica se livros esta vazio
        if (livros.isEmpty()) {
            System.out.println("Não há livros na biblioteca.");
            System.out.println("Retornando ao menu...");
            try {
                Thread.sleep(2000); // Pausa por 2 segundos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                }
                return;
            }
        List<Livro> livrosOrdenados = new ArrayList<>(livros);
        Collections.sort(livrosOrdenados, Comparator.comparing(Livro::getTitulo));
        for (Livro livro : livrosOrdenados) {
            int index = livrosOrdenados.indexOf(livro);
            System.out.println("Livro posição: " + index + 1 +" "+livro);
        }
        //os livros ficarao ate apertar qualquer tecla do teclado
        System.out.println("Pressione ENTER para sair: ");
        scanner.nextLine();
    }

    //Imprimir Lista por Autor
    public void imprimirLivrosAutor(String autor) {
             //verifica se livros esta vazio
             if (livros.isEmpty()) {
                System.out.println("Não há livros na biblioteca.");
                System.out.println("Retornando ao menu...");
                try {
                    Thread.sleep(2000); // Pausa por 2 segundos
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    }
                    return;
                }
            //cria uma lista nova com os livros do autor
            List<Livro> livrosAutor = new ArrayList<>();
            for (Livro livro : livros) {
                if (livro.getAutorNome().equalsIgnoreCase(autor)){
                    livrosAutor.add(livro);
                }
            }
            if (livrosAutor.isEmpty()){
                System.out.println("Impossivel ordenar os livros");
                System.out.println("Retornando ao menu...");
                try {
                    Thread.sleep(2000); // Pausa por 2 segundos
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    }
                    return;
            }
            System.out.println("Lista de livros do Autor: " + autor +" na biblioteca:");
            for (Livro livro : livrosAutor) {
                System.out.println(livro);
            }
            //os livros ficarao ate apertar qualquer tecla do teclado
            System.out.println("Pressione ENTER para sair: ");
            scanner.nextLine();
    }

     //Imprimir Lista por Genero
     public void imprimirLivrosGenero(String genero) {
        //verifica se livros esta vazio
        if (livros.isEmpty()) {
           System.out.println("Não há livros na biblioteca.");
           System.out.println("Retornando ao menu...");
           try {
               Thread.sleep(2000); // Pausa por 2 segundos
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
               }
               return;
           }
       //cria uma lista nova com os livros do genero
       List<Livro> livrosGenero = new ArrayList<>();
       for (Livro livro : livros) {
           if (livro.getGeneroNome().equalsIgnoreCase(genero)){
               livrosGenero.add(livro);
           }
       }
       if (livrosGenero.isEmpty()){
           System.out.println("Impossivel ordenar os livros");
           System.out.println("Retornando ao menu...");
           try {
               Thread.sleep(2000); // Pausa por 2 segundos
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
               }
               return;
       }
       System.out.println("Lista de livros do Genero: " + genero +" na biblioteca:");
       for (Livro livro : livrosGenero) {
           System.out.println(livro);
       }
       //os livros ficarao ate apertar qualquer tecla do teclado
       System.out.println("Pressione ENTER para sair: ");
       scanner.nextLine();
    }

        //Imprimir Lista por editora
        public void imprimirLivrosEditora(String editora) {
            //verifica se livros esta vazio
            if (livros.isEmpty()) {
               System.out.println("Não há livros na biblioteca.");
               System.out.println("Retornando ao menu...");
               try {
                   Thread.sleep(2000); // Pausa por 2 segundos
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
                   }
                   return;
               }
           //cria uma lista nova com os livros da editora
           List<Livro> livrosEditora = new ArrayList<>();
           for (Livro livro : livros) {
               if (livro.getEditoraNome().equalsIgnoreCase(editora)){
                   livrosEditora.add(livro);
               }
           }
           if (livrosEditora.isEmpty()){
               System.out.println("Impossivel ordenar os livros");
               System.out.println("Retornando ao menu...");
               try {
                   Thread.sleep(2000); // Pausa por 2 segundos
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
                   }
                   return;
           }
           System.out.println("Lista de livros da editora: " + editora +" na biblioteca:");
           for (Livro livro : livrosEditora) {
               System.out.println(livro);
           }
           //os livros ficarao ate apertar qualquer tecla do teclado
           System.out.println("Pressione ENTER para sair: ");
           scanner.nextLine();
   }

    

    //metodo para procurar livro por titulo e retorna um livro
    //pesquisar serve para metodos enquanto procurar para print de um livro
    public Livro pesquisarLivro(String titulo){
        for (Livro livro: livros){
            if(livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }
    //metodo para procurar um livro
    public void procurarLivro(String titulo){
        Livro livro = pesquisarLivro(titulo);
        if (livro != null){
            System.out.println("Livro encontrado!");
            System.out.println(livro);
        } else System.out.println("Livro nao encontrado!");
        System.out.println("Pressione ENTER para sair: ");
        scanner.nextLine();     
        return;
    }


    //Criar um metodo para remover e para pesquisar um livro (não sei se precisa ser por autor, genero etc... talvez só titulo)
    public void removeLivros(String titulo){
        Livro livro = pesquisarLivro(titulo);
        if (livro != null){
            System.out.println("Removendo livro: " +livro.getTitulo());
            livros.remove(livro);
        } else System.out.println("Livro nao encontrado...");
        System.out.println("Voltando ao menu...");
        try {
            Thread.sleep(2000); // Pausa por 2 segundos
            } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            }
        salvarDados();
    }
    public void removeLivrosSemTexto(String titulo){
        Livro livro = pesquisarLivro(titulo);
        if (livro != null){
            System.out.println("Removendo livro: " +livro.getTitulo());
            livros.remove(livro);
        } else System.out.println("Livro nao encontrado...");
        System.out.println("Voltando ao menu...");
        try {
            Thread.sleep(2000); // Pausa por 2 segundos
            } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            }
        salvarDados();
    }

    //metodo para salvar os dados no arquivo
    private void salvarDados() {
        List<String> data = new ArrayList<>();
        for (Livro livro : livros) {
            data.add(livro.getTitulo() + "," + livro.getAutorNome() + "," + livro.getGeneroNome() + "," + livro.getEditoraNome());
        }
        fileManager.saveToFile(data);
    }

}
