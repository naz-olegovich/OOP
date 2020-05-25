package Lab6;

public class Song extends Track{
    String style;
    public Song(String name, double duration, String style) {
        super(name,duration);
        this.style = style;
    }

}
