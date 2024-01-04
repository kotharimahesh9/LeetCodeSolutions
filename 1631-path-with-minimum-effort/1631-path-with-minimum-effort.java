class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        int[][] efforts = new int[n][m];
        for(int i=0; i<n; i++)
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        queue.offer(new Pair(0, 0, 0));
        
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, -1, 0, 1};
        
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int effort = p.effort;
            int row = p.row;
            int col = p.col;
            
            for(int i=0; i<4; i++){
                int nextRow = row + dRow[i];
                int nextCol = col + dCol[i];
                
                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m){
                    
                    int maxDifference = Math.max(Math.abs(heights[row][col] - heights[nextRow][nextCol]), effort);
                    
                    if(maxDifference < efforts[nextRow][nextCol]){
                        efforts[nextRow][nextCol] = maxDifference;
                        queue.offer(new Pair(maxDifference, nextRow, nextCol));
                    }
                    
                }
            }
        }
        
        return efforts[n-1][m-1] == Integer.MAX_VALUE ? 0 : efforts[n-1][m-1];       
        
    }
}


class Pair{
    int effort;
    int row;
    int col;
    
    public Pair(int effort, int row, int col){
        this.effort = effort;
        this.row = row;
        this.col = col;
    }
}