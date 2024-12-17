package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println("Playing Track: " + title);
        System.out.println("DVD length: " + length);
    }

    @Override
    public boolean equals(Object obj) {
        Track otherTrack = (Track) obj;
        return this.title != null && this.title.equals(otherTrack.title)
                && this.length == otherTrack.length;
    }

}
