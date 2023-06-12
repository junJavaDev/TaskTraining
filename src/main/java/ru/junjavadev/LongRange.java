package ru.junjavadev;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

class LongRange {
    private final long left;
    private final long right;

    public static void main(String[] args) {
        Set<LongRange> numbers = new TreeSet<>(LongRange.getComparator());

        numbers.add(new LongRange(0, 5));
        numbers.add(new LongRange(2, 4));
        numbers.add(new LongRange(1, 4));
        numbers.add(new LongRange(1, 7));
        numbers.add(new LongRange(3, 5));

        final StringBuilder sb = new StringBuilder("");
        numbers.forEach(s -> sb.append(s).append("\n"));
        String expected = """
                2 4
                3 5
                1 4
                0 5
                1 7
                """;
        String got = sb.toString();
        if (!expected.equals(got)) {
            System.out.println("Expected:\n" + expected);
            System.out.print("\nBut got:\n" + got);
        } else System.out.println("GOOD");
    }

    public static Comparator<LongRange> getComparator() {
        return comparing((LongRange lr) -> lr.getRight() - lr.getLeft())
                .thenComparing(LongRange::getLeft);
    }

    public LongRange(long left, long right) {
        this.left = left;
        this.right = right;
    }

    public long getLeft() {
        return left;
    }

    public long getRight() {
        return right;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LongRange longRange = (LongRange) other;
        return left == longRange.left &&
                right == longRange.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return String.format("%d %d", left, right);
    }
}