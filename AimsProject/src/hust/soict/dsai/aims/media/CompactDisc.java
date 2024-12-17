package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        super();
    }


    //Getter
    public String getArtist() {
        return artist;
    }


    //Constructor
    public CompactDisc(int id, String title, String category, float price, String director, int length, String artist, List<Track> tracks) {
        super(id, title, category, price, director, length);
        artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String artist, List<Track> tracks) {
        super(id, title);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, float price, String artist, List<Track> tracks) {
        super(id, title, category, price);
        this.artist = artist;
        this.tracks = tracks;
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
