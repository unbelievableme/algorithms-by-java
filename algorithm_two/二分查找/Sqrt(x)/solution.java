class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int i = 1;
        int j = x;
        while(i<=j){
            int mid = i + (j - i)/2;
            //不要写成mid * mid >x
            if(mid>x/mid){
                j = mid - 1;
            }
            else{
                if((mid+1) > x/(mid+1))
                return mid;
                i = mid + 1;
        }       
    }
        return -1;
 }
}