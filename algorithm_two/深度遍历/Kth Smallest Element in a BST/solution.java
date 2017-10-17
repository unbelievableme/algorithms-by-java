//递归
class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public int kthSmallest(TreeNode root, int k) {
        LNR(root);
        return list.get(k-1);
    }
    public void LNR(TreeNode node){
        if(node == null) return ;
        LNR(node.left);
        list.add(node.val);
        LNR(node.right);
    }
}

//迭代
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null || !stack.empty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0)break;
            root = root.right;
        }
        return root.val;
    }
}