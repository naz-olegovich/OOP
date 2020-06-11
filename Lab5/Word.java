package Lab5;

public class Word {
    public Letter[] letter;
    public String wordd;

    public Word(String word) {
        wordd = word;
        String[] splited_word = word.split("");
        letter = new Letter[splited_word.length];
        for (int i = 0; i < splited_word.length; i++) {
            letter[i] = new Letter(splited_word[i]);
        }
    }
}

