//Walking Robot Simulation Description:
//https://leetcode.com/problems/walking-robot-simulation/description/?envType=daily-question&envId=2024-09-04
//My Walking Robot Simulation Solution
//https://leetcode.com/problems/walking-robot-simulation/solutions/5740952/874-walking-robot-simulation/

public class WalkingRobotSubmition {

    public static int robotSim(int[] commands, int[][] obstacles) {
        Direction currentDirection = Direction.NORTH;
        int[] coordinates = {0, 0};
        int maxEuclideanDistance = 0;

        for (int command : commands) {
            if (command == -2) {
                currentDirection = turn90DegLeft(currentDirection);
            } else if (command == -1) {
                currentDirection = turn90DegRight(currentDirection);
            } else {
                for (int i = 0; i < command; i++) { // Take steps forward
                    if (isObstacleInFront(currentDirection, coordinates, obstacles)) {
                        break; // Stop moving if there's an obstacle
                    }
                    // Move forward directly updates the coordinates array
                    moveForward(currentDirection, coordinates);
                    // Check to see if maxEuclideanDistance should be updated after each move
                    int currentDistanceSqrd = calcEuclideanDistanceSqrd(coordinates[0], coordinates[1]);
                    if (currentDistanceSqrd > maxEuclideanDistance) {
                        maxEuclideanDistance = currentDistanceSqrd;
                    }
                }
            }
        }
        return maxEuclideanDistance;
    }

    public enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST;
    }

    public static Direction turn90DegRight(Direction currentDirection) {
        return switch (currentDirection) {
            case NORTH -> Direction.EAST;
            case EAST -> Direction.SOUTH;
            case SOUTH -> Direction.WEST;
            case WEST -> Direction.NORTH;
        };
    }

    public static Direction turn90DegLeft(Direction currentDirection) {
        return switch (currentDirection) {
            case NORTH -> Direction.WEST;
            case EAST -> Direction.NORTH;
            case SOUTH -> Direction.EAST;
            case WEST -> Direction.SOUTH;
        };
    }

    public static int calcEuclideanDistanceSqrd(int xCoordinate, int yCoordinate) {
        return (xCoordinate * xCoordinate) + (yCoordinate * yCoordinate);
    }

    public static void moveForward(Direction currentDirection, int[] coordinates) {
        switch (currentDirection) {
            case NORTH:
                coordinates[1] += 1;
                break;
            case EAST:
                coordinates[0] += 1;
                break;
            case SOUTH:
                coordinates[1] -= 1;
                break;
            case WEST:
                coordinates[0] -= 1;
                break;
        }
    }

    public static boolean isObstacleInFront(Direction direction, int[] coordinates, int[][] obstacles) {
        // Create a temporary copy of the coordinates so original array is not changed
        int[] nextCoordinate = coordinates.clone();

        // Check the coordinate 1 step in front of the robot
        moveForward(direction, nextCoordinate);

        // Loop through 2D array of obstacles
        for (int[] obstacle : obstacles) {
            // Check if both x and y coordinates match
            if (obstacle[0] == nextCoordinate[0] && obstacle[1] == nextCoordinate[1]) {
                return true;  // Obstacle found
            }
        }
        return false;  // No obstacle found
    }

    public static void main(String[] args) {

        //Testing code. Euclidean distance should be 65
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};

        System.out.println(robotSim(commands, obstacles));

    }
}
