class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, -1, 0, 1};
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                if(grid[i][j] == 1){
                    // connect the existing islands
                    // see for all 4 directions
                    int row = i;
                    int col = j;
                    int cell = n * i + j;
                    
                    for(int k=0; k<4; k++){
                        int nextRow = row + dRow[k];
                        int nextCol = col + dCol[k];
                        
                        if(isValid(nextRow, nextCol, n) && grid[nextRow][nextCol] != 0){
                            int adjCell = n * nextRow + nextCol;
                            if(ds.unionFind(cell) != ds.unionFind(adjCell)){
                                ds.unionBySize(cell, adjCell);
                            }
                        }
                    }   
                }
            }
        }
        
        // Now all the connected islands are together.
        
        int maxSize = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Set<Integer> parentSet = new HashSet<>();

                if(grid[i][j] == 0){
                    int row = i;
                    int col = j;
                    
                    for(int k=0; k<4; k++){
                        int nextRow = row + dRow[k];
                        int nextCol = col + dCol[k];
                        
                        if(isValid(nextRow, nextCol, n) && grid[nextRow][nextCol] == 1){
                            int adjCell = n * nextRow + nextCol;
                            int adjParent = ds.unionFind(adjCell);
                            parentSet.add(adjParent);
                        }    
                    }
                }
                
                int size = 0;
                for(int p : parentSet){
                    size = size + ds.size.get(p);
                }
                
                maxSize = Math.max(maxSize, size+1);
                
            }
        }
        
        for(int i=0; i<n*n; i++){
            maxSize = Math.max(maxSize, ds.size.get(ds.unionFind(i)));
        }
        
        return maxSize;
    } 
    
    
    private boolean isValid(int row, int col, int n){
        if(row >= 0 && row < n && col >= 0 && col < n)
            return true;
        return false;
    }
}

class DisjointSet {
    List<Integer> parent;
    List<Integer> size;
    
    public DisjointSet(int n){
        parent = new ArrayList<>();
        size = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    public int unionFind(int n){
        if(n == parent.get(n))
            return n;
        
        int p = unionFind(parent.get(n));
        parent.set(n, p);
        return p;
    }
    
    public void unionBySize(int u, int v){
        int parentU = unionFind(u);
        int parentV = unionFind(v);
        
        if(parentU == parentV)
            return;
        
        int sizeParentU = size.get(parentU);
        int sizeParentV = size.get(parentV);
        
        if(sizeParentU < sizeParentV){
            parent.set(parentU, parentV);
            size.set(parentV, sizeParentU + sizeParentV);
        }else{
            parent.set(parentV, parentU);
            size.set(parentU, sizeParentU + sizeParentV);
        }
    }
}