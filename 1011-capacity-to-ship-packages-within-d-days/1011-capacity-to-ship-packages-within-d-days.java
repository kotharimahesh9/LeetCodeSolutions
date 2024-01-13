class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int n = weights.length;
        int start = Integer.MIN_VALUE;
        int end = 0;
        for(int i=0; i<n; i++){
            start = Math.max(start, weights[i]);
            end += weights[i];
        }
        
        int ans = (int)1e9;
        while(start <= end){
            int mid = (start + end) / 2;
            
            int daysRequired = find(weights, n, mid);
            
            if(daysRequired <= days){
                ans = Math.min(ans, mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return ans;
    }
    
    private int find(int[] weight, int n, int minWeight){
        
        int sum = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            if(sum + weight[i] <= minWeight){
                sum += weight[i];
            }else{
                sum = weight[i];
                count++;
            }
        }
        
        return count + 1;
    }
}