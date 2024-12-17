package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;


public class TestSorting {
    public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<>();

        DigitalVideoDisc dvd = new DigitalVideoDisc();
        dvd.setTitle("Inception");
        dvd.setPrice(19.99f);

        CompactDisc cd = new CompactDisc();
        cd.setTitle("Greatest Hits");
        cd.setPrice(14.99f);

        Book book = new Book();
        book.setTitle("Java Programming");
        book.setPrice(29.99f);

        // Add the media to the list
        mediaList.add(dvd);
        mediaList.add(cd);
        mediaList.add(book);

        mediaList.sort(Media.COMPARE_BY_TITLE_COST);
        System.out.println("Sorted by title then cost:");
        for (Media media : mediaList) {
            System.out.println(media);
        }

        mediaList.sort(Media.COMPARE_BY_COST_TITLE);
        System.out.println("Sorted by cost then title:");
        for (Media media : mediaList) {
            System.out.println(media);
        }
    }
}
