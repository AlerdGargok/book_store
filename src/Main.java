import java.util.List;
import java.util.Scanner;


import model.Autor;
import model.Biblioteca;
import model.Editora;
import model.Genero;
import model.Livro;

import util.*;
import util.user.Cadastro;
import util.user.User;


/*Faz um loop para imprimir o menu enquanto o usuário não selecionar a opção de sair ou o programa finalizar
Recebe os valores inseridos pelo usuário na classe interface para adicionar livros e chama o construtor para ser enviado ao arraylist da classe Biblioteca
Recebe os valores de pesquisa e remoção dos itens para serem aplicados na classe bilbioteca
*/

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        View user = new View();
        Biblioteca biblioteca = new Biblioteca("dados.txt");
        Cadastro cadastro = new Cadastro();
        boolean menuLoop = true;
        Integer opMenu;

        User user1 = new User("user1", "senha12345", "12345678901");
        cadastro.addUsuario(user1);

        User user2 = new User("user2", "senha54321", "10987654321");
        cadastro.addUsuario(user2);

        do{
            user.Flush();
            user.imprimirInicio();
            cadastro.listarUsuarios();
            opMenu=scanner.nextInt();
                
            switch(opMenu) {
                case 1 :
                user.imprimirLoginUser();
                break;

                case 2:
                user.imprimirCadastroUser();

                break;
            }
        }while(menuLoop);

        /** 
        Integer escolha;
        String procura; // variavel para procurar por autor, genero ou editora

        do {
            user.Flush();
            user.imprimirMenu();
            opMenu = scanner.nextInt();
            user.Flush();
            switch (opMenu) {
                case 1:
                    user.adicionarLivro();

                    String titulo = user.get_tituloLivro();
                    Autor autor = user.get_autorLivro();
                    Genero genero = user.get_generoLivro();
                    Editora editora = user.get_editoraLivro();
                    double valorLivro = user.getValorLivro();

                    Livro novoLivro = new Livro(titulo, autor, genero, editora, valorLivro);
                    user.Flush();
                    biblioteca.addLivros(novoLivro);
                    break;

                case 2:
                    user.removerLivros();
                    titulo = scanner.next();
                    biblioteca.removeLivros(titulo);
                    break;

                case 3:
                    user.pesquisarLivro();
                    titulo = scanner.next();
                    biblioteca.procurarLivro(titulo);

                    break;

                case 4:
                    // pede o tipo de listagem desejada
                    escolha = user.ListarLivro();
                    if (escolha == 1)
                        biblioteca.imprimirLivros();
                    if (escolha == 2)
                        biblioteca.imprimirLivrosOrdenados();
                    if (escolha == 3) {
                        System.out.println("Digite o nome do autor: ");
                        procura = scanner.next();
                        biblioteca.imprimirLivrosAutor(procura);
                    }
                    if (escolha == 4) {
                        System.out.println("Digite o nome do genero: ");
                        procura = scanner.next();
                        biblioteca.imprimirLivrosGenero(procura);
                    }
                    if (escolha == 5) {
                        System.out.println("Digite o nome da editora: ");
                        procura = scanner.next();
                        biblioteca.imprimirLivrosEditora(procura);
                    }

                    break;

                case 5:
                    menuLoop = false;
                    break;

            }

        } while (menuLoop);
        */
    }
        
}
