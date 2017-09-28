class Solution {
    public int searchInsert(int[] nums, int target) {
       int low = 0;
       //high = nums.length -1注意要减一
       int high = nums.length-1;
       //判断条件是小于等于
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return low;
}
}