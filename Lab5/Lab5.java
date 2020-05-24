package Lab5;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть текст:");
        Text text = new Text(scan.nextLine());


        Arrays.sort(text.sentences, new sort_words());
        for (int i = 0; i < text.sentences.length; i++) {
            System.out.format("%d: [%s]  Кількість слів: %d\n", i + 1, text.sentences[i].sentt, text.sentences[i].qunt);
        }
    }

}

class sort_words implements Comparator<Sentences> {
    @Override
    public int compare(Sentences o1, Sentences o2) {
        return o1.qunt - o2.qunt;
    }
}
