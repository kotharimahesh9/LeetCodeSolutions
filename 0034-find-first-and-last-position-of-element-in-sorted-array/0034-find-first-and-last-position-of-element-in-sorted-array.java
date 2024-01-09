class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        // find the lower bound
        int start = 0;
        int end = n-1;
        
        int index1 = -1;
        while(start <= end){
            int mid = (start + end) / 2;
            
            if(nums[mid] == target){
                index1 = mid;
                end = mid-1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        start = 0;
        end = n - 1;
        int index2 = -1;
        while(start <= end){
            int mid = (start + end) / 2;
            
            if(nums[mid] == target){
                index2 = mid;
                start = mid+1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        ans[0] = index1;
        ans[1] = index2;
        
        return ans;
    }
}