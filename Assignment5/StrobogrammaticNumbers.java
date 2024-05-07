package Assignment5;

import java.util.*;

public class StrobogrammaticNumbers {

    
    public static List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    private static List<String> helper(int n, int m) {
        // Base case: if no digits left, return a list with an empty string
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        // Base case: if one digit left, return a list with all one-digit strobogrammatic numbers
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        
        // Recur for the list that is shorter by 2, to be filled in this call
        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<>();
        
        // Loop over each string from the recursive call and add valid strobogrammatic pairs around it
        for (String s : list) {
            if (n != m) {
                // Add 0s around the string only if it is not the outermost layer
                res.add("0" + s + "0");
            }
            // Add all possible pairs that form strobogrammatic numbers
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
            res.add("8" + s + "8");
        }
        
        return res;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Testing the method
        System.out.println("Strobogrammatic Numbers of Length 2: " + findStrobogrammatic(2));
        System.out.println("Strobogrammatic Numbers of Length 1: " + findStrobogrammatic(1));
    }
}


