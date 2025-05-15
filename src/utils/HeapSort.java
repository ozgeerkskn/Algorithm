package utils;

//Utility class that implements the Heap Sort algorithm.
 
 

public class HeapSort {
	
    public static void heapSort(int[] array) {
        int n = array.length;

     // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

     // One by one extract elements from heap
        for (int i = n - 1; i > 0; i--) {
        	// Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

      
            heapify(array, i, 0);
        }
    }

   
    private static void heapify(int[] array, int n, int i) {
        int largest = i;      // root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2;// right child

    
        if (left < n && array[left] > array[largest])
            largest = left;

    
        if (right < n && array[right] > array[largest])
            largest = right;

       
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            
         // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }
}

