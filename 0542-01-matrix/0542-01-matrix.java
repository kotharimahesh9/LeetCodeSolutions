class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] ans = new int[n][m];
        for(int[] x : ans)
            Arrays.fill(x, -1);
        
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    queue.offer(new Pair(i, j, 0));
                    ans[i][j] = 0;
                }
            }
        }
        
        
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, -1, 0, 1};
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            int dist = p.dist;
            
            for(int i=0; i<4; i++){
                int nextRow = row + dRow[i];
                int nextCol = col + dCol[i];
                
                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && ans[nextRow][nextCol] == -1){
                    ans[nextRow][nextCol] = 1 + dist;
                    queue.offer(new Pair(nextRow, nextCol, 1 + dist));
                }
            }
        }
        
        return ans;
        
    }
}

class Pair{
    int row;
    int col;
    int dist;
    
    public Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}