package 递归;

public class isValidBST {
    static boolean flag = true;
    public static boolean isValidBST(TreeNode root) {
        recur(root);
        return flag;
    }

    private static void recur(TreeNode root) {
        // 终结条件
        if (root == null || flag == false){
            return;
        }
        // 逻辑处理,左子树小于当前层，并且右子树大于当前层
        if ((root.left != null && root.left.val > root.val)||
                (root.right != null && root.right.val < root.val))
            flag = false;
        // 调用下一层
        recur(root.left);
        recur(root.right);
        // 清理当前层
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(4);
        root.left = root1;
        root.right = root2;
        isValidBST(root);
    }


}
