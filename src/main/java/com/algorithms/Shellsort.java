package com.algorithms;

public class Shellsort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] A) {
        int h = 1;

        while (h < A.length / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < A.length; i++) {
                for (int j = i; j >= h && A[j] < A[j - h]; j -= h) {
                    int temp = A[j];
                    A[j] = A[j - h];
                    A[j - h] = temp;
                }
            }
            h /= 3;
        }
        return A;
    }

    @Override
    public String toString() {
        return "Shellsort";
    }
}
