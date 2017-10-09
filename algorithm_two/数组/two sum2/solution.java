//二分法的变形应用你，凡是排好序的数组，都要想到利用二分的技巧
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length-1;
        //元素不能重复所以left<right
        while(left<right){
            int v = numbers[left]+numbers[right];
            if(v == target){
            result[0] = left+1;
            result[1] = right+1;
            break;
        }
            else if(v>target)
                right--;
            else 
                left++;
    }
            return result;
    }
}