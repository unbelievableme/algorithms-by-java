public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end =n;
        //判断条件
        while(start<end){
        	//为什么不用 （start+end）/2
            int mid = start + (end - start) /2 ;
            if(!isBadVersion(mid)) start = mid+1;
            //并不是end+1
            else end = mid;
        }
        return start;
    }
}