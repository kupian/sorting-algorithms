package com.util;

import com.algorithms.*;

import java.util.HashMap;
import java.util.Map;

public class TimeSortingAlgorithms {

    private static final String[] INPUT_FILES = {
            "int10.txt",
            "int50.txt",
            "int100.txt",
            "int1000.txt",
            "int20k.txt",
            "int500k.txt",
            "intBig.txt"
    };

    private static long TimeAlgorithm(SortingAlgorithm algorithm, int[] A) {
        long startTime = System.nanoTime();
        algorithm.sort(A);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static void TimeSortingAlgorithms() {
        SortingAlgorithm[] algorithms = {
                new InsertionSort(),
                new MergeSort(),
                new SelectionSort(),
                new Quicksort()
        };

        Map<String, Map<String, Long>> runtimeMap = new HashMap<>();

        for (SortingAlgorithm algorithm : algorithms) {
            System.out.println("Timing " + algorithm);
            Map<String, Long> inputRuntime = new HashMap<>();

            for (String f : INPUT_FILES) {
                System.out.println("with input file: " + f);
                int[] A = CreateArrayFromFile.CreateIntArrayFromFile(f);
                long startTime = System.nanoTime();
                algorithm.sort(A);
                long endTime = System.nanoTime();
                inputRuntime.put(f, (endTime - startTime));
            }

            runtimeMap.put(algorithm.toString(), inputRuntime);
        }

        CSV.writeToFile("timings.csv", runtimeMap);
    }

    public static void main(String[] args) {
        System.out.println("Timing all algorithms...");
        long startTime = System.nanoTime();
        TimeSortingAlgorithms();
        long endTime = System.nanoTime();
        System.out.println("Done in: " + (endTime - startTime) + "ns");
    }
}
