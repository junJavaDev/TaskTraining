package ru.jvst.leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqualRowAndColumnPairsTest {
    EqualRowAndColumnPairs checker;
    @BeforeEach
    void setup() {
        checker = new EqualRowAndColumnPairs();
    }
    @Test
    void equalPairsQube() {
        assertEquals(1, checker.equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
    }
}