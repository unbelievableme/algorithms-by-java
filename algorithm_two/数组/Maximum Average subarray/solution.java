//滑动窗口解法
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i =0;i<k;i++){
            sum+=nums[i];
        }
       int max = sum;
        for(int i = k;i<nums.length;i++){
            sum += nums[i] - nums[i-k];
            max = Math.max(sum,max);
        }
        //注意最后的结果是double形的
        return max/1.0/k;
    }
}