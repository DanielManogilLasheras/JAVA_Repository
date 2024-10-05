package model;


public final class Audio extends File {
    private int durationAudio;
    private String supportAudio;


    public Audio() {
    }

    public Audio(int idFile, String titleFile, Person author, int sizeFile, String formatFile, int durationAudio, String supportAudio) {
        super(idFile, titleFile, author, sizeFile, formatFile);
        this.durationAudio = durationAudio;
        this.supportAudio = supportAudio;
    }

    public int getDurationAudio() {
        return durationAudio;
    }

    public void setDurationAudio(int durationAudio) {
        this.durationAudio = durationAudio;
    }

    public String getSupportAudio() {
        return supportAudio;
    }

    public void setSupportAudio(String supportAudio) {
        this.supportAudio = supportAudio;
    }

    @Override
    public void showData(){
        super.showData();
        System.out.println("Duration: " + durationAudio);
        System.out.println("Support " + supportAudio);
    }
}

