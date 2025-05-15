package utils;


import utils.MergeSort;
import utils.HeapSort;
import utils.QuickSort;
import utils.SelectionSort;
import utils.BinarySearch;
import utils.ExponentialSearch;

public class SortBenchmark {
	
	 /**
     * Calculates the average execution time of Merge Sort over a number of repetitions.
     */
    public static double avgMergeSortTime(int[] array, int reps) {
        long total = 0;
        for (int i = 0; i < reps; i++) {
            int[] copy = array.clone();
            long start = System.nanoTime();
            MergeSort.mergeSort(copy);
            long end = System.nanoTime();
            total += (end - start);
        }
        return (total / (double) reps) / 1e6; // ms
    }

    /**
     * Calculates the average execution time of Heap Sort over a number of repetitions.
     */
    public static double avgHeapSortTime(int[] array, int reps) {
        long total = 0;
        for (int i = 0; i < reps; i++) {
            int[] copy = array.clone();
            long start = System.nanoTime();
            HeapSort.heapSort(copy);
            long end = System.nanoTime();
            total += (end - start);
        }
        return (total / (double) reps) / 1e6; // ms
    }

    /**
     * Calculates the average execution time of Quick Sort over a number of repetitions.
     */
    public static double avgQuickSortTime(int[] array, int reps) {
        long total = 0;
        for (int i = 0; i < reps; i++) {
            int[] copy = array.clone();
            long start = System.nanoTime();
            QuickSort.quickSort(copy, 0, copy.length - 1);
            long end = System.nanoTime();
            total += (end - start);
        }
        return (total / (double) reps) / 1e6; // ms
    }

    /**
     * Calculates the average execution time of Selection Sort over a number of repetitions.
     */
    public static double avgSelectionSortTime(int[] array, int reps) {
        long total = 0;
        for (int i = 0; i < reps; i++) {
            int[] copy = array.clone();
            long start = System.nanoTime();
            SelectionSort.selectionSort(copy);
            long end = System.nanoTime();
            total += (end - start);
        }
        return (total / (double) reps) / 1e6; // ms
    }
    
	/**
	 * Calculates the average execution time of the Binary Search algorithm
	 * over a given number of repetitions (reps).
	 * 
	 * Prior to measurement, the method is run multiple times (JIT warm-up) to allow
	 * the Just-In-Time compiler to optimize the code and stabilize performance.
	 */
	
    public static double avgBinarySearchTime(int[] array, int reps) {
        for (int i = 0; i < 50; i++) { BinarySearch.binarySearch(array, -1); } // JIT warm-up
        long total = 0;
        for (int i = 0; i < reps; i++) {
            long start = System.nanoTime();
            BinarySearch.binarySearch(array, -1);
            long end = System.nanoTime();
            total += (end - start);
        }
        return (total / (double) reps) / 1e3; // µs
    }
    
    /**
     * Calculates the average execution time of the Exponential Search algorithm
     * over a given number of repetitions (reps).
     * 
     * Similar to Binary Search, the method is pre-executed to allow for JIT optimization
     * before actual timing begins.
     */
    
    public static double avgExponentialSearchTime(int[] array, int reps) {
        for (int i = 0; i < 50; i++) { ExponentialSearch.exponentialSearch(array, -1); }
        long total = 0;
        for (int i = 0; i < reps; i++) {
            long start = System.nanoTime();
            ExponentialSearch.exponentialSearch(array, -1);
            long end = System.nanoTime();
            total += (end - start);
        }
        return (total / (double) reps) / 1e3;
    }

}
