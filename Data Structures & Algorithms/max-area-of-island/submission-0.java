class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    int currArea = dfs(grid,i,j);
                    maxArea = Math.max(maxArea,currArea);
                }
            }
        }
        return maxArea;
    }
    public int dfs(int[][] grid,int x,int y){
        int n = grid.length;
        int m = grid[0].length;

        if(x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0) return 0;

        grid[x][y] = 0;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};

        int area = 1;
        for(int i=0;i<4;i++){
            area += dfs(grid,x+dx[i],y+dy[i]);
        }
        return area;
    }
}