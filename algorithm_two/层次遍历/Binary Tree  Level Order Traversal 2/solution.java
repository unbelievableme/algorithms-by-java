class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
             List<Integer> list1 = new ArrayList<Integer>();
        Queue<TreeNode> q =new LinkedList<TreeNode>();
        int currNum = 1;
        int nextNum = 0;
        q.offer(root);
        while(!q.isEmpty()){
         TreeNode node = q.poll();
         list1.add(node.val);
         currNum--;
         if(node.left!=null){
             q.offer(node.left);
             nextNum++;
         }
         if(node.right!=null){
             q.offer(node.right);
             nextNum++;
         }
        if(currNum == 0){
            list.add(0,list1);
            list1 = new ArrayList<Integer>();
            currNum = nextNum;
            nextNum = 0;
        } 
        }
        return list;
    }
}