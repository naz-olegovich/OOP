package Lab7;
/*
9130%2 = 0
9130%3 = 1
Interface = List
internal structure of the collection =  Однозв’язний список (linked list)
 */

import Lab6.Track;
import Lab6.JazzSong;
import Lab6.RapSong;
import Lab6.PopSong;
import Lab8.WrongDurationValueException;
import Lab8.WrongNameValueException;


import java.util.Iterator;


public class Lab7 {
    public static void main(String[] args) throws WrongNameValueException, WrongDurationValueException {
        PopSong pops = new PopSong("Pop song", 12.5);
        MyList myList = new MyList(pops);
        myList.add(new RapSong("Eminem - Godzilla", 3.33));
        myList.add(new JazzSong("Some Jazz music", 7.4));
        Iterator<Track> it = myList.iterator();
        System.out.println(myList.isEmpty());
        System.out.println("\nFirst  collection");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        MyList myList2 = new MyList(myList);
        Iterator<Track> iterator = myList2.iterator();
        System.out.println("\nSecond collection");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        myList.remove(pops);
        System.out.println();
        Iterator<Track> iterat = myList.iterator();
        System.out.println("\nRemoved pop song");
        while (iterat.hasNext()) {
            System.out.println(iterat.next());
        }
        myList.clear();
        System.out.print("Clear, is empty = ");
        System.out.println(myList.isEmpty());
        Iterator<Track> iter = myList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        RapSong rp = new RapSong("Some Rap song ", 5.55);
        System.out.println();
        myList.add(new RapSong("Popular rap song", 4.4));
        myList.add(pops);
        myList.add(new JazzSong("Some jazz song", 2.5));
        myList.add(new JazzSong("Another jazz song", 125));
        System.out.println("\nAdded new elements to first collection");
        Iterator<Track> iterator1 = myList.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println("\nInserted pop song in 3rd index ");

        myList.set(3, pops);
        Iterator<Track> iterator2 = myList.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}




