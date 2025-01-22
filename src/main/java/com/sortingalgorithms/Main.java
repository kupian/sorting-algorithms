package com.sortingalgorithms;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        boolean result = TestSortingAlgorithms.TestInsertionSort();
        System.out.println("Did Insertion Sort pass?\n" + result);
    }
}