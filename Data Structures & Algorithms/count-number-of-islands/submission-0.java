class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(grid,vis,i,j);
                    cnt++;
                }
            }
        } 
        return cnt;
    }
    public void dfs(char[][] grid,boolean[][] vis,int x,int y){
        if(x >= grid.length || x < 0 || y < 0 || y >= grid[0].length || grid[x][y] == '0'|| vis[x][y]){
            return;
        }

        vis[x][y] = true;
        int[] dirX = {-1,0,1,0};
        int[] dirY = {0,-1,0,1};
        for(int i=0;i<4;i++){
            dfs(grid,vis,x+dirX[i],y+dirY[i]);
        }
    }
}
