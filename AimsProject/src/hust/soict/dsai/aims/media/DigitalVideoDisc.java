package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private String image;
    private String detail;
    private String demoLink;
    private static int nbDigitalVideoDiscs = 1;

    public DigitalVideoDisc() {

    }


    //Getter and Setter

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDemoLink() {
        return demoLink;
    }

    public void setDemoLink(String demoLink) {
        this.demoLink = demoLink;
    }



    //Constructor

    public DigitalVideoDisc(String title, String category, float price, String image, String detail, String director, int length, String demoLink) {

        super(nbDigitalVideoDiscs, title, category, price, director, length);
        this.image = image;
        this.detail = detail;
        this.demoLink = demoLink;

    }

    public DigitalVideoDisc(String title){
        super(nbDigitalVideoDiscs, title);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float price) {
        super(nbDigitalVideoDiscs, title, category, price, director, length);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, float price) {
        super(nbDigitalVideoDiscs, title,category, price);
        nbDigitalVideoDiscs++;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }

    @Override
    public String toString(){
        return "DVD ["+ getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength()/60+":"+ getLength()%60+ "]: "+ getPrice();
    }

}

