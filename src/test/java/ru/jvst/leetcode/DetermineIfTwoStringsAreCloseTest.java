package ru.jvst.leetcode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DetermineIfTwoStringsAreCloseTest {
    static DetermineIfTwoStringsAreClose checker;
    @BeforeAll
    public static void setup() {
        checker = new DetermineIfTwoStringsAreClose();
    }

    @Test
    public void testAbcBsaCloseStrings() {
        DetermineIfTwoStringsAreClose checker = new DetermineIfTwoStringsAreClose();
        assertTrue(checker.closeStrings("abc", "bca"));
    }
    @Test
    public void testAAaCloseStrings() {
        DetermineIfTwoStringsAreClose checker = new DetermineIfTwoStringsAreClose();
        assertFalse(checker.closeStrings("a", "aa"));
    }
    @Test
    public void testCabbbaAbbcccCloseStrings() {
        DetermineIfTwoStringsAreClose checker = new DetermineIfTwoStringsAreClose();
        assertTrue(checker.closeStrings("cabbba", "abbccc"));
    }
}