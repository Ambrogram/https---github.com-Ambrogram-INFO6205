package Asssignment3;

public class SolutiontoProblem2 {

    // For keeping track of the result in Problem 2
    private long result = 0;
    private final long MODULO = 1000_000_007;

    // Problem 2: Count subarrays with more 1s than 0s
    public int subarraysWithMoreOnesThanZeros(int[] nums) {
        // Convert the array to prefix sums, changing 0s to -1
        int[] prefixSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (nums[i] == 0) ? -1 : nums[i];
            prefixSum[i] = (i == 0) ? nums[i] : prefixSum[i - 1] + nums[i];
            // Increment result if the current sum is positive
            if (prefixSum[i] > 0) result++;
        }

        // Use merge sort on the prefix sum array
        mergeSort(prefixSum, 0, nums.length - 1);
        return (int) (result % MODULO);
    }

    // Implements the merge sort algorithm
    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = left + (right - left) / 2;
            // Sort first and second halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    // Merges two subarrays of array[]
    private void merge(int[] array, int left, int middle, int right) {
        // Create temp arrays for left and right subarrays
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[middle + 1 + j];

        // Merge the temp arrays back into the original array
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i++];
            } else {
                result += (middle + 1) - (left + i);
                array[k] = R[j++];
            }
            k++;
        }

        // Copy remaining elements of L[] and R[]
        while (i < n1) array[k++] = L[i++];
        while (j < n2) array[k++] = R[j++];

    }

    // Main method to run tests
    public static void main(String[] args) {
        SolutiontoProblem2 solution = new SolutiontoProblem2();

        // Test for Problem 2
        int[] nums = {0, 1, 1, 0, 1};
        System.out.println("Subarrays with more ones than zeros: " + solution.subarraysWithMoreOnesThanZeros(nums));
    }
}
