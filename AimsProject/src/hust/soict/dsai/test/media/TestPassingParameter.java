package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String title = dvd1.getTitle();
        String category = dvd1.getCategory();
        float price = dvd1.getPrice();
        String image = dvd1.getImage();
        String detail = dvd1.getDetail();
        String director = dvd1.getDirector();
        int length = dvd1.getLength();
        String demoLink = dvd1.getDemoLink();

        dvd1.setTitle(dvd2.getTitle());
        dvd1.setCategory(dvd2.getCategory());
        dvd1.setPrice(dvd2.getPrice());
        dvd1.setImage(dvd2.getImage());
        dvd1.setDetail(dvd2.getDetail());
        dvd1.setDirector(dvd2.getDirector());
        dvd1.setLength(dvd2.getLength());
        dvd1.setDemoLink(dvd2.getDemoLink());

        dvd2.setTitle(title);
        dvd2.setCategory(category);
        dvd2.setPrice(price);
        dvd2.setImage(image);
        dvd2.setDetail(detail);
        dvd2.setDirector(director);
        dvd2.setLength(length);
        dvd2.setDemoLink(demoLink);
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
