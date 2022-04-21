package lv.aaa.tree;

import java.util.Arrays;

/**
 * 堆排序
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/4/21 下午1:44
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
     * 交换数字，
     * @param arr 树
     * @param i 要比较的树的根节点
     */
    public static void compare(int[] arr,int i,int len){
        int temp = arr[i];
        // j = i * 2 + 1 解释：取第i个根节点的左子节点
        for (int j = i * 2 + 1; j < len; j = j * 2 + 1) {
            //说明左子节点小于右子节点
            if(j + 1 < len && arr[j] > arr[j + 1]){
                //为了避免右子节点下面还有子节点数据,继续循环
                j = j + 1;
            }
            if(temp > arr[j]){
                //此时j一定是大的子节点的索引
                arr[i] = arr[j];
                arr[j] = temp;
                i = j;
            }
        }
    }
}
