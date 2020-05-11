package subsets;

import java.util.ArrayList;
import java.util.List;

public class test {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        // 回溯
        // 关键内容都要当参数传进去,new ArrayList<Integer>() 存结果，level 代表层级
        dfs(result,nums,new ArrayList<Integer>(),0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, ArrayList<Integer> list, int level) {
        // terminal
        if (level == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        // process current logic
        dfs(result,nums,list,level+1); // pick
        list.add(nums[level]);
        dfs(result,nums,list,level+1); // no pick
        // drill dowm

        // restore current status 改变参数内容需要复原
        list.remove(list.size()-1);
    }
}
