package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Objects;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED =20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media ... medias) {
        for (Media media : medias) {
            if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
                itemsOrdered.add(media);
                System.out.println( media.getTitle());
            } else {
                System.out.println("Can't add DVD " + media.getTitle() + " because qtyOrder > " + MAX_NUMBERS_ORDERED);
            }
        }
    }

    public void removeMedia(Media media) {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            itemsOrdered.remove(media);
        }

    }

    public void removeAllMedia(){
        for (Media media : itemsOrdered) itemsOrdered.remove(media);
    }

    public float totalPrice() {
        int total = 0;
        for (Media media : itemsOrdered) total += (int) media.getPrice();
        return total;
    }

    public void print (){
        System.out.println("***********************CART***********************" +
                "\nOrdered Items:");
        for (Media media: itemsOrdered){
            System.out.println(media.toString());
        }
        System.out.println("Total cost: " + totalPrice() +
                "\n**************************************************");
    }

    public Media find(String title){
        for (Media media : itemsOrdered){
            if (Objects.equals(media.getTitle(), title)) return media;
        }
        return null;
    }

}