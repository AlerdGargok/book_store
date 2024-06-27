package models;

//Constroi um objeto livro a partir dos outros obejtos autor, genero e editora. Recebe também uma string com o titulo do livro

public class Livro {
    private String titulo;
    private Autor autor;
    private Genero genero;
    private Editora editora;
    private double valor;
    
    public Livro(String titulo, Autor autor, Genero genero, Editora editora, double valor) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
        this.valor = valor;
    }
    //esse é o metodo padrao para criar um livro sem valor, caso isso aconteça ele cai nesse
    public Livro(String titulo, Autor autor, Genero genero, Editora editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
    }

    //get e set do titulo do livro
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //Get e set do autor do livro
    public Autor getAutor() {
        return autor;
    }

    public String getAutorNome(){
        return autor.getNome();
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    //Get e set do genero do livro
    public Genero getGenero() {
        return genero;
    }

    public String getGeneroNome(){
        return genero.getGenero();
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    //Get e set da editora do livro
    public Editora getEditora() {
        return editora;
    }

    public String getEditoraNome(){
        return editora.getNome();
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    
    //Get e set do valor do livro
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public double getValor() {
        return valor;
    }


   @Override
    public String toString() {
        //caso o livro nao tenha valor mostrar sem o valor mesmo 
        try {
            return "Título: " + titulo + ", Autor: " + autor + ", Gênero: " + genero + ", Editora: " + editora + ", Valor: R$" + valor;
        } catch (Exception e) {
            return "Título: " + titulo + ", Autor: " + autor + ", Gênero: " + genero + ", Editora: " + editora;
        }
    }   



}