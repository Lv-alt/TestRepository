package lv.aaa.test;

import org.springframework.stereotype.Component;

/**
 * @author lvweichen πΊ β β β β¦β¦ οΈπ
 * @date 2022/7/15 δΈε10:56
 */
@Component("banana")
public class Banana implements Fruits {
    @Override
    public String name() {
        return "ι¦θ";
    }
}
