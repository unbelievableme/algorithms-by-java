//思路：找出对于每个house而言到火种的最近距离，然后取最近距离的最大值
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);        
        Arrays.sort(heaters);
        int i =0 ;
        int j =0 ;
        int dis =0 ;
        while(i<houses.length){
            while(j<heaters.length-1 && Math.abs(heaters[j]-houses[i])>=Math.abs(heaters[j+1]-houses[i])){
                j++;
            }
            dis = Math.max(dis,Math.abs(heaters[j]-houses[i++]));
        }
        return dis;
    }
}