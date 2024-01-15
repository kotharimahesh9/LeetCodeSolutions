class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int start = 0;
        int end = n-1;
        
        while(start <= end){
            int mid = (start + end) / 2;
            int missingNumbers = arr[mid] - (mid + 1);
            
            if(k > missingNumbers){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return start + k;
    }
}