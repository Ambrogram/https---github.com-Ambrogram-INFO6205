package Asssignment3;


public class SolutiontoProblem1 {

    // Problem 1: Checking if one can attend all meetings
    public boolean canAttendMeetings(int[][] intervals) {
        // Sort the intervals based on their start times
        quickSort(intervals, 0, intervals.length - 1);
        // Loop through the sorted intervals to check for overlaps
        for (int i = 0; i < intervals.length - 1; i++) {
            // If the current interval ends after the next one starts, return false
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        // If we find no overlaps, return true
        return true;
    }

    // Implements the quick sort algorithm
    private void quickSort(int[][] intervals, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(intervals, low, high);
            // Recursively sort the two subarrays
            quickSort(intervals, low, pivotIndex - 1);
            quickSort(intervals, pivotIndex + 1, high);
        }
    }

    // Partitions the array around a pivot and returns the pivot's index
    private int partition(int[][] intervals, int low, int high) {
        // Choose the last element as the pivot
        int[] pivot = intervals[high];
        int i = low - 1; // Index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (intervals[j][0] <= pivot[0]) {
                i++;
                // Swap intervals[i] and intervals[j]
                int[] temp = intervals[i];
                intervals[i] = intervals[j];
                intervals[j] = temp;
            }
        }
        // Swap intervals[i+1] and intervals[high] (or pivot)
        int[] temp = intervals[i + 1];
        intervals[i + 1] = intervals[high];
        intervals[high] = temp;

        return i + 1;
    }

    // Main method to run tests
    public static void main(String[] args) {
        SolutiontoProblem1 solution = new SolutiontoProblem1();

        // Test for Problem 1
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Can attend all meetings: " + solution.canAttendMeetings(meetings));
    }
}

