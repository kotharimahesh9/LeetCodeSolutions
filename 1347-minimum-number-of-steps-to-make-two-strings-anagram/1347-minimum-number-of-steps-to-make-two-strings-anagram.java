class Solution {
    public int minSteps(String s, String t) {
        
        char[] chArray = new char[26];
        for(char ch : s.toCharArray())
            chArray[ch - 'a']++;
        
        int diff = 0;
        for(char ch : t.toCharArray()){
            if(chArray[ch - 'a'] == 0){
                diff++;
            }else{
                chArray[ch - 'a']--;
            }
        }
        return diff;
        
    }
}