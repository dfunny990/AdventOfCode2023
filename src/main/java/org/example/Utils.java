package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {


    public static List<String> GetStringListFromFile(String fileName) {
        List<String> stringList = new ArrayList<>();
        String filepath = "src/main/resources/" + fileName;
//        System.out.println(filepath);
        try {
            File thisFile = new File(filepath);
            Scanner myReader = new Scanner(thisFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stringList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return stringList;
    }
}
