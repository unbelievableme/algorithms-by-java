class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)return null;
        TreeNode treeNode = createBST(nums,0,nums.length-1);
        return treeNode;
    }
    public TreeNode createBST(int []nums,int low,int high){
        if(low > high){
            return null;
        }
        int mid = (low + high)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        //创建左子树 BST
        treeNode.left = createBST(nums,low,mid-1);
        //创建右子树 BST
        treeNode.right = createBST(nums,mid+1,high);
        return treeNode;
    }
}