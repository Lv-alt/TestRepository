package lv.aaa.tree;

/**
 * 线索化二叉🌲
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/4/20 上午10:00
 */
public class IndexTree {
    
    private Node rootNode;
    private Node pre = null;
    
    public IndexTree(Node rootNode){
        this.rootNode = rootNode;
    }
    
    public void binaryTree(){
        this.binaryTree(this.rootNode);
    }
    
    private void binaryTree(Node root){
        if(root == null){
            return;
        }
        //递归到最左叶子节点
        binaryTree(root.getLeft());
        if(root.getLeft() == null){
            root.setLeft(pre);
            root.setLeftType(1);
        }
        if(pre != null && pre.getRight() == null){
            pre.setRight(root);
            pre.setRightType(1);
        }
        pre = root;
        binaryTree(root.getRight());
    }

    /**
     * 线索化中序遍历
     */
    public void printNode(){
        Node templateNode = rootNode;
        while(templateNode != null){
            //定位到最左叶子节点
            while(templateNode.getLeftType() == 0){
                templateNode = templateNode.getLeft();
            }
            System.out.println(templateNode.getNum());
            while(templateNode.getRightType() == 1){
                templateNode = templateNode.getRight();
                System.out.println(templateNode.getNum());
            }
            templateNode = templateNode.getRight();
        }
    }
    
}
