package com.algorithms;

public class HybridQuicksort extends Quicksort {
    @Override
    public void quickSort(int[] A, int left, int right) {
        SortingAlgorithm insertion = new InsertionSort();
        while (left < right) {

            // Use insertion sort for small arrays
            if (right - left < 10) {
                insertion.sort(A);
                break;
            } else {
                int pivot = partition(A, left, right);

                if (pivot - left < pivot - right) {
                    quickSort(A, left, pivot - 1);
                    left = pivot + 1;
                } else {
                    quickSort(A, pivot + 1, right);
                    right = pivot - 1;
                }
            }
        }
    }
}
