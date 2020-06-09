package Lab8;


public class WrongNameValueException extends RuntimeException {
    public WrongNameValueException(String str) {
        System.out.println(str);
//        System.exit(1);

    }
}

