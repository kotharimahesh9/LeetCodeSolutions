class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] x : dp)
            Arrays.fill(x, -1);
        return LIS(nums, 0, -1, dp);
    }
    
    
    private int LIS(int[] nums, int index, int prevIndex, int[][] dp){
        if(index == nums.length)
            return 0;
        
        if(dp[index][prevIndex+1] != -1)
            return dp[index][prevIndex+1];
        
        int take = 0;
        if(prevIndex == -1 || nums[index] > nums[prevIndex]){
            take = 1 + LIS(nums, index + 1, index, dp);
        }
        int notTake = LIS(nums, index + 1, prevIndex, dp);
        
        return dp[index][prevIndex+1] = Math.max(take, notTake);
    }
}