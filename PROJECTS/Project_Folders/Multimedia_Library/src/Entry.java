import controller.Library;
import model.*;
import java.util.Scanner;

public class Entry {
    public static void main(String[] args) {
        Scanner scanner= new Scanner (System.in);
        int option,size,duration,npages;
        String title,format,support,isbn,dniDirector,nameDirector,nameAuthor,dniAuthor,nameActor,dniActor;
        Library library=new Library();


        do{
            System.out.println("Welcome to your JAVA Collection, below this text you are offered a number of choices:");
            System.out.println("1. Add a file to my library");
            System.out.println("2. Listing my library");
            System.out.println("3. Search a file");
            System.out.println("4. Delete a file from my library");
            System.out.println("5. Exit");
            System.out.println("Select an option: ");
            option=scanner.nextInt();

            switch (option){
                case 1:
                    File element=null;
                    System.out.println("Specify what kind of file you want to add to the library: ");
                    System.out.println("1. Add an audio.");
                    System.out.println("2. Add a book.");
                    System.out.println("3. Add a video");
                    int optionadd=scanner.nextInt();

                    System.out.println("Insert an ID of this file");
                    int id=scanner.nextInt();
                    System.out.println("Insert a title for this file");
                    title=scanner.next();
                    System.out.println("Type the name of the author");
                    nameAuthor=scanner.next();
                    System.out.println("Insert the ID of the Director");
                    dniAuthor=scanner.next();
                    System.out.println("Insert the size of the file in MB");
                    size=scanner.nextInt();
                    System.out.println("Insert the format of this file");
                    format=scanner.next();
                    System.out.println();
                        switch(optionadd){
                            case 1: //Add Audio
                                System.out.println("Insert the duration of the audio:");
                                duration=scanner.nextInt();
                                System.out.println("Insert the support of the audio:");
                                support=scanner.next();
                                element=new Audio(id,title,new Person(nameAuthor,dniAuthor),size,format,duration,support);
                                break;

                            case 2: //Add Book
                                System.out.println("Insert the isbn of the book");
                                isbn=scanner.next();
                                System.out.println("Insert the number of pages of the book");
                                npages=scanner.nextInt();
                                element=new Book(id,title,new Person(nameAuthor,dniAuthor),size,format,isbn,npages);
                                break;
                            case 3: //Add Video
                                System.out.println("Insert the name of the Director");
                                nameDirector=scanner.next();
                                System.out.println("Insert the ID of the Director");
                                dniDirector=scanner.next();
                                System.out.println("How many actors do you want to add to the casting?");
                                int respuesta=scanner.nextInt();
                                Person [] actoresObjetos=new Person[respuesta]; //PARA ARRAY OBJETOS PERSON

                                for (int i=0; i<respuesta;i++){ //ARRAY DE OBJETOS PERSON
                                    System.out.println("Name of actor nº " + i);
                                    nameActor=scanner.next();
                                    System.out.println("ID of actor nº " + i);
                                    dniActor=scanner.next();
                                    actoresObjetos[i]=new Person(nameActor,dniActor); //CONSIGO UN ARRAY DE TANTAS PERSONAS COMO ACTORES NECESITO

                                }
                                element=new Video(id,title,new Person(nameAuthor,dniAuthor),size,format,
                                        new Person(nameDirector,dniDirector),
                                        actoresObjetos); //NO SE CÓMO INTEGRAR NINGUNA DE LAS DOS OPCIONES AQUÍ

                                break;
                            case 4: // Go back
                                System.out.println("Cancelling operation");
                                break;

                        }
                    library.addFile(element);
                    break;
                case 2: //Listing my library
                    library.displayLibrary();
                    break;
                case 3: //Search a file
                    System.out.println("Insert an ID of this file");
                    id=scanner.nextInt();
                    library.searchFile(id);
                    break;
                case 4: //Delete a file
                    System.out.println("Insert an ID of this file");
                    id=scanner.nextInt();
                    library.removeFile(id);
                    break;

                case 5: //Exit program
                    break;
            }
        } while (option !=5 );
    }
}


