package com.cssrc.controller;

import com.cssrc.entity.StudentEntity;
import com.cssrc.service.IStudentService;
import com.cssrc.util.CommonAjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @RequestMapping("list")
    @ResponseBody
    public CommonAjaxResponse<List<StudentEntity>> getAllStudents(){
        return new CommonAjaxResponse<>("请求成功",true,studentService.getAllStudents());
    }

    @RequestMapping("saveStudent")
    @ResponseBody
    public CommonAjaxResponse<StudentEntity> saveStudent(){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setAge(0l);
        studentEntity.setBirth(new Date());
        studentEntity.setName("潘端端");
        studentService.saveStudent(studentEntity);
        return new CommonAjaxResponse<>("请求成功",true,studentEntity);
    }

}
