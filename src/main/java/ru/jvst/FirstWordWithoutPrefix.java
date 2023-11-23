package ru.jvst;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class FirstWordWithoutPrefix {

    public static void printFirstWordWithoutPrefix(List<String> words, String prefix) {
        words.stream()
                .filter(w -> !w.startsWith(prefix))
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .toList();

        String prefix = scanner.nextLine();

        printFirstWordWithoutPrefix(words, prefix);
    }
}