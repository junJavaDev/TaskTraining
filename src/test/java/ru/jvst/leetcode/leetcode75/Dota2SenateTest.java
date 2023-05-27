package ru.jvst.leetcode.leetcode75;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Dota2SenateTest {

    Dota2Senate checker;
    @BeforeEach
    void setUp() {
        checker = new Dota2Senate();
    }

    @Test
    void predictPartyVictory() {
        assertEquals("Dire", checker.predictPartyVictory("RDD"));
        assertEquals("Radiant", checker.predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }
}