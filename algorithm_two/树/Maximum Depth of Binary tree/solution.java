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
//层次遍历
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int curNum =1;
        int nextNum = 0 ;
        int level = 0;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            curNum--;
            if(node.left!=null){
                q.offer(node.left);
                nextNum++;
            }
            if(node.right!=null){
                q.offer(node.right);
                nextNum++;
            }
            if(curNum == 0){
                level++;
                curNum = nextNum;
                nextNum =0;
            }
        }
        return level;
    }
}