package lv.aaa.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树 
 * 什么是赫夫曼树？wpl最小
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/5/10 下午4:19
 */
public class HfmsTree {

    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        List<HfNode> list = new ArrayList<>();
        for (int item : arr) {
            list.add(new HfNode(item));    
        }
        while(list.size() > 1){
            Collections.sort(list);
            HfNode leftNode = list.get(0);
            HfNode rightNode = list.get(1);
            HfNode root = new HfNode(leftNode.getValue() + rightNode.getValue());
            root.setLeft(leftNode);
            root.setRight(rightNode);
            list.add(root);
            list.remove(leftNode);
            list.remove(rightNode);
        }
        print(list.get(0));
    }
    public static void print(HfNode root){
        System.out.println(root.getValue());
        if(root.getLeft() != null){
            print(root.getLeft());
        }
        if(root.getRight() != null){
            print(root.getRight());
        }
    }
    
}

class HfNode implements Comparable<HfNode>{
    private Integer value;
    private HfNode left;
    private HfNode right;
    
    public HfNode(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public HfNode getLeft() {
        return left;
    }

    public void setLeft(HfNode left) {
        this.left = left;
    }

    public HfNode getRight() {
        return right;
    }

    public void setRight(HfNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HfNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(HfNode o) {
        return this.value - o.getValue();
    }
}
