package model;

import model.enums.Trama;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public final class Policiaca extends Libro implements Serializable {
    private static final long serialVersionUID = 6529685098267757689L;
    private Trama trama;
    private String[]personajes;

    public Policiaca() {
        personajes=new String[0];
    }

    public Policiaca(String titulo, String autor, String isbn, int numPag, Trama trama, String[] personajes) {
        super(titulo, autor, isbn, numPag);
        this.trama = trama;
        this.personajes = personajes;
    }
    public Trama getTrama() {return trama;}

    public void setTrama(Trama trama) {this.trama = trama;}

    public String[] getPersonajes() {return personajes;}

    public void setPersonajes(String[] personajes) {this.personajes = personajes;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policiaca policiaca)) return false;
        if (!super.equals(o)) return false;
        return trama == policiaca.trama && Arrays.equals(personajes, policiaca.personajes);
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), trama);
        result = 31 * result + Arrays.hashCode(personajes);
        return result;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", Trama: " + trama +
                ", Listado de personajes:" + Arrays.toString(personajes) ;
    }
}
