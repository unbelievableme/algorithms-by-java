//与求最长增长子序列有相同之处
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int num = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==1){
                num  = Math.max(num,++count);
            }
            else count=0;
        }
        return num;
    }
}