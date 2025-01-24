package LeetCodeProblems.MaxAreaOfIsland_695;

public class MaxAreaOfIslandSubmission {

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int islandArea = dfs(i, j, grid);
                    maxArea = Math.max(maxArea, islandArea);  // Update the maximum area found
                }
            }
        }

        resetGrid(grid);

        return maxArea;
    }

    private static int dfs(int i, int j, int[][] grid) {
        // Check if the current cell is out of bounds or water
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        // Mark the current cell as visited (Avoid infinite loops)
        grid[i][j] = -1;

        // Initialize area to 1 for the current land cell
        int area = 1;

        // Explore all four directions
        area += dfs(i - 1, j, grid);
        area += dfs(i + 1, j, grid);
        area += dfs(i, j + 1, grid);
        area += dfs(i, j - 1, grid);

        return area; // Return all the areas added up
    }

    private static void resetGrid(int[][] grid) {
        // Reset all marked indices from -1 back to 1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) {
                    grid[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 0, 0, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 1, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        System.out.println(maxAreaOfIsland(grid1));
        System.out.println(grid1[0][0]);
    }
}
