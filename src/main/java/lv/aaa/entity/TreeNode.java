package lv.aaa.entity;

/**
 * @author lvweichen πΊ β β β β¦β¦ οΈπ
 * @date 2022/7/21 δΈε3:39
 */
public class TreeNode {
    public int      val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
