package MidtermProject.Maze;

import java.util.PriorityQueue;

public class MazeSolver {
    // Direction vectors
    private static final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // Initialize the priority queue with a comparator defined in the Point class
        PriorityQueue<Point> pq = new PriorityQueue<>(Point.comp);
        pq.offer(new Point(start[0], start[1], 0));

        // Distance array to keep track of the shortest distance for each cell
        int[][] distance = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                distance[i][j] = Integer.MAX_VALUE; // Set all distances to infinity
            }
        }
        distance[start[0]][start[1]] = 0; // Distance from the start to the start is 0

        // Dijkstra's algorithm using a priority queue
        while (!pq.isEmpty()) {
            Point p = pq.poll(); // Get the next most promising point

            // Check if we've reached the destination
            if (p.x == destination[0] && p.y == destination[1]) {
                return p.dist; // Shortest distance to the destination
            }

            // Explore all possible directions
            for (int[] dir : dirs) {
                int x = p.x;
                int y = p.y;
                int dist = p.dist;

                // Move in the direction until we hit a wall
                while (canRoll(maze, x + dir[0], y + dir[1])) {
                    x += dir[0];
                    y += dir[1];
                    dist++; // Increment the distance for each empty space traversed
                }

                // Check if this is the shortest path to (x, y) so far
                if (dist < distance[x][y]) {
                    distance[x][y] = dist;
                    pq.offer(new Point(x, y, dist)); // Add the new point with updated distance to the queue
                }
            }
        }

        // The destination cannot be reached
        return -1;
    }

    // Helper method to check if the ball can roll to a cell (x, y)
    private boolean canRoll(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }

}
       

