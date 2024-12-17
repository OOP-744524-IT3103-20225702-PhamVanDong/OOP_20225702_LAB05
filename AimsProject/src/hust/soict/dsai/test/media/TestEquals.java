package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class TestEquals {
    public static void main(String[] args) {
        Media media1 = new Media();
        media1.setTitle("Inception");

        Media media2 = new Media();
        media2.setTitle("Inception");

        Media media3 = new Media();
        media3.setTitle("Avatar");

        System.out.println(media1.equals(media2));
        System.out.println(media1.equals(media3));


        Track track1 = new Track();
        track1.setTitle("Track 1");
        track1.setLength(300);

        Track track2 = new Track();
        track2.setTitle("Track 1");
        track2.setLength(300);

        Track track3 = new Track();
        track3.setTitle("Track 1");
        track3.setLength(200);

        System.out.println(track1.equals(track2));
        System.out.println(track1.equals(track3));
    }
}
