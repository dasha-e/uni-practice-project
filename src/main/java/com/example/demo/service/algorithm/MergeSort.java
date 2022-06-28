package com.example.demo.service.algorithm;

import java.util.Arrays;

public class MergeSort {
    private void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        // dividing the array in half
        int[] l = Arrays.copyOfRange(arr, 0, mid);
        int[] r = Arrays.copyOfRange(arr, mid, arr.length);
        // recursively sorting halves
        mergeSort(l);
        mergeSort(r);
        // merge halves in one array
        merge(arr, l, r);
    }

    private void merge(int[] arr, int[] l, int[] r) {
        int i = 0, j = 0, k = 0;
        while (i < l.length && j < r.length) {
            // take the least element from two arrays and put it output array
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        //if one of the input arrays is not empty, merge the rest into the output array
        while (i < l.length) {
            arr[k++] = l[i++];
        }
        while (j < r.length) {
            arr[k++] = r[j++];
        }
    }

    public String sort(int[] arr) {
        mergeSort(arr);
        return Arrays.toString(arr);
    }
}
