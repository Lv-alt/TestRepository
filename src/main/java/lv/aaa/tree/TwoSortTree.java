package lv.aaa.tree;

import org.apache.commons.lang3.StringUtils;

/**
 * 二叉排序树
 *
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/5/18 下午2:12
 */
public class TwoSortTree {
    public static void main(String[] args) {
        String version = "V3";
        String channelSource = "mfzt_zt69_365";
        if (StringUtils.containsAny(channelSource, "zjx-slj-MF3-BC39")) {
            System.out.println("true");
            return;
        }
    }

    /**
     * 左边旋转
     */
    public static void leftRotate(BasicsNode root){
        BasicsNode newNode = new BasicsNode(root.getData());
        newNode.setRight(root.getRight().getLeft());
        newNode.setLeft(root.getLeft());
        root.setData(root.getRight().getData());
        root.setRight(root.getRight().getRight());
        root.setLeft(newNode);
    }

    /**
     * root节点
     */
    static BasicsNode basicsNode = null;

    public static void builderTree(int[] arr) {
        basicsNode = new BasicsNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            builderTree(basicsNode, new BasicsNode(arr[i]));
        }
        foreach(basicsNode);
    }

    /**
     * 这里删除分三种可能的思路，
     * 一种是删除的节点是叶子节点，一种是删除的节点有一个子节点，一种是删除的节点有两个子节点
     * 如果删除的节点是叶子节点，就是没有任何子节点的节点，直接就把该节点的父节点指向要删除的节点的指针指空就行，
     * 所以还需要判断要删除的节点在父节点的左边还是右边.
     * 第二种情况是 删除的节点有一个子节点 需要把删除的节点（这里为命名为目标节点）下的那个节点挂载到目标节点的父节点（需要做判断）。
     * 第三种情况是 目标节点有两个子节点，左右都有。这时就需要把这个目标节点下最小的那个节点的值 和 目标节点交换，
     * 以上就是删除节点的三种可能的思路。也许会有点绕吧
     * java的垃圾处理机制，会把没有被引用的对象清理掉。
     * @param root
     * @param value
     */
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

    /**
     * 获取以root为根节点下的最小的那个节点的值，并且删除该节点
     * @param root
     * @return
     */
    public static int getMin(BasicsNode root){
        if(root.getLeft() != null){
            return getMin(root.getLeft());
        }
        int temp = root.getData();
        deleteNode(basicsNode,temp);
        return temp;
    }

    /**
     * 获取到要删除的目标节点
     * @param root
     * @param value
     * @return
     */
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

    /**
     * 获取到要删除的目标节点的父节点
     * @param root
     * @param value
     * @return
     */
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

    /**
     * 重载了一下方法，插入节点。
     * @param root 根节点
     * @param targetNode 要插入的节点 
     */
    public static void builderTree(BasicsNode root, BasicsNode targetNode) {
        // 我定义的规则是，如果要插入的节点值和root节点的值相等，就放到root节点的右边
        // 判断目标节点是否 > root节点
        if (targetNode.getData() >= root.getData()) {
            // 如果大于 并且root的右节点为空 就直接把root的右指针 指向目标节点
            if (root.getRight() == null) {
                root.setRight(targetNode);
            } else {
                // 否则递归添加
                builderTree(root.getRight(), targetNode);
            }
        } else {
            // 如果目标节点 < root节点，就往左遍历，思路一样的
            if (root.getLeft() == null) {
                root.setLeft(targetNode);
            } else {
                builderTree(root.getLeft(), targetNode);
            }
        }
        if((getHeight(basicsNode.getRight()) - getHeight(basicsNode.getLeft())) > 1){
            leftRotate(basicsNode);
        }
    }

    /**
     * 获取root节点的高度
     */
    public static Integer getHeight(BasicsNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.getLeft()),getHeight(root.getRight())) + 1;
    }

}
