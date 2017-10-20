//mysolution use hashmap
class Solution {
    public boolean isValid(String s) {
        if(s.length()==1)return false;
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack =new Stack<Character>();
        for(int i  =0 ;i<s.length();i++){
            char a = s.charAt(i);
            if(map.containsValue(a))stack.push(a);
            else {
                if(stack.empty())return false;
                if(!map.get(a).equals(stack.pop()))return false;
            }
        }
        return stack.empty()?true:false;
    }
}
//good
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char a : s.toCharArray()){
            switch(a){
                case '(':stack.push(')');break;
                case '{':stack.push('}');break;
                case '[':stack.push(']');break;
                default:
                    if(stack.empty()||!stack.pop().equals(a))return false;
            }
        }
        return stack.empty();
    }
}