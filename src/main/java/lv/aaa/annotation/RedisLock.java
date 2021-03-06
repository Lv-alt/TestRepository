package lv.aaa.annotation;

import java.lang.annotation.*;

/**
 * @author lvweichen πΊ β β β β¦β¦ οΈπ
 * @date 2022/7/20 δΈε4:52
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisLock {

    /**
     * ιηεηΌ
     * @return value
     */
    String prefix() default "";

    /**
     * ιηkey
     * @return key
     */
    String key() default "";
    
}
