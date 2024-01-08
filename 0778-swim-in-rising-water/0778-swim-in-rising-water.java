class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
        pq.offer(new Pair(0, 0, grid[0][0]));
        
        boolean[][] visited = new boolean[n][n];
        
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, -1, 0, 1};
        int maxTime = grid[0][0];
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int row = p.row;
            int col = p.col;
            int time = p.time;
            
            if(row == n-1 && col == n-1)
                return time;
                        
            for(int i=0; i<4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && visited[nRow][nCol] == false){
                    visited[nRow][nCol] = true;
                    maxTime = Math.max(grid[nRow][nCol], time);
                    pq.offer(new Pair(nRow, nCol, maxTime));
                }
                
            }
        }
        
        return 0;
        
    }
}

class Pair {
    int row;
    int col;
    int time;
    
    public Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}