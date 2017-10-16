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