package java;

//Constroi um objeto livro a partir dos outros obejtos autor, genero e editora. Recebe também uma string com o titulo do livro

public class Livro {
    private String titulo;
    private Autor autor;
    private Genero genero;
    private Editora editora;

    public Livro(String titulo, Autor autor, Genero genero, Editora editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getAutorNome(){
        return autor.getNome();
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getGeneroNome(){
        return genero.getGenero();
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Editora getEditora() {
        return editora;
    }

    public String getEditoraNome(){
        return editora.getNome();
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
    return "Título: " + titulo + ", Autor: " + autor + ", Gênero: " + genero + ", Editora: " + editora;
}



}