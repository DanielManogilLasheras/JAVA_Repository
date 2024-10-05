package model;

public abstract class File {
    private int idFile, sizeFile;
    private String titleFile, formatFile;
    private Person author;

    public File() {
    }

    public File(int idFile, String titleFile, Person author, int sizeFile, String formatFile) {
        this.idFile = idFile;
        this.sizeFile = sizeFile;
        this.titleFile = titleFile;
        this.formatFile = formatFile;
        this.author = author;
    }

    public int getIdFile() {
        return idFile;
    }

    public void setIdFile(int idFile) {
        this.idFile = idFile;
    }

    public int getSizeFile() {
        return sizeFile;
    }

    public void setSizeFile(int sizeFile) {
        this.sizeFile = sizeFile;
    }

    public String getTitleFile() {
        return titleFile;
    }

    public void setTitleFile(String titleFile) {
        this.titleFile = titleFile;
    }

    public String getFormatFile() {
        return formatFile;
    }

    public void setFormatFile(String formatFile) {
        this.formatFile = formatFile;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public void showData(){
        System.out.println("Identifier number: " + idFile);
        System.out.println("Title: " + titleFile);
        System.out.println("File size (in KB): " + sizeFile);
        System.out.println("File extension: " + formatFile);
        author.showData();
    }
}


