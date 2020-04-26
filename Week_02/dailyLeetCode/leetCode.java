import day5.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 给定一个二叉树，判断它是否是高度平衡的二叉树。

 本题中，一棵高度平衡二叉树定义为：

 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class leetCode {
    public boolean isBalanced(TreeNode root) {
        return dept(root)!=-1;
    }

    public int dept(TreeNode root) {
        if (root == null) return 0;
        int left = dept(root.left);
        if (root == -1) return -1;
        int right = dept(root.right);
        if (root == -1) return -1;
        return Math.abs(left-right) < 2?Math.max(left,right)+1:-1;

    }
}
