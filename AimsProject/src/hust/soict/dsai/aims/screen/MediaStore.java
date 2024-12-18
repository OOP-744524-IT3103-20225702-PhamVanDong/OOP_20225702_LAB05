package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;
    private JButton playButton = new JButton("Play");
    private JButton addToCart = new JButton("Add To Cart");

    public MediaStore(Media media, Cart cart) {
        PlayButtonListener playButtonListener = new PlayButtonListener();
        AddToCartButtonListener addToCartButtonListener = new AddToCartButtonListener();

        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getPrice() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        container.add(addToCart);
        addToCart.addActionListener(addToCartButtonListener);
        if (media instanceof Playable) {
            container.add(playButton);
            playButton.addActionListener(playButtonListener);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class PlayButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
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
            }catch (Exception ex) {
                System.out.println(ex);
            }



        }
    }

    private class AddToCartButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cart.addMedia(media);
            JOptionPane.showMessageDialog(null, media.getTitle() + " added!");
        }
    }




}