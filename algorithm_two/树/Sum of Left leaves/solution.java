//采用了二叉树的中序遍历
class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)return 0;
        traver(root);
        return sum;
    }
    public void traver(TreeNode treeNode){
        visitleft(treeNode.left);
        visitright(treeNode.right);
    }
    
    public void visitleft(TreeNode treeNode){
        if(treeNode == null)return;
        if(treeNode.left == null&&treeNode.right == null)sum += treeNode.val;
        traver(treeNode);
    }
      public void visitright(TreeNode treeNode){
        if(treeNode == null) return ;
        traver(treeNode);
    }
}