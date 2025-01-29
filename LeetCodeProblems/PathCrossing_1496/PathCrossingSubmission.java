package LeetCodeProblems.PathCrossing_1496;

import java.util.HashSet;
import java.util.Objects;

public class PathCrossingSubmission {

    public static boolean isPathCrossing(String path) {
        int[] coordinates = {0, 0}; // Start path at (0,0)

        char[] directions = path.toCharArray();

        HashSet<Coordinate> visitedCoordinates = new HashSet<>();

        visitedCoordinates.add(new Coordinate(0, 0)); // Store starting position

        for (char direction : directions) {
            updateCoordinate(coordinates, direction);
            Coordinate newCoordinate = new Coordinate(coordinates[0], coordinates[1]);

            // If we already visited this coordinate then a path crossing has occurred
            if (visitedCoordinates.contains(newCoordinate)) {
                return true;
            }

            visitedCoordinates.add(newCoordinate); // Mark coordinate as visited
        }

        return false; // Reach here only if path is fully completed and no crossing was detected
    }

    private static void updateCoordinate(int[] coordinates, char direction) {
        switch (direction) {
            case 'N': coordinates[1]++; break;
            case 'S': coordinates[1]--; break;
            case 'E': coordinates[0]++; break;
            case 'W': coordinates[0]--; break;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPathCrossing("NNNNNEE"));
    }
}


/**
 * A class representing a 2D coordinate (x, y).
 */
class Coordinate {
    int x, y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinate coordinate = (Coordinate) o;
        return x == coordinate.x && y == coordinate.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
