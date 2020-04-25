package day5;

/**
 * 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 思路
 *
 * 1.通过递归，找到叶子结点，叶子结点就是1，然后往上层层返回，如果兄弟节点比较，选择深度大的。
 *
 * O（n），O（1）
 */
public class maximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return root == null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
