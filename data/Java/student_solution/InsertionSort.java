package de.hso.aud.ex04_02;

import de.hso.aud.sorting.SortingAlgorithm;

public class InsertionSort implements SortingAlgorithm {

    public void sort(String[] arr) {
        public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallestIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallestIdx]) {
                    smallestIdx = j;
                }
            }

            if (i != smallestIdx) {
                Utils.swap(arr, i, smallestIdx);
            }
        }
    }
    }
}
