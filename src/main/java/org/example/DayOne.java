package org.example;

import java.util.List;

public class DayOne {

    static int DayOne() {
        List<String> inputs = Utils.GetStringListFromFile("DayOneInput.txt");
        int result = 0;
        for (String word : inputs) {
            int value = DayOneGetIntFromString(word);
            result += value;
        }

        return result;

    }
    static int DayOneGetIntFromString(String input) {
        int indexOfFirst = 0;
        while(getNumberAtPosition(input, indexOfFirst) == -1){
            indexOfFirst++;
        }
        int indexOfLast = input.length()-1;
        while (indexOfLast >= indexOfFirst && getNumberAtPosition(input, indexOfLast) == -1) {
            indexOfLast--;
        }
        String result = "";
        result += getNumberAtPosition(input, indexOfFirst);
        result += getNumberAtPosition(input, indexOfLast);
        return Integer.parseInt(result);

    }

    public static int getNumberAtPosition(String fullString, int index) {
        if (Character.isDigit(fullString.charAt(index))) {
            String digit = String.valueOf(fullString.charAt(index));
            return Integer.parseInt(digit);
        }
        if (index + 3 <= fullString.length()) {
            String currentString = fullString.substring(index, index+3);
            if (currentString.equals("one")) {
                return 1;
            }
            if (currentString.equals("two")) {
                return 2;
            }
            if (currentString.equals("six")) {
                return 6;
            }
        }
        if (index + 4 <= fullString.length()) {
            String currentString = fullString.substring(index, index+4);
            if (currentString.equals("four")) {
                return 4;
            }
            if (currentString.equals("five")) {
                return 5;
            }
            if (currentString.equals("nine")) {
                return 9;
            }
            if (currentString.equals("zero")) {
                return 0;
            }
        }
        if (index + 5 <= fullString.length()) {
            String currentString = fullString.substring(index, index+5);
            if (currentString.equals("three")) {
                return 3;
            }
            if (currentString.equals("seven")) {
                return 7;
            }
            if (currentString.equals("eight")) {
                return 8;
            }
        }
        return -1;
    }
}
