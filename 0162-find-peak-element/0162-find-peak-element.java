class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return 0;
        if(nums[0] > nums[1])
            return 0;
        if(nums[n-1] > nums[n-2])
            return n-1;
        
        int start = 1;
        int end = n-2;
        
        while(start <= end){
            int mid = (start + end) / 2;
            int num = nums[mid];
            int left = nums[mid - 1];
            int right = nums[mid + 1];
            
            if(num > left && num > right)
                return mid;
            else{
                // mid is not the peak
                if(left > num)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        
        return -1;
    }
}