package com.zhangzhao.springboot.service.impl;/**
 * @Author zhangzhao
 * @Date 2019/5/1 20:43
 */

import com.zhangzhao.springboot.domain.Student;
import com.zhangzhao.springboot.mapper.StudentMapper;
import com.zhangzhao.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@ClassName StudentServiceImpl
 *@Description 练习
 *@Author zhangzhao
 *@Date 2019/5/1 20:43
 *@Version 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    //注入springboot自动配置好的redisTemplate
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public List<Student> getAllStudent() {

        //redis字符串序列化
        RedisSerializer redisSerializer =  new  StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        //查询缓存
        List<Student> allStudents = (List<Student>) redisTemplate.opsForValue().get("allStudents");
        if(null == allStudents){
            synchronized (this){
                //查询缓存
                allStudents = (List<Student>) redisTemplate.opsForValue().get("allStudents");
                if(null == allStudents){
                    //缓存为空，查询数据库
                    allStudents = studentMapper.selectAllStudent();
                    //存入缓存
                    redisTemplate.opsForValue().set("allStudents", allStudents);
                }
            }
        }

        return allStudents;
    }


}
