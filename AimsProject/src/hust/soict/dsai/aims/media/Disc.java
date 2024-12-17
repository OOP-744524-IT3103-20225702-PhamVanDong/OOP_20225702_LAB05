package hust.soict.dsai.aims.media;

public class Disc extends Media{
    private String director;
    private int length;

    public Disc(int id, String title, String category, float price, String director, int length) {
        super(id, title, category, price);
        this.director = director;
        this.length = length;
    }

    public Disc(int id, String title) {
        super(id, title);
    }

    public Disc(int id, String title, String category, float price) {
        super(id, title, category, price);
    }

    public Disc() {

    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
