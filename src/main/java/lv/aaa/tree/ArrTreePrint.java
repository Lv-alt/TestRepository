package lv.aaa.tree;

/**
 * 顺序存储二叉树遍历 后序遍历
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/4/18 下午3:04
 */
public class ArrTreePrint {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Tree tree = new Tree(arr);
        tree.print(0);
    }
}

class Tree{
    int[] arr;
    
    public Tree(int arr[]){
        this.arr = arr;
    }
    
    public void print(int index){
        if(arr == null || arr.length == 0 || index < 0){
            System.out.println("入参error");
            return;
        }
        // 向左遍历
        if(index * 2 + 1 < arr.length){
            print(index * 2 + 1);
        }
        if(index * 2 + 2 < arr.length){
            print(index * 2 + 2);
        }
        System.out.println(arr[index]);
    }
}
