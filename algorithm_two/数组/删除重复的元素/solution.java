//O(n^2)
class Solution {
    public int removeDuplicates(int[] nums) {
        //@new_len 新的长度
         int new_len = nums.length;
        for(int i =0;i<new_len-1;i++){
            if(nums[i]==nums[i+1]){
                //后续数组前移一位
                for(int j =i;j<nums.length-1;j++){
                    nums[j] = nums[j+1];
                }
                new_len--;
                nums[nums.length-1] = nums[i--];
            }
        }
        return new_len;
    }
}

//O(n),动态规划来理解下，题目对内存做了要求，其实问题就是求出一个序列和他的取值标号
//目的：构造一个没有重复值的序列，求出id号
//序列增长的过程就是各个状态逐渐形成的时候，而每个状态的确定取决于当前数组值和前一个
//是否相等，如果不相等序列增长，并修正前id序列的最大值。
class Solution {
    public int removeDuplicates(int[] nums) {
        int id = 1;
        for(int i =1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[id++] = nums[i];
            }
        }
        return id;
}
}