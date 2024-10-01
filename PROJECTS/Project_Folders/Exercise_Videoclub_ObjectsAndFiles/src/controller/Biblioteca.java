package controller;
import Exceptions.CantidadMaximaDeLibrosException;
import Exceptions.LibroEnBusquedaNoEncontradoException;
import Exceptions.NoExisteCatalogoExcepcion;
import model.Libro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca<T extends Libro>{
    private String nombre,director;
    private Catalogo catalogo;
    private ArrayList<T> biblioteca;
    //CONSTRUCTORES
    public Biblioteca() {
        biblioteca=new ArrayList<>();
    }

    public Biblioteca(String nombre, String director, Catalogo catalogo, ArrayList<T> biblioteca) {
        this.nombre = nombre;
        this.director = director;
        this.catalogo = catalogo;
        this.biblioteca = biblioteca;
    }
    //SETTERS Y GETTERS
    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDirector() {return director;}

    public void setDirector(String director) {this.director = director;}

    public Catalogo getCatalogo() {return catalogo;}

    public void setCatalogo(Catalogo catalogo) {this.catalogo = catalogo;}

    public ArrayList<T> getBiblioteca() {return biblioteca;}

    public void setBiblioteca(ArrayList<T> biblioteca) {this.biblioteca = biblioteca;}

    public void mostrardatosBiblioteca(){ //MOSTRAR DATOS BÁSICOS DE BIBLIOTECA
        System.out.println("Biblioteca: " + getNombre() +" ---- " + "Director: " + getDirector());
    }
    //OPCIONES DE BIBLIOTECA
    public void agregarLibro(T libro) { //AGREGAR LIBRO A BIBLIOTECA
        System.out.println("------>");
        if (estaLibro2(libro) != null){

            System.out.println("Agregado correctamente");
            this.biblioteca.add(libro);
        } else {
            System.out.println("Cancelado");
        }
    }
    public Libro estaLibro2(T libro){ //CONFIRMACIÓN PARA NO AÑADIR DUPLICADOS
        System.out.println("------>");
        for (Libro item: biblioteca){
            if(item.equals(libro)){
                System.out.println("Libro encontrado en la biblioteca");
                return null;
            }
        }
        System.out.println("Libro no encontrado en la biblioteca");
        return libro;
    }
    public void mostrarLibros() { //MOSTRAR TODOS LOS LIBROS DE LA BIBLIOTECA
        System.out.println("|------------------------------------------------------------|");
        System.out.println("Desplegando lista de libros:");
        for (T item : biblioteca){
            System.out.println(item.toString());
        }
    }
    public ArrayList<T> buscarLibro(String isbn) throws LibroEnBusquedaNoEncontradoException{ //BUSCAR UN LIBRO, SIRVE PARA AGREGAR LIBROS AL CATÁLOGO DESDE LA BIBLIOTECA
        int incremento=0;
        ArrayList<T>conjuntoBusqueda=new ArrayList<>();
       for(T item:biblioteca){
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
               for (T item:conjuntoBusqueda){
                   System.out.println("Libro nº"  + (incremento=incremento+1) +": "+ item.toString());
               }
           }
       }catch(Exception e){
           System.out.println("\"Excepción controlada: No se ha encontrado ningún libro en la biblioteca, volviendo al menú.\"");
       }finally{

       }

       return conjuntoBusqueda;
    }
    public void eliminarLibro(ArrayList<T>conjuntobusqueda) { //ELIMINAR LIBRO DE BIBLIOTECA
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
                            T elementoselect= conjuntobusqueda.get(respuesta-1);
                            biblioteca.remove(elementoselect);
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
    //FUNCIONES DEL CATÁLOGO
    public Catalogo crearCatalogo(){ //CREA UN CATÁLOGO
                Catalogo catalogo=new Catalogo();
                Scanner sc=new Scanner(System.in);
                System.out.println("A continuación, elija un nombre para su catálogo.");
                String respCatStr=sc.nextLine();
                catalogo.setNombreCatalogo(respCatStr);
                System.out.println("Elija cuántos libros quiere que tenga su catálogo");
                int respCatInt= sc.nextInt();
                catalogo.setNumLibros(respCatInt);
                System.out.println("Su catálogo ha sido creado y a continuación se mostrará:\n");
                System.out.println(catalogo.toString());
                return catalogo;
    }
    public void eliminarcatalogo(){ //ELIMINAR CATÁLOGO
        catalogo=null;
    }
    //FUNCIONES DEL CATÁLOGO QUE NECESITAN MÉTODOS DE CATÁLOGO
    public void agregarlibrocat(ArrayList<T> conjuntobusqueda) throws CantidadMaximaDeLibrosException { //AGREGAR LIBRO A CATÁLOGO
        boolean exit=false;
        if(conjuntobusqueda.isEmpty()){
            System.out.println("Su operación ha sido cancelada porque no hay ningun libro con este ISBN.");
        }else{
            System.out.println("¿Cuál de las coincidencias desea agregar al catalogo?");
            System.out.println("Pulse 0 para cancelar la operación");
            do{
                Scanner sc2=new Scanner(System.in);
                int respuesta=sc2.nextInt();
                sc2.nextLine();
                switch (respuesta){
                    case 0:
                        System.out.println("Cancelando operación");
                        exit=true;
                        break;
                    default:
                        if(respuesta<=conjuntobusqueda.size()){
                            T elementoselect= conjuntobusqueda.get(respuesta-1);
                            catalogo.agregarLibro(elementoselect);
                            exit=true;
                        }else{
                            System.out.println("Ha habido un problema en la eliminación, volviendo al menú.");
                            exit=true;
                        }
                        break;
                }
            }while(!exit);
        }
    }

    public void quitarlibroCat() throws LibroEnBusquedaNoEncontradoException { //QUITAR LIBRO DE CATÁLOGO
        Scanner sc=new Scanner(System.in);
        String resStr=sc.next();
        catalogo.quitarLibro(catalogo.buscarLibro(resStr));

    }
    public void buscarCatalogo(String str) throws LibroEnBusquedaNoEncontradoException { //BUSCAR LIBRO EN EL CATÁLOGO
        catalogo.buscarLibro(str);
    }
    public void mostrarcatalogo(){
        catalogo.mostrarLibrosCat();
    } //MOSTRAR TODOS LOS LIBROS DEL CATÁLOGO

    public void exportarCatalogo() throws IOException, ClassNotFoundException { //EXPORTAR CATÁLOGO
        catalogo.escribirCatalogo();
    }
}
