package lowestCommonAncestor;

public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        if (left != null && left != p && left != q) return left;
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null)
            return root;
        else
            return  left == null?right:left;
    }
}
