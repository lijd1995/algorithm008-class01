package subsets;

import java.util.ArrayList;
import java.util.List;

public class subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        dfs(result,nums,new ArrayList<Integer>(),0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, ArrayList<Integer> list, int level) {
        // terminal
        if (level == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        // process current logic 可选择，或者不选择  // drill down
        dfs(result,nums,list,level+1);
        list.add(nums[level]);
        dfs(result,nums,list,level+1);
        // restore current status;
        list.remove(list.size()-1);
    }
}
