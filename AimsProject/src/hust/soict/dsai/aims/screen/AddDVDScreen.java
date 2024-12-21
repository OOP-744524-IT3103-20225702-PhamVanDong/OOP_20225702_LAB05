package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDVDScreen extends JFrame {
    private Store store;
    private Cart cart;
    private ScreenManager screenManager;
    private CartButtonListener cartButtonListener = new CartButtonListener();
    private final AddCDButtonListener addCDButtonListener = new AddCDButtonListener();
    private final AddBookButtonListener addBookButtonListener = new AddBookButtonListener();
    private JTextField title ;
    private JTextField category;
    private JTextField director ;
    private JTextField length ;
    private JTextField cost;

    public AddDVDScreen(ScreenManager screenManager) {
        this.store = screenManager.getStore();
        this.screenManager = screenManager;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createSouth(), BorderLayout.SOUTH);


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


        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        title = addInputField("Title: *", center);
        category = addInputField("Category:", center);
        director = addInputField("Director:", center);
        length = addInputField("Length:", center);
        cost = addInputField("Cost: *", center);
        center.add(Box.createRigidArea(new Dimension(10, 40)));
        add(center, BorderLayout.CENTER);

            return center;
    }

    public JTextField addInputField(String fieldName, JPanel panel) {
        JPanel p = new JPanel(new FlowLayout());
        JLabel label = new JLabel(fieldName);
        label.setPreferredSize(new Dimension(60, 20));
        p.add(label);
        JTextField textField = new JTextField(15);
        p.add(textField);
        panel.add(p);
        return textField;
    }

    JPanel createSouth(){
        AddBtnListener addBtnListener = new AddBtnListener();
        JPanel south = new JPanel();
        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(addBtnListener);
        south.add(addBtn);
        return south;
    }



    private class CartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screenManager.getCartScreen().setVisible(true);
            setVisible(false);
        }
    }

    private class AddBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                DigitalVideoDisc digitalVideoDisc = new DigitalVideoDisc(title.getText(), category.getText(), director.getText(), Integer.parseInt(length.getText()), Float.parseFloat(cost.getText()));
                store.addMedia(digitalVideoDisc);
                title.setText(null);
                category.setText(null);
                director.setText(null);
                length.setText(null);
                cost.setText(null);
                screenManager.getStoreScreen().refresh();
                screenManager.getStoreScreen().setVisible(true);
                setVisible(false);
            } catch (Exception e){
                System.out.println(e);
            }
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



