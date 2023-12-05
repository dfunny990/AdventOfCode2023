package org.example;

import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

//12 Red
//13 Green
//14 Blue

public class DayTwo {
    public static int RunDayTwo(){
        int total = 0;
        List<String> input = Utils.GetStringListFromFile("DayTwoInput.txt");
        for (String line : input) {
            int colonIndex = line.indexOf(":");
            line = line.substring(colonIndex+2);
            total += ProcessGame(line);
        }
        return total;
    }

    private static int ProcessGame(String line) {
        String[] shows = line.split(";");
        int maxRed = 0;
        int maxGreen = 0;
        int maxBlue = 0;

        for (String show : shows) {
            List<String> dice = Arrays.asList(show.split(","));
            int[] requiredDiceRGB = ProcessDice(dice);
            maxRed = Math.max(maxRed, requiredDiceRGB[0]);
            maxGreen = Math.max(maxGreen, requiredDiceRGB[1]);
            maxBlue = Math.max(maxBlue, requiredDiceRGB[2]);
        }
        return maxRed * maxGreen * maxBlue;
    }

    private static int[] ProcessDice(List<String> dice) {
        int[] rgbValues = new int[3];
        for (String roll : dice) {
            roll = roll.trim();
            int spaceIndex = roll.indexOf(" ");
            int numDice = parseInt(roll.substring(0,spaceIndex));
            String color = roll.substring(spaceIndex+1);
            if (color.equals("red")) {
                rgbValues[0] = numDice;
            }
            if (color.equals("green")) {
                rgbValues[1] = numDice;
            }
            if (color.equals("blue")){
                rgbValues[2] = numDice;
            }
        }
        return rgbValues;
    }

}
