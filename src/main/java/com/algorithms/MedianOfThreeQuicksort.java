package com.algorithms;

public class MedianOfThreeQuicksort extends Quicksort {

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    @Override
    protected int getPivot(int[] A, int start, int end) {
        int mid = (start + end) / 2;

        if (A[mid] < A[start]) {
            swap(A, start, mid);
        }
        if (A[end] < A[start]) {
            swap(A, end, start);
        }
        if (A[mid] < A[end]) {
            swap(A, mid, end);
        }
        return A[end];
    }

    @Override
    public String toString() {
        return "MedianOfThreeQuicksort";
    }
}
