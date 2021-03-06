package lv.aaa.tree;

import java.util.Arrays;

/**
 * å æåº
 * @author lvweichen ðº â â â â¦â¦ ï¸ð
 * @date 2022/4/21 ä¸å1:44
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {12,4,325,6,2,6,3,643,26,3,23,5,32};
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            compare(arr,i,arr.length);
        }
        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            compare(arr,0,i);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * äº¤æ¢æ°å­ï¼
     * @param arr æ 
     * @param i è¦æ¯è¾çæ çæ ¹èç¹
     */
    public static void compare(int[] arr,int i,int len){
        int temp = arr[i];
        // j = i * 2 + 1 è§£éï¼åç¬¬iä¸ªæ ¹èç¹çå·¦å­èç¹
        for (int j = i * 2 + 1; j < len; j = j * 2 + 1) {
            //è¯´æå·¦å­èç¹å°äºå³å­èç¹
            if(j + 1 < len && arr[j] > arr[j + 1]){
                //ä¸ºäºé¿åå³å­èç¹ä¸é¢è¿æå­èç¹æ°æ®,ç»§ç»­å¾ªç¯
                j = j + 1;
            }
            if(temp > arr[j]){
                //æ­¤æ¶jä¸å®æ¯å¤§çå­èç¹çç´¢å¼
                arr[i] = arr[j];
                arr[j] = temp;
                i = j;
            }
        }
    }
}
