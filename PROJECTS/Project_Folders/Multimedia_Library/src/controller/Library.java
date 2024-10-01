package controller;
import model.*;
import model.File;
import java.util.ArrayList;
public class Library {
    private ArrayList<File> library;
    public Library() {
        library=new ArrayList<>();
    }
    public void addFile(File element) {
        if (existsfile(element.getIdFile()) == null) {
            library.add(element);
            System.out.println("File added successfully");
        } else {
            System.out.println("A file with this ID already exists. Please insert a new ID or modify the one that already exists");
        }
    }

    public void removeFile(int id) {
        for (File item : library) {
            if (item.getIdFile() == id) {
                library.remove(item);
                System.out.println("The file was deleted successfully");
                break;

            }
        }
    }

        public Boolean searchFile (int id){
            for (File item : library) {
                if (item.getIdFile() == id) {
                    System.out.println("Element found");
                    item.showData();
                    return true;
                } else {
                    System.out.println("The file nº: " + item.getIdFile() + " doesn't exist.");
                }
            }
            return false;
        }
        public void displayLibrary () {
            for (File item : library) {
                item.showData();
            }
        }
        public File existsfile(int id){
            for (File item : library) {
                if (item.getIdFile() == id) {
                    return item;
                }
            }
            return null;
        }

}


