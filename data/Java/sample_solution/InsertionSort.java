package de.hso.aud.ex04_02;

import de.hso.aud.sorting.SortingAlgorithm;
import de.hso.aud.sorting.Utils;

public class InsertionSort implements SortingAlgorithm {

    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                Utils.swap(arr, j - 1, j);
                j--;
            }
        }
    }
}
