package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * 左 中 右
 */
public class binaryTreeInorderTraversal {
    /**
     * 使用递归
     * @param root
     * @return
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        inorder(root,res);
//        return  res;
//
//    }
//
//    public void inorder(TreeNode root, List<Integer> res){
//        if (root.left!=null)
//            inorder(root.left,res);
//        res.add(root.val);
//        if (root.right!=null)
//            inorder(root.right,res);
//    }

    /**
     * 通过栈的方式
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return  res;
    }

}


