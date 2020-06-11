package Lab6;

import Lab8.WrongDurationValueException;

import java.math.BigDecimal;

public class Album {
    private static int album_size = 3;
    public static Track[] tracks = new Track[album_size];
    private int counter;

    public void add_track(Track track) {
        tracks[counter++] = track;
    }

    public double get_duration() {
        int minutes = 0;
        double seconds = 0;
        for (Track track : tracks) {
            if (track != null) {
                BigDecimal bigDecimal = BigDecimal.valueOf(track.get_duration());
                int intValue = bigDecimal.intValue();
                String decimalPart = bigDecimal.subtract(new BigDecimal(intValue)).toPlainString();


                minutes += intValue;
                seconds += Double.parseDouble(decimalPart);
            }
        }
        BigDecimal bigDecimal = BigDecimal.valueOf(seconds);
        seconds = Math.round(((int) (seconds / 0.6) + (seconds % 0.6)) * 100.0) / 100.0;


        return minutes + seconds;
    }



    public void getSong(Double down, Double up) {
        String result = "Not found";

        if (down <= 0 | up <= 0) {
            throw new WrongDurationValueException("\nIncorrect duration - not found");
        }

        int intPart1 = up.intValue();
        int intPart2 = down.intValue();

        if (up - intPart1 > 0.6 | down - intPart2 > 0.6) {
            throw new WrongDurationValueException("Incorrect duration of song(s) - not found\n\nEnter the duration in such format: **.^^\n" +
                    "Where ** - minutes, ^^ - seconds\n** and ^^ couldn't be bigger than 60");
        }



        System.out.println("\nЗнайдені композиції: ");
        int foundTracks = 0;
        for (Track track : tracks) {
            if (track != null) {
                if (track.get_duration() >= down & track.get_duration() <= up) {
                    System.out.println(track.toString());
                    foundTracks++;
                }
            }
        }

        
        if (foundTracks == 0) {
            System.out.println("not found\n");
        } else {
            System.out.println("\n");
        }
    }
}
