package Day12.task5;

import java.util.ArrayList;
import java.util.List;

public class MusicBand {
    private String name;
    private int year;
    private List<MusicArtist> artists;

    public MusicBand(String name, int year, List<MusicArtist> artists) {
        this.name = name;
        this.year = year;
        this.artists = artists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<MusicArtist> getNameMusicians() {
        return artists;
    }

    public void setNameMusicians(List<MusicArtist> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", artists=" + artists +
                '}';
    }

    public static void transferMembers(MusicBand a, MusicBand b) {
        b.getNameMusicians().addAll(a.getNameMusicians());
        a.getNameMusicians().clear();
        printMembers(b);
    }

    public static void printMembers(MusicBand musicBand) {
        System.out.println(musicBand);
    }

    public static void main(String[] args) {
       List<MusicArtist> members = new ArrayList<>();
       List<MusicArtist> members1 = new ArrayList<>();
       List<MusicArtist> members2 = new ArrayList<>();
       members.add(new MusicArtist("Yura", 22));
       members1.add(new MusicArtist("fd", 212));
       members2.add(new MusicArtist("asd", 72));
       MusicBand musicBand = new MusicBand("Voda", 2005, members);
       MusicBand musicBand1 = new MusicBand("Voda2", 2006, members1);
       MusicBand musicBand2 = new MusicBand("Voda3", 2007, members2);
       transferMembers(musicBand, musicBand2);
       printMembers(musicBand);
       printMembers(musicBand1);
       printMembers(musicBand2);
    }
}