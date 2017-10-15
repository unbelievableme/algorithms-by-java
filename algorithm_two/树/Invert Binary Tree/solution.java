//无非是DFS和BFS，顺便做点事情
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root ==null) return null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode treeNode = q.poll();
            TreeNode t = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = t;
            if(treeNode.left != null){
                q.offer(treeNode.left);
            }
            if(treeNode.right != null){
                q.offer(treeNode.right);
            }
        }
        return root;
    }
}