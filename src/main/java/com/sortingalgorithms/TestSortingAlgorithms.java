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

/**
 * The TestSortingAlgorithms class provides methods to test the functionality
 * of various sorting algorithms, including the use of external files to generate
 * data for testing. It ensures that the sorted arrays adhere to the correct ordering.
 */
public class TestSortingAlgorithms {

    /**
     * Checks if the given integer array is sorted in ascending order.
     *
     * @param arr the array of integers to check
     * @return true if the array is sorted in ascending order, otherwise false
     */
    private static boolean TestIntArrayAscends(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Reads integers from a file and creates an array of those integers.
     * The file should have one integer per line.
     *
     * @param filename the path to the file containing integers
     * @return an array of integers read from the file
     */
    private static int[] CreateIntArrayFromFile(String filename) {
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

            while(reader.hasNextLine()) {
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

    /**
     * Tests the InsertionSort algorithm by sorting an array of integers loaded from a file
     * and verifying that the resulting array is sorted in ascending order.
     *
     * @return true if the array is correctly sorted in ascending order, otherwise false
     */
    public static boolean TestInsertionSort() {
        int[] int1000 = CreateIntArrayFromFile("int1000.txt");
        return TestIntArrayAscends(InsertionSort.sorted(int1000));
    }
}
