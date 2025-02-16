package Day12.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MusicBand musicBand = new MusicBand("1", 1995);
        MusicBand musicBand1 = new MusicBand("2", 1996);
        MusicBand musicBand2 = new MusicBand("3", 1997);
        MusicBand musicBand3 = new MusicBand("4", 1998);
        MusicBand musicBand4 = new MusicBand("5", 2005);
        MusicBand musicBand5 = new MusicBand("6", 1740);
        MusicBand musicBand6 = new MusicBand("7", 2012);
        MusicBand musicBand7 = new MusicBand("8", 1997);
        MusicBand musicBand8 = new MusicBand("9", 2000);
        MusicBand musicBand9 = new MusicBand("10", 1995);
        List<MusicBand> list = new ArrayList<>();
        list.add(musicBand);
        list.add(musicBand1);
        list.add(musicBand2);
        list.add(musicBand3);
        list.add(musicBand4);
        list.add(musicBand5);
        list.add(musicBand6);
        list.add(musicBand7);
        list.add(musicBand8);
        list.add(musicBand9);
        Collections.shuffle(list);
        System.out.println(list);
        list = Task3.groupsAfter2000(list);
        System.out.println(list);
    }
}
