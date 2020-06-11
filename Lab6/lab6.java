package Lab6;
/*
9130%13 = 4
Визначити ієрархію музичних композицій.
Записати на диск альбом. Порахувати тривалість альбому.
Провести перестановку композицій диска на основі приналежності до стилю.
Знайти композицію, що відповідає заданому діапазону довжини треків.
 */

import Lab8.WrongDurationValueException;

import java.util.Arrays;
import java.util.Comparator;

public class lab6 {
    public static void main(String[] args) {
        Album album = new Album();
        album.add_track(new PopSong("Memories", 4));
        album.add_track(new RapSong("Eminem - Not Afraid", 6));
        album.add_track(new JazzSong("Louis Armstrong - You're The Top", 4.37));
//        album.add_track(new RapSong("", 4.37));

        System.out.printf("Тривалість альбому %s мин\n", album.get_duration());

        try {
            album.getSong(3.0, 6.5);
        } catch (WrongDurationValueException e){
            System.out.println("Be more attentive :)\n");
        }



        Arrays.sort(Album.tracks, new Sort());
        for (int i = 0; i < Album.tracks.length; i++) {
            System.out.println(Album.tracks[i].getClass().getSimpleName() + ": " + Album.tracks[i].name);
        }

    }
}


class Sort implements Comparator<Track> {
    @Override
    public int compare(Track o1, Track o2) {
        return o1.getClass().getSimpleName().codePointAt(0) - o2.getClass().getSimpleName().codePointAt(0);
    }
}