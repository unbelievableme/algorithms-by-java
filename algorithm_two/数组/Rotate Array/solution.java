class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        //全部倒置
        reserve(nums,0,nums.length-1);
        //后K个倒置
        reserve(nums,k,nums.length-1);
        //前面倒置
        reserve(nums,0,k-1);
    }
    public void reserve(int a[],int start , int end){
        while(start<end){
            int temp  = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
}