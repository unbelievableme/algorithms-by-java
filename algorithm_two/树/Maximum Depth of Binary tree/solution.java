class Solution {
    public int maxDepth(TreeNode root) {
        if(root!=null){
        	//求左子树深度
           int left = maxDepth(root.left);
           //求右子树深度
           int right = maxDepth(root.right);
           //取最大值+1
           return Math.max(left,right)+1;
        }
        return 0;
    }
}