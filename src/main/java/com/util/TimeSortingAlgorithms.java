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
            //"int500k.txt",
            //"intBig.txt"
    };

    private static long TimeAlgorithm(SortingAlgorithm algorithm, int[] A) {
        long startTime = System.nanoTime();
        algorithm.sort(A);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static void TimeSortingAlgorithms(int iterations) {
        SortingAlgorithm[] algorithms = {
                new InsertionSort(),
                new Shellsort(),
                new MergeSort(),
                new HybridMergeSort(),
                new IterativeMergeSort(),
                new SelectionSort(),
                new Quicksort()
        };

        Map<String, Map<String, Long>> runtimeMap = new HashMap<>();

        for (String f : INPUT_FILES) {
            System.out.println("Sorting " + f);
            Map<String, Long> inputRuntime = new HashMap<>();

            for (SortingAlgorithm algorithm : algorithms) {

                long runningTotal = 0;
                System.out.println("with: " + algorithm);

                for (int i = 0; i < iterations; i++) {
                    int[] A = CreateArrayFromFile.CreateIntArrayFromFile(f);

                    long startTime = System.currentTimeMillis();

                    algorithm.sort(A);

                    long endTime = System.currentTimeMillis();

                    runningTotal += endTime - startTime;
                }

                inputRuntime.put(algorithm.toString(), runningTotal / iterations);
            }

            runtimeMap.put(f, inputRuntime);
        }

        CSV.writeToFile("timings.csv", runtimeMap, algorithms);
    }

    public static void main(String[] args) {
        System.out.println("Timing all algorithms...");
        long timerStart = System.currentTimeMillis();

        Runnable timingThread = () -> {
            while (true) {
                long elapsedTime = System.currentTimeMillis() - timerStart;
                System.out.println("Elapsed time: " + elapsedTime / 1000 + " s");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                    break;
                }
            }
        };

        Thread run = new Thread(timingThread);
        run.setDaemon(true);
        run.start();

        long startTime = System.nanoTime();
        TimeSortingAlgorithms(10);
        long endTime = System.nanoTime();

        System.out.println("Done in: " + (endTime - startTime) + "ns");
    }
}
