class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        
        while(start <= end){
            int mid = (start + end)/2;
            
            if(nums[mid] == target)
                return mid;
            else{
                if(nums[start] <= nums[mid]){
                    // left side is sorted
                    
                    if(nums[start] <= target && nums[mid] > target){
                        end = mid - 1;
                    }else{
                        start = mid + 1;
                    }
                }else{
                    // right side is sorted
                    
                    if(nums[mid] <= target && nums[end] >= target){
                        start = mid + 1;
                    }else{
                        end = mid - 1;
                    }
                }
            }
        }
        
        return -1;
        
    }
}