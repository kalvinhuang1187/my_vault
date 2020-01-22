/*
289. Game of Life [array]
---
According to the Wikipedia's article: "The Game of Life, also known simply as Life,
is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using
the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.
The next state is created by applying the above rules simultaneously to every cell in the current state,
where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]


Follow up:

1. Could you solve it in-place? Remember that the board needs to be updated at the same time:
You cannot update some cells first and then use their updated values to update other cells.

2. In this question, we represent the board using a 2D array. In principle, the board is infinite,
which would cause problems when the active area encroaches the border of the array.
How would you address these problems?
*/

class Solution {
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1,1}, {-1, -1}, {-1, 1}, {1, -1}};
    private static final int ALIVE = 1;
    private static final int DEAD = 0;
    private static final int DEADTOALIVE = 2;
    private static final int ALIVETODEAD = 3;
    
    public void gameOfLife(int[][] board) {
        // iterate through every cell in this 2D array
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
            // keep track of the number of alive neighbors
                int liveNeighbors = 0;
                
                // for each cell, check all possible 8 directions and count the number of alive neighbors
                for (int[] direction : directions) {
                  liveNeighbors += isAlive(board, r + direction[0], c + direction[1]) ? 1 : 0;
                }
                
                // Case 4: Reproduction
                // in case current cell is dead but has 3 live neighbors
                if (board[r][c] == DEAD) {
                    if (liveNeighbors == 3) {
                        board[r][c] = DEADTOALIVE;
                    }
                } 
                // Case 3: Over-population
                // in case current cell is alive
                else {
                    // in case, only 2 or 3 neighbors are alive
                    if (liveNeighbors != 2 && liveNeighbors != 3) {
                        board[r][c] = ALIVETODEAD;
                    }
                }
            }
        }
        
        // converting 2s and 3s to binary 0s and 1s
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == DEADTOALIVE) {
                    board[r][c] = ALIVE;
                }
                else if (board[r][c] == ALIVETODEAD) {
                    board[r][c] = DEAD;
                }
            }
        }
    }
    
    private boolean isAlive(int[][] board, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length && (board[r][c] == ALIVE || board[r][c] == ALIVETODEAD);
    }   
}