package ru.junjavadev;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public class lol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lines = new ArrayList<>();
        boolean repeat = true;
        while (repeat) {
            String line = scanner.nextLine();
            if (line.isEmpty()) repeat = false;
            lines.add(line);
        }

        int max = lines.stream()
                .flatMap(line -> Arrays.stream(line.split("\s+")))
                .filter(string -> string.length() > 0)
                .map(Integer::parseInt)
                .max(Comparator.naturalOrder())
                .orElse(Integer.MIN_VALUE);

        System.out.println(max);
    }
}
