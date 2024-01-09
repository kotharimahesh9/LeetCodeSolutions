class Solution {
    
    private static int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> answer = new ArrayList<>();
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        // create an adjacency list
        for(int i=0; i < connections.size(); i++){
            int source = connections.get(i).get(0);
            int target = connections.get(i).get(1);
            adj.get(source).add(target);
            adj.get(target).add(source);
        }
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] vis = new int[n];
           
        dfs(0, -1, adj, vis, tin, low, answer);
        return answer;
        
    }
    
    private void dfs(int source, int parent, List<List<Integer>> adj, int[] vis, int[] tin, int[] low, List<List<Integer>> answer){
        
        vis[source] = 1;
        tin[source] = timer;
        low[source] = timer;
        timer++;
        
        for(int v : adj.get(source)){
            if(v == parent)
                continue;
            if(vis[v] == 0){
                // unvisited , do DFS
                dfs(v, source, adj, vis, tin, low, answer);
                low[source] = Math.min(low[source], low[v]);
                
                if(low[v] > tin[source]){
                    answer.add(new ArrayList<>(Arrays.asList(source, v)));
                }
                
            }else{
                // visited
                low[source] = Math.min(low[source], low[v]);
                
            }
        }
    }
}