package Day12.task4;

import java.util.ArrayList;
import java.util.List;

public class MusicBand {
    private String name;
    private int year;
    private List<String> nameMusicians;

    public MusicBand(String name, int year, List<String> nameMusicians) {
        this.name = name;
        this.year = year;
        this.nameMusicians = nameMusicians;
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

    public List<String> getNameMusicians() {
        return nameMusicians;
    }

    public void setNameMusicians(List<String> nameMusicians) {
        this.nameMusicians = nameMusicians;
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", nameMusicians=" + nameMusicians +
                '}';
    }

    public static void transferMembers(MusicBand a, MusicBand b) {
        for (String member : a.getNameMusicians()) {
            b.getNameMusicians().add(member);
        }
        a.getNameMusicians().clear();
        printMembers(b);

    }

    public static void printMembers(MusicBand musicBand) {
        System.out.println(musicBand.nameMusicians);
    }

    public static void main(String[] args) {
       List<String> members = new ArrayList<>();
       List<String> members2 = new ArrayList<>();
       List<String> members3 = new ArrayList<>();
       members.add("Yura");
       members.add("Vasya");
       members2.add("Sasha");
       members2.add("Masha");
       members3.add("Strelka");
       members3.add("Belka");
       MusicBand musicBand = new MusicBand("Voda", 2005, members);
       MusicBand musicBand1 = new MusicBand("Voda2", 2006, members2);
       MusicBand musicBand2 = new MusicBand("Voda3", 2007, members3);
       transferMembers(musicBand, musicBand2);
       printMembers(musicBand);
       printMembers(musicBand1);
       printMembers(musicBand2);
    }
}