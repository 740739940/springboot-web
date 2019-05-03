package com.zhangzhao.springboot.mapper;

import com.zhangzhao.springboot.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectAllStudent();

}