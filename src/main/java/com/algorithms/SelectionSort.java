package com.algorithms;

import java.util.Arrays;

public class SelectionSort implements SortingAlgorithm {

    private static final int INF = 999999999;

    @Override
    public int[] sort(int[] A) {

        int[] sorted = new int[A.length];
        int min;

        for (int i = 0; i < sorted.length; i++) {
            min = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }

            if (A[min] == INF) {
                return sorted;
            }

            sorted[i] = A[min];
            A[min] = INF;
        }

        return sorted;
    }

    @Override
    public String toString() {
        return "SelectionSort";
    }
}
