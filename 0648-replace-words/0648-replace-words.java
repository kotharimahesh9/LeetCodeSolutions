class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String s: dictionary){
            trie.insert(s);
        }
        
        String[] sentenceWords = sentence.split(" ");
        
        StringBuilder sb = new StringBuilder();
        for(String s: sentenceWords){
            String prefix = trie.getPrefix(s);
            
            if(!prefix.equals("")){
                sb.append(prefix);
            }else{
                sb.append(s);
            }
            sb.append(" ");
        }
        
        return sb.toString().trim();
        
    }
}

class Trie{
    Node root;
    
    public Trie(){
        root = new Node();
    }
    
    public void insert(String word){
        Node node = root;
        for(char ch: word.toCharArray()){
            if(!node.contains(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        
        node.setEnd();
    }
    
    public String getPrefix(String word){
        Node node = root;
        StringBuilder sb = new StringBuilder();
        for(char ch : word.toCharArray()){
            if(node.contains(ch)){
                sb.append(ch);
                node = node.get(ch);
                if(node.isEnd())
                    return sb.toString();
            }else{
                return "";
            }
        }
        
        return "";
        
    }
}

class Node{
    Node[] node;
    boolean flag;
    
    public Node(){
        node = new Node[26];
        flag = false;
    }
    
    public void put(char ch, Node newNode){
        node[ch - 'a'] = newNode;
    }
    
    public Node get(char ch){
        return node[ch - 'a'];
    }
    
    public boolean contains(char ch){
        return node[ch - 'a'] != null;
    }
    
    public void setEnd(){
        flag = true;
    }
    
    public boolean isEnd(){
        return flag;
    }
    
}