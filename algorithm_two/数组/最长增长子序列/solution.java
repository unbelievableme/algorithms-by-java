//简直6的一批，一直困惑当遇到非递增元素的时候怎么重新开始计数比较？
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max_len = 0; int new_len = 0; 
        for(int i =0;i<nums.length;i++){
            if(i==0||nums[i-1]<nums[i]){
                max_len = Math.max(max_len,++new_len);
            }
            else new_len=1;
        }
        return max_len;
    }
}