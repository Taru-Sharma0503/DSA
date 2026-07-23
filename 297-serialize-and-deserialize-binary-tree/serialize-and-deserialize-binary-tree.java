/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        
        StringBuilder ans=new StringBuilder();
        LinkedList<TreeNode> q=new LinkedList<>();
        q.add(root);

        ans.append(root.val);
        ans.append(',');
        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                TreeNode node=q.removeFirst();
                if(node==null)
                    continue;

                if(node.left==null)
                    ans.append(1001);
                else
                    ans.append(node.left.val);
                ans.append(',');

                if(node.right==null)
                    ans.append(1001);
                else
                    ans.append(node.right.val);
                ans.append(',');

                q.addLast(node.left);
                q.addLast(node.right);
            }
        }

        ans.setLength(ans.length()-1);
        return ans.toString(); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)
            return null;
        
        String head[]=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(head[0]));
        LinkedList<TreeNode> q=new LinkedList<>();
        int i=0;

        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.removeFirst();

            if(curr==null)
                continue;
            
            if(head[2*i+1].equals("1001"))
                curr.left=null;
            else
                curr.left=new TreeNode(Integer.parseInt(head[2*i+1]));
            
            if(head[2*i+2].equals("1001"))
                curr.right=null;
            else
                curr.right=new TreeNode(Integer.parseInt(head[2*i+2]));
            
            q.add(curr.left);
            q.add(curr.right);
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));