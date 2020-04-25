package homework;

/**
 * 二叉树最大深度
 *
 * 思路
 *
 * 1.递归
 * 2. 使用栈模拟递归
 */
public class maxDepth {

    public int maxDepth(TreeNode root) {
        return root == null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
