package com.util;

import com.algorithms.InsertionSort;
import com.algorithms.InsertionSortDescending;
import com.algorithms.MergeSort;
import com.algorithms.SortingAlgorithm;

public class TimeSortingAlgorithms {

    private static final String[] INPUT_FILES = {
            ""
    };

    private static long TimeAlgorithm(SortingAlgorithm algorithm, int[] A) {
        long startTime = System.nanoTime();
        algorithm.sort(A);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static void TimeSortingAlgorithms() {

    }

    public static void main(String[] args) {
        System.out.println("--------------------------");
        System.out.println("Time taken to sort int1000.txt:\n");

        int[] testArray = CreateArrayFromFile.CreateIntArrayFromFile("int1000.txt");
        SortingAlgorithm[] algorithmsToTest = {new InsertionSort(), new InsertionSortDescending(), new MergeSort()};

        for (SortingAlgorithm algorithm : algorithmsToTest) {
            double runTime = (double) TimeAlgorithm(algorithm, testArray) / 1000000;
            System.out.println(algorithm + ": " + runTime + "ms");
        }
        System.out.println("--------------------------");
    }
}
