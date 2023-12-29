class Solution {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        
        int n = graph.length;
        boolean[] visited = new boolean[n];
        
        
        
        for(int j=0; j<n; j++){
             if(visited[j] == false){
                 Node source = new Node(j, "A");
                 setA.add(j);
                 queue.offer(source);
                 visited[j] = true;
                 
                 while(!queue.isEmpty()){
                    Node node = queue.poll();
                    int vertex = node.vertex;
                    String sourceSet = node.set;

                    for(int i=0; i<graph[vertex].length; i++){
                        int u = graph[vertex][i];
                        if(visited[u] == false){
                            // not visited
                            if(sourceSet.equals("A")){
                                setB.add(graph[vertex][i]);
                                queue.offer(new Node(graph[vertex][i], "B"));
                            }else{
                                setA.add(graph[vertex][i]);
                                queue.offer(new Node(graph[vertex][i], "A"));
                            }

                            visited[u] = true;

                        }else{
                            // visited
                            if(sourceSet.equals("A") && setA.contains(graph[vertex][i])){
                                return false;
                            }
                            if(sourceSet.equals("B") && setB.contains(graph[vertex][i]))
                                return false;
                        }
                    }
                }
             }
        }
        
        
        return true;
        
    }
}

class Node{
    int vertex;
    String set;
    
    Node(int vertex, String set){
        this.vertex = vertex;
        this.set = set;
    }
}