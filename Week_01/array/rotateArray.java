package array;

public class rotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 1 || k%nums.length == 0) return;;
        // 对k进行取余
        k = k%nums.length;
        // 数组倒叙
        reverse(nums,0,nums.length-1);
        // 互换两边
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i<j){
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j] = temp;
            i++;j--;
        }
    }
}
