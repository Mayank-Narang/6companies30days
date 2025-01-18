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
    
    HashMap<Integer,List<Integer>> map = new HashMap();

    private void traverse(TreeNode root){

        if (root == null)
            return;

        if (root.left != null){

            map.put(root.left.val, new ArrayList<>());
            map.get(root.val).add(root.left.val);
            map.get(root.left.val).add(root.val);

            traverse(root.left);

        }
        if (root.right != null){

            map.put(root.right.val, new ArrayList<>());
            map.get(root.val).add(root.right.val);
            map.get(root.right.val).add(root.val);

            traverse(root.right);

        }

    }

    public int amountOfTime(TreeNode root, int start) {
        
        map.put(root.val,new ArrayList<>());
        traverse(root);
    
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,0});

        map.get(start).add(0);

        int max = 0;

        while (!q.isEmpty()){

            int[] node = q.poll();

            max = Math.max(max,node[1]);

            for (int i = 0; i < map.get(node[0]).size()-1; i++){

                int going = map.get(node[0]).get(i);
                int gos = map.get(going).size();

                if (map.get(going).get(gos-1) == 0)
                    continue;

                map.get(going).add(0);
                q.add(new int[]{going,node[1]+1});

            }

        }

        return max;

    }
}
