class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        int[] safe = new int[n];
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                dfs(graph, i, visited, pathVisited, safe);
            }
        }
        
        for(int i=0; i<n; i++){
            if(safe[i] == 1)
                answer.add(i);
        }
        
        return answer;
    }
    
    private boolean dfs(int[][] graph, int v, int[] visited, int[] pathVisited, int[] safe){
        
        visited[v] = 1;
        pathVisited[v] = 1;
        safe[v] = 0;
        
        for(int u : graph[v]){
            if(visited[u] == 0){
                if(dfs(graph, u, visited, pathVisited, safe))
                    return true;
            }
            else if(pathVisited[u] == 1)
                return true;
        }
        
        pathVisited[v] = 0;
        safe[v] = 1;
        return false;
        
        
    }
}