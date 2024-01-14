class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        if(word1.length() != word2.length())
            return false;
        
        Set<Character> s1 = new HashSet<>();
        Set<Character> s2 = new HashSet<>();
        
        int n = word1.length();
        for(int i=0; i<n; i++){
            s1.add(word1.charAt(i));
            s2.add(word2.charAt(i));
        }
        
        if(s1.equals(s2)){
            int[] freq1 = new int[26];
            int[] freq2 = new int[26];
            
            for(int i=0; i<n; i++){
                freq1[word1.charAt(i) - 'a']++;
                freq2[word2.charAt(i) - 'a']++;
            }
            
            Arrays.sort(freq1);
            Arrays.sort(freq2);
            
            for(int i=0; i<26; i++){
                if(freq1[i] != freq2[i])
                    return false;
            }
            
            return true;
            
        }
        
        return false;
        
    }
}