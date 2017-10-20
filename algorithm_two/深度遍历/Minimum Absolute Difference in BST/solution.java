class Solution {
    Integer pre = null;
    int diff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null)return  0;
        getMinimumDifference(root.left);
        if(pre!=null){
            diff = Math.min(diff,root.val - pre);
        }
        pre = root.val;
        getMinimumDifference(root.right);
        return diff;
    }
}