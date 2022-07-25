package lv.aaa.aspect;

import lombok.extern.slf4j.Slf4j;
import lv.aaa.annotation.RedisLock;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/7/20 下午4:58
 */
@Aspect
@Slf4j
@Component
public class RedisLockAspect {

    @Autowired
    private RedisTemplate redisTemplate;

    @Pointcut("@annotation(lv.aaa.annotation.RedisLock)")
    public void targetMethod() {
    }

    @Around("targetMethod()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        //目标方法
        Method method = signature.getMethod();
        //目标参数
        Object[] args = pjp.getArgs();
        RedisLock annotation = method.getAnnotation(RedisLock.class);
        for (Object arg : args) {
            System.out.println();
        }
        String key = annotation.prefix() + annotation.key();
        //加锁
        if (StringUtils.isNotBlank(key)) {
            if (redisTemplate.opsForValue().increment(key) > 1) {
                throw new RuntimeException("请求正在处理中，请稍后再试");
            }
        }
        try {
            return pjp.proceed();
        } finally {
            redisTemplate.delete(key); 
        }
    }

}
