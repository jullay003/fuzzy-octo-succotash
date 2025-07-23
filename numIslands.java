// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

// Example 1:

// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1
// Example 2:

// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.

//

import java.util.LinkedList;
import java.util.Queue;

public class numIslands{
    public int numsIslands(char[][] grid){
        if(grid == null || grid.length == 0) return 0;

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i =0; i<rows; i++){
            for(int j =0; j<cols; j++){
                if(grid[i][j] == '1'){
                    numIslands++;
                    bfs(grid, i, j);
                }
            }
        }
        return numIslands;

    }

    private void bfs(char[][] grid, int i, int j){
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});

        grid[i][j] = '0';

        int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0]; 
            int y = cell[1];

            for(int[] dir : directions){
                int newX = x + dir[0];
                int newY = y + dir[1];


                if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == '1'){
                    grid[newX][newY] = '0';
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }


    public static void main(String[] args){
        numIslands sol = new numIslands();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}

        };

        int count = sol.numsIslands(grid);
        System.out.println("Number of Islands: " + count);
    }


}