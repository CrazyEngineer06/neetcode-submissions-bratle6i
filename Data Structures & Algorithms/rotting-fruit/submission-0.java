class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int time = 0;
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }

        while(fresh > 0 && !q.isEmpty()){
            int length = q.size();
            
            for(int i=0;i<length;i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0 || grid[x][y] == 2){
                        continue;
                    }

                    grid[x][y] = 2;
                    fresh--;
                    q.add(new int[]{x,y});
                }
            }
            time++;
        }
        return fresh == 0 ? time:-1;
    }
}
