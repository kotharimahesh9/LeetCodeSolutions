class Trie {
    Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        
        return node.isEnd();
    }
    
    public boolean startsWith(String word) {
        Node node = root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        
        return true;
    }
    
}


class Node{
    Node[] root = new Node[26];
    boolean flag = false;
    
    public boolean containsKey(char ch){
        return (root[ch-'a'] != null);
    }
    
    public Node get(char ch){
        return root[ch - 'a'];
    }
    
    public void put(char ch, Node node){
        root[ch - 'a'] = node;
    }
    
    public void setEnd(){
        flag = true;
    }
    
    public boolean isEnd(){
        return flag;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */