class NumArray {
int num[];
    public NumArray(int[] nums) {
        for(int i =1 ;i<nums.length;i++){
            nums[i] += nums[i-1];
        }
        this.num = nums;
    }
    
    public int sumRange(int i, int j) {
        if(i == 0)return num[j];
        return num[j] - num[i-1];
    }
}