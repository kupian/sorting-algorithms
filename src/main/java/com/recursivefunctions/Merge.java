package com.recursivefunctions;

public class Merge {
    public static int[] merge(int[] a, int p, int q, int r) {
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

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        int[] c = merge(a, 0, 4, a.length - 1);
        for (int i : c) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
