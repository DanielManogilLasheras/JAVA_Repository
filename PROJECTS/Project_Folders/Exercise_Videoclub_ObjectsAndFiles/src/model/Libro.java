package model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Libro implements Serializable {
    private String titulo,autor,isbn;
    private int numPag;

    public Libro() {}

    public Libro(String titulo, String autor, String isbn, int numPag) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.numPag = numPag;
    }

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getAutor() {return autor;}

    public void setAutor(String autor) {this.autor = autor;}

    public String getIsbn() {return isbn;}

    public void setIsbn(String isbn) {this.isbn = isbn;}

    public int getNumPag() {return numPag;}

    public void setNumPag(int numPag) {this.numPag = numPag;}

    @Override
    public String toString() {
        return
                "Titulo:'" + titulo + '\'' +
                ", Autor:'" + autor + '\'' +
                ", ISBN:'" + isbn + '\'' +
                ", Número de páginas:" + numPag;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro libro)) return false;
        return numPag == libro.numPag && Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor) && Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {return Objects.hash(titulo, autor, isbn, numPag);}
}

