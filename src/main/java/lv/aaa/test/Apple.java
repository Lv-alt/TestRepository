package lv.aaa.test;

import org.springframework.stereotype.Component;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/7/15 上午10:55
 */
@Component("apple")
public class Apple implements Fruits {
    @Override
    public String name() {
        return "苹果";
    }
}
