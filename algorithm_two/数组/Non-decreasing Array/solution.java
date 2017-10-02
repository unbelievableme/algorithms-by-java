class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (i > 0 && nums[i + 1] < nums[i - 1]) nums[i + 1] = nums[i];
                else nums[i] = nums[i + 1];
            }
        }
        return count>1?false:true;
    }
}