package homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历
 *
 * 思路：BFS，通过队列的方式
 *
 * 先将值存放到队列中，队列下一次存的值就是此次队列的 children
 */
public class levelOrder {
    // BFS
//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) return res;
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        while(!queue.isEmpty()){
//            List<Integer> level = new ArrayList<>();
//            int size = queue.size();
//            for (int i=0;i<size;i++){
//                level.add(queue.peek().val);
//                queue.addAll(queue.poll().children);
//            }
//            res.add(level);
//        }
//        return res;
//    }

    // 递归
    public List<List<Integer>> levelOrder(Node root) {
        return levelOrder(root, 0, new ArrayList<>());
    }

    private List<List<Integer>> levelOrder(Node node, int level, List<List<Integer>> order){
        if (node == null){
            return order;
        }
        List<Integer> list = order.size() > level ?  order.get(level) : new ArrayList<>();
        list.add(node.val);
        if (order.size() <= level){
            order.add(list);
        }
        for (Node n : node.children){
            levelOrder(n, level + 1, order);
        }
        return order;
    }
}
