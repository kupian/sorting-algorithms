package com.sortingalgorithms;

/**
 * The InsertionSortDescending class implements the SortingAlgorithm interface
 * to provide functionality for sorting integer arrays in descending order
 * using the insertion sort algorithm.
 *
 * Insertion sort is an algorithm that builds the sorted array one item at a time,
 * inserting each element into its correct position with respect to a descending order.
 */
public class InsertionSortDescending implements SortingAlgorithm {
    public int[] sorted(int[] arr) {
        int key;
        for (int j = 1; j < arr.length; j++) {
            key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] < key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i+1] = key;
        }
        return arr;
    }

    public String toString() {
        return "Insertion Sort in descending order";
    }
}
