//i作为当前移动到的位置的游标，j作为有重复的游标
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)return 0;
        int sum =0;
        HashMap<Character,Integer> hashMap = new HashMap<Character,Integer>();
        int j =-1;
        for(int i =0;i<s.length();i++){
            if(hashMap.containsKey(s.charAt(i))){
                j = Math.max(j,hashMap.get(s.charAt(i)));
            }
            hashMap.put(s.charAt(i),i);
            sum = Math.max(sum,i-j);
        } 
            return sum;
    }
}