public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        //通过root的最长距离
       int dia = depth(root.left) + depth(root.right);
       //左子数的最长距离
       int ldia = diameterOfBinaryTree(root.left);
       //右子数的最长距离
       int rdia = diameterOfBinaryTree(root.right);
       //求最大
       return Math.max(dia,Math.max(ldia,rdia));      
    }
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1+Math.max(depth(root.left), depth(root.right));
    }  
}
