package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private static int nbBooks = 0;

    //Get And Set




    //Constructor
    public Book(String title, String category, float price, List<String> authors) {
        super(nbBooks, title,category,price);
        this.authors = authors;
        nbBooks++;
    }

    public Book(String title, String category, float price, String authors) {
        super(nbBooks, title, category, price);
        this.authors.add(authors);
        nbBooks++;
    }

    public Book() {

    }

    public void AddAuthor(String ... author){
        for (String a : author){
            if (!authors.contains(a)) authors.add(a);
        }
    }

    public void RemoveAuthor(String ... author){
        for (String a : author){
            if (authors.contains(a)) authors.remove(a);
            else System.out.println("Book "+ getId() +" does not have author " + a);
        }
    }

    @Override
    public String toString() {
        return "Book [" + getTitle() + " - " + getCategory() + " - " + authors + "]: " + getPrice();
    }


}
