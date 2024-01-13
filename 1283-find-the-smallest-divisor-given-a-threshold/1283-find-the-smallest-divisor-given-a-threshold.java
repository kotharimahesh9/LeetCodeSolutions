class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
        }
        
        int start = 1;
        int end = max;
        int ans = Integer.MAX_VALUE;
        while(start <= end){
            int mid = (start + end) / 2;
            int sum = findSum(nums, n, mid);
            if(sum <= threshold){
                ans = Math.min(ans, mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return ans;
    }
    
    private int findSum(int[] nums, int n, int divisor){
        double sum = 0;
        for(int i=0; i<n; i++){
            double d = nums[i] / (double) divisor;
            sum += Math.ceil(d); 
        }
        
        return (int)sum;
    }
}