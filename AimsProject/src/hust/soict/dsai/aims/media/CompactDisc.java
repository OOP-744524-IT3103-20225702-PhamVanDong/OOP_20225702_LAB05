package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    private static int nbCompactDiscDiscs = 1;

    public CompactDisc() {
        super(nbCompactDiscDiscs);
        nbCompactDiscDiscs++;
    }


    //Getter
    public String getArtist() {
        return artist;
    }


    //Constructor
    public CompactDisc(String title, String category, float price, String director, int length, String artist, List<Track> tracks) {
        super(nbCompactDiscDiscs, title, category, price, director, length);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title, String artist, List<Track> tracks) {
        super(nbCompactDiscDiscs, title);
        this.artist = artist;
        this.tracks = tracks;
        nbCompactDiscDiscs++;
    }

    public CompactDisc(String title, String category, float price, String artist, List<Track> tracks) {
        super(nbCompactDiscDiscs, title, category, price);
        this.artist = artist;
        this.tracks = tracks;
        nbCompactDiscDiscs++;
    }

    //
    public void addTrack(Track ... trackList){
        for(Track track : trackList) {
            if (!tracks.contains(track)) tracks.add(track);
        }
    }

    public void removeTrack(Track ... trackList){
        for(Track track : trackList) {
            if (tracks.contains(track)) tracks.remove(track);
            else System.out.println("TrackList "+ getId() +" does not have track " + track.getTitle());
        }
    }

    public int getLength(){
        int length = 0;
        for(Track track : tracks){
            length+= track.getLength();
        }
        return length;
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
