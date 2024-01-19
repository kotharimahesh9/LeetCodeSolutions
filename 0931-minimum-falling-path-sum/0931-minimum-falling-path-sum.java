class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n+1][n+1];

        int min = (int)1e9;
        for(int i=n-1; i>=0; i--){
            for(int row = n-1; row >=0 ; row--){
                for(int col = i; col >= 0; col--){
                    int currentCost = matrix[row][col];
        
                    // go diagonally left
                    int left = (int)1e9;
                    if(col >= 1)
                        left = dp[row + 1][col - 1];

                    // go diagonally right
                    int right = (int)1e9;
                    if(col + 1 < n)
                        right = dp[row + 1][col + 1];

                    // go down
                    int down = dp[row + 1][col];

                    dp[row][col] = Math.min(left, Math.min(right, down)) + currentCost;
                }
            }
            min = Math.min(min, dp[0][i]);
        }
        
        return min;
    }
    
//     private int f(int[][] matrix, int row, int col, int n, int[][] dp){
        
//         if(row == n)
//             return 0;
        
//         if(dp[row][col] != -1)
//             return dp[row][col];
        
//         int currentCost = matrix[row][col];
        
//         // go diagonally left
//         int left = (int)1e9;
//         if(col >= 1)
//             left = f(matrix, row + 1, col - 1, n, dp);
        
//         // go diagonally right
//         int right = (int)1e9;
//         if(col + 1 < n)
//             right = f(matrix, row + 1, col + 1, n, dp);
        
//         // go down
    
//         int down = f(matrix, row + 1, col, n, dp);
        
//         return dp[row][col] = Math.min(left, Math.min(right, down)) + currentCost; 
//     }
}