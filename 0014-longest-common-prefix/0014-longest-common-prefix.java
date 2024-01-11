class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int n = strs.length;
        Node root = new Node();
        for(int i=0; i<n; i++){
            Node node = root;
            for(char ch : strs[i].toCharArray()){
                if(!node.containsKey(ch)){
                    node.put(ch, new Node());
                }
                node = node.get(ch);
                node.increaseCount();
            }
        }
        
        String first = strs[0];
        StringBuilder ans = new StringBuilder();
        
        Node node = root;
        for(char ch : first.toCharArray()){
            if(node.containsKey(ch)){
                node = node.get(ch);
                if(node.getCount() == n){
                    ans.append(ch);
                }else{
                    break;
                }
                
            }else{
                break;
            }
        }
        
        return ans.toString();
    }
}

class Node{
    Node[] node;
    boolean flag;
    int count;
    
    public Node(){
        node = new Node[26];
        flag = false;
        count = 0;
    }
    
    public void put(char ch, Node t){
        node[ch - 'a'] = t;
    } 
    
    public void increaseCount(){
        count++;
    }
    
    public boolean containsKey(char ch){
        return node[ch - 'a'] != null;
    }
    
    public int getCount(){
        return count;
    }
    
    public Node get(char ch){
        return node[ch-'a'];
    }
    
    
}