//求出左子树深度，求出右子树深度，相差小于1即可，
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        //还要递归子树保证所有节点都是平衡的
        return Math.abs(getDepth(root.left)-getDepth(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int getDepth(TreeNode treeNode){
        if(treeNode!=null){
        int left = getDepth(treeNode.left);
        int right = getDepth(treeNode.right);
        return Math.max(left,right)+1;
    }
        return 0;
    }
}