package java;

import java.util.ArrayList;
import java.util.List;

// Constroi a classe genero e também cria um metodo estatico no formato de lista dinamica para alguns generos escolhidos previamente que serão as opções do usuário na inserção

public class Genero {
    private String nome;
    private static List<Genero> nomeGenero;

    public Genero(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return nome;
    }

    public void setGenero(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }


    static {
        Genero genero1 = new Genero("[1] Romance");
        Genero genero2 = new Genero("[2] Infatil");
        Genero genero3 = new Genero("[3] Ficcao");
        Genero genero4 = new Genero("[4] Suspense");
        Genero genero5 = new Genero("[5] Biografia");

        nomeGenero = new ArrayList<>();
        nomeGenero.add(genero1);
        nomeGenero.add(genero2);
        nomeGenero.add(genero3);
        nomeGenero.add(genero4);
        nomeGenero.add(genero5);

    }

    public static List<Genero> getnomeGenero() {
        return nomeGenero;
    }

}

