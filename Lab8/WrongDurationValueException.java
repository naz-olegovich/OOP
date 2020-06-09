package Lab8;


public class WrongDurationValueException extends RuntimeException {
    public WrongDurationValueException(String str) {
        System.out.println(str);
//        System.exit(1);

    }
}