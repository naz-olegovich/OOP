package Lab6;

import Lab8.WrongDurationValueException;
import Lab8.WrongNameValueException;

public abstract class Track {
    public String name;
    private double duration;


    public Track(String name, double duration)
           {
        if (name == null) {
            throw new WrongNameValueException("Incorrect name "+"'"+name+"'");
        }
        boolean isNumeric = name.chars().allMatch( Character::isDigit );
        if (isNumeric){
            throw new WrongNameValueException("Incorrect name "+"'"+name+"'");

        }

        if (duration <= 0) {
            throw new WrongDurationValueException("Incorrect duration: "+duration);
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


