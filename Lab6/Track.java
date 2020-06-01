package Lab6;

public abstract class Track {
    public String name;
    private double duration;


    public Track(String name, double duration)
           {
        if (name == null) {
            throw new WrongNameValueException("Incorrect duration");
        }

        if (duration <= 0) {
            throw new WrongDurationValueException("Incorrect duration");
        }
        int intPart = (int) duration;
        if (duration - intPart > 0.6) {
            throw new WrongDurationValueException("Incorrect duration of song(s)\n\nEnter the duration in such format: **.^^\n" +
                    "Where ** - minutes, ^^ - seconds\n** and ^^ couldn't be bigger than 60");
        }


        this.name = name;
        this.duration = duration;
    }

    public double get_duration() {
        return duration;
    }


    @Override
    public String toString() {
        return name + " " + this.getClass().getSimpleName() + " " + duration + " min.";
    }
}


class WrongNameValueException extends RuntimeException {
    public WrongNameValueException(String str) {
        System.out.println(str);
        System.exit(1);

    }
}

class WrongDurationValueException extends RuntimeException {
    public WrongDurationValueException(String str) {
        System.out.println(str);
        System.exit(1);

    }
}