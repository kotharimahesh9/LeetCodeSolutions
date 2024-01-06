class Solution {
    public int minOperations(String s) {
        int start0 = 0;
        int start1 = 0;
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(i % 2 == 0){
                // even and we start from 0
                if(ch == '0'){
                    start1++;
                }else{
                    start0++;
                }
            }else{
                // odd and we start from 0
                if(ch == '1'){
                    start1++;
                }else{
                    start0++;
                }
            }
        }
        
        return Math.min(start1, start0);
    }
}