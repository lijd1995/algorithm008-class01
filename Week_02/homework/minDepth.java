package homework;

/**
 * 二叉树最大深度
 *最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * 思路
 *
 * 1.递归
 * 2.使用栈模拟递归
 */
public class minDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        return root.left == null || root.right == null ? m1+m2+1:Math.min(m1,m2)+1;
    }
}
