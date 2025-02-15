package com.algorithms;

public class Quicksort implements SortingAlgorithm {

    protected int getPivot(int[] A, int start, int end) {
        return A[end];
    }

    protected int partition(int[] A, int start, int end) {

        // Initialise pivot to the end and start i at -1
        int pivot = getPivot(A, start, end);
        int i = start - 1;

        // Initialise j to the start and iterate over the array
        for (int j = start; j < end; j++) {
            // If element at j is less than pivot, increment i and swap A[i] with A[j]
            if (A[j] < pivot) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        // Once j reaches end of array, increment i and swap A[i] with A[j]
        int temp = A[i + 1];
        A[i + 1] = A[end];
        A[end] = temp;

        // All items to left of pivot are now smaller, and all items to right are greater. return index of pivot
        return i + 1;
    }

    public void quickSort(int[] A, int start, int end) {
        if (start < end) {
            // Partition the array and get the pivot index
            int pivot = partition(A, start, end);
            // Quicksort the left partition and right partition in place
            quickSort(A, start, pivot - 1);
            quickSort(A, pivot + 1, end);
        }
    }

    @Override
    public int[] sort(int[] A) {
        quickSort(A, 0, A.length - 1);
        return A;
    }

    @Override
    public String toString() {
        return "Quicksort";
    }
}
