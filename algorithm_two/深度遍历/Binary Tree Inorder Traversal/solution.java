//递归
class Solution {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        LNR(root);
        return list;
    }
    public void LNR(TreeNode root){
        if(root == null) return ;
        LNR(root.left);
        list.add(root.val);
        LNR(root.right);
    }
}

//迭代
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list =  new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null || !stack.empty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
             root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
