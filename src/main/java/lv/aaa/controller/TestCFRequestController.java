package lv.aaa.controller;

import lombok.extern.slf4j.Slf4j;
import lv.aaa.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lvweichen πΊ β β β β¦β¦ οΈπ
 * @date 2022/7/15 δΈε2:32
 */
@RestController
@Slf4j
@RequestMapping("/batch")
public class TestCFRequestController {

    @PostMapping("/batchInsertStudent")
    public void batchInsertStudent(List<Student> list){
        
    }
    
}

