package com.algorithms;

public class IterativeMergeSort implements SortingAlgorithm {

    // Implemented based on Lab 3 solutions
    private void sort(int[] arr, int start, int end) {
        int n = arr.length;
        for (int size = 1; size < n; size = size + size) {
            for (int p = 0; p < n - size; p += size + size) {
                MergeSort.merge(arr, p, p + size - 1, Math.min(p + size + size - 1, n - 1));
            }
        }
    }

    @Override
    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    @Override
    public String toString() {
        return "IterativeMergeSort";
    }
}
