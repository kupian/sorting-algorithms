package com.streaming;

import java.util.Arrays;

import com.util.CreateArrayFromFile;

public class ViewCounter {

    public int[] getTopViews(int k, int[] views) {
        MinHeap heap = new MinHeap(k);
        // We iterate through all the views and compare each to the root of the heap
        for (int x : views) {
            // If the heap is not full, or x is greater than the root
            // x must be swapped into the heap
            if (heap.getHeapSize() < heap.getMaxSize()) {
                heap.insert(x);
            } else if (heap.getMin() < x) {
                heap.popMin();
                heap.insert(x);
            }
        }
        return heap.getHeap();
    }

    public static void main(String[] args) {
        ViewCounter viewCounter = new ViewCounter();
        int k = 100;

        int[] views = CreateArrayFromFile.CreateIntArrayFromFile("intBig.txt");

        long startTime = System.currentTimeMillis();
        int[] topViews = viewCounter.getTopViews(k, views);
        long endTime = System.currentTimeMillis();

        System.out.println("Top views: " + Arrays.toString(topViews));
        System.out.println("Runtime: " + (endTime - startTime));
    }
}
