package Lab6;
/*
9130%13 = 4
Визначити ієрархію музичних композицій.
Записати на диск альбом. Порахувати тривалість альбому.
Провести перестановку композицій диска на основі приналежності до стилю.
Знайти композицію, що відповідає заданому діапазону довжини треків.
 */
import java.util.Arrays;
import java.util.Comparator;

public class lab6 {
    public static void main(String[] args) {
        Album album = new Album();
        album.add_track(new Song("Memories", 4, "POP Song"));
        album.add_track(new Song("Eminem - Not Afraid", 6, "Rap song"));
        album.add_track(new Song("Eminem - Lose yourself", 4.37, "Rap song"));
//        album.add_track(new RapSong("", 4.37));

        System.out.printf("Тривалість альбому %s мин\n", album.get_duration());
        System.out.println("Знайдена композиція: " + album.getSong(6.0) + "\n");

        Arrays.sort(Album.tracks, new Sort());
        for (int i = 0; i < Album.tracks.length; i++) {
            System.out.println(Album.tracks[i].style + ": " + Album.tracks[i]);
        }

    }
}


class Sort implements Comparator<Song> {
    @Override
    public int compare(Song o1, Song o2) {
        return o1.style.codePointAt(0) - o2.style.codePointAt(0);
    }
}