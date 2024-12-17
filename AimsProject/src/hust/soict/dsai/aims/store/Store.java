package hust.soict.dsai.aims.store;


import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Store {
    private ArrayList<Media>  items = new ArrayList<Media>();;
    
    public void addMedia( Media... media) {
        Collections.addAll(items, media);
    }

    public void removeMedia(Media media) {
        items.remove(media);
    }

    public Media find(String title){
        for (Media media : items){
            if (Objects.equals(media.getTitle(), title)) return media;
        }
        return null;
    }

    public void print (){
        System.out.println("***********************CART***********************" +
                "\nOrdered Items:");
        for (Media media: items){
            System.out.println(media.toString());
        }
        System.out.println("\n**************************************************");
    }

}
