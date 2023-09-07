package ru.junjavadev;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            result.append(" ");
        }
        return result.toString().trim();
    }
}
