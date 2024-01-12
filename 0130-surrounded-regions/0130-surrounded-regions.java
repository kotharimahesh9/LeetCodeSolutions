class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        
        Queue<Pair> queue = new LinkedList<>();
        // add the first row and last row
        for(int i=0; i<m; i++){
            if(board[0][i] == 'O'){
                queue.offer(new Pair(0, i));
                visited[0][i] = 1;
            }
            
            if(board[n-1][i] == 'O'){
                queue.offer(new Pair(n-1, i));
                visited[n-1][i] = 1;
            }
        }
        
        // add the first column and last column
        for(int i=0; i<n; i++){
            if(board[i][0] == 'O'){
                queue.offer(new Pair(i, 0));
                visited[i][0] = 1;
            }
            
            if(board[i][m-1] == 'O'){
                queue.offer(new Pair(i, m-1));
                visited[i][m-1] = 1;
            }
        }
        
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, -1, 0, 1};
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            
            for(int i=0; i<4; i++){
                int nextRow = row + dRow[i];
                int nextCol = col + dCol[i];
                
                if(nextRow < n && nextRow >= 0 
                   && nextCol < m && nextCol >= 0 
                   && visited[nextRow][nextCol] == 0
                   && board[nextRow][nextCol] == 'O'){
                    visited[nextRow][nextCol] = 1;
                    queue.offer(new Pair(nextRow, nextCol));
                }
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
}

class Pair{
    int row;
    int col; 
    
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}