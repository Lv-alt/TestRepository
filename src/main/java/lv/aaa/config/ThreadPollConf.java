package lv.aaa.config;

import lombok.Setter;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lvweichen 
 * @date 2022/7/5 下午4:32
 */
@Configuration
@ConfigurationProperties(prefix = "executor")
@Setter
public class ThreadPollConf {
    
    private Integer core_count;
    
    private Integer max_count;
    
    private Integer time_out;
    
    private final static TimeUnit UNIT = TimeUnit.SECONDS;
    
    private final static LinkedBlockingQueue<Runnable> QUEUE = new LinkedBlockingQueue<>();
    
    public final static List<LinkedBlockingQueue<String>> QUEUE_LIST = new ArrayList<>();
    
    public final static Integer QUEUE_COUNT = 5;

    public static final File file = new File(File.separator+"Users"+File.separator+"lvweichen"+File.separator+"bigData.txt");
    
    static {
        for (int i = 0; i < QUEUE_COUNT; i++) {
            QUEUE_LIST.add(new LinkedBlockingQueue());
        }
    }
    
    @Bean
    public Executor createExecutor(){
        return new ThreadPoolExecutor(core_count,max_count,time_out,UNIT,QUEUE);
    }

    public static void main(String[] args) throws Exception {
        long beginTime = System.currentTimeMillis();
        if(!file.exists()){
            file.createNewFile();
        }
        final BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
        //添加队列，使用多线程来处理数据
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if(i % 100000 == 0){
                bos.write(randomData()+"。");
                bos.write("\n");
                continue;
            }
            bos.write(randomData()+",");
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - beginTime));
    } 
    
    private static String randomData(){
        return String.valueOf(RandomUtils.nextInt(0,100));
    }
}
