package model;

import java.io.Serializable;
import java.util.Objects;

public final class Terror extends Libro implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Double rating;

    public Terror() {}

    public Terror(String titulo, String autor, String isbn, int numPag, Double rating) {
        super(titulo, autor, isbn, numPag);
        this.rating = rating;
    }

    public Double getRating() {return rating;}

    public void setRating(Double rating) {this.rating = rating;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Terror terror)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(rating, terror.rating);
    }
    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), rating);}
    @Override
    public String toString() {
        return super.toString() +
                ", Rating: " + rating;
    }

}
