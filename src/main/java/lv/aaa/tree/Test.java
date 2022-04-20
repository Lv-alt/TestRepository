package lv.aaa.tree;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/4/20 上午10:22
 */
public class Test {
    public static void main(String[] args) {
        Node root = new Node(1,"a");
        Node node1 = new Node(3,"b");
        Node node2 = new Node(6,"c");
        Node node3 = new Node(8,"d");
        Node node4 = new Node(10,"e");
        Node node5 = new Node(14 ,"f");
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        IndexTree tree = new IndexTree(root);
        tree.binaryTree();

        System.out.println(node5.getLeft().getNum());
        System.out.println(node5.getRight().getNum());
        
    }
}
