import modelos.*;
import util.*;

import java.util.Scanner;

/*Faz um loop para imprimir o menu enquanto o usuário não selecionar a opção de sair ou o programa finalizar
Recebe os valores inseridos pelo usuário na classe interface para adicionar livros e chama o construtor para ser enviado ao arraylist da classe Biblioteca
Recebe os valores de pesquisa e remoção dos itens para serem aplicados na classe bilbioteca
*/

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Interface user = new Interface();
        Biblioteca biblioteca = new Biblioteca("dados.txt");
        boolean menuLoop = true;
        Integer opMenu;
        Integer escolha;
        String procura; //variavel para procurar por autor, genero ou editora

        do{
            user.Flush();
            user.imprimirMenu();
            opMenu = scanner.nextInt();
            user.Flush();
            switch (opMenu){
                case 1:
                user.adicionarLivro();

                String titulo = user.get_tituloLivro();
                Autor autor = user.get_autorLivro();
                Genero genero = user.get_generoLivro();
                Editora editora = user.get_editoraLivro();

                Livro novoLivro = new Livro(titulo, autor, genero, editora);
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
                //pede o tipo de listagem desejada
                escolha = user.ListarLivro();
                if (escolha == 1) biblioteca.imprimirLivros();
                if (escolha == 2) biblioteca.imprimirLivrosOrdenados();
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

        }while(menuLoop);

    }
}
