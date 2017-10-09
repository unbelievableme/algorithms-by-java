//对于每个元素，我们都需要考虑他是否与前面的元素能够形成pair，同时要加入已经遍历的set中
class Solution {
    public int findPairs(int[] nums, int k) {
        if(k<0){
            return 0;
        }
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for(int num : nums){
            if(set1.contains(num-k))set2.add(num-k);
            if(set1.contains(k+num))set2.add(num);
            set1.add(num);
        }
        return set2.size();
    }
}