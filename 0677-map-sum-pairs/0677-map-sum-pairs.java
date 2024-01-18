class MapSum {

    Trie trie;
    HashMap<String, Integer> map;
    public MapSum() {
        trie = new Trie();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        trie.insert(key, delta);
    }
    
    public int sum(String prefix) {
        return trie.getSumPrefix(prefix);
    }
}

class Trie{
    
    Node root;
    
    public Trie(){
        root = new Node();
    }
    
    public void insert(String word, int sum){
        Node node = root;
        for(char ch: word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch);
            node.setSum(sum);
        }
    }
    
    public int getSumPrefix(String prefix){
        Node node = root;
        for(char ch: prefix.toCharArray()){
            if(!node.containsKey(ch)){
                return 0;
            }
            node = node.get(ch);
        }
        
        return node.sum;
    }
}

class Node{
    Node[] node;
    boolean flag;
    int sum;
    
    public Node(){
        node = new Node[26];
        flag = false;
        sum = 0;
    }
    
    public void put(char ch, Node newNode){
        node[ch - 'a'] = newNode;
    }
    
    public Node get(char ch){
        return node[ch - 'a'];
    }
    
    public boolean containsKey(char ch){
        return node[ch - 'a'] != null;
    }
    
    public void setSum(int x){
        this.sum += x;
    }
    
    public int getSum(){
        return this.sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */