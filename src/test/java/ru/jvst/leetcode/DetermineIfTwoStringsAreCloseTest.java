package ru.jvst.leetcode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DetermineIfTwoStringsAreCloseTest {
    DetermineIfTwoStringsAreClose checker;
    @BeforeEach
    void setup() {
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