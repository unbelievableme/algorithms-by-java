class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list1 =  new ArrayList<Integer>();
        int currNum = 1;
        int nextNum = 0;
        int level = 1;
        Queue<TreeNode>q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(level % 2 ==1){
                list1.add(node.val);
            }
            else list1.add(0,node.val);
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
                level++;
                list.add(list1);
                list1 = new ArrayList<Integer>();
                currNum = nextNum; 
                nextNum =0;
            }
        }
        return list;
    }
}