package lv.aaa.controller;


import lv.aaa.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.LockSupport;

@RestController
@RequestMapping("/testNacos")
public class NewController {
    
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private TestService testService;
    
    @GetMapping("/testRedis")
    public String testRedis(){
        try {
            return testService.testService("lvweichen");
        } catch (Exception e){
            return e.getMessage();
        }
    }
    
    @GetMapping("/setRedis")
    public String setRedis(){
        redisTemplate.opsForValue().set("age","aaaaa");
        return "success";
    }
    
    
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("进来，阻塞");
            LockSupport.park();
            System.out.println("第一次唤醒：阻塞");
            LockSupport.park();
            System.out.println("第二次唤醒");
        },"A");
        thread.start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(thread);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(thread);
        },"B").start();
        
    }
    
}
