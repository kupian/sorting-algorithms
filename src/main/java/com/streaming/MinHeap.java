package com.streaming;

public class MinHeap {
    private final int[] arr;
    private final int maxSize;
    private int heapSize;

    MinHeap(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        heapSize = 0;
    }

    // Correct ordering to preserve min-heap properties
    void minHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int min = i;
        if (left < heapSize && arr[left] < arr[i]) {
            min = left;
        }
        if (right < heapSize && arr[right] < arr[min]) {
            min = right;
        }
        if (min != i) {
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            minHeapify(min);
        }
    }

    // Remove the minimum element (root) and return it
    int popMin() {
        if (heapSize <= 0) {
            return -1;
        }
        if (heapSize == 1) {
            heapSize--;
            return arr[0];
        }

        int root = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;

        minHeapify(0);

        return root;
    }

    // Return the root without removing it
    int getMin() {
        return arr[0];
    }

    // Insert an element and correct ordering
    void insert(int x) {
        if (heapSize == maxSize) {
            System.out.println("Could not insertKey");
            return;
        }

        // Place x at the end
        heapSize++;
        int i = heapSize - 1;
        arr[i] = x;

        // Make swaps to maintain min-heap
        while (i != 0 && arr[parent(i)] > arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int leftChild(int i) {
        return 2 * i + 1;
    }

    int rightChild(int i) {
        return 2 * i + 2;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int[] getHeap() {
        return arr;
    }
}
