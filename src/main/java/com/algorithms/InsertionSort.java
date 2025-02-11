package com.algorithms;

public class InsertionSort implements SortingAlgorithm {

    public int[] sort(int[] arr) {
        int key;
        for (int j = 1; j < arr.length; j++) {
            key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i+1] = key;
        }
        return arr;
    }

    public String toString() {
        return "InsertionSort";
    }
}
