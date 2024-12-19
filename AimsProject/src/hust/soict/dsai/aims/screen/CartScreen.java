package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    private ScreenManager screenManager;


    public void close() {
        Platform.runLater(() -> {
            try {
                Parent root = new Parent() {};
                Scene emptyScene = new Scene(root);
                ((JFXPanel) this.getContentPane().getComponent(0)).setScene(emptyScene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }




    public CartScreen(ScreenManager screenManager) {
        super();

        this.screenManager = screenManager;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass()
                            .getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
                    CartScreenController controller =
                            new CartScreenController(screenManager);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}

