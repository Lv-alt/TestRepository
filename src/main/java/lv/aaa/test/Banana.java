package lv.aaa.test;

import org.springframework.stereotype.Component;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/7/15 上午10:56
 */
@Component("banana")
public class Banana implements Fruits {
    @Override
    public String name() {
        return "香蕉";
    }
}
