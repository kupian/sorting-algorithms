package com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class CreateArrayFromFile {
    /**
     * Reads integers from a file and creates an array of those integers.
     * The file should have one integer per line.
     *
     * @param filename the path to the file containing integers
     * @return an array of integers read from the file
     */
    public static int[] CreateIntArrayFromFile(String filename) {

        ArrayList<Integer> list = new ArrayList<>();

        // Read numbers into array
        try {
            File f = new File(filename);
            Scanner reader = new Scanner(f);

            while (reader.hasNextLine()) {
                int nextInt = Integer.parseInt(reader.nextLine());
                list.add(nextInt);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file. Check spelling and try again.");
            return new int[0];
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
