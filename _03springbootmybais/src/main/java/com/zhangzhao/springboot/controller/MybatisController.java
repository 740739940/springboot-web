package com.zhangzhao.springboot.controller;
import com.zhangzhao.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *@ClassName MybatisController
 *@Description TODO
 *@Author zhangzhao
 *@Date 2019/5/1 20:26
 *@Version 1.0
 */
@RestController
public class MybatisController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/boot/students")
    public  Object students(){
        return studentService.getAllStudent();
    }
}
