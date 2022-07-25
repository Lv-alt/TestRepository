package lv.aaa.likou;

import java.util.List;
import java.util.ArrayList;

/**
 * 括号生成
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/7/25 下午3:57
 */
public class KuoHaoGenerate {

    public static void main(String[] args) {
        generateParenthesis(3).forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);

        return res;
    }

    /**
     * count1统计“(”的个数，count2统计“)”的个数
     * 深度优先搜索算法
     * @param res
     * @param ans
     * @param count1
     * @param count2
     * @param n
     */
    private static void generate(List<String> res , String ans, int count1, int count2, int n){
        if(count1 > n || count2 > n){
            return; // ((())) (()) () 
        }
        if(count1 == n && count2 == n){
            res.add(ans);
        }
        if(count1 >= count2){
            String ans1 = new String(ans);
            generate(res, ans+"(", count1+1, count2, n);
            generate(res, ans1+")", count1, count2+1, n);
            
        }
    }
    
}
