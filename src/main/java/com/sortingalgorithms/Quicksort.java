package com.sortingalgorithms;

public class Quicksort implements SortingAlgorithm {

    /**
     * Partitions an array to place all items less than the pivot to its left, and all items greater to its right.
     *
     * @param A     Array of integers
     * @param start Start index of array
     * @param end   Final index of array
     * @return Index of the pivot
     */
    protected static int partition(int[] A, int start, int end) {

        // Initialise pivot to rightmost element and start i at -1
        int pivot = A[end];
        int i = start - 1;

        // Initialise j to the start and iterate over the array
        for (int j = start; j < end; j++) {
            // If element at j is less than pivot, increment i and swap A[i] with A[j]
            if (A[j] < pivot) {
                i = i + 1;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        // Once j reaches end of array, increment i and swap A[i] with A[j]
        i++;
        int temp = A[i];
        A[i] = A[end];
        A[end] = temp;

        // All items to left of pivot are now smaller, and all items to right are greater. return index of pivot
        return i;
    }

    /**
     * Sorts an array using the Quicksort algorithm
     *
     * @param A     Integer array
     * @param start Start index of array
     * @param end   End index of array
     */
    public static void quickSort(int[] A, int start, int end) {
        if (start < end) {
            // Partition the array and get the pivot index
            int pivot = partition(A, start, end);
            // Quicksort the left partition and right partition in place
            quickSort(A, start, pivot - 1);
            quickSort(A, pivot + 1, end);
        }
    }

    public int[] sort(int[] A) {
        int[] B = new int[A.length];
        System.arraycopy(A, 0, B, 0, A.length);

        quickSort(B, 0, B.length - 1);
        return B;
    }
}
