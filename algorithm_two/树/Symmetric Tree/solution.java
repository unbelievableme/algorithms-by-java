//用递归的思想去思考问题
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || digui(root.left,root.right);
    }
    public boolean digui(TreeNode left , TreeNode right){
        //下面的代码很精炼，比避免了null异常，有能够返回正常的boolean值
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val){
            return false;
        }
        return digui(left.left,right.right) && digui(left.right , right.left);
    }
}