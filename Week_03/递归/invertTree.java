package 递归;

public class invertTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        // 终结条件
        if (node == null){
            return;
        }
        // 逻辑处理,左右翻转
        TreeNode right = node.right;
        node.right = node.left;
        node.left = right;

        // 调用下一层
        invert(node.left);
        invert(node.right);
        // 清理当前层内容
    }


}
