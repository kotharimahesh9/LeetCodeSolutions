class Solution {
    public List<Integer> lexicalOrder(int n) {
        Trie trie = new Trie();
        List<Integer> answer = new ArrayList<>();
        for(int i=1; i<=n; i++){
            trie.insert(i);
        }
        
        for(int i=1; i<=9; i++){
            trie.getNum(i, answer);
        }
        
        return answer;
    }
}


class Trie{
    
    Node root;
    
    public Trie(){
        root = new Node();
    }
    
    public void insert(int num){
        // extract the digits and store them in a stack.
        int n = num;
        Stack<Integer> stack = new Stack<>();
        while(n > 0){
            int mod = n % 10;
            n = n / 10;
            stack.push(mod);
        }
        
        Node node = root;
        while(!stack.isEmpty()){
            int x = stack.pop();
            if(!node.contains(x)){
                node.put(x, new Node());
            }
            
            node = node.get(x);
        }
        
        node.setEnd();
    }
    
    public void getNums(int num, List<Integer> answer, Node node){
        if(node.isEnd())
            answer.add(num);
        
        for(int i=0; i<=9; i++){
            
            if(node.contains(i)){
                getNums(num*10 + i, answer, node.get(i));    
            }
        }
        
    }
    
    public void getNum(int n, List<Integer> answer){
        Node node = root;
        if(node.contains(n)){
            getNums(n, answer, node.get(n));        
        }
    }
}

class Node{
    Node[] node;
    boolean flag;
    
    public Node(){
        node = new Node[10];
        flag = false;
    }
    
    public void put(int n, Node newNode){
        node[n] = newNode;
    }
    
    public Node get(int n){
        return node[n];
    }
    
    public boolean contains(int n){
        return node[n] != null;
    }
    
    public void setEnd(){
        flag = true;
    }
    
    public boolean isEnd(){
        return flag;
    }
    
}