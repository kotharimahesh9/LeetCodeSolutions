class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }
        
        int cnt = 0;
        for (Map.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
            if (ds.unionFind(it.getKey()) == it.getKey()) {
                cnt++;
            }
        }
        return n - cnt;       
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