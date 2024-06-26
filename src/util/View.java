package util;

import java.util.List;
import java.util.Scanner;
import model.*;
import util.user.*;

public class View implements testInterface {
    private static Scanner scanner = new Scanner(System.in);

    private String tituloLivro;
    private Autor autorLivro;
    private Genero generoLivro;
    private Editora editoraLivro;
    private double valorLivro;

    private String username;
    private String senha;
    private String cpf;

    private boolean usernameValido;
    private boolean cpfValido;
    private boolean senhaValida;
    private boolean cpfRegistrado;

    // Chama as listas estáticas de genero e editora (Já previamente selecionadas para o usuário)
    List<Genero> generos = Genero.getnomeGenero();
    List<Editora> editoras = Editora.getnomeEditora();

    // Limpa o terminal do usuário
    public void Flush() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void imprimirInicio() {
        System.out.println("==========================================================\n");
        System.out.println("                      [BOOK STORE]                        \n");
        System.out.println("==========================================================");
        System.out.println();
        System.out.println("                     SEJA BEM VINDO!                      \n");
        System.out.println("         -> Faça o login ou cadastre-se abaixo: <-        ");
        System.out.println();
        System.out.println("==========================================================\n");
        System.out.println("                      [1] Login                           ");
        System.out.println("                      [2] Cadastro                        ");
        System.out.println("                      [3] Administrador                   ");
        System.out.println("                      [4] Sair                            ");
        System.out.println("==========================================================");
        System.out.println();
        System.out.println();
        System.out.println("Sua escolha: ");
    }

    public void imprimirLoginAdm(){
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                    [Login - ADM]                         \n");
        System.out.println("==========================================================");

        senhaValida = false;
        while(!senhaValida) {
            System.out.println("                   Insira sua senha:                      \n");
        }
    }

    public void imprimirLoginUser() {
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                    [Login - Usuário]                     \n");
        System.out.println("==========================================================");
        System.out.println();

        usernameValido = false;
        while(!usernameValido){
            System.out.println("                 Insira o seu username:                   \n");
            username = scanner.next();
            usernameValido = cadastro.validarUser(username);

            if(!usernameValido) {
                System.out.println("       Username não existe, digite novamente          \n");
            }
        }

        senhaValida = false;
        while(!senhaValida) {
            System.out.println("                   Insira sua senha:                      \n");
            System.out.println("        *Caso tenha esquecido sua senha insira '0'*       \n");
            senha = scanner.next();
            if(senha.equals("0")) recuperarSenha();
            senhaValida = cadastro.validarUser_Senha(senha);

            if (!senhaValida) {
                System.out.println("          Senha inválida, digite novamente             \n");
            }
        }

        //if(cadastro.verificaAdm(username, senha)) imprimirAdm();
        //else  {
            System.out.println("          Login efetuado com sucesso!            \n");
            cadastro.setUsuarioAtual(username);
            try {
                Thread.sleep(2000); // Pausa por 2 segundos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            //return 1;
       // }
        
        //return 0; // caso retorne 0 - deu errado, caso retorne 1- va para o menu de usuario e caso retorne 2 - menu adm
        //arrumar aq dps

        imprimirMenuUsuario();
    }

    //espaço para usuario
    public int imprimirMenuUsuario() {
        int escolha;
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                      [BOOK STORE]                        \n");
        System.out.println("==========================================================");
        System.out.println();
        System.out.printf("                  SEJA BEM VINDO, %s!                 \n", cadastro.getUsuarioAtual().getUsername());
        System.out.println();
        System.out.println("==========================================================");

        try {
            Thread.sleep(1000); // Pausa por 2 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                  [OPÇÕES DO USUÁRIO]                     \n");
        System.out.println("==========================================================");
        System.out.println("             [1] Verificar dados da conta                ");
        System.out.println("             [2] Comprar Livros                          ");
        System.out.println("             [3] Sair da conta                           ");
        System.out.println("==========================================================");
        escolha = scanner.nextInt();
        return escolha;
    }

    public void imprimirDadosUsuario(Cliente usuario){
        System.out.println("==========================================================\n");
        System.out.println("                      [DADOS DA CONTA]                        \n");
        System.out.println("==========================================================");     
        System.out.printf("                    Nome de Usuário: %s                           \n", cadastro.getUsuarioAtual().getUsername());
        System.out.printf("                    Saldo da Conta: R$ %.2f                        \n", cadastro.getUsuarioAtual().getSaldo());
        System.out.println();
        System.out.println("                        [1] Adicionar Saldo                       ");
        System.out.println("                        [2] Retornar ao menu                           ");
        int escolha = scanner.nextInt();
        if (escolha == 1){
            adicionarSaldo();
        }

    }

    

    public void adicionarSaldo(){
        System.out.println("==========================================================\n");
        System.out.println("                      [SALDO DA CONTA]                        \n");
        System.out.println("==========================================================");
        System.out.printf("                  Você possui :%.2f                      \n", cadastro.getUsuarioAtual().getSaldo()); 
        System.out.println("Adicionar: "); 
        double aumentarSaldo = scanner.nextDouble();
        try {
            cadastro.getUsuarioAtual().adicionarSaldo(aumentarSaldo);
            System.out.println("Saldo adicionado, Retornando...");
        } catch (Exception e) {
            System.out.println("Impossivel adicionar saldo!");
        }
    }


    //fim espaço usuario
    
    public void imprimirAdm() {
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                      [BOOK STORE]                        \n");
        System.out.println("==========================================================");
        scanner.nextLine();
        scanner.nextLine();
    }

    //
    public void imprimirCadastroUser() {
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                   [Cadastro - Usuário]                   \n");
        System.out.println("==========================================================");
        System.out.println();
        
        usernameValido = true;
        while(usernameValido){
            System.out.println("                Insira o username desejado:               \n");
            username = scanner.next();
            usernameValido = cadastro.validarUser(username);

            if(usernameValido) {
                System.out.println("     Username não disponível, digite novamente        \n");
            }
        }

        cpfValido = false;
        cpfRegistrado = true;
        while (!cpfValido) {
            System.out.println("            Insira o seu CPF: (Apenas números)            \n");
            cpf = scanner.next();
            cpfValido = cadastro.validarCpf(cpf);
            cpfRegistrado = cadastro.validarUser_Cpf(cpf);

            if (!cpfValido || cpfRegistrado) {
                System.out.println("          CPF inválido, digite novamente              \n");
            }
        }

        senhaValida = false;
        while(!senhaValida) {
            System.out.println("                   Insira uma senha:                      \n");
            senha = scanner.next();
            senhaValida = cadastro.validarSenha(senha);

            if (!senhaValida) {
                System.out.println("          Senha inválida, digite novamente             \n");
            }
        }


        Cliente novoUsuario = new Cliente(username, cpf, senha);
        cadastro.addUsuario(novoUsuario);

        System.out.println();
        System.out.println("   Cadastro concluído com sucesso! Voltando para o menu...     \n");
        try {
            Thread.sleep(2000); // Pausa por 2 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void recuperarSenha() {
        Flush();
        System.out.println("==========================================================\n");
        System.out.println("                    [Recuperar Senha]                     \n");
        System.out.println("==========================================================");
        System.out.println();

        usernameValido = true;
        while(usernameValido){
            System.out.println("                 Insira o seu username:                   \n");
            username = scanner.next();
            usernameValido = cadastro.validarUser_Senha(username);

            if(usernameValido) {
                System.out.println("       Username não existe, digite novamente          \n");
            }
        }

        cpfValido = false;
        while(!cpfValido){
            System.out.println("                   Insira o seu CPF:                      \n");
            cpf = scanner.next();
            cpfValido = cadastro.validarUser_Cpf(cpf);

            if(!cpfValido) {
                System.out.println("          CPF inválido, digite novamente              \n");
            }
        }

        senhaValida = false;
        while(!senhaValida) {
            System.out.println("                  Insira uma nova senha:                  \n");
            senha = scanner.next();
            senhaValida = cadastro.validarSenha(senha);

            if (!senhaValida) {
                System.out.println("          Senha inválida, digite novamente             \n");
            }
        }
        System.out.println();
        System.out.println("     Senha cadastrada com sucesso! Voltando para o menu...     \n");
        try {
            Thread.sleep(2000); // Pausa por 2 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        imprimirLoginUser();
    }

    ///////////////////////////

    // Imprime o menu principal;
    public void imprimirMenuEstoque() {
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
        System.out.println("                [5] Sair                                  ");
        System.out.println("==========================================================");
        System.out.println();
        System.out.println();
        System.out.println("Sua escolha: ");
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

    public String get_senha() {
        return senha;
    }

    public String get_Username() {
        return username;
    }

    public String get_Cpf() {
        return cpf;
    }

}