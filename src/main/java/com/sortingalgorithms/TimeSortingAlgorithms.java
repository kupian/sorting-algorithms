package com.sortingalgorithms;

public class TimeSortingAlgorithms {

    private static long TimeAlgorithm(SortingAlgorithm algorithm, int[] array) {
        long startTime = System.nanoTime();
        algorithm.sort(array);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        System.out.println("--------------------------");
        System.out.println("Time taken to sort int1000.txt:\n");

        int[] testArray = CreateArrayFromFile.CreateIntArrayFromFile("int1000.txt");
        SortingAlgorithm[] algorithmsToTest = {new InsertionSort(), new InsertionSortDescending()};

        for (SortingAlgorithm algorithm : algorithmsToTest) {
            double runTime = (double) TimeAlgorithm(algorithm, testArray) / 1000000;
            System.out.println(algorithm + ": " + runTime + "ms");
        }
        System.out.println("--------------------------");
    }
}
