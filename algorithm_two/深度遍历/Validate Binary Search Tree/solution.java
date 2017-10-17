class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public boolean isValidBST(TreeNode root) {
         LUR(root);
         int[] a = new int[list.size()];
         int j = 0; 
        for(Integer li : list){
             a[j++] = li;
         }
        for(int i = 1;i<a.length;i++){
            if(a[i]<=a[i-1]){
                return false;
            }
        }
        return true;
    }
    public void LUR(TreeNode root){
        if(root == null) return ;
        LUR(root.left);
         list.add(root.val);
        LUR(root.right);  
    }
}

//迭代
class Solution {
    public boolean isValidBST(TreeNode root) { 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while(root!=null || !stack.empty()){
            while(root!=null){
                stack.push(root);
                root =  root.left;
            }
            root = stack.pop();
            if(pre!=null && pre.val >= root.val)return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}