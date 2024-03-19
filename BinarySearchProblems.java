public class BinarySearchProblems {

    // Counts occurrences of a target value in a sorted array with duplicates
    public static int countOccurrences(int[] arr, int target) {
        // Calculate total occurrences by subtracting indices of first and last occurrence
        return findLastOccurrence(arr, target) - findFirstOccurrence(arr, target) + 1;
    }

    // Finds the first occurrence of the target in the array
    private static int findFirstOccurrence(int[] arr, int target) {
        int low = 0; // Start of the search range
        int high = arr.length - 1; // End of the search range
        int result = -1; // Default result if target is not found

        // Binary search loop
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate mid-point
            if (arr[mid] == target) { // Check if mid-point is the target
                result = mid; // Update result with the new found index
                high = mid - 1; // Narrow search to left half to find first occurrence
            } else if (arr[mid] < target) { // Target is in the right half
                low = mid + 1;
            } else { // Target is in the left half
                high = mid - 1;
            }
        }
        return result; // Return the index of first occurrence
    }

    // Finds the last occurrence of the target in the array
    private static int findLastOccurrence(int[] arr, int target) {
        int low = 0; // Start of the search range
        int high = arr.length - 1; // End of the search range
        int result = -1; // Default result if target is not found

        // Binary search loop
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate mid-point
            if (arr[mid] == target) { // Check if mid-point is the target
                result = mid; // Update result with the new found index
                low = mid + 1; // Narrow search to right half to find last occurrence
            } else if (arr[mid] < target) { // Target is in the right half
                low = mid + 1;
            } else { // Target is in the left half
                high = mid - 1;
            }
        }
        return result; // Return the index of last occurrence
    }

    // Finds an element's index in a rotated sorted array
    public static int findInRotatedArray(int[] arr, int target) {
        int low = 0; // Start of the search range
        int high = arr.length - 1; // End of the search range

        // Binary search loop adapted for rotated array
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate mid-point
            if (arr[mid] == target) { // Target found at mid
                return mid;
            }
            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                // Target is in the left sorted half
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1; // Target must be in the right half
                }
            // Right half is sorted
            } else {
                // Target is in the right sorted half
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1; // Target must be in the left half
                }
            }
        }
        return -1; // Target not found
    }

    // Main method to run example cases
    public static void main(String[] args) {
        // Example sorted array with duplicates
        int[] sortedArray = {2, 2, 3, 3, 4, 4, 4, 8, 8, 8, 8, 8, 9, 9, 10, 12, 15};
        // Example rotated sorted array without duplicates
        int[] rotatedArray = {6, 7, 8, 2, 3, 4, 5};

        // Demonstrate counting occurrences
        System.out.println("Target 4 = " + countOccurrences(sortedArray, 4) + " Occurrences");
        System.out.println("Target 2 = " + countOccurrences(sortedArray, 2) + " Occurrences");
        System.out.println("Target 5 = " + countOccurrences(sortedArray, 5) + " Occurrences");
        // Demonstrate finding index in a rotated array
        System.out.println("Target 8 = Index " + findInRotatedArray(rotatedArray, 8));
        System.out.println("Target 9 = Index " + findInRotatedArray(rotatedArray, 9));
    }
}
