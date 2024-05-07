package FinalProject;

import java.util.*;

public class WordDistance {
    private Map<String, List<Integer>> map;

    // Constructor to initialize the word dictionary and prepare for queries
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        // Populate the map with words and their positions for quick lookup
        for (int i = 0; i < wordsDict.length; i++) {
            map.putIfAbsent(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }
    }

    // Method to find the shortest distance between two words in the dictionary
    public int shortest(String word1, String word2) {
        List<Integer> loc1 = map.get(word1);
        List<Integer> loc2 = map.get(word2);
        int l1 = 0, l2 = 0, minDist = Integer.MAX_VALUE;

        // Iterate through both lists to find the minimum distance
        while (l1 < loc1.size() && l2 < loc2.size()) {
            int index1 = loc1.get(l1);
            int index2 = loc2.get(l2);
            if (index1 < index2) {
                minDist = Math.min(minDist, index2 - index1);
                l1++;
            } else {
                minDist = Math.min(minDist, index1 - index2);
                l2++;
            }
        }

        return minDist;
    }

    public static void main(String[] args) {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        WordDistance wordDistance = new WordDistance(wordsDict);
        // Example 1 testing
        System.out.println("Shortest distance between 'coding' and 'practice': " + wordDistance.shortest("coding", "practice")); // Output: 3
        System.out.println("Shortest distance between 'makes' and 'coding': " + wordDistance.shortest("makes", "coding")); // Output: 1
    }
}


