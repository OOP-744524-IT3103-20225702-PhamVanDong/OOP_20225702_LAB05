package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED =20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
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

    public void clear(){
        for (Media media : itemsOrdered) itemsOrdered.remove(media);
    }

    public String totalPrice() {
        float total =  0.0f;
        for (Media media : itemsOrdered) total += media.getPrice();
        return String.format("%.2f", total).replace(',', '.');
    }

    public String print (){
        StringBuilder tmp = new StringBuilder();
        tmp.append("***********************CART***********************" + "\nOrdered Items:\n");
        for (Media media: itemsOrdered){
            tmp.append(media.toString());
            tmp.append("\n");
        }
        tmp.append("Total cost: "); tmp.append(totalPrice());
        tmp.append("\n**************************************************");

        return tmp.toString();
    }

    public ObservableList<Media> find(String title){
        ObservableList<Media> a = FXCollections.observableArrayList();
        for (Media media : itemsOrdered){
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) a.add(media);
        }
        return a;
    }

    public ObservableList<Media> findById(String id){
        ObservableList<Media> b = FXCollections.observableArrayList();
        for (Media media : itemsOrdered){
            if (media.getId().toString().contains(id)) b.add(media);
        }
        return b;
    }

}