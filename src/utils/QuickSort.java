package utils;


/**
 * Utility class that implements the Quick Sort algorithm.
 * It works by selecting a 'pivot' element and partitioning the array around the pivot.
 */

public class QuickSort {
    //* Sorts the given array in ascending order using the Quick Sort algorithm.
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
        	// Find the pivot position and partition the array
            int pi = partition(array, low, high);

         // Recursively sort elements before and after the pivot
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; 
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                // swap
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Place pivot in the correct position
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}

