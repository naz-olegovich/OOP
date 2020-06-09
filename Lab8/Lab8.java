package Lab8;

import Lab6.PopSong;
import Lab7.MyList;

public class Lab8 {
    public static void main(String[] args) {


        String name = null;
        try {
            new MyList().add(new PopSong("", 23));
            System.out.println("Success");
        } catch (WrongDurationValueException e) {
            System.out.println("Wrong duration: duration couldn't be negative");
        } catch (WrongNameValueException e) {
            System.out.println("There is a problem with name: field of name couldn't be empty");
        }

        try {
            new MyList().add(new PopSong("Some pop song", -2.3));
            System.out.println("Success");
        } catch (WrongDurationValueException e) {
            System.out.println("Wrong duration: duration couldn't be negative");
        } catch (WrongNameValueException e) {
            System.out.println("There is a problem with name: field of name couldn't be empty");
        }

        try {
            new MyList().add(new PopSong("Song", 2.8));
            System.out.println("Success");
        } catch (WrongDurationValueException e) {
            System.out.println("\n***Wrong duration***");
        } catch (WrongNameValueException e) {
            System.out.println("There is a problem with name: field of name couldn't be empty");
        }
    }
}