//pop push  peek isEmpty函数的调用
class Solution {
    public int calPoints(String[] ops) {
        int result = 0;
        Stack<Integer> s  = new Stack<Integer>();
        for(String op : ops){
            if(op.equals("C")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }
            else if(op.equals("D")){
                if(!s.isEmpty()){
                    s.push(2*s.peek());
                }
            }
            else if(op.equals("+")){
                int i = s.pop();
                int j = s.pop();
                s.push(j);s.push(i);
                s.push(i+j);
            }
            else {
                s.push(Integer.valueOf(op));
            }
        }
        while(!s.isEmpty()){
            result+=s.pop();
        }
        return result;
    }
}