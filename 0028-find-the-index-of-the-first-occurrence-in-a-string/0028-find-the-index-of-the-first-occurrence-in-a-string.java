class Solution {
    public int strStr(String haystack, String needle) {

        int index = -1;
        int j = 0;
        for(int i=0; i< haystack.length(); i++){
            int idx = i;
            j = 0;
            while(idx < haystack.length() && j < needle.length() && haystack.charAt(idx) == needle.charAt(j)){
                j++;
                idx++;
            }
            if(j == needle.length())
                return i;
        }

        return -1;
        
    }
}