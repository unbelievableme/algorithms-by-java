//自顶向下和自底向上
class Solution {
    public int climbStairs(int n) {
        int pre1 = 1;
        int pre2 = 2;
        int step = 0;
        for(int  i = 3 ;i <=n; i++){
            step = pre1+pre2;
            pre1 = pre2;
            pre2 = step;
        }
        return (n==1 || n==2)?n:step;
    }
}