package com.util;

import com.algorithms.*;

import java.util.HashMap;
import java.util.Map;

public class TimeSortingAlgorithms {

    private static long timeAlgorithm(SortingAlgorithm algorithm, int[] A) {
        long startTime = System.nanoTime();
        algorithm.sort(A);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static Map<String, Map<String, Long>> runSortingAlgorithms(String[] inputFiles, SortingAlgorithm[] algorithms, int iterations) {

        Map<String, Map<String, Long>> runtimeMap = new HashMap<>();

        for (String f : inputFiles) {
            System.out.println("Sorting " + f);
            Map<String, Long> inputRuntime = new HashMap<>();

            for (SortingAlgorithm algorithm : algorithms) {

                long runningTotal = 0;
                System.out.println("with: " + algorithm);

                for (int i = 0; i < iterations; i++) {
                    int[] A = CreateArrayFromFile.CreateIntArrayFromFile(f);
                    runningTotal += (timeAlgorithm(algorithm, A));
                }

                inputRuntime.put(algorithm.toString(), runningTotal / iterations);
            }

            runtimeMap.put(f, inputRuntime);
        }
        return runtimeMap;
    }

    private static void startProgramTimer() {
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
    }

    public static void main(String[] args) {
        String[] files = {"intBig.txt"};
        SortingAlgorithm[] algorithms = {
                new SelectionSort(),
        };

        System.out.println("Timing all algorithms...");

        startProgramTimer();

        long startTime = System.nanoTime();
        Map<String, Map<String, Long>> runtimeMap = runSortingAlgorithms(files, algorithms, 10);
        long endTime = System.nanoTime();
        CSV.writeToFile("timings.csv", runtimeMap, algorithms);

        System.out.println("Done in: " + (endTime - startTime) + "ns");
    }
}
