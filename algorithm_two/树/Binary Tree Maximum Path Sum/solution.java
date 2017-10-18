//基本上关于树的一切算法都是以树的DFS和BFS为基础的，LRN自底向上
class Solution {
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return sum;
    }
    public int helper(TreeNode node){
        if(node == null) return 0;
        int left = Math.max(helper(node.left),0);
        int right = Math.max(helper(node.right),0);
        sum = Math.max(sum,left+right+node.val);
        return node.val+Math.max(left,right);
    } 
}