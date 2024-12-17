package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class Media {
    private int id;
    private String title;
    private String category;
    private float price;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new TitleCostComparator();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new CostTitleComparator();


    public Media() {

    }


    public int getId() {return id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Media(int id, String title, String category, float price) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        Media otherMedia = (Media) obj;
        return this.title != null && this.title.equals(otherMedia.title);
    }
}
