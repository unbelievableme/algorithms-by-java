// O(n^2)solution
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i =0;i<nums.length;i++){
            //j从i+1开始，因为不允许重复
            for(int j = i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
//O(n)solution，借助了一个HashMap工具类
class Solution {
    public int[] twoSum(int[] nums, int target) {
         HashMap<Integer,Integer> tracker = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(tracker.containsKey(nums[i])){
                return new int[]{i,tracker.get(nums[i])};
            }
            else{
                tracker.put(target-nums[i],i);
            }
        }
        return null;
    }
}