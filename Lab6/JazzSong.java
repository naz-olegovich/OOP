package Lab6;

import Lab8.WrongDurationValueException;
import Lab8.WrongNameValueException;

public class JazzSong extends Track {
    public JazzSong(String name, double duration)
            throws WrongDurationValueException, WrongNameValueException {
        super(name,duration);
    }

}
