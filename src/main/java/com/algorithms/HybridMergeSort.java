package com.algorithms;

import static com.algorithms.MergeSort.merge;

public class HybridMergeSort implements SortingAlgorithm {

    private void sort(int[] a, int p, int r) {
        if (p < r) {
            if (a.length >= 5 && a.length <= 20) {
                new InsertionSort().sort(a);
            }
            int q = (p + r) / 2;
            sort(a, p, q);
            sort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    @Override
    public int[] sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    @Override
    public String toString() {
        return "HybridMergeSort";
    }
}
