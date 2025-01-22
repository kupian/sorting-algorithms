package com.sortingalgorithms;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class TestSortingAlgorithms {

    private static boolean TestIntArrayAscends(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (i < i-1) {
                return false;
            }
        }
        return true;
    }

    private static int[] CreateIntArrayFromFile(String filename) {
        long lineCount = 0;
        try {
            // Count lines in file
            Path path = Paths.get(filename);
            Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8);
            lineCount = stream.count();
            stream.close();
        } catch (IOException e) {
            System.err.println(e);
        }

        int[] arr = new int[(int) lineCount];

        try {
            // Read numbers into array
            File f = new File(filename);
            Scanner reader = new Scanner(f);
            int i = 0;
            while(reader.hasNextLine()) {
                int nextInt = Integer.parseInt(reader.nextLine());
                arr[i] = nextInt;
                i++;
            }

        } catch (Exception e) {
        }

        return arr;
    }

    public static boolean TestInsertionSort() {
        int[] int1000 = CreateIntArrayFromFile("int1000.txt");
        return TestIntArrayAscends(InsertionSort.sort(int1000));
    }
}
