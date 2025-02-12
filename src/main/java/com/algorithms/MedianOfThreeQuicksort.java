package com.algorithms;

public class MedianOfThreeQuicksort extends Quicksort {

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    @Override
    protected int getPivot(int[] arr, int start, int end) {
        int mid = (start + end) / 2;

        if (arr[mid] < arr[start]) {
            swap(arr, start, mid);
        }
        if (arr[end] < arr[start]) {
            swap(arr, end, start);
        }
        if (arr[mid] < arr[end]) {
            swap(arr, mid, end);
        }
        return arr[end];
    }

    @Override
    public String toString() {
        return "MedianOfThreeQuicksort";
    }
}
