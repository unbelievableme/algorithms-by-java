//思路比较简单，将3sum问题转化为了2sum问题
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i =0 ;i<nums.length-2;i++){
            //细节1：连续重复元素只需要处理第一个否则结果会产生重复。例如【0，0，0，0】
            if(i>0&&nums[i]==nums[i-1])continue;
            int two_sum = 0 - nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[left]+nums[right];
                if(sum == two_sum){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
            //细节2：当发现一个满足2sum之后该如何？还是避免重复
                    while(left<right&&nums[left] == nums[left+1])left++;
                    while(left<right&&nums[right] == nums[right-1])right--;
                    right--;left++;
                }
                else if(sum > two_sum)
                    right--;
                else left++;
            }
        }
        return list;
    }
}