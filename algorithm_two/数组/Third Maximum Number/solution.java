class Solution {    
    public int thirdMax(int[] nums) {
        Integer[] max = new Integer[] { null, null, null };
        //习惯应用这种迭代方式
        for (Integer num : nums) {
            //区别==和equals的用法
            if (num.equals(max[0]) || num.equals(max[1]) || num.equals(max[2])) {
                continue;
            }
            if (max[0] == null || max[0] < num) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = num;
            } else if (max[1] == null || max[1] < num) {
                max[2] = max[1];
                max[1] = num;
            } else if (max[2] == null || max[2] < num)
                max[2] = num;
        }
        return (max[2] == null ? max[0] : max[2]);
    }
}