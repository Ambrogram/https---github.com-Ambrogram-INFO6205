package Assignment4;

import java.util.*;

public class DirectedGraphPathChecker {
    
    // Method to build an adjacency list from the given edges of the graph
    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>()); // Ensure the node exists in the map as a key
            graph.get(edge[0]).add(edge[1]);              // Add the destination node to the adjacency list of the source node
        }
        return graph;
    }
    
    // Public method that determines if all paths from source lead to destination
    public boolean allPathsLeadToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = buildGraph(edges); // Build the graph using the adjacency list
        Set<Integer> visited = new HashSet<>(); // Track visited nodes to avoid reprocessing
        Set<Integer> stack = new HashSet<>();   // Track nodes in the current recursion stack to detect cycles
        
        return dfs(graph, source, destination, visited, stack); // Start DFS from the source node
    }

    // Helper method for DFS that returns true if all paths from current to destination are valid
    private boolean dfs(Map<Integer, List<Integer>> graph, int current, int destination, Set<Integer> visited, Set<Integer> stack) {
        if (!graph.containsKey(current)) { // Check if the current node has no outgoing edges
            return current == destination; // If no outgoing edges, it must be the destination to return true
        }
        if (stack.contains(current)) { // Check for cycles that do not involve the destination
            return false; // If a cycle is found that doesn't reach the destination, return false
        }
        if (visited.contains(current)) { // If already visited, no need to process again
            return true;
        }

        visited.add(current); // Mark this node as visited
        stack.add(current);   // Add current node to stack to track recursion path

        // Recursively visit all neighbors
        for (int neighbor : graph.get(current)) {
            if (!dfs(graph, neighbor, destination, visited, stack)) { // If any path is invalid, return false
                return false;
            }
        }

        stack.remove(current); // Remove current node from stack after processing all neighbors
        return true; // If all paths from current node lead to destination, return true
    }

    // Main method to run some examples
    public static void main(String[] args) {
        DirectedGraphPathChecker checker = new DirectedGraphPathChecker();

        // Example 1
        System.out.println("Example 1: " +
            checker.allPathsLeadToDestination(3, new int[][] {{0,1}, {0,2}}, 0, 2));  // Output: False

        // Example 2
        System.out.println("Example 2: " +
            checker.allPathsLeadToDestination(4, new int[][] {{0,1}, {0,3}, {1,2}, {2,1}}, 0, 3));  // Output: False

        // Example 3
        System.out.println("Example 3: " +
            checker.allPathsLeadToDestination(4, new int[][] {{0,1}, {0,2}, {1,3}, {2,3}}, 0, 3));  // Output: True
    }
}

