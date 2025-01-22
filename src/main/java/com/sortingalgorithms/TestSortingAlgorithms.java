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
     * Tests whether the specified sorting algorithm correctly sorts the given array
     * in ascending order by verifying its output.
     *
     * @param alg the sorting algorithm to test, implementing the SortingAlgorithm interface
     * @param arr the array of integers to be sorted and tested
     * @return true if the sorting algorithm correctly sorts the array in ascending order, otherwise false
     */
    public static boolean TestAlgorithm(SortingAlgorithm alg, int[] arr) {
        System.out.println("Testing " + alg);
        boolean result = TestIntArrayAscends(alg.sorted(arr));
        System.out.println(result ? "Passed" : "Failed");
        return result;
    }

    /**
     * Tests the functionality of multiple sorting algorithms by verifying their ability
     * to correctly sort a predefined dataset. This method uses a data file containing integers,
     * applies sorting algorithms to the data, and checks for correctness of the results.
     *
     * @return true if all tested sorting algorithms pass their respective tests, otherwise false
     */
    public static boolean TestAlgorithms() {
        int[] int1000 = CreateIntArrayFromFile("int1000.txt");
        if (!TestAlgorithm(new InsertionSort(), int1000)) return false;
        if (!TestAlgorithm(new InsertionSortDescending(), int1000)) return false;
        return true;
    }
}
