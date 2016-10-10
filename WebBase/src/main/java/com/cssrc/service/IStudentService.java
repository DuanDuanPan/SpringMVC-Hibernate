package com.cssrc.service;

import com.cssrc.entity.StudentEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public interface IStudentService {

    List<StudentEntity> getAllStudents();
    Boolean saveStudent(StudentEntity studentEntity);
}
