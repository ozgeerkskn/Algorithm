package utils;

import java.util.Random;

// Utility class for generating random integer arrays.

public class RandomArray {
    public static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(1_000_000); 
        }
        return array;
    }
}
