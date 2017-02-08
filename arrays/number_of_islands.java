/*
200. Number of Islands
---
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is
surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

---
Example 1:

11110
11010
11000
00000
Answer: 1

---
Example 2:

11000
11000
00100
00011
Answer: 3

 */

public class number_of_island {
  static int[][] g;
  
    public static int numIslands(int[][] grid) {
        int islands = 0;
        g = grid;
        for (int i = 0; i < g.length; i++)
            for (int j = 0; j < g[i].length; j++)
                islands += sink(i, j);
        return islands;
    }
    
    public static int sink(int i, int j) {
        if (i < 0 || i == g.length || j < 0 || j == g[i].length || g[i][j] == '0')
            return 0;
        g[i][j] = '0';
        sink(i+1, j); sink(i-1, j); sink(i, j+1); sink(i, j-1);
        return 1;
    }

    public static void main(String args[]) {
        int grid[][] = {{'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}};

        int grid2[][] = {{'1', '1', '0', '0', '0'},
                 {'1', '1', '0', '0', '0'},
                 {'0', '0', '1', '0', '0'},
                 {'0', '0', '0', '1', '1'}};

        System.out.println(numIslands(grid));
        System.out.println(numIslands(grid2));
    }
}

