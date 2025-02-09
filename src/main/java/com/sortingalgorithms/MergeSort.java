package com.sortingalgorithms;

import com.recursivefunctions.Merge;

public class MergeSort implements SortingAlgorithm {

    private int[] sort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            a = sort(a, p, q);
            a = sort(a, q + 1, r);
            a = Merge.merge(a, p, q, r);
        }
        return a;
    }

    @Override
    public int[] sort(int[] arr) {
        return sort(arr, 0, arr.length - 1);
    }

    @Override
    public String toString() {
        return "Merge Sort";
    }
}
