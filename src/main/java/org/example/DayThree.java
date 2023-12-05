package org.example;

import java.util.List;

public class DayThree {
    public static int RunDayThree() {
        int total = 0;
        int counter = 0;
        List<String> input = Utils.GetStringListFromFile("DayThreeInput.txt");
        for (int i = 0; i < input.size(); i++) {
            total += ProcessLine(input, i);
        }
        return total;
    }

    private static int ProcessLine(List<String> map, int lineNumber) {
        String currentString = map.get(lineNumber);
        int total = 0;
        for (int characterIndex = 0; characterIndex < currentString.length(); characterIndex ++) {
            int u = 0;
            int ul = 0;
            int ur = 0;
            int l = 0;
            int r = 0;
            int dr = 0;
            int d = 0;
            int dl = 0;
            char thisChar = currentString.charAt(characterIndex);
            if (!Character.isDigit(thisChar) && thisChar != '.') {
                char left = currentString.charAt(characterIndex-1);
                if (Character.isDigit(left)){
                    l = getNumber(currentString, characterIndex-1);
                }
                char upperLeft = map.get(lineNumber-1).charAt(characterIndex-1);
                if (Character.isDigit(upperLeft)){
                    ul = getNumber(map.get(lineNumber-1), characterIndex-1);
                }
                char lowerLeft = map.get(lineNumber+1).charAt(characterIndex-1);
                if (Character.isDigit(lowerLeft)){
                    dl = getNumber(map.get(lineNumber+1), characterIndex-1);
                }
                char up = map.get(lineNumber-1).charAt(characterIndex);
                if (Character.isDigit(up)){
                    u = getNumber(map.get(lineNumber-1), characterIndex);
                }
                char down = map.get(lineNumber+1).charAt(characterIndex);
                if (Character.isDigit(down)){
                    d = getNumber(map.get(lineNumber+1), characterIndex);
                }

                char right = currentString.charAt(characterIndex+1);
                if (Character.isDigit(right)){
                    r = getNumber(map.get(lineNumber), characterIndex+1);
                }
                char upperRight = map.get(lineNumber-1).charAt(characterIndex+1);
                if (Character.isDigit(upperRight)){
                    ur = getNumber(map.get(lineNumber-1), characterIndex+1);
                }
                char lowerRight = map.get(lineNumber+1).charAt(characterIndex+1);
                if (Character.isDigit(lowerRight)){
                    dr = getNumber(map.get(lineNumber+1), characterIndex+1);
                }
                if (ul != 0 && u != 0 && ur != 0) {
                    u = 0;
                    ur = 0;
                }
                if (dl != 0 && d != 0 && dr != 0) {
                    d = 0;
                    dr = 0;
                }
                if ((d != 0 && dl != 0) || (d != 0 && dr != 0)) {
                    d = 0;
                }
                if ((u != 0 && ul != 0) || (u != 0 && ur != 0)) {
                    u = 0;
                }

            }
            total += u + ul + ur + l + r + dl + d + dr;
        }
        return total;
    }

    private static int getNumber(String input, int  index) {
        int numEnd = index;
        int numStart = index;
        while(numEnd <=input.length()-1 && Character.isDigit(input.charAt(numEnd))) {
            numEnd++;
        }
        while(numStart >= 0 && Character.isDigit(input.charAt(numStart))) {
            numStart--;
        }
        return Integer.parseInt(input.substring(numStart+1, numEnd));
    }

}
