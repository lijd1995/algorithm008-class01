package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class inorderTraversal {
    // 1.递归，中序遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }
    public void inorder(TreeNode root,List<Integer> list){
        if(root != null){
            // 左
            if (root.left != null) inorder(root.left,list);
            // 中
            list.add(root.val);
            // 右
            if (root.right != null) inorder(root.right,list);
        }
    }

    // 2.通过栈进行遍历,模拟递归的场景:q:

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (stack.size() > 0 || root != null){
            if(root != null){
                stack.add(root);
                root = root.left;
            }else{
                TreeNode pop = stack.pop();
                list.add(pop.val);
                root = pop.right;
            }
        }
        return list;
    }
}
