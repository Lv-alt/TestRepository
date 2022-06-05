package lv.aaa.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * 比较基础的Node 之后 data left right 
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/5/18 下午2:13
 */
@Getter
@Setter
public class BasicsNode {
    private Integer data;
    private BasicsNode left;
    private BasicsNode right;

    public BasicsNode(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BasicsNode{" +
                "data=" + data +
                '}';
    }
}

