package homework;

import java.util.*;

public class binaryTreePreorderTraversal {
    // 1.递归 前序遍历 中 左 右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return  res;

    }
    public void inorder(TreeNode root, List<Integer> res){
        if(root != null){
            res.add(root.val);
            if (root.left!=null)
                inorder(root.left,res);
            if (root.right!=null)
                inorder(root.right,res);
        }
    }
    // 2. 使用队列的方式
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode p = root;
        Deque<TreeNode> queue = new LinkedList();
        while (queue.size()>0||p!=null){
            while (p!=null){
                res.add(p.val);
                queue.push(p);
                p = p.left;
            }
            p = queue.pop().right;
        }
        return  res;
    }
}
