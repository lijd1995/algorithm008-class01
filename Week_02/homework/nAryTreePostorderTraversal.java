package homework;

import java.util.ArrayList;
import java.util.List;

public class nAryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList();
        postorder(root,res);
        return res;
    }

    public void postorder(Node root,List<Integer> res){
        if (root == null) return;
        for(Node node:root.children){
            postorder(node,res);
        }
        res.add(root.val);
    }
}
