class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        int n = nums.length;
        Trie trie = new Trie();
        Arrays.sort(nums);
        int m = queries.length;
        int[] ans = new int[m];
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList < Integer > temp = new ArrayList < Integer > ();
            temp.add(queries[i][1]);
            temp.add(queries[i][0]);
            temp.add(i);
            offlineQueries.add(temp);
        }
        Arrays.fill(ans, -1);
        
        Collections.sort(offlineQueries, new Comparator < ArrayList < Integer >> () {
          @Override
          public int compare(ArrayList < Integer > a, ArrayList < Integer > b) {
            return a.get(0).compareTo(b.get(0));
          }
        });
        int index = 0;
        for(int i=0; i<m; i++){
            int mi = offlineQueries.get(i).get(0);
            int xi = offlineQueries.get(i).get(1);
            int j = offlineQueries.get(i).get(2);
            while(index < n && nums[index] <= mi){
                trie.insert(nums[index]);
                index++;
            }
            
            if(index != 0){
                ans[j] = trie.getMax(xi);
            }  
        }
        
        return ans;
        
    }
}


class Node {
    Node[] node;
    
    public Node(){
        node = new Node[2];
    }
    
    public Node get(int i){
        return node[i];
    }
    
    public void put(int i, Node newNode){
        node[i] = newNode;
    }
    
    public boolean contains(int i){
        return node[i] != null;
    }
}

class Trie{
    Node root;
    
    public Trie(){
        root = new Node();
    }
    
    
    public void insert(int num){
        // inserts the number into the Trie Datastructure, in binary
        
        Node node = root;
        for(int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            if(!node.contains(bit)){
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }
    
    public int getMax(int num){
        Node node = root;
        int ans = 0;
        for(int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            
            if(node.contains(1-bit)){
                // add this to answer
                ans = ans | (1 << i);
                node = node.get(1-bit);
            }else{
                node = node.get(bit);
            }
        }
        return ans;
    }
}