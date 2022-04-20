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
        }
        if(pre != null && pre.getRight() == null){
            pre.setRight(root);
        }
        pre = root;
        binaryTree(root.getRight());
    }
    
}
