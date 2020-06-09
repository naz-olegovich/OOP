package Lab6;

import Lab8.WrongDurationValueException;
import Lab8.WrongNameValueException;

public class RapSong extends Track{
    public RapSong (String name,double duration)
        throws WrongDurationValueException, WrongNameValueException {
        super(name,duration);
    }
    public void myMethod(){}
}
