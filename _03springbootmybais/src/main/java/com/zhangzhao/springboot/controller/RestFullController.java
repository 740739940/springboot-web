package com.zhangzhao.springboot.controller;/**
 * @Author zhangzhao
 * @Date 2019/5/1 22:11
 */

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName RestFullController
 *@Description TODO
 *@Author zhangzhao
 *@Date 2019/5/1 22:11
 *@Version 1.0
 */
@RestController
public class RestFullController {


    @RequestMapping("/boot/user/{id}")
    public Object user(@PathVariable String id){
        System.out.print("-============" + id);
        return id;

    }

}
