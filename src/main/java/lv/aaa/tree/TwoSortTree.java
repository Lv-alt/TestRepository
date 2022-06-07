package lv.aaa.tree;

/**
 * 二叉排序树
 *
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/5/18 下午2:12
 */
public class TwoSortTree {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9 , 2};
        builderTree(arr);
    }

    static BasicsNode basicsNode = null;

    public static void builderTree(int[] arr) {
        basicsNode = new BasicsNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            builderTree(basicsNode, new BasicsNode(arr[i]));
        }
        foreach(basicsNode);
        deleteNode(basicsNode, 7);
    }

    public static void deleteNode(BasicsNode root, int value) {
        //先找到要删除的目标节点的父级节点
        BasicsNode targetNode = queryTargetNode(root, value);
        BasicsNode parentNode = queryParentNode(root, value);
        //如果删除的是叶子节点
        if(targetNode.getLeft() == null && targetNode.getRight() == null){
            if(parentNode.getData() > targetNode.getData()){
                parentNode.setLeft(null);
            }else{
                parentNode.setRight(null);
            }
            
        } else if(targetNode.getLeft() != null && targetNode.getRight() != null){
            //遍历targetNode 这颗tree的右子树中最左子节点
            int temp = getMin(targetNode.getRight());
            targetNode.setData(temp);
        } else {
            // 只有一个节点
            if(targetNode.getLeft() != null){
                if(parentNode.getData() > targetNode.getData()){
                    parentNode.setLeft(targetNode.getLeft());
                } else {
                    parentNode.setRight(targetNode.getLeft());
                }
            }else{
                if(parentNode.getData() > targetNode.getData()){
                    parentNode.setLeft(targetNode.getRight());
                } else {
                    parentNode.setRight(targetNode.getRight());
                }
            }
        }
        System.out.println("删除后-----------------");
        foreach(root);
    }
    
    public static int getMin(BasicsNode root){
        if(root.getLeft() != null){
            return getMin(root.getLeft());
        }
        int temp = root.getData();
        deleteNode(basicsNode,temp);
        return temp;
    }

    public static BasicsNode queryTargetNode(BasicsNode root, int value) {
        if(root == null){
            return null;
        }
        if (root.getData() == value) {
            return root;
        } else if (root.getData() > value) {
            //向左遍历
            return queryTargetNode(root.getLeft(), value);
        } else {
            return queryTargetNode(root.getRight(), value);
        }
    }
    
    public static BasicsNode queryParentNode(BasicsNode root,int value){
        if((root.getLeft() != null && root.getLeft().getData().equals(value)) || (root.getRight() != null && root.getRight().getData().equals(value))){
            return root;    
        }
        if(root.getData() > value){
            if(root.getLeft() != null){
                return queryParentNode(root.getLeft(),value);
            }
        }else{
            if(root.getRight() != null){
                return queryParentNode(root.getRight(),value);
            }
        }
        return null;
    }


    public static void foreach(BasicsNode root) {
        if (root.getLeft() != null) {
            foreach(root.getLeft());
        }
        System.out.println(root);
        if (root.getRight() != null) {
            foreach(root.getRight());
        }
    }

    public static void builderTree(BasicsNode root, BasicsNode targetNode) {
        if (targetNode.getData() >= root.getData()) {
            if (root.getRight() == null) {
                root.setRight(targetNode);
            } else {
                builderTree(root.getRight(), targetNode);
            }
        } else {
            if (root.getLeft() == null) {
                root.setLeft(targetNode);
            } else {
                builderTree(root.getLeft(), targetNode);
            }
        }
    }


}
