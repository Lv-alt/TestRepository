package lv.aaa.controller;

import lv.aaa.config.StartInitData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/Test")
public class TestController {

    @Autowired
    StartInitData startInitData;


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
        List<int[]> arrayList = new ArrayList<int[]>();
        int[] array1 = {1,2,345,56};
        int[] array2 = {1,2,345,56,452};
        int[] array3 = {1,2,345,56,1,1,1,1,1}; 
        int[] array4 = {1,2,345,561,1,1,1,};
        int[] array5 = {1,2};
        arrayList.add(array1);
        arrayList.add(array2);
        arrayList.add(array3);
        System.out.println();
        arrayList.add(array4);
        arrayList.add(array5);
        Map<Integer, List<int[]>> collect = arrayList.stream().collect(Collectors.groupingBy(item -> item.length));
        collect.forEach((item,itemTwo) -> {
            System.out.println(item+"       =>          "+itemTwo);
        });
    }

}
