package ru.jvst;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class AbsoluteNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String result = Arrays.stream(scanner.nextLine().split("\\s+")) // Stream<String>
                .map(s -> s.startsWith("-") ? s.substring(1) : s)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}