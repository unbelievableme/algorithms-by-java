//学会巧用hashmap
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Integer num : nums1){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        for(Integer num : nums2){
            if(map.containsKey(num)&&map.get(num)>0){
                list.add(num);
                map.put(num,map.get(num)-1);
            }
        }
        int j =0;
        int result[] = new int[list.size()];
        for(Integer i : list){
            result[j++] = i;
        }
        return result;
    }
}