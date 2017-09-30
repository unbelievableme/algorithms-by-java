//贪心策略，每一步解的形成条件是当前数值为0 并且前后都为0
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i =0;i<flowerbed.length;i++){
            if(flowerbed[i]==0){
            int next  = (i==flowerbed.length-1)?0:flowerbed[i+1];
            int pre = (i==0)?0:flowerbed[i-1];
            if(next==0 && pre==0){
                flowerbed[i]=1;
                count++;
            }}
        }
        return (count>=n)?true:false;
    }
}