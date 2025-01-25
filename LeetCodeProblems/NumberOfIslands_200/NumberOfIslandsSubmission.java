package LeetCodeProblems.NumberOfIslands_200;

public class NumberOfIslandsSubmission {

    //Islands are made up of chars not ints!

    public static int numIslands(char[][] grid) {
        int numIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if (grid[i][j] == '1') {
                    dfs(i,j,grid);
                    numIslands++;
                }
            }
        }

        resetGrid(grid);

        return numIslands;
    }

    private static void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return; // Stop exploring
        }

        grid[i][j] = 'X'; // Mark this cell as visited

        // Explore in all four directions
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }

    private static void resetGrid(char[][] grid) {
        // Reset all marked indices from 'X' back to '1'
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'X') {
                    grid[i][j] = '1';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }


}
