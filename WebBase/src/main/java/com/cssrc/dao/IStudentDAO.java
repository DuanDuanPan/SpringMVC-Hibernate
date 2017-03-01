package com.cssrc.dao;

import com.cssrc.entity.StudentEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public interface IStudentDAO {

    List<StudentEntity> getAllStudents();
    Boolean saveStudent(StudentEntity studentEntity);

    StudentEntity getById(Long student);

    void delete(Long student);
}
