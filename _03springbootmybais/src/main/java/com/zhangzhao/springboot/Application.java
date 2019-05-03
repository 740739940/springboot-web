package com.zhangzhao.springboot;/**
 * @Author zhangzhao
 * @Date 2019/5/1 20:23
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.swing.*;

/**
 *@ClassName Application
 *@Description 启动类
 *@Author zhangzhao
 *@Date 2019/5/1 20:23
 *@Version 1.0
 */
@SpringBootApplication
@MapperScan(basePackages="com.zhangzhao.springboot.mapper")
//开启springboot事务的支持
@EnableTransactionManagement
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
