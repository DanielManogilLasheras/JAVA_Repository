package controller;

import Exceptions.CantidadMaximaDeLibrosException;
import Exceptions.LibroEnBusquedaNoEncontradoException;
import model.Libro;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Catalogo {
    private String nombreCatalogo;
    private int numLibros;
    ArrayList<Libro>listalibros;
    //CONSTRUCTORES
    public Catalogo() {
        listalibros=new ArrayList<>();
    }

    public Catalogo(String nombreCatalogo, int numLibros, ArrayList<Libro> listalibros) {
        this.nombreCatalogo = nombreCatalogo;
        this.numLibros = numLibros;
        this.listalibros = listalibros;
    }
    //GETTERS Y SETTERS
    public String getNombreCatalogo() {
        return nombreCatalogo;
    }

    public void setNombreCatalogo(String nombreCatalogo) {
        this.nombreCatalogo = nombreCatalogo;
    }

    public int getNumLibros() {
        return numLibros;
    }

    public void setNumLibros(int numLibros) {
        this.numLibros = numLibros;
    }

    public ArrayList<Libro> getListalibros() {
        return listalibros;
    }

    public void setListalibros(ArrayList<Libro> listalibros) {
        this.listalibros = listalibros;
    }
    //TOSTRING
    @Override
    public String toString() {
        return "Catalogo{" +
                "nombreCatalogo='" + nombreCatalogo + '\'' +
                ", numLibros=" + numLibros +
                ", listalibros=" + listalibros +
                '}';
    }
    public void agregarLibro(Libro elemento) throws CantidadMaximaDeLibrosException { //AGREGAR LIBRO AL CATÁLOGO
            if(estaLibro(elemento)==null){
                System.out.println("El libro que intenta agregar ya se encuentra en el catálogo.");
            }else{
                try{
                    if(numLibros==listalibros.size()){
                        throw new CantidadMaximaDeLibrosException("Mala");
                    }else{
                        this.listalibros.add(elemento);
                        System.out.println("Libro agregado");
                    }
                }catch (Exception e){
                    System.out.println("Excepción controlada: Ha intentado sobrepasar la cantidad máxima de libros");
                }
            }
    }
    public Libro estaLibro(Libro libro){ //CONFIRMA QUE NO EXISTE EL LIBRO A AÑADIR
        System.out.println("------>");
        for (Libro item: listalibros){
            if(item.equals(libro)){
                System.out.println("Libro encontrado en el catálogo.");
                return null;
            }
        }
        System.out.println("Libro no encontrado en el catálogo.");
        return libro;
    }
    public void quitarLibro(ArrayList<Libro> conjuntobusqueda){ //BUSCAR Y ELIMINAR LIBRO DEL CATÁLOGO
        boolean exiteliminacion=false;
        if(conjuntobusqueda.isEmpty()){
            System.out.println("Su operación ha sido cancelada porque no hay ningun libro con este ISBN.");
        }else{
            System.out.println("¿Cuál de las coincidencias desea eliminar?");
            System.out.println("Pulse 0 para cancelar la operación");
            do{
                Scanner sc2=new Scanner(System.in);
                int respuesta=sc2.nextInt();
                sc2.nextLine();
                switch (respuesta){
                    case 0:
                        System.out.println("Cancelando operación");
                        exiteliminacion=true;
                        break;
                    default:
                        if(respuesta<=conjuntobusqueda.size()){
                            Libro elementoselect= conjuntobusqueda.get(respuesta-1);
                            listalibros.remove(elementoselect);
                            System.out.println("Elemento eliminado");
                            exiteliminacion=true;
                        }else{
                            System.out.println("Ha habido un problema en la eliminación, volviendo al menú.");
                        }
                        break;
                }
            }while(!exiteliminacion);
        }
    }
    public ArrayList<Libro> buscarLibro(String isbn) throws LibroEnBusquedaNoEncontradoException { //BUSCAR LIBRO EN CATALOGO
        int incremento=0;
        ArrayList<Libro>conjuntoBusqueda=new ArrayList<>();
        for(Libro item:listalibros){
            if(item.getIsbn().equals(isbn)){
                conjuntoBusqueda.add(item);
            }
        }
        System.out.println("Se han encontrado " + conjuntoBusqueda.size() + " coincidencias");
        try{
            if(conjuntoBusqueda.isEmpty()){
                throw new LibroEnBusquedaNoEncontradoException();
            }
            else{
                for (Libro item:conjuntoBusqueda){
                    System.out.println("Libro nº"  + (incremento=incremento+1) +": "+ item.toString());
                }
            }
        }catch(Exception e){
            System.out.println("Excepción controlada. No se ha encontrado este libro en el catálogo, volviendo al menú.");
        }
        return conjuntoBusqueda;
    }
    public void mostrarLibrosCat(){ //MOSTRAR LIBROS DEL CATÁLOGO
        for (Libro item : listalibros){
            System.out.println(item.toString());
        }
    }
    public void escribirCatalogo() throws IOException,ClassNotFoundException,ClassCastException { //EXPORTAR LIBROS DEL CATALOGO A FICHERO
        ObjectOutputStream objectOutputStream=null;
        try{
            File file=new File("src/files/Exportacion.obj");
            objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(listalibros);
        }catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("Error en cerrado");
            } catch (NullPointerException e) {
                System.out.println("Cerrado en nulo");
            }
        }
    }
}

/*
Se puede usar esto para testear.

 */