package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Objects;

public class CartScreenController {

    private Cart cart;
    private Store store;
    private ScreenManager screenManager;

    @FXML
    private Button btnPlay;
    private Boolean searchByTitle = false;

    @FXML
    private Button btnRemove;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TextField tfFilter;

    @FXML
    private Label total;


    public CartScreenController(ScreenManager screenManager) {
        super();
        this.cart = screenManager.getCart();
        this.store = screenManager.getStore();
        this.screenManager = screenManager;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        total.setText(cart.totalPrice()+"$");

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);


        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            }
        );

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        cart.getItemsOrdered().addListener(
                new ListChangeListener<Media>() {
                    @Override
                    public void onChanged(Change<? extends Media> c) {
                        Platform.runLater(() -> {
                            total.setText(cart.totalPrice()+"$");
                        });

                    }
                }
        );



    }
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }


    void showFilteredMedia(String newValue){
        if(Objects.equals(newValue, "")) tblMedia.setItems(cart.getItemsOrdered());
        else if (searchByTitle) {
            tblMedia.setItems(cart.find(newValue));
        }
        else tblMedia.setItems(cart.findById(newValue));
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void filterTitle(ActionEvent event){
        searchByTitle = true;
    }

    @FXML
    void filterId(ActionEvent event){
        searchByTitle = false;
    }

    @FXML
    void btnPlayPressed(ActionEvent event){
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        String soundFilePath = "src/main/resources/Media/a.wav";
        File audioFile = new File(soundFilePath);
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            JOptionPane.showMessageDialog(null, "Playing " + media.getTitle() + "!");
            clip.stop();
            clip.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }


    @FXML
    void print(){
        JOptionPane.showMessageDialog(null, cart.print());
        cart.clear();
    }

    @FXML
    void openStore(){
        screenManager.getStoreScreen().setVisible(true);
        screenManager.getCartScreen().setVisible(false);
    }




}
