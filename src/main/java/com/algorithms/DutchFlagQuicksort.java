package com.algorithms;

public class DutchFlagQuicksort extends Quicksort {

    private void partition(int[] A, int left, int right, int[] ij) {
        if (right - left <= 1) {
            if (A[right] < A[left]) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
            ij[0] = left;
            ij[1] = right;
            return;
        }

        int mid = left;
        int pivot = getPivot(A, left, right);

        while (mid <= right) {
            if (A[mid] < pivot) {
                int temp = A[mid];
                A[mid] = A[left];
                A[left] = temp;
                mid++;
                left++;
            } else if (A[mid] == pivot) {
                mid++;
            } else if (A[mid] > pivot) {
                int temp = A[right];
                A[right] = A[mid];
                A[mid] = temp;
                right--;
            }
        }

        ij[0] = left - 1;
        ij[1] = mid;
    }

    @Override
    public void quickSort(int[] A, int left, int right) {
        if (left >= right) {
            return;
        }

        int[] ij = new int[2];
        partition(A, left, right, ij);

        quickSort(A, left, ij[0]);
        quickSort(A, ij[1], right);
    }

    @Override
    public String toString() {
        return "DutchFlagQuicksort";
    }
}
