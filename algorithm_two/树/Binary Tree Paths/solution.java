class Solution {
    List<String> list = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root != null)NLR("",root);
        return list;
    }
    public void NLR(String path,TreeNode root){
        if(root.left == null && root.right == null)list.add(path+root.val);
        if(root.left!=null)NLR(path+root.val+"->",root.left);
        if(root.right!=null)NLR(path+root.val+"->",root.right);
    }
}