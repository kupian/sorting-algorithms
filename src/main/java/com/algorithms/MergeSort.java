package com.algorithms;

public class MergeSort implements SortingAlgorithm {

    private int[] merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            left[i] = a[p + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = a[q + i + 1];
        }

        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
        }

        return a;
    }

    private int[] sort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            a = sort(a, p, q);
            a = sort(a, q + 1, r);
            a = merge(a, p, q, r);
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
