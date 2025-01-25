/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int ans = 0;
    // min max sum
    private int[] solve(TreeNode node){

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        if (node == null)
            return new int[]{max,min,0};
        
        int[] left = solve(node.left);
        int[] right = solve(node.right);

        if (node.val > left[1] && node.val < right[0]){
            ans = Math.max(ans,left[2]+right[2]+node.val);
            return new int[]{Math.min(node.val,left[0]),Math.max(node.val,right[1]),left[2]+right[2]+node.val};
        }
        else {
            ans = Math.max(ans,Math.max(left[2],right[2]));
            return new int[]{min,max,Math.max(left[2],right[2])};
        }

    }

    public int maxSumBST(TreeNode root) {
        
        solve(root);

        return ans;

    }
}
