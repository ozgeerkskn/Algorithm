package utils;

// Utility class that implements the Binary Search algorithm.
 

public class BinarySearch {

    // Searches for the target value in the entire sorted array.
    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    //Overload method that searches for the target value in the specified range of the array. (Required for ExponentialSearch)
    public static int binarySearch(int[] array, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target)
                return mid;

            if (array[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
     // Target not found
        return -1;
    }
}
