package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayOneTest {
    @Test
    void shouldReturnFirstAndLastDigitsAsInt() {
        String input = "1and2";

        int actual = DayOne.DayOneGetIntFromString(input);

        assertEquals(actual, 12);
    }
    @Test
    void shouldReturnDoubleDigitForSingleDigit() {
        String input = "eleph3nt";
        int actual = DayOne.DayOneGetIntFromString(input);
        assertEquals(actual, 33);
    }

}

