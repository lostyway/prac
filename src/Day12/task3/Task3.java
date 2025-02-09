package Day12.task3;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static List<MusicBand> groupsAfter2000 (List<MusicBand> bands) {
        List<MusicBand> result = new ArrayList<>();
        for (MusicBand musicBand : bands) {
            if (musicBand.getYear() >= 2000) {
                result.add(musicBand);
            }
        }
        return result;
    }
}
