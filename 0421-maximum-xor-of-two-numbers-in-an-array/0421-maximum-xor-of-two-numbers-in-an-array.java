class Solution {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        Trie trie = new Trie();
        for(int i=0; i<n; i++){
            trie.insert(nums[i]);
        }
        
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, trie.getMax(nums[i]));
        }
        
        
        return max;
    }
}
class Trie{
    private static Node root;
    Trie(){
        root = new Node();
    }
    
    public void insert(int num){
        Node node = root;
        for(int i=31; i>= 0; i--){
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }
    
    public int getMax(int num){
        Node node = root;
        int maxNum = 0;
        
        for(int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            if(node.containsKey(1 - bit)){
                maxNum = maxNum | (1<<i);
                node = node.get( 1 - bit); 
            }else{
                node = node.get(bit);
            }
        }
        
        return maxNum;
    }
}
class Node{
    Node[] node;
    
    public Node(){
        node = new Node[2];
    }
    
    public boolean containsKey(int i){
        return node[i] != null;
    }
    
    public Node get(int i){
        return node[i];
    }
    
    public void put(int i, Node newNode){
        node[i] = newNode;
    }
}