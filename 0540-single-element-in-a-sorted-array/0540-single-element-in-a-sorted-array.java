class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        int start = 1;
        int end = n - 2;
        
        if(nums[0] != nums[1])
            return nums[0];
    
        if(nums[n-1] != nums[n-2])
            return nums[n-1];
        
        while(start <= end){
            int mid = (start + end) / 2;
            int num = nums[mid];
            int left = nums[mid-1];
            int right = nums[mid+1];
            
            if(num != left && num != right)
                return num;
            else{
                if(mid % 2 == 0){
                    // odd numbers
                    if(left == num){
                       end = mid; 
                    }else{
                        start = mid;
                    }
                }else{
                    // even numbers
                    if(left == num){
                        start = mid;
                    }else{
                        end = mid;
                    }
                }
            }
        }
        
        return -1;
    }
}