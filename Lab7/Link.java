package Lab7;

import Lab6.Track;


public class Link {
    private Link next;
    private Track data;

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public Track getData() {
        return data;
    }

    public void setData(Track data) {
        this.data = data;
    }
}