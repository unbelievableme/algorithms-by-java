class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int a[] = nums.clone();
        Arrays.sort(a);
        //i表示开始的位置，j表示结束的位置
        int i =0;int j = nums.length-1;
        while(i<nums.length&&nums[i] == a[i]){
            i++;
        }
        while(j>i&&nums[j]==a[j]){
            j--;
        }
        return j-i+1;
    }
}