package model;

public final class Video extends File {
    private Person director;
    private Person [] casting;
    public Video() {
    }

    public Video(int idFile, String titleFile, Person author, int sizeFile, String formatFile, Person director, Person[] casting) {
        super(idFile, titleFile, author, sizeFile, formatFile);
        this.director = director;
        this.casting = casting;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    public Person[] getCasting() {
        return casting;
    }

    public void setCasting(Person[] casting) {
        this.casting = casting;
    }

    @Override
    public void showData() {
        super.showData();
        director.showData();
        for (Person actor: casting){
            actor.showData();
        }
    }
}
