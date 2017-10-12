//训练二分算法所以用了time O(nlgn),最好的做法是用两个hashSet time O(m+n）
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length ==0){
            return new int[0];
        }
        HashSet<Integer> a = new HashSet<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int num : nums1){
           if(isExsit(num,nums2)){
               a.add(num);
           }
        }
        int i =0;
        int ar[] = new int[a.size()];
        for(Integer num : a){
            ar[i++] = num;
        } 
        return ar;
    }
    public boolean isExsit(int num,int nums[]){
        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            int mid =i + (j-i)/2;
            if(nums[mid] == num) return true;
            else if(nums[mid] > num) j = mid- 1;
            else i = mid+1;
        }
        return false;
    }
}