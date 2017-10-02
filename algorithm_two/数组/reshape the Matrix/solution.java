//将一个矩阵从左到右从上到下依次标号，根据标号映射出行和列
//思路：根据相同的标号映射到不同的矩阵的行和列，把他们对应起来
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length;
        int m = nums[0].length;
        if(r*c != n*m)return nums;
        int [][]new_nums = new int[r][c];
        for(int i =0 ;i<m*n;i++){
            new_nums[i/c][i%c] = nums[i/m][i%m];
        }
        return new_nums;
    }
}