package homework;

public class maximumDepthOfnAryTree {
    public int maxDepth(Node root) {
        if (root == null);
        int max = 0;
        for (Node node : root.children){
            max = Math.max(maxDepth(node),max);
        }
        return max+1;
    }
}
