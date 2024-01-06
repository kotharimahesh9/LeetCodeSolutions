class DisjointSet{
    private List<Integer> size;
    private List<Integer> parent;

    public DisjointSet(int n){
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i=0; i<=n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node))
            return node;

        int p = findParent(parent.get(node));
        parent.set(node, p);
        return parent.get(node);
    }
    
    public void unionBySize(int node1, int node2){
        int parentNode1 = findParent(node1);
        int parentNode2 = findParent(node2);

        if(parentNode1 == parentNode2){
            return;
        }
        int sizeParentNode1 = size.get(parentNode1);
        int sizeParentNode2 = size.get(parentNode2);

        if(sizeParentNode1 < sizeParentNode2){
            // parent 1 connects to parent 2
            parent.set(parentNode1, parentNode2);
            size.set(parentNode2, sizeParentNode1 + sizeParentNode2);
        }else{
            // parent 2 connects to parent 1 and rank of parent1 increases by one
            parent.set(parentNode2, parentNode1);
            size.set(parentNode1, sizeParentNode1 + sizeParentNode2);
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1)
            return -1;
        int edges = connections.length;
        DisjointSet ds = new DisjointSet(n);
        int redundantWires = 0;
        
        for(int i=0; i<connections.length; i++){
            int source = connections[i][0];
            int target = connections[i][1];
            if(ds.findParent(source) != ds.findParent(target)){
                ds.unionBySize(source, target);
            }else{
                redundantWires++;
            }
        }
        
        int disconnectedComponents = 0;
        for(int i=0; i<n; i++){
            if(ds.findParent(i) == i){
                disconnectedComponents++;
            }
        }
        int ans = disconnectedComponents -1;
        if(ans > redundantWires)
            return -1;
        return ans;
        
    }
}