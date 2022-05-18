package lv.aaa.likou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四树之和
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/5/13 下午3:25
 */
public class fourNumSum {
    public static void main(String[] args) {
        int[] num = {2,2,2,2,2};
        int target = 8;
        List<List<Integer>> lists = fourSum(num, target);
        System.out.println();
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length < 4){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        //定义下一个和左右指针
        int next,left,right;
        for (int i = 0; i < nums.length; i++) {
            next = i;
            while(next < nums.length - 3){
                next++;
                left = next + 1;
                right = nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[left] + nums[right] + nums[next];
                    if(result.contains(Arrays.asList(nums[i],nums[left],nums[right],nums[next]))){
                        sum = target+1;
                    }
                    if(sum == target){
                        result.add(Arrays.asList(nums[i],nums[left],nums[right],nums[next]));
                        left++;
                        right--;
                    } else if(sum < target){
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
