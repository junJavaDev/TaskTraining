package ru.jvst;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

class CombiningPredicates {

    /**
     * The method represents the conjunction operator for a list of predicates.
     * For an empty list it returns the always true predicate.
     */
    public static IntPredicate conjunctAll(List<IntPredicate> predicates) {
        return n -> {
            if (predicates.isEmpty()) {
                return true;
            }
            IntPredicate result = predicates.get(0);
            for (int i = 1; i < predicates.size(); i++) {
                result = result.and(predicates.get(i));
            }
            return result.test(n);
        };
    }

    public static <T> Predicate<T> xor(Predicate<T> predicate1, Predicate<T> predicate2) {
        return predicate1.or(predicate2).and((predicate1.and(predicate2)).negate());
    }


    // Don't change the code below
    public static void main(String[] args) {
        Predicate<String> firstDigit = s -> !s.isEmpty() && Character.isDigit(s.charAt(0));//предикат для проверки, начинается ли строка с цифры
        Predicate<String> bigLength = s -> !s.isEmpty() && s.length() > 10;//предикат для проверки, что длина строки больше 10
        System.out.println(xor(firstDigit, bigLength).test("Привет"));//берем оба предиката и композируем. В данном примере должно получиться false
        System.out.println(xor(firstDigit, bigLength).test("Привет всем"));//true
        System.out.println(xor(firstDigit, bigLength).test("2022 привет"));//false
        System.out.println(xor(firstDigit, bigLength).test("2022"));//true
    }
}