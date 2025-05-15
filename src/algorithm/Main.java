package algorithm;

import java.util.Scanner;
import utils.RandomArray;
import utils.SortBenchmark;

public class Main {
	


 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        int index = 0;

        System.out.print("How many different N values ​​will you enter? (For example: 4): ");
        int totalInputs = input.nextInt();
      

        while (index < totalInputs) {
            System.out.print("How many elements would you like to create an array with? (Type 0 to exit):");
            n = input.nextInt();

            if (n == 0) {
                System.out.println("Program has been terminated.");
                break;
            }

          
            int[] originalArray = RandomArray.generateRandomArray(n);
            System.out.println("Random array has been created.");
            

            int reps = 10; // Number of repetitions for averaging

            double mergeTime = SortBenchmark.avgMergeSortTime(originalArray, reps);
            double heapTime = SortBenchmark.avgHeapSortTime(originalArray, reps);
            double quickTime = SortBenchmark.avgQuickSortTime(originalArray, reps);
            double selectionTime = SortBenchmark.avgSelectionSortTime(originalArray, reps);

            System.out.println("-----------------------------------------");
            System.out.printf("Merge Sort Time: %.2f ms%n", mergeTime);
            System.out.println("-----------------------------------------");
            System.out.printf("Heap Sort Time: %.2f ms%n", heapTime);
            System.out.println("-----------------------------------------");
            System.out.printf("Quick Sort Time: %.2f ms%n", quickTime);
            System.out.println("-----------------------------------------");
            System.out.printf("Selection Sort Time: %.2f ms%n", selectionTime);
                
            
           
            int[] sortedArray = originalArray.clone();
            SortBenchmark.avgMergeSortTime(sortedArray, 1); // sort once before search

            double binaryAvg = SortBenchmark.avgBinarySearchTime(sortedArray, reps);
            double exponentialAvg = SortBenchmark.avgExponentialSearchTime(sortedArray, reps);

            System.out.println("-----------------------------------------");
            System.out.printf("Binary Search Time: %.2f µs%n", binaryAvg);
            System.out.println("-----------------------------------------");
            System.out.printf("Exponential Search Time: %.2f µs%n", exponentialAvg);
            System.out.println("-----------------------------------------");

            index++;
        }

        input.close();

       
    }
}
