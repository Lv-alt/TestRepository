package lv.aaa.likou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/4/21 下午3:14
 */
public class StringNotRepeatMax {

    public static void main(String[] args) {
        int i = 10;
        System.out.println(i << 1);
    }
    public static int lengthOfLongestSubstring(String s) {
        String[] targetChars = s.split("");
        if (targetChars.length <= 1) {
            return "".equals(s) ? 0 : 1;
        }
        int index = 0;
        List<Integer> nums = new ArrayList();
        int i = 0;
        Map<String,Integer> hash = new HashMap();
        while(i < targetChars.length){
            if(hash.containsKey(targetChars[i])){
                nums.add(i - index);
                index++;
                hash.clear();
                i = index;
                continue;
            }else{
                if(i == targetChars.length - 1){
                    if(!hash.containsKey(targetChars[i])){
                        nums.add(targetChars.length - index);
                    }
                }
            }
            hash.put(targetChars[i],1);
            i++;
        }
        List<Integer> collect = nums.stream().sorted().collect(Collectors.toList());
        return collect.size() == 0 ? hash.size() : collect.get(collect.size() - 1);
    }
}
