package lv.aaa.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/7/4 上午10:28
 */
@FeignClient(url = "localhost:8080",name = "localhost")
public interface TestFeign {
    
    @RequestMapping("/api/prudential/v1/ipd/admission")
    Object testRequest(@RequestBody PltClaimIpdAdmissionRequest request, @RequestHeader MultiValueMap<String,String> map);
    
}
