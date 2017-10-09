//奇淫技巧
class Solution {
    public int missingNumber(int[] nums) {
       int len = nums.length;
       int sum = (len * (len+1))/2;
        for(int num : nums){
            sum-= num;
        }
        return sum;
    }
}