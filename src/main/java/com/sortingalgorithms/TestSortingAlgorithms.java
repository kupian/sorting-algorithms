package com.sortingalgorithms;

/**
 * The TestSortingAlgorithms class provides methods to test the functionality
 * of various sorting algorithms, including the use of external files to generate
 * data for testing. It ensures that the sorted arrays adhere to the correct ordering.
 */
public class TestSortingAlgorithms {
    /**
     * Checks if the given integer array is sorted in ascending order.
     *
     * @param arr the array of integers to check
     * @return true if the array is sorted in ascending order, otherwise false
     */
    private static boolean TestIntArrayAscends(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the given integer array is sorted in descending order.
     *
     * @param arr the array of integers to check
     * @return true if the array is sorted in descending order, otherwise false
     */
    private static boolean TestIntArrayDescends(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Tests whether the specified sorting algorithm correctly sorts the given array
     * in ascending order by verifying its output.
     *
     * @param alg the sorting algorithm to test, implementing the SortingAlgorithm interface
     * @param arr the array of integers to be sorted and tested
     */
    public static void TestAlgorithm(SortingAlgorithm alg, int[] arr, boolean ascending) {
        System.out.print("Testing " + alg + "... ");
        boolean result = ascending ? TestIntArrayAscends(alg.sort(arr)) : TestIntArrayDescends(alg.sort(arr));
        System.out.println(result ? "Passed" : "Failed");
    }

    /**
     * Tests the functionality of multiple sorting algorithms by verifying their ability
     * to correctly sort a predefined dataset. This method uses a data file containing integers,
     * applies sorting algorithms to the data, and checks for correctness of the results.
     *
     */
    public static void TestAlgorithms(String filename) {
        int[] int1000 = CreateArrayFromFile.CreateIntArrayFromFile(filename);
        TestAlgorithm(new InsertionSort(), int1000, true);
        TestAlgorithm(new InsertionSortDescending(), int1000, false);
    }
}
