class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = bloomDay.length;
        for(int i=0; i<n; i++){
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        int ans = Integer.MAX_VALUE;
        while(min <= max){
            int mid = (min + max) / 2;
            
            int bouquets = findDays(bloomDay, n, mid, k);
            if(bouquets >= m){
                ans = Math.min(ans, mid);
                max = mid - 1;
            }else{
                min = mid + 1;
            }
            
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private int findDays(int[] bloomDay, int n, int day, int k){
        int ans = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            if(bloomDay[i] <= day){
                count++;    
            }else{
                count = 0;
            }
            
            if(count == k){
                ans++;
                count = 0;
            }
        }
        
        return ans;
    }
}