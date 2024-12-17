package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class TestMediaToString {
    public static void main(String[] args) {
        // Create an ArrayList of Media
        ArrayList<Media> mediaList = new ArrayList<>();

        // Create some Media objects
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

        // Iterate through the list and print the information
        for (Media m : mediaList) {
            System.out.println(m.toString());
        }
    }
}
