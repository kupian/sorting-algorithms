package com.streaming;

import java.util.Arrays;

import com.algorithms.Quicksort;

public class ViewCounter {

    public int[] getTopViews(int k, int[] views) {
        Quicksort quicksort = new Quicksort();
        int[] topViews = new int[k];
        for (int x : views) {
            if (x > topViews[0]) {
                topViews[0] = x;
                quicksort.sort(topViews);
            }
        }
        return topViews;
    }

    public static void main(String[] args) {
        ViewCounter viewCounter = new ViewCounter();
        int[] views = {12, 43, 22, 56, 78, 1, 2, 3, 4, 5, 6, 99, 134, 65};
        int[] topViews = viewCounter.getTopViews(3, views);
        System.out.println("Top views: " + Arrays.toString(topViews));
    }
}
