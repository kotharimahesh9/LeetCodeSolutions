class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int p1 = 0;
        int p2 = 0;
        
        int content = 0;
        while(p1 < g.length && p2 < s.length){
            if(s[p2] >= g[p1]){
                p2++;
                p1++;
                content++;
            }else{
                p2++;
            }
        }
        
        return content;
        
    }
}