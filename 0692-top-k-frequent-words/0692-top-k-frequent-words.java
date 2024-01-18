class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Pair> map = new HashMap<>();
        
        for(String s: words){
            if(map.containsKey(s)){
                Pair p = map.get(s);
                p.frequency++;
                map.put(s, p);
            }else{
                map.put(s, new Pair(s, 1));
            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.frequency - a.frequency);
        for(String key : map.keySet()){
            pq.offer(map.get(key));
        }
        
        List<String> answer = new ArrayList<>();
        while(answer.size() < k){
            Pair p = pq.poll();
            String s = p.word;
            int freq = p.frequency;
            List<String> temp = new ArrayList<>();
            temp.add(s);
            while(!pq.isEmpty() && pq.peek().frequency == freq){
                temp.add(pq.poll().word);
            }
            
            Collections.sort(temp);
            int j = 0;
            while(answer.size() < k && j < temp.size()){
                answer.add(temp.get(j++));    
            }
            
        }
        
        return answer;
    }
}

class Pair{
    String word;
    int frequency;
    
    public Pair(String word, int frequency){
        this.word = word;
        this.frequency = frequency;
    }
}