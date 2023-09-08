package de.tum.in.ase.eist.orderHandling;

import java.util.List;
import java.util.Map;

public class WordReducer {

    public static void reduce(String file, Map<String, Integer> wordCounter) {
        // String is split into chunks
        String[] tokens = file.split(" ");
        // all words in the list are checked and if the list contains
        // the word currently being checked in the splitfile chunk then
        // the value/counter in the map is incremented
        for (String word : tokens) {
            if (!word.isEmpty()) {
                wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
            }
        }
    }

    //adds a word and its count to a StringBuilder (String)
    public static void append(StringBuilder orderfile, String word, Map<String, Integer> wordCounter) {
        orderfile.append(word).append(" - ").append(wordCounter.get(word)).append("\n");
    }
}
