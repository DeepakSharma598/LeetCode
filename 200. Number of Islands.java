class Solution {
    public int numIslands(char[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        int island = 0;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
               if(grid[i][j] == '1'){
                island++;
                dfs(i,j,grid);
               }
                }
            }
            return island;
        }
           void dfs(int row, int col, char[][] grid) {
        if (row < 0 || col < 0 || 
            row >= grid.length || col >= grid[0].length || 
            grid[row][col] == '0') return;

        grid[row][col] = '0';

        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
    }
}