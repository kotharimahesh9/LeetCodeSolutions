class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++)
            adj.add(new ArrayList<>());
        
        for(int[] v : prerequisites){
            int course = v[0];
            int prereq = v[1];
            adj.get(prereq).add(course);
        }
        
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] ingress = new int[numCourses];
        
        for(int i = 0; i<numCourses; i++){
            for(int v : adj.get(i)){
                ingress[v]++;
            }
        }
        
        for(int i=0; i<numCourses; i++){
            if(ingress[i] == 0){
                queue.offer(i);
            }
        }
        
        if(queue.isEmpty())
            return false;
        
        while(!queue.isEmpty()){
            int v = queue.poll();
            answer.add(v);
            
            for(int u : adj.get(v)){
                ingress[u]--;
                if(ingress[u] == 0)
                    queue.offer(u);
            }
        }
        return answer.size() == numCourses;
    }
}