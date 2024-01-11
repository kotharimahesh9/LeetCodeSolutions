class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int first = 0;
        int second = n-2;
        int third = n-1;
        
        int ans = 0;
        while(first < second){
            ans = ans + piles[second];
            first++;
            third = second - 1;
            second = third - 1;
        }
        return ans;
    }
}