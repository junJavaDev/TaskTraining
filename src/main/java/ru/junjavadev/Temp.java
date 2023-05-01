package ru.junjavadev;

import java.util.List;

public class Temp {
    public static void main(String[] args) {
        List<Integer> digits = List.of(1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        digits.stream().takeWhile(n -> n == 1).forEach(System.out::println);
        System.out.println();
        digits.stream().takeWhile(n -> n < 9).forEach(System.out::println);
        System.out.println();
        digits.stream().dropWhile(n -> n == 1).forEach(System.out::println);
        System.out.println();
        digits.stream().dropWhile(n -> n > 0).forEach(System.out::println);
        System.out.println();
        digits.stream().dropWhile(n -> n > 9).forEach(System.out::println);
    }
}
