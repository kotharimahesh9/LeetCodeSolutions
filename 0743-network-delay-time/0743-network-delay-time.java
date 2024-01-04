class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] answer = new int[n+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[k] = 0;
        
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++)
            adj.add(new ArrayList<>());
        
        for(int i=0; i<times.length; i++){
            int source = times[i][0];
            int target = times[i][1];
            int time = times[i][2];
            adj.get(source).add(new Pair(target, time));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
        pq.offer(new Pair(k, 0));
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int v = p.vertex;
            int time = p.time;
        
            for(Pair u : adj.get(v)){
                int newTime = time + u.time;
                if(newTime < answer[u.vertex]){
                    answer[u.vertex] = newTime;
                    pq.offer(new Pair(u.vertex, newTime));
                }
            }
        }
        int max = -1;
        
        for(int i=1; i<=n; i++){
            max = Math.max(max, answer[i]);
        }
        
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}

class Pair{
    int vertex;
    int time;
    
    public Pair(int vertex, int time){
        this.vertex = vertex;
        this.time = time;
    }
}