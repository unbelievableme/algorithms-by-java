class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public boolean isValidBST(TreeNode root) {
         LUR(root);
         int[] a = new int[list.size()];
         int j = 0; 
        for(Integer li : list){
             a[j++] = li;
         }
        for(int i = 1;i<a.length;i++){
            if(a[i]<=a[i-1]){
                return false;
            }
        }
        return true;
    }
    public void LUR(TreeNode root){
        if(root == null) return ;
        LUR(root.left);
         list.add(root.val);
        LUR(root.right);  
    }
}