class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        
        Queue<Pair> queue = new LinkedList<>();
        // add the first row and last row
        for(int i=0; i<m; i++){
            if(board[0][i] == 'O'){
                dfs(0, i, n, m, board, visited);
            }
            
            if(board[n-1][i] == 'O'){
                dfs(n-1, i, n, m, board, visited);
            }
        }
        
        // add the first column and last column
        for(int i=0; i<n; i++){
            if(board[i][0] == 'O'){
                dfs(i, 0, n, m, board, visited);
            }
            
            if(board[i][m-1] == 'O'){
                dfs(i, m-1, n, m, board, visited);
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    private void dfs(int row, int col, int n, int m, char[][] board, int[][] visited){
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, -1, 0, 1};
        
        visited[row][col] = 1;
        for(int i=0; i<4; i++){
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            
            if(nextRow >=0 && nextRow < n 
               && nextCol >= 0 && nextCol < m 
               && board[nextRow][nextCol] == 'O'
               && visited[nextRow][nextCol] == 0){
                dfs(nextRow, nextCol, n, m, board, visited);
            }
        }
        
    }
}

class Pair{
    int row;
    int col; 
    
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}