class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[insertPos++] = nums[i];
            }
        }
        while(insertPos<nums.length){
            nums[insertPos++] = 0;
        }
    }
}