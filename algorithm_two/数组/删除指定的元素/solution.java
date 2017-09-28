//和删除重复的元素有异曲同工之处
class Solution {
    public int removeElement(int[] nums, int val) {
        int id = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[id++] = nums[i];
            }
        }
        return id;
    }
}