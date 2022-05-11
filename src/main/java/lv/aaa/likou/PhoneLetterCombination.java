package lv.aaa.likou;

import java.util.*;

/**
 * 字母组合
 * 
 * 回溯算法，牢记今天的耻辱
 * 
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/5/11 上午10:04
 */
public class PhoneLetterCombination {

    public static void main(String[] args) {
    }
    
    List<String> resultList = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        // 首先要做一个映射表。Map<char,char[]> digits 进行分割，拿到每一个字符集合，
        // 遍历该集合，从前往后，第一个字符，匹配后面所有字符组合的可能，然后第二个字符，同样的操作
        // 从前往后匹配所有字符……，直到遍历到该集合的长度 - 2，最后一个字符不做操作。
        List<String> list = new ArrayList<>();
        Map<String,String[]> MAP = new HashMap<>();
        MAP.put("2",new String[]{"a","b","c"});
        MAP.put("3",new String[]{"d","e","f"});
        MAP.put("4",new String[]{"g","h","i"});
        MAP.put("5",new String[]{"j","k","l"});
        MAP.put("6",new String[]{"m","n","o"});
        MAP.put("7",new String[]{"p","q","r","s"});
        MAP.put("8",new String[]{"t","u","v"});
        MAP.put("9",new String[]{"w","x","y","z"});
        String[] split = digits.split("");
        if(split.length == 1){
            return Arrays.asList(MAP.get(split[0]));
        }
        test(split,0,MAP);
        return resultList;
    }
    
    StringBuilder result = new StringBuilder();
    
    public void test(String[] splits,int index,Map<String,String[]> map){
        if(index == splits.length){
            resultList.add(result.toString());
            return;
        }
        String[] strings = map.get(splits[index]);
        for (int i = 0; i < strings.length; i++) {
            result.append(strings[i]);
            test(splits,index+1,map);
            result.delete(result.length()-1,result.length());
        }
    }
    
}
