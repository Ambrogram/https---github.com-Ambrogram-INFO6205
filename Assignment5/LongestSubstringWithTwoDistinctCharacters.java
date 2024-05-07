package Assignment5;

import java.util.*;

public class LongestSubstringWithTwoDistinctCharacters {

    // Method to find the length of the longest substring with at most two distinct characters
    public static int longestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;
        
        // Sliding window approach
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), right); // Track the last index of each character
            
            // When there are more than 2 distinct characters in the map, shrink the window
            if (map.size() > 2) {
                int minIndex = Collections.min(map.values()); // Find the leftmost character to remove
                map.remove(s.charAt(minIndex)); // Remove the leftmost character
                left = minIndex + 1; // Move left pointer of the window
            }
            
            maxLen = Math.max(maxLen, right - left + 1); // Calculate the maximum length found
        }
        
        return maxLen;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Testing the method
        System.out.println("Longest Substring with Two Distinct Characters: " + longestSubstringTwoDistinct("eceba"));  // Output: 3
        System.out.println("Longest Substring with Two Distinct Characters: " + longestSubstringTwoDistinct("ccaabbb"));  // Output: 5
    }
}
