package com.recursivefunctions;

import com.sortingalgorithms.Quicksort;

public class Factorial {
    private static long fact(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    private static long factTR(int n, int a) {
        if (n <= 1) {
            return a;
        }

        return factTR(n - 1, n * a);
    }

    public static void main(String[] args) {
        System.out.println(factTR(5, 1));
    }

}
