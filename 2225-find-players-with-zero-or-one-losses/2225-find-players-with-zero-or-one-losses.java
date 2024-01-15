class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());
        int n = matches.length;
        
        Map<Integer, Pair> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int winner = matches[i][0];
            int loser = matches[i][1];
            if(!map.containsKey(winner)){
                map.put(winner, new Pair(1, 0));
            }else{
                Pair p = map.get(winner);
                p.winCount += 1;
                map.put(winner, p);
            }
            
            if(!map.containsKey(loser)){
                map.put(loser, new Pair(0, 1));
            }else{
                Pair p = map.get(loser);
                p.loseCount += 1;
                map.put(loser, p);    
            }
        }
        
        for(int key : map.keySet()){
            Pair p = map.get(key);
            if(p.loseCount == 0){
                answer.get(0).add(key);
            }
            
            if(p.loseCount == 1){
                answer.get(1).add(key);
            }
        }
        
        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));
        
        return answer;
    }
}

class Pair{
    int winCount;
    int loseCount;
    
    public Pair(int winCount, int loseCount){
        this.winCount = winCount;
        this.loseCount = loseCount;
    }
}