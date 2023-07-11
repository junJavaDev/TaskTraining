package ru.jvst.leetcode.leetcode75;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RottingOrangesTest {

    RottingOranges checker;
    @BeforeEach
    void setup() {
        checker = new RottingOranges();
    }
    @Test
    void orangesRotting() {
        assertEquals(2, checker.orangesRotting(new int[][] {   {2,1,1},
                                                                        {1,1,1},
                                                                        {0,1,2}}));
        assertEquals(4, checker.orangesRotting(new int[][] {{2,1,1},{1,1,0},{0,1,1}}));
        assertEquals(-1, checker.orangesRotting(new int[][] {{2,1,1},{0,1,1},{1,0,1}}));
        assertEquals(0, checker.orangesRotting(new int[][] {{0,2}}));
    }
}