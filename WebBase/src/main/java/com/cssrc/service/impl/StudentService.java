package com.cssrc.service.impl;

import com.cssrc.dao.IStudentDAO;
import com.cssrc.entity.StudentEntity;
import com.cssrc.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
@Service
public class StudentService implements IStudentService{

    @Autowired
    IStudentDAO studentDAO;

    public List<StudentEntity> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public Boolean saveStudent(StudentEntity studentEntity) {
        return studentDAO.saveStudent(studentEntity);
    }
}
