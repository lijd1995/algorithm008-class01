import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class maxSlidingWindow {

    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k];
        int index=0;
        int[] temp = new int[k];
        if(k == 1) return nums;
        for(int i=0;i<nums.length-k;i++){
            for(int j=0;j<k-1;j++){
                temp[j] = nums[i+j];
            }
            Arrays.sort(temp);
            res[index++] = temp[k-1];
        }
        return res;
    }
}
