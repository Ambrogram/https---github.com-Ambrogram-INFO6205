package Assignment4;

import java.util.*;

public class GraphPathChecker {
    // Method to determine if there is a valid path in the graph
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }

        // Building the adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // BFS initialization
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        Set<Integer> visited = new HashSet<>();
        visited.add(source);

        // BFS loop
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (neighbor == destination) {
                    return true;
                }
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }

    // Main method to run some examples
    public static void main(String[] args) {
        // Example 1
        int n1 = 3;
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
        int source1 = 0;
        int destination1 = 2;
        System.out.println("Example 1: " + validPath(n1, edges1, source1, destination1)); // Output: true

        // Example 2
        int n2 = 6;
        int[][] edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int source2 = 0;
        int destination2 = 5;
        System.out.println("Example 2: " + validPath(n2, edges2, source2, destination2)); // Output: false
    }
}
