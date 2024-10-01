package model;
public final class Book extends File {
    private String isbnBook;
    private int numPagesBook;
    public Book() {
    }

    public Book(int idFile, String titleFile, Person author, int sizeFile, String formatFile, String isbnBook, int numPagesBook) {
        super(idFile, titleFile, author, sizeFile, formatFile);
        this.isbnBook = isbnBook;
        this.numPagesBook = numPagesBook;
    }

    public String getIsbnBook() {
        return isbnBook;
    }

    public void setIsbnBook(String isbnBook) {
        this.isbnBook = isbnBook;
    }

    public int getNumPagesBook() {
        return numPagesBook;
    }

    public void setNumPagesBook(int numPagesBook) {
        this.numPagesBook = numPagesBook;
    }

    @Override
    public void showData(){
        super.showData();
        System.out.println("ISBN: " + isbnBook);
        System.out.println("Number of pages. " + numPagesBook);
    }
}
