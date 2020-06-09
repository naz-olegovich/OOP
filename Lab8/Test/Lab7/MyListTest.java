package Lab7;

import Lab6.PopSong;
import Lab6.RapSong;
import Lab6.Track;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyListTest {

    @Test
    public void size() {
        MyList myList = new MyList(new PopSong("Pop song", 12.5));
        Assert.assertEquals(1, myList.size());
    }

    @Test
    public void isEmpty() {

    }

    @Test
    public void contains() {
        MyList myList = new MyList();
        PopSong ps = new PopSong("Pop song", 12.5);
        Assert.assertTrue(myList.contains(ps));
    }


    @Test
    public void toArray() {
        PopSong ps = new PopSong("Pop song", 12.5);
        MyList myList = new MyList(ps);
        Track[] array = (Track[]) myList.toArray();
        Track[] expected_array = {ps};
        Assert.assertArrayEquals(expected_array, array);
    }


    @Test
    public void add() {
        PopSong ps = new PopSong("Pop song", 12.5);
        MyList myList = new MyList(ps);
        Assert.assertTrue(myList.contains(ps));
    }

    @Test
    public void remove() {
        PopSong ps = new PopSong("Pop song", 12.5);
        MyList myList = new MyList(ps);
        myList.remove(ps);
        Assert.assertFalse(myList.contains(ps));
    }

    @Test
    public void containsAll() {
        PopSong song1 = new PopSong("Pop song 1", 12.5);
        PopSong song2 = new PopSong("Pop song 2", 2.5);
        MyList list1 = new MyList(song1);
        list1.add(song2);
        MyList list2 = new MyList(list1);
        Assert.assertTrue(list2.containsAll(list1));
    }

    @Test
    public void get() {
        PopSong pop1 = new PopSong("Pop song 1", 12.5);
        PopSong pop2 = new PopSong("Pop song 2", 2.5);
        MyList list = new MyList();
        list.add(pop1);
        list.add(pop2);
        Assert.assertEquals(pop2, list.get(1));
    }

    @Test
    public void set() {
        PopSong pop1 = new PopSong("Pop song 1", 12.5);
        PopSong pop2 = new PopSong("Pop song 2", 2.5);
        MyList list = new MyList();
        list.add(pop1);
        MyList list2 = new MyList();
        list2.add(pop2);
        list.set(0, pop2);
        Assert.assertTrue(list.toArray()[0].equals(list2.toArray()[0]));
    }

    @Test
    public void testAdd() {
        PopSong pop1 = new PopSong("Pop song 1", 12.5);
        PopSong pop2 = new PopSong("Pop song 2", 2.5);
        MyList list = new MyList();
        list.add(pop2);
        MyList list2 = new MyList();
        list2.add(pop1);
        list2.add(pop2);
        list.add(0, pop1);
        Assert.assertTrue(list.toArray()[0].equals(list2.toArray()[0]) || list.toArray()[1].equals(list2.toArray()[1]));
    }

    @Test
    public void testRemove() {
        PopSong pop1 = new PopSong("Pop song 1", 12.5);
        PopSong pop2 = new PopSong("Pop song 2", 2.5);
        MyList list = new MyList();
        list.add(pop1);
        list.add(pop2);
        Track[] arr = {pop2};
        list.remove(0);
        Assert.assertEquals(arr[0], list.toArray()[0]);
    }

    @Test
    public void addAll() {
        PopSong pop1 = new PopSong("Pop song 1", 12.5);
        PopSong pop2 = new PopSong("Pop song 2", 2.5);
        MyList list = new MyList();
        list.add(pop1);
        list.add(pop2);
        MyList list2 = new MyList(list);
        Assert.assertTrue(list.toArray()[0].equals(list2.toArray()[0]) || list.toArray()[1].equals(list2.toArray()[1]));
    }


    @Test
    public void removeAll() {
        PopSong pop1 = new PopSong("Pop song 1", 12.5);
        PopSong pop2 = new PopSong("Pop song 2", 2.5);
        RapSong rap = new RapSong("Rap song", 3.5);
        MyList list1 = new MyList(pop1);
        list1.add(pop2);
        list1.add(rap);
        MyList list2 = new MyList(pop2);
        list2.add(rap);
        list1.removeAll(list2);
        MyList removed_all = new MyList(rap);
        Assert.assertTrue(list1.equals(removed_all));
    }

    @Test
    public void retainAll() {
        PopSong pop1 = new PopSong("Pop song 1", 12.5);
        PopSong pop2 = new PopSong("Pop song 2", 2.5);
        RapSong rap = new RapSong("Rap song", 3.5);
        MyList list1 = new MyList(pop1);
        list1.add(pop2);
        list1.add(rap);
        MyList list2 = new MyList(pop2);
        list2.add(rap);
        list1.retainAll(list2);
        Assert.assertTrue(list1.equals(list2));
    }

    @Test
    public void clear() {
        PopSong pop1 = new PopSong("Pop song 1", 12.5);
        PopSong pop2 = new PopSong("Pop song 2", 2.5);
        MyList list = new MyList();
        list.add(pop1);
        list.add(pop2);
        MyList empty_list = new MyList();
        list.clear();
        Assert.assertTrue(list.equals(empty_list));
    }


}