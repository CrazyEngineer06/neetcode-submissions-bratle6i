class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == 0){
                    setRowColZero(matrix,i,j);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public void setRowColZero(int [][]matrix,int row,int col){
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0;i<m;i++){
            if(matrix[row][i] != 0){
                matrix[row][i] = -1;
            }
            
        }

        for(int j=0;j<n;j++){
            if(matrix[j][col] != 0){
                matrix[j][col] = -1;
            }
            
        }
    }
}
