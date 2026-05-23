class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
        }
        if(q.size() == 0) return;

        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};

        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for(int[] dir: dirs){
                int r = row + dir[0];
                int c = col + dir[1];

                if(r >= n || c >= m || r < 0 || c < 0 || grid[r][c] != Integer.MAX_VALUE){
                    continue;
                }
                // INF  INF  INF
                // INF   0   INF
                // INF  INF  INF
                // q = [ [0,1], [2,1], [1,0], [1,2] ]

                // INF   1   INF
                // 1    0    1
                // INF   1   INF
                q.add(new int[]{r,c});

                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}