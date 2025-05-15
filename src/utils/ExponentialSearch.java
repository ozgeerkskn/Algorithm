package utils;

// Utility class that implements the Exponential Search algorithm.


public class ExponentialSearch {

    public static int exponentialSearch(int[] array, int target) {
     
        if (array[0] == target)
            return 0;

        int i = 1;

     
        while (i < array.length && array[i] <= target) {
            i = i * 2;
        }

        //Perform binary search in the found range
        return BinarySearch.binarySearch(array, target, i / 2, Math.min(i, array.length - 1));
    }
}