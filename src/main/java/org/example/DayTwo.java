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
        int counter = 1;
        List<String> input = Utils.GetStringListFromFile("DayTwoInput.txt");
        for (String line : input) {
            int colonIndex = line.indexOf(":");
            line = line.substring(colonIndex+2);
            if (ProcessGame(line)) {
                total += counter;
            }
            counter ++;
        }
        return total;
    }

    private static boolean ProcessGame(String line) {
        String[] shows = line.split(";");
        for (String show : shows) {
            List<String> dice = Arrays.asList(show.split(","));
            boolean validShow = ProcessDice(dice);
            if (!validShow) {
                return false;
            }
        }
        return true;
    }

    private static boolean ProcessDice(List<String> dice) {
        for (String roll : dice) {
            roll = roll.trim();
            System.out.println(roll);
            int spaceIndex = roll.indexOf(" ");
            int numDice = parseInt(roll.substring(0,spaceIndex));
            String color = roll.substring(spaceIndex+1);
            if ((color.equals("red") && numDice > 12) ||
                (color.equals("green") && numDice > 13) ||
                (color.equals("blue") && numDice > 14)) {
                return false;
            }
        }
        return true;
    }

}
