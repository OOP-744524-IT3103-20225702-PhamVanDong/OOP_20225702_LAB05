package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class ScreenManager {
    private StoreScreen storeScreen;
    private CartScreen cartScreen;
    private AddDVDScreen addDVDScreen;
    private AddBookScreen addBookScreen;
    private AddCDScreen addCDScreen;
    private Store store;
    private Cart cart;

    public ScreenManager(Store store, Cart cart) {

        this.store = store;
        this.cart = cart;
        this.storeScreen = new StoreScreen(this);
        this.cartScreen = new CartScreen(this);
        this.addDVDScreen = new AddDVDScreen(this);
        this.addBookScreen = new AddBookScreen(this);
        this.addCDScreen = new AddCDScreen(this);

        this.cartScreen.setVisible(false);
        this.addDVDScreen.setVisible(false);
        this.addBookScreen.setVisible(false);
        this.addCDScreen.setVisible(false);
    }

    public StoreScreen getStoreScreen() {
        return storeScreen;
    }

    public CartScreen getCartScreen() {
        return cartScreen;
    }

    public AddDVDScreen getAddDVDScreen(){
        return addDVDScreen;
    }

    public AddBookScreen getAddBookScreen() {
        return addBookScreen;
    }

    public AddCDScreen getAddCDScreen() {
        return addCDScreen;
    }

    public Store getStore() {
        return store;
    }

    public Cart getCart() {
        return cart;
    }
}
