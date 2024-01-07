class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        
        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(map.containsKey(email)){
                    // Build the DisjointSet Datastructure
                    int account = i;
                    int matchedAccount = map.get(email);
                    ds.unionBySize(matchedAccount, account);
                    
                }else{
                    map.put(email, i);
                }
            }
        }
        
        List<String>[] mergedMails = new ArrayList[n];
        for(int i = 0; i < n; i++) 
            mergedMails[i] = new ArrayList<String>();
        
        for(String key : map.keySet()){
            int account = map.get(key);
            int parent = ds.unionFind(account);
            mergedMails[parent].add(key);
        }
        
        List<List<String>> answer = new ArrayList<>();
        for(int i=0; i<n; i++){
            String accountName = accounts.get(i).get(0);
            if(mergedMails[i].isEmpty())
                continue;
            Collections.sort(mergedMails[i]);
            mergedMails[i].add(0, accountName);
            answer.add(new ArrayList<>(mergedMails[i]));
        }
        
        return answer;       
    }
}

class DisjointSet {
    
    private List<Integer> parent;
    private List<Integer> size;
    
    public DisjointSet(int n){
        parent = new ArrayList<>();
        size = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    public int unionFind(int v){
        
        if(v == parent.get(v))
            return v;
        
        int p = unionFind(parent.get(v));
        parent.set(v, p);
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