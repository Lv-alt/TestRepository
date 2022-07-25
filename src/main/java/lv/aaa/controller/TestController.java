package lv.aaa.controller;

import lv.aaa.config.StartInitData;
import lv.aaa.config.ThreadPollConf;
import lv.aaa.service.PltClaimIpdAdmissionRequest;
import lv.aaa.service.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/Test")
public class TestController {

    @Autowired
    private StartInitData startInitData;
    @Autowired
    private TestFeign testFeign;
    @Resource
    private Executor executor;
    
    private static Map<String,AtomicInteger> HASH = new ConcurrentHashMap<>();
    
    @PostMapping("/testFeign")
    public String testFeign(@RequestBody PltClaimIpdAdmissionRequest request){
        MultiValueMap<String,String> map = new HttpHeaders();
        map.put("Authorization", Collections.singletonList("Bearer 34ac6451-ef56-45a4-8f3b-b705ccf9ecd1"));
        map.put("x-za-tenant", Collections.singletonList("prudential"));
        Object result = testFeign.testRequest(request, map);
        System.out.println("线程执行完毕");
        return "aa";
    }

    /**
     * 生产
     * @return
     */
    private boolean customerFlag = true;
    
    @GetMapping("/handleData")
    public String handleData() throws Exception {
        AtomicInteger rowCount = new AtomicInteger();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ThreadPollConf.file), "utf-8"));
        new Thread(() -> {
            String line;
            while(true){
                try {
                    if (((line = br.readLine()) == null)){
                        break;
                    }
                    int index = rowCount.get() % ThreadPollConf.QUEUE_COUNT;
                    ThreadPollConf.QUEUE_LIST.get(index).add(line);
                    rowCount.getAndIncrement();
                    if(rowCount.get() % 2000 == 0){
                        System.out.println("生产20行了");
                    }
                } catch (IOException e) {
                    System.out.println("报错，终止while");
                    e.printStackTrace();
                    break;
                }
            }
        }).start();
        //消息生产完毕，停止消费
        customerFlag = false;        
        return "success";
    }
    
    // 1000000步长打印一次
    private volatile AtomicInteger step = new AtomicInteger();

    /**
     * 消费
     */
    @GetMapping("/consumer")
    public String consumer(){
        for (int i = 0 ; i < ThreadPollConf.QUEUE_LIST.size() ; i++) {
            final int index = i;
            executor.execute(() -> {
                LinkedBlockingQueue<String> queue = ThreadPollConf.QUEUE_LIST.get(index);
                while(true){
                    //有两种可能，1是消费太快 生产不及时，该线程睡1秒，2是生产完毕 消费完毕。结束循环
                    if(queue.isEmpty() && !customerFlag){
                        //表示已经生产完毕，并且消费完毕 结束循环
                        break;
                    }
                    if(queue.isEmpty() && customerFlag){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String content = queue.poll();
                    Stream.of(content.split(",")).forEach(item -> HASH.computeIfAbsent(item, k -> new AtomicInteger(0)).getAndIncrement());
                    step.getAndIncrement();
                    if(step.get() % 1000 == 0){
                        Integer maxValue = 0;
                        String resultKey = "";
                        for (String key : HASH.keySet()) {
                            if(maxValue < HASH.get(key).get()){
                                maxValue = HASH.get(key).get();
                                resultKey = key;
                            }
                        }
                        System.out.println("当前出现最多的数字是："+resultKey+"，次数："+maxValue);
                    }
                }
            });
        }
        return "success";
    }


    @GetMapping("/testMethod")
    public Object test(){
        Map<String, Object> map = startInitData.getMap();
        if(map.containsKey("name")){
            Arrays.asList("1","2","3","4");
            return "Map 中包含这个key";
        }
        return startInitData.getMap().get("name");
    }

    public static void main(String[] args) {
        //输出cpu核数 System.out.println(Runtime.getRuntime().availableProcessors()); //返回java虚拟机试图使用的最大内存量
        long maxMemory = Runtime.getRuntime().maxMemory(); //返回java虚拟机中的内存总量
        long totalMemory = Runtime.getRuntime().totalMemory(); 
        System.out.println("totalMemory = "+totalMemory+"(字节)，"+
                (maxMemory/(double)1024/1024)+"MB"); 
        System.out.println("totalMemory = "+totalMemory+"(字节)，"+
                (totalMemory/(double)1024/1024)+"MB");
    }
    
    

}
