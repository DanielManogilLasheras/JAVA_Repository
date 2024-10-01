import Exceptions.CantidadMaximaDeLibrosException;
import Exceptions.LibroEnBusquedaNoEncontradoException;
import controller.Biblioteca;
import model.enums.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.*;
public class Entrada{
    public static void main(String[] args) throws CantidadMaximaDeLibrosException, LibroEnBusquedaNoEncontradoException, IOException, ClassNotFoundException {
        Biblioteca<Libro>biblioteca=new Biblioteca<>();
        Scanner sc= new Scanner(System.in);
        int respuesta; //CREACIÓN BIBLIOTECA
        System.out.println("BIENVENIDO A SU BIBLIOTECA!");
        System.out.println("INTRODUCCIÓN DE DATOS PERSONALES");
        System.out.println("Introduzca el nombre de su biblioteca. Ejemplo: Biblioteca central de Madrid");
        biblioteca.setNombre(sc.nextLine());
        System.out.println("Introduzca el nombre del director responsable de la biblioteca");
        biblioteca.setDirector(sc.nextLine());
        System.out.println("Su biblioteca ha sido creada, a continuación se le mostrará un menú con las opciones disponibles.");
        boolean exit=false;
        //MENU PRINCIPAL
        do{
            System.out.println("|------------------------------------------------------------|");
            biblioteca.mostrardatosBiblioteca();
            System.out.println("Qué desea hacer?");
            System.out.println ("1. Gestionar libros." + "2. Gestionar catálogo.\n" +
                    "3. Exportar catálogo(Debe crear uno primero) || Pulse cualquier otra tecla para salir");
            respuesta=sc.nextInt();
            sc.nextLine();
            switch (respuesta){
                case 1://MENU DE BIBLIOTECA
                    System.out.println("Esta gestionando su biblioteca");
                    System.out.println("1. Agregar libro nuevo." + " ----- " + "2. Eliminar libro." );
                    System.out.println("3. Buscar libro."  + " ----- " +  "4. Mostrar libros de la biblioteca.");
                    System.out.println("5. Cancelar operacion.");
                    System.out.println("|------------------------------------------------------------|");
                    int navegacion=sc.nextInt();
                    sc.nextLine();
                    switch (navegacion){
                        case 1://CREAR LIBRO EN BIBLIOTECA
                            Libro insercion;
                            System.out.println("|------------------------------------------------------------|");
                            System.out.println("Inserte título del libro:");
                            String insNombre=sc.nextLine();
                            System.out.println("Inserte el autor:");
                            String insAutor=sc.nextLine();
                            System.out.println("Inserte el isbn del libro:");
                            String insIsbn=sc.nextLine();
                            System.out.println("Inserte el número de páginas");
                            int insnum=5;
                            try{
                                insnum=sc.nextInt();
                                sc.nextLine();
                                System.out.println("¿Qué género es el libro?: 1.Comedia, 2.Terror, 3.Policiaca");
                                navegacion=sc.nextInt();
                                sc.nextLine();
                            }catch(InputMismatchException e){
                                System.out.println("El valor insertado no es correcto");
                                break;
                            }
                            switch (navegacion){
                                case 1://DE HUMOR
                                    Humor.mostrarDescripcionesHumor();
                                    System.out.println("|------------------------------------------------------------|");
                                    System.out.println("Escriba el tipo de humor del libro:");
                                    String insert=sc.next();
                                    boolean encontrado=false;
                                        for (Humor item : Humor.values()) {
                                            if (item.name().equalsIgnoreCase(insert)) {
                                                encontrado=true;
                                                insercion = new Comedia(insNombre, insAutor, insIsbn, insnum, item);
                                                biblioteca.agregarLibro(insercion);
                                                break;
                                            }
                                        }
                                    if(encontrado){
                                        break;
                                    }else{
                                        System.out.println("No se ha podido asignar el tipo de humor, cancleando operación.");
                                    }
                                    break;
                                case 2://DE TERROR (como este proyecto xD)
                                    System.out.println("Indique del 1 al 10 el rating de este libro");
                                    boolean exitrating=false;
                                    while (!exitrating){
                                        double resprating=sc.nextInt();
                                        if(resprating <0 | resprating >10){
                                            System.out.println("rating no aceptado, especifique el número según la regla");
                                        }else{
                                            insercion=new Terror(insNombre,insAutor,insIsbn,insnum,resprating);
                                            biblioteca.agregarLibro(insercion);
                                            exitrating=true;
                                        }
                                    }
                                    break;
                                case 3: //NOVELA POLICIACA
                                    System.out.println("Indique de qué tipo es la trama: Escriba Intriga o Misterio");
                                        String insert2=sc.next();
                                        encontrado=false;
                                        for (Trama item: Trama.values()){
                                            if (item.name().equalsIgnoreCase(insert2)) {
                                                System.out.println("Indique el número de personajes a añadir:");
                                                respuesta=sc.nextInt();
                                                sc.nextLine();
                                                String[] numeroPjs =new String[respuesta];
                                                for (int i=0;i<numeroPjs.length;i++){
                                                    System.out.println("Inserte personaje nº: " + (i+1));
                                                    numeroPjs[i]=sc.nextLine();
                                                }
                                                encontrado=true;
                                                insercion=new Policiaca(insNombre,insAutor,insIsbn,insnum,item,numeroPjs);
                                                biblioteca.agregarLibro(insercion);
                                                break;
                                            }
                                        }
                                    if(encontrado){
                                        break;
                                    }else{
                                        System.out.println("No se ha podido asignar el tipo de humor, cancleando operación.");
                                    }
                                    break;
                                default:
                                    System.out.println("-------------");
                                    System.out.println("Orden no reconocida");
                                    System.out.println("-------------");
                                    break;
                            }
                            break;
                        case 2: //ELIMINAR LIBRO DE BIBLIOTECA
                            System.out.println("Va a eliminar un libro de la biblioteca:\n" + "Inserte el ISBN a buscar");
                            String respString=sc.next();
                            biblioteca.eliminarLibro(biblioteca.buscarLibro(respString));
                            break;
                        case 3: //BUSCAR LIBRO EN BIBLIOTECA
                            System.out.println("Va a buscar un libro de la biblioteca:\n" + "Inserte el ISBN a buscar");
                            respString=sc.next();
                            biblioteca.buscarLibro(respString);
                            break;
                        case 4: //MOSTRAR LIBROS DE BIBLIOTECA
                            System.out.println("Mostrando todos los libros de su biblioteca");
                            biblioteca.mostrarLibros();
                            break;
                        case 5: //CANCELLED
                            System.out.println("Cancelando operación.");
                            break;
                        default:
                            break;
                    }
                    break;
                case 2://MENU DE CATÁLOGO
                    try{
                        System.out.println("Esta gestionando sus catálogos");
                        System.out.println("1. Construir catálogo." + " ----- " + "2. Agregar libro al catálogo."+ " ----- " + "3. Quitar libro del catálogo.");
                        System.out.println("4. Buscar libro en el catálogo." + " ----- " + "5. Mostrar todos los libros del catálogo" + " ----- " + "6. Eliminar un catálogo.");
                        System.out.println("7. Cancelar operación.");
                        respuesta=sc.nextInt();
                        sc.nextLine();
                        switch (respuesta){
                            case 1://CREACIÓN DE CATÁLOGO
                                biblioteca.setCatalogo(biblioteca.crearCatalogo());
                                break;
                            case 2: //AÑADIR LIBRO DE LA BIBLIOTECA AL CATÁLOGO
                                System.out.println("Va a añadir un libro al catálogo.");
                                System.out.println("Ingrese el isbn que desea ingresar al catalogo");
                                String resStr=sc.next();
                                biblioteca.agregarlibrocat(biblioteca.buscarLibro(resStr));
                                break;
                            case 3: //QUITAR LIBRO DEL CATÁLOGO
                                System.out.println("Va a quitar un libro del catálogo:");
                                biblioteca.quitarlibroCat();
                                break;
                            case 4://BUSCAR LIBRO EN EL CATÁLOGO
                                System.out.println("Va a buscar un libro en el catálogo.");
                                System.out.println("Ingrese el isbn que desea ingresar al catalogo");
                                resStr=sc.next();
                                biblioteca.buscarCatalogo(resStr);
                                break;
                            case 5: //MOSTRAR LIBROS DEL CATÁLOGO
                                System.out.println("Va a mostrarse el contenido de su catálogo.");
                                biblioteca.mostrarcatalogo();
                                break;
                            case 6: //ELIMINAR CATÁLOGO
                                System.out.println("Va a eliminar el catálogo creado");
                                biblioteca.eliminarcatalogo();
                                System.out.println("Catálogo eliminado");
                                break;
                            case 7: //CANCELLED
                                System.out.println("Cancelando operación");
                                break;
                            default:
                                System.out.println("Orden no reconocida");
                                break;
                        }
                    } catch(NullPointerException e){ //DEBES CONSTRUIR CATÁLOGO PARA OPERARLO
                        System.out.println("-------------ERROR-------------");
                        System.out.println("No ha construido un catálogo");
                    }
                    break;
                    //EXPORTACIÓN DE CATÁLOGO
                case 3:
                    try{ //DEBES CONSTRUIR CATÁLOGO PARA EXPORTARLO
                        System.out.println("Exportando catálogo.");
                        biblioteca.exportarCatalogo();
                        break;
                    }catch(RuntimeException e){
                        System.out.println("-------------ERROR-------------");
                        System.out.println("No ha construido un catálogo");
                }
                default:
                    System.out.println("Opción no reconocida, saliendo.");
                    exit=true;
                    break;
            }
        }while (!exit);
    }
}

