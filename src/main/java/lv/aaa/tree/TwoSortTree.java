package lv.aaa.tree;

/**
 * 二叉排序树
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/5/18 下午2:12
 */
public class TwoSortTree {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9};   
        builderTree(arr);
    }
    
    public static void builderTree(int[] arr){
        BasicsNode root = new BasicsNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            builderTree(root,new BasicsNode(arr[i]));
        }
        foreach(root);
    }
    
    public static void foreach(BasicsNode root){
        if(root.getLeft() != null){
            foreach(root.getLeft());
        }
        System.out.println(root);
        if(root.getRight() != null){
            foreach(root.getRight());
        }
    }
    
    public static void builderTree(BasicsNode root,BasicsNode targetNode){
        if(targetNode.getData() >= root.getData()){
            if(root.getRight() == null){
                root.setRight(targetNode);
            }else{
                builderTree(root.getRight(),targetNode);
            }
        }else{
            if(root.getLeft() == null){
                root.setLeft(targetNode);
            }else{
                builderTree(root.getLeft(),targetNode);
            }
        }
    }
    
    
}
