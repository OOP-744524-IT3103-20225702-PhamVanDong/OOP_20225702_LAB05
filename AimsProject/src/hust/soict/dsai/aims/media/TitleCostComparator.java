package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class TitleCostComparator implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int titleComparison = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        return Float.compare(m2.getPrice(), m1.getPrice());
    }
}
