package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction",
                "George Lucas",
                87,
                24.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation",
                18.99f);

        DigitalVideoDisc dvd = new DigitalVideoDisc();
        dvd.setTitle("Inception");
        dvd.setPrice(19.99f);

        CompactDisc cd = new CompactDisc();
        cd.setTitle("Greatest Hits");
        cd.setPrice(14.99f);

        Book book = new Book();
        book.setTitle("Java Programming");
        book.setPrice(29.99f);


        Store store = new Store();
        store.addMedia(dvd3, dvd2, dvd1, dvd, cd, book);
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    handleViewStore(store, cart, scanner);
                    break;
                case 2:
                    handleViewStore(store, cart, scanner);
                    break;
                case 3:
                    handleViewCart(cart, scanner);
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }


    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }



    //Handle
    private static void handleViewStore(Store store, Cart cart, Scanner scanner) {
        int storeChoice;
        do {
            storeMenu();
            storeChoice = scanner.nextInt();
            scanner.nextLine();
            switch (storeChoice) {
                case 1:
                    store.print();
                    break;
                case 2:
                    System.out.print("Enter media title to add to cart: ");
                    String titleToAdd = scanner.nextLine();
                    Media mediaToAdd = store.find(titleToAdd);
                    if (mediaToAdd != null) {
                        cart.addMedia(mediaToAdd);
                        System.out.println("Media added to cart. Total items: " + cart.getItemsOrdered().size());
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter media title to play: ");
                    String titleToPlay = scanner.nextLine();
                    Media mediaToPlay = store.find(titleToPlay);
                    if (mediaToPlay instanceof Playable) {
                        ((Playable) mediaToPlay).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 4:
                    handleViewCart(cart, scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (storeChoice != 0);
    }

    private static void handleViewCart(Cart cart, Scanner scanner) {
        int cartChoice;
        do {
            cart.print();
            cartMenu();
            cartChoice = scanner.nextInt();
            scanner.nextLine();
            switch (cartChoice) {
                case 1:
                    // Filter medias by ID or title
                    break;
                case 2:
                    ArrayList<Media> mediaList = cart.getItemsOrdered();
                    mediaList.sort(Media.COMPARE_BY_TITLE_COST);
                    System.out.println("Sorted by title then cost:");
                    for (Media media : mediaList) {
                        System.out.println(media);
                    }
                    break;
                case 3:
                    System.out.print("Enter media title to remove: ");
                    String titleToRemove = scanner.nextLine();
                    Media mediaToRemove = cart.find(titleToRemove);
                    cart.removeMedia(mediaToRemove);
                    break;
                case 4:
                    System.out.print("Enter media title to play: ");
                    String titleToPlay = scanner.nextLine();
                    Media mediaToPlay = cart.find(titleToPlay);
                    if (mediaToPlay instanceof Playable) {
                        ((Playable) mediaToPlay).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 5:
                    System.out.println("Order placed successfully!");
                    cart.removeAllMedia();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (cartChoice != 0);
    }




}