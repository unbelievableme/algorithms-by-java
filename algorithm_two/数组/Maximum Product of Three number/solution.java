//最大值的情况只存在，三个正数，两个负数一个正数
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int a = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int b =nums[0]*nums[1]*nums[nums.length-1];
        return a>b?a:b;
    }
}