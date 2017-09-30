class Solution {
    public boolean containsDuplicate(int[] nums) {
    	//运用了hashset
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i =0;i<nums.length;i++){
            if(!hashSet.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}