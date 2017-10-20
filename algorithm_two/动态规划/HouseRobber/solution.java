//对于每个状态保存两个数值，1.如果在前面个房子Notrob，那么当前最大值是preRob+num
//2.如果在前面个房子rob，那么当前最大值为前面房子两个状态的最大值
//3.结果为两个状态的最大值
class Solution {
    public int rob(int[] nums) {
        int preRob = 0;
        int preNotRob = 0;
        for(int num : nums){
            int currRob = preNotRob + num;
            int currNotRob = Math.max(preRob,preNotRob);
            preRob = currRob;
            preNotRob = currNotRob;
        }
        return Math.max(preRob,preNotRob);
    }
}