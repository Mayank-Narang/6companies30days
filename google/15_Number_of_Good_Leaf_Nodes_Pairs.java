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

    Set<TreeNode> leaves = new HashSet();
    HashMap<TreeNode, List<TreeNode>> adj = new HashMap();

    private void makeGraph(TreeNode node,TreeNode prev){

        if (node == null)
            return;

        if (node.left == null && node.right == null) leaves.add(node);

        if (prev != null){
            adj.computeIfAbsent(node,k -> new ArrayList<>()).add(prev);
            adj.computeIfAbsent(prev,k -> new ArrayList<>()).add(node);
        }

        makeGraph(node.left,node);
        makeGraph(node.right,node);

    }

    public int countPairs(TreeNode root, int distance) {
        
        makeGraph(root,null);
        int count = 0;

        for (TreeNode node : leaves){

            Queue<TreeNode> q = new LinkedList<>();
            Set<TreeNode> vis 
            q.add(node);
            int size = q.size();

            while (size-- > 0){

            }

        }

    }
}
