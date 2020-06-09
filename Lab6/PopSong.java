package Lab6;

import Lab8.WrongDurationValueException;
import Lab8.WrongNameValueException;

public class PopSong extends Track {
    public PopSong(String name, double duration)
            throws WrongNameValueException, WrongDurationValueException {

        super(name, duration);

    }
}
