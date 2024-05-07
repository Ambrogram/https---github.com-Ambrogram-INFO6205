package FinalProject;

public class CelebrityFinder {
    private int[][] graph;

    public CelebrityFinder(int[][] graph) {
        this.graph = graph;
    }

    // Simulation of the knows API
    // Returns true if person a knows person b, false otherwise.
    private boolean knows(int a, int b) {
        return graph[a][b] == 1;
    }

    // Main function to identify the celebrity
    public int findCelebrity(int n) {
        int candidate = 0; // Start with assuming person 0 is the celebrity

        // First pass to find the candidate
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) { // If candidate knows i, candidate cannot be the celebrity
                candidate = i; // Update the candidate because the current one knows someone
            }
        }

        // Second pass to verify the candidate
        for (int i = 0; i < n; i++) {
            // Check if everyone knows the candidate and the candidate knows nobody
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1; // Not a celebrity because either not everyone knows the candidate or the candidate knows someone
            }
        }

        return candidate; // Candidate is the celebrity
    }

    public static void main(String[] args) {
        // Example 1
        int[][] graph1 = {{1,1,0},{0,1,0},{1,1,1}};
        CelebrityFinder finder1 = new CelebrityFinder(graph1);
        System.out.println("Celebrity in Example 1: " + finder1.findCelebrity(3)); // Output: 1

        // Example 2
        int[][] graph2 = {{1,0,1},{1,1,0},{0,1,1}};
        CelebrityFinder finder2 = new CelebrityFinder(graph2);
        System.out.println("Celebrity in Example 2: " + finder2.findCelebrity(3)); // Output: -1
    }
}

