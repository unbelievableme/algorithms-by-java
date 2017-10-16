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