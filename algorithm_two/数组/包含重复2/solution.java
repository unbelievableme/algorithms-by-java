//自己的做法
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for(int i =0;i<nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                int  j = hashMap.get(nums[i]);
                if(Math.abs(i-j)<=k){
                    return true;
                }
                else {hashMap.remove(j);
                     hashMap.put(nums[i],i);
                     }            }
            else hashMap.put(nums[i],i);
        }
        return false;
    }
}

//别人的
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       HashSet<Integer>hashSet = new HashSet<Integer>();
        for(int i =0;i<nums.length;i++){
            if(i>k){
                hashSet.remove(nums[i-k-1]);
            }
            if(!hashSet.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}