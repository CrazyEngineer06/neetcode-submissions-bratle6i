class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i=0;i<n;i++){
            int p1 = 0,p2 = n-1;

            while(p1 < p2){
                int temp = matrix[i][p1];
                matrix[i][p1] = matrix[i][p2];
                matrix[i][p2] = temp;

                p1++;p2--;
            }
        }

        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                int temp = matrix[i][j];

                matrix[i][j] = matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1] = temp;
            }
        }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
}
