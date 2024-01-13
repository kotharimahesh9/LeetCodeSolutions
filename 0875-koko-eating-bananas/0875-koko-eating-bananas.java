class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(h < piles.length)
            return -1;
        
        int n = piles.length;
        int max = -1;
        for(int i=0; i<n; i++)
            max = Math.max(max, piles[i]);
        
        double start = 1;
        double end = max;
        
        double ans = end;
        while(start <= end){
            double mid = Math.floor((start + end)/2);
            double time = isAbleToFinish(piles, n, mid, h);
            if(time <= h){
                ans = Math.min(ans, mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return (int)ans;
    }
    
    private double isAbleToFinish(int[] piles, int n, double expectedHours, int h){
        
        double observedHours = 0;
        for(int i=0; i<n; i++){
            double time = piles[i] / expectedHours;
            
            observedHours += Math.ceil(time);
        }
        
        return (int)observedHours;
    }
}