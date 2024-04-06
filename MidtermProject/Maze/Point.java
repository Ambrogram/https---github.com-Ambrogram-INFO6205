package MidtermProject.Maze;

import java.util.Comparator;

public class Point {
    int x; // row index
    int y; // column index
    int dist; // distance from the start

    public Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    public static Comparator<Point> comp = new Comparator<Point>() {
        public int compare(Point p1, Point p2) {
            return p1.dist - p2.dist; // Ascending order of distance
        }
    };
}

