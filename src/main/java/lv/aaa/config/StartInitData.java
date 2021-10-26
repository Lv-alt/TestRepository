package lv.aaa.config;

import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class StartInitData {

    //项目启动初始化数据
    public Map<String,Object> InitMap = new HashMap();

    @PostConstruct
    public void initDataMethod(){
        InitMap.put("name","lvweichen");
    }

    public Map<String,Object> getMap(){
        return InitMap;
    }

}
