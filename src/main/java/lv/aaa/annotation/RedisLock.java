package lv.aaa.annotation;

import java.lang.annotation.*;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/7/20 下午4:52
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisLock {

    /**
     * 锁的前缀
     * @return value
     */
    String prefix() default "";

    /**
     * 锁的key
     * @return key
     */
    String key() default "";
    
}
