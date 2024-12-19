package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class ScreenManager {
    private StoreScreen storeScreen;
    private CartScreen cartScreen;
    private Store store;
    private Cart cart;

    public ScreenManager(Store store, Cart cart) {

        this.store = store;
        this.cart = cart;
        this.storeScreen = new StoreScreen(this);
        this.cartScreen = new CartScreen(this);
        this.cartScreen.setVisible(false);
    }

    public StoreScreen getStoreScreen() {
        return storeScreen;
    }

    public CartScreen getCartScreen() {
        return cartScreen;
    }

    public Store getStore() {
        return store;
    }

    public Cart getCart() {
        return cart;
    }
}
