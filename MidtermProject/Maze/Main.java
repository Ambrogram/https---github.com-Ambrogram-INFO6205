package MidtermProject.Maze;

public class Main {
    public static void main(String[] args) {
        MazeSolver solver = new MazeSolver();

        // Example 1
        int[][] maze1 = {
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0}
        };
        int[] start1 = {0, 4};
        int[] destination1 = {4, 4};
        System.out.println("Example 1: " + solver.shortestDistance(maze1, start1, destination1)); // Expected: 12

        // Example 2
        int[][] maze2 = {
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0}
        };
        int[] start2 = {0, 4};
        int[] destination2 = {3, 2};
        System.out.println("Example 2: " + solver.shortestDistance(maze2, start2, destination2)); // Expected: -1

        // Example 3
        int[][] maze3 = {
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {0, 1, 0, 0, 0}
        };
        int[] start3 = {4, 3};
        int[] destination3 = {0, 1};
        System.out.println("Example 3: " + solver.shortestDistance(maze3, start3, destination3)); // Expected: -1
    }
}

