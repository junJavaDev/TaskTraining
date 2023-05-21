package ru.jvst.leetcode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DetermineIfTwoStringsAreCloseTest {
    static DetermineIfTwoStringsAreClose checker;
    @BeforeAll
    static void setup() {
        checker = new DetermineIfTwoStringsAreClose();
    }

    @Test
    void testAbcBsaCloseStrings() {
        assertTrue(checker.closeStrings("abc", "bca"));
    }
    @Test
    void testAAaCloseStrings() {
        assertFalse(checker.closeStrings("a", "aa"));
    }
    @Test
    void testCabbbaAbbcccCloseStrings() {
        assertTrue(checker.closeStrings("cabbba", "abbccc"));
    }
}