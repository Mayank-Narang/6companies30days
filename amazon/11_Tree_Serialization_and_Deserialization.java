//nice question

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){

            TreeNode node = q.poll();

            if (node == null){
                sb.append(" -1001");
                continue;
            }
            
            q.add(node.left);
            q.add(node.right);

            sb.append(" "+node.val);

        }

        sb.deleteCharAt(0);

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] serial = data.split(" ");
        int n = serial.length;

        int[] vals = new int[n];

        System.out.println(Arrays.toString(serial));

        for (int i = 0; i < n; i++)
            vals[i] = Integer.parseInt(serial[i]);

        TreeNode root = new TreeNode();
        TreeNode temp = root;

        if (vals[0] == -1001)
            return null;

        root.val = vals[0];

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(temp);

        for (int i = 1; i < n; i += 2){

            TreeNode node = nodes.poll();

            if (vals[i] == -1001)
                node.left = null;
            else if(vals[i] != -1001){
                TreeNode left = new TreeNode(vals[i]);
                node.left = left;
                nodes.add(left);
            }

            if (vals[i+1] == -1001)
                node.right = null;
            else if (vals[i+1] != -1001){
                TreeNode right = new TreeNode(vals[i+1]);
                node.right = right;
                nodes.add(right);
            }

        }

        return root;

    }
}
