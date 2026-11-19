class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean [][] vis = new boolean[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        int island = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(vis[i][j] == false){
                    if(grid[i][j] == '1'){
                        BFS(i, j, grid, vis, m, n, dr, dc);
                        island++ ;
                    }
                }
            }
        }
            return island;
     }
        public void BFS(int row, int col, int[][] grid, boolean[][] vis, int m, int n, int[] dr, int[] dc){
            Queue<int[]> Q = new LinkedList<>();
            Q.offer(new int[] {row, col});
            vis[row][col] = true;
            while(!Q.isEmpty()){
                int [] curr = Q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int i = 0; i < 4; i++){
                    int newRow = r + dr[i];
                    int newCol = c + dc[i];
                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == '1' && vis[newRow][newCol] == false){
                        Q.offer(new int[]{newRow, newCol});
                        vis[newRow][newCol] = true;
                    } 
                }
            }
     }  
}
