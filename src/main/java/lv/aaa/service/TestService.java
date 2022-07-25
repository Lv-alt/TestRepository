package lv.aaa.service;

import lv.aaa.annotation.RedisLock;
import lv.aaa.entity.TreeNode;
import org.springframework.stereotype.Service;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/7/21 上午9:42
 */
@Service
public class TestService {
    
    @RedisLock(prefix = "testService",key = "testKey")
    public String testService(String name){
        //模拟4秒业务处理
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) { 
            e.printStackTrace();
        }
        return "success";
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode( 1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(-1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(1);
        System.out.println(isBalanced(root));

    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        boolean result = isTrue(root);
        if(!result){
            return result;
        }
        //每个节点都应该判断一下
        if(root.left != null){
            result = isBalanced(root.left);
        }
        if(!result){
            return result;
        }
        if(root.right != null){
            result = isBalanced(root.right);
        }
        return result;
    }

    /**
     * 判断一个树点是否是平衡二叉树
     * @return
     */
    public static boolean isTrue(TreeNode root){
        if(getHeight(root.left) - getHeight(root.right) > 1){
            return false;
        }
        if(getHeight(root.right) - getHeight(root.left) > 1){
            return false;
        }
        return true;
    }
    
    public static int getHeight(TreeNode root)
    {
        if(root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }    
}
