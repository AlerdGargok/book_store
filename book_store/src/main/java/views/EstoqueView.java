package views;

import java.util.InputMismatchException;
import java.util.List;

import controllers.Estoque;
import models.*;


public class EstoqueView extends View implements interfaceView{
    
        private String tituloLivro;
    private Autor autorLivro;
    private Genero generoLivro;
    private Editora editoraLivro;
    private double valorLivro;

    List<Genero> generos = Genero.getnomeGenero();
    List<Editora> editoras = Editora.getnomeEditora();

    public Integer imprimirMenuEstoque() {
        Integer escolha = scanner.nextInt();
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("               [Gerenciamento de Estoque]                 \n");
        System.out.println("==========================================================");
        System.out.println();
        System.out.println("           -> Escolha uma das opções abaixo: <-           ");
        System.out.println();
        System.out.println("==========================================================\n");
        System.out.println("                [1] Adicionar um novo livro               ");
        System.out.println("                [2] Remover um livro                      ");
        System.out.println("                [3] Pesquisar um livro                    ");
        System.out.println("                [4] Listar estoque                        ");
        System.out.println("                [5] Voltar                                  ");
        System.out.println("==========================================================");
        System.out.println();
        System.out.println();
        System.out.println("Sua escolha: ");
        scanner.next();
        escolha = scanner.nextInt();

        if ((escolha /1) != escolha) System.out.println("Entrada incorreta!");

        return escolha;
    
    }

    // Segmentação do menu para a adição de livros, recebe do usuário os argumentos
    // da classe Livro
    // Em genero e editora é impresso para o usuário uma lista pre-estabelecida para
    // ser escolhida qual ser utilizada

    public void adicionarLivro() {
        //cont++;
        Flush();
        //if (cont > 1)
            scanner.nextLine();
        System.out.println("==========================================================\n");
        System.out.println("                 [Adicionar um novo Livro]                \n");
        System.out.println("==========================================================");
        System.out.println();
        System.out.println("                  Insira o titulo do livro:               \n");
        System.out.println("Titulo: ");
        tituloLivro = scanner.nextLine();

        System.out.println("                  Insira o autor do livro:                \n");
        System.out.println("Autor: ");

        String nomeAutor = scanner.nextLine();
        autorLivro = new Autor(nomeAutor);

        System.out.println("                Selecione o genero do livro:              \n");
        imprimirGenero();

        System.out.println("Genero: ");
        Integer opGenero = scanner.nextInt();

        switch (opGenero) {
            case 1:
                generoLivro = new Genero("Romance");
                break;
            case 2:
                generoLivro = new Genero("Infantil");
                break;
            case 3:
                generoLivro = new Genero("Ficcao");
                break;
            case 4:
                generoLivro = new Genero("Suspense");
                break;
            case 5:
                generoLivro = new Genero("Biografia");
                break;
            default:
                System.out.println("Opçao invalida, retornando ao menu...");
                try {
                    Thread.sleep(2000); // Pausa por 2 segundos
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return;
        }

        System.out.println("                Selecione a editora do livro:              \n");
        imprimirEditora();

        System.out.println("Editora: ");
        Integer opEditora = scanner.nextInt();

        switch (opEditora) {
            case 1:
                editoraLivro = new Editora("Companhia das Letras");
                break;
            case 2:
                editoraLivro = new Editora("Record");
                break;
            case 3:
                editoraLivro = new Editora("Intrinseca");
                break;
            case 4:
                editoraLivro = new Editora("Sextante");
                break;
            case 5:
                editoraLivro = new Editora("Globo Livros");
                break;
            default:
                System.out.println("Opçao invalida, retornando ao menu...");
                try {
                    Thread.sleep(2000); // Pausa por 2 segundos
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return;
        }

        System.out.println("                  Insira o valor do livro:               \n");
        System.out.println("Valor: ");
        valorLivro = scanner.nextDouble();

    }

    public void removerLivros() {
        System.out.println("==========================================================\n");
        System.out.println("                     [Remover um Livro]                   \n");
        System.out.println("==========================================================");
        System.out.println("                  Digite o nome do livro:              \n");
    }

    public void pesquisarLivro() {
        System.out.println("==========================================================\n");
        System.out.println("                      [Pesquisar Livro]                \n");
        System.out.println("==========================================================");
        System.out.println("                  Digite o nome do livro:              \n");
    }

    public Integer ListarLivro() {
        int escolha;
        System.out.println("==========================================================\n");
        System.out.println("                      [Listar estoque]                \n");
        System.out.println("==========================================================");
        System.out.println("                  De que maneira deseja listar?              \n");
        System.out.println("                  [1] Listar por ordem de inserção              \n");
        System.out.println("                  [2] Listar por Titulo              \n");
        System.out.println("                  [3] Listar por Autor              \n");
        System.out.println("                  [4] Listar por Genero              \n");
        System.out.println("                  [5] Listar por Editora             \n");
        System.out.println("==========================================================");

        System.out.println("Digite: ");
        escolha = scanner.nextInt();
        return escolha;
    }

    // Imprime a lista de generos pre-estabelecidos
    public void imprimirGenero() {
        System.out.println("Generos Disponiveis:");
        for (Genero genero : generos) {
            System.out.println(genero);
        }
    }

    // Imprime a lista de editoras pre-estabelecidas
    public void imprimirEditora() {
        System.out.println("Editoras Disponiveis:");
        for (Editora editora : editoras) {
            System.out.println(editora);
        }
    }

    public String get_tituloLivro() {
        return tituloLivro;
    }

    public Autor get_autorLivro() {
        return autorLivro;
    }

    public Genero get_generoLivro() {
        return generoLivro;
    }

    public Editora get_editoraLivro() {
        return editoraLivro;
    }

    public double getValorLivro() {
        return valorLivro;
    }
}
