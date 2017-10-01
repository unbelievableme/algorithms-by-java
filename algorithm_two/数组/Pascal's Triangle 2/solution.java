class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i =0;i<rowIndex+1;i++){
            list.add(1);
            for(int j = i-1;j>=1;j--){
                list.set(j,list.get(j-1)+list.get(j));
        }
      }
          return list;
    }
}