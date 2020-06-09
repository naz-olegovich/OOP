package Lab7;

import Lab6.Track;

import java.math.BigDecimal;
import java.util.*;

public class MyList implements List<Track> {

    private Link head;
    private Link tail;
    private int size = 0;

    public MyList() {
    }

    public MyList(Track elem) {
        add(elem);
    }

    public MyList(Collection<? extends Track> elem) {
        addAll(elem);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        Iterator iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Track> iterator() {
        return new Iterator<Track>() {
            private Link currentLink = head;

            @Override
            public boolean hasNext() {
                return currentLink != null;
            }

            @Override
            public Track next() {
                Link result = currentLink;
                if (currentLink != null) {
                    currentLink = currentLink.getNext();
                } else {
                    throw new NoSuchElementException();
                }
                return result.getData();
            }
        };
    }

    @Override
    public Object[] toArray() {
        int counter = 0;
        Track[] arrayOfTracks = new Track[size];
        Iterator<Track> iterator = iterator();
        while (iterator.hasNext()) {
            arrayOfTracks[counter] = iterator.next();
        }
        return arrayOfTracks;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Track track) {
        Link link = new Link();
        link.setData(track);
        if (head == null) {
            head = link;
            tail = link;
        } else {
            tail.setNext(link);
            tail = link;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            Iterator<Track> iterator = iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == o) {
                    delEl((Track) o);
                    size--;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean flag = true;
        Iterator<Track> iterator = (Iterator<Track>) c.iterator();
        while (iterator.hasNext()) {
            flag = contains((Track) iterator.next());
            if (flag == false) {
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean addAll(Collection<? extends Track> c) {
        Iterator<? extends Track> iterator = c.iterator();
        boolean flag = false;
        while (iterator.hasNext()) {
            flag = add((Track) iterator.next());
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Track> c) {
        return false;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = false;
        for (Object object : c) {
            flag = remove(object);
        }
        return flag;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag = true;
        Iterator<Track> iterator = iterator();
        while (iterator.hasNext()) {
            Track Track = (Track) iterator.next();
            flag = c.contains(Track);
            if (flag == false)
                remove(Track);
        }
        return flag == false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Track get(int index) {
        Iterator<Track> iterator = iterator();
        int real_index = 0;
        while (iterator.hasNext()) {
            if (real_index++ == index) {
                return (iterator.next());
            }
            iterator.next();
        }
        return null;
    }

    @Override
    public Track set(int index, Track element) {
        Iterator<Track> iterator = iterator();
        int counter = 0;
        int real_index = 0;
        Track[] arr = new Track[0];
        while (iterator.hasNext()) {
            if (real_index++ >= index) {
                Track next = iterator.next();
                arr = addTrack(arr, next, counter++);
                remove(next);
            } else {
                iterator.next();
            }
        }
        add(element);
        for (int i = 1; i < arr.length; i++) {
            add(arr[i]);
        }
        return null;
    }

    @Override
    public void add(int index, Track element) {
        Iterator<Track> iterator = iterator();
        int counter = 0;
        int real_index = 0;
        Track[] arr = new Track[0];
        while (iterator.hasNext()) {
            if (real_index++ >= index) {
                Track next = iterator.next();
                arr = addTrack(arr, next, counter++);
                remove(next);
            } else {
                iterator.next();
            }
        }
        add(element);
        for (Track el : arr) {
            add(el);
        }


    }

    @Override
    public Track remove(int index) {
        Iterator iterator = iterator();
        int real_index = 0;
        while (iterator.hasNext()) {
            if (real_index++ == index) {
                remove(iterator.next());
                return null;
            }
            iterator.next();
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Track> listIterator() {
        return null;
    }


    @Override
    public ListIterator<Track> listIterator(int index) {
        return null;
    }

    @Override
    public List<Track> subList(int fromIndex, int toIndex) {
        return null;
    }

    void delEl(Track data) {
        if (head == null)
            return;
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        if (head.getData() == data) {
            head = head.getNext();
            return;
        }
        Link t = head;
        while (t.getNext() != null) {
            if (t.getNext().getData() == data) {
                if (tail == t.getNext()) {
                    tail = t;
                }
                t.setNext(t.getNext().getNext());
                return;
            }
            t = t.getNext();
        }
    }

    public static Track[] addTrack(Track[] arr, Track x, int n) {
        int i;
        Track newarr[] = new Track[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = x;
        return newarr;
    }

}



