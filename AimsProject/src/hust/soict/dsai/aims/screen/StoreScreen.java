package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;
    private ScreenManager screenManager;
    private final CartButtonListener cartButtonListener = new CartButtonListener();
    private final AddCDButtonListener addCDButtonListener = new AddCDButtonListener();
    private final AddBookButtonListener addBookButtonListener = new AddBookButtonListener();
    private final AddDVDButtonListener addDVDButtonListener = new AddDVDButtonListener();
    private final JPanel center = new JPanel();

    public StoreScreen(ScreenManager screenManager) {
        this.store = screenManager.getStore();
        this.cart = screenManager.getCart();
        this.screenManager = screenManager;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        createCenter();
        cp.add(center, BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }


    JMenuBar createMenuBar() {
        JMenuItem viewCart = new JMenuItem("View cart");
        JMenuItem addDVD = new JMenuItem("Add DVD");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addBook = new JMenuItem("Add Book");

        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(addBook);
        addBook.addActionListener(addBookButtonListener);
        smUpdateStore.add(addCD);
        addCD.addActionListener(addCDButtonListener);
        smUpdateStore.add(addDVD);
        addDVD.addActionListener(addDVDButtonListener);

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(viewCart);
        viewCart.addActionListener(cartButtonListener);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont((new Font(title.getFont().getName(), Font.PLAIN, 50)));
        title.setForeground((Color.CYAN));

        JButton cartButton = new JButton("View cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize((new Dimension(100, 50)));
        
        cartButton.addActionListener(cartButtonListener);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    void createCenter() {

        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItems();
        for (Media media : mediaInStore) {
            MediaStore cell = new MediaStore(media, cart);
            center.add(cell);
        }

    }

    void refresh(){
        center.removeAll();
        createCenter();
        center.revalidate();
        center.repaint();
    }



    private class CartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screenManager.getCartScreen().setVisible(true);
            setVisible(false);
        }
    }

    private class AddDVDButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screenManager.getAddDVDScreen().setVisible(true);
            setVisible(false);
        }
    }

    private class AddCDButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screenManager.getAddCDScreen().setVisible(true);
            setVisible(false);
        }
    }

    private class AddBookButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screenManager.getAddBookScreen().setVisible(true);
            setVisible(false);
        }
    }






    



}
