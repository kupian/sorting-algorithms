package com.sortingalgorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;


public class CreateArrayFromFile {
    /**
     * Reads integers from a file and creates an array of those integers.
     * The file should have one integer per line.
     *
     * @param filename the path to the file containing integers
     * @return an array of integers read from the file
     */
    public static int[] CreateIntArrayFromFile(String filename) {
        long lineCount = 0;

        // Count lines in file
        try {
            Path path = Paths.get(filename);
            Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8);
            lineCount = stream.count();
            stream.close();
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }

        int[] arr = new int[(int) lineCount];

        // Read numbers into array
        try {
            File f = new File(filename);
            Scanner reader = new Scanner(f);
            int i = 0;

            while (reader.hasNextLine()) {
                int nextInt = Integer.parseInt(reader.nextLine());
                arr[i] = nextInt;
                i++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }

        return arr;
    }
}
