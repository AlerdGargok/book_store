package models;

import java.util.ArrayList;
import java.util.List;

// Constroi o obejto editora e também cria um metodo estatico no formato de lista dinamica para algumas editoras escolhidas previamente que serão as opções do usuário na inserção

public class Editora {
    private String nome;
    private static List<Editora> nomeEditora;

    public Editora(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    // mudar para controller

    static {
        Editora editora1 = new Editora("[1] Companhia das Letras");
        Editora editora2 = new Editora("[2] Record");
        Editora editora3 = new Editora("[3] Intrinseca");
        Editora editora4 = new Editora("[4] Sextante");
        Editora editora5 = new Editora("[5] Globo Livros");

        nomeEditora = new ArrayList<>();
        nomeEditora.add(editora1);
        nomeEditora.add(editora2);
        nomeEditora.add(editora3);
        nomeEditora.add(editora4);
        nomeEditora.add(editora5);
    }

    public static List<Editora> getnomeEditora() {
        return nomeEditora;
    }

}
