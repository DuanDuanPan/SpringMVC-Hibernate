package com.cssrc.controller;

import com.cssrc.entity.StudentEntity;
import com.cssrc.service.IStudentService;
import com.cssrc.util.CommonAjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
@RestController
@RequestMapping("student")
public class StudentController {

    private final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    IStudentService studentService;

    @RequestMapping(value = "/{student}", method = RequestMethod.GET)
    @ResponseBody
    public CommonAjaxResponse<StudentEntity> getStudent(@PathVariable Long student) {
        StudentEntity studentEntity = studentService.getById(student);
        return new CommonAjaxResponse<>("请求成功", true, studentEntity);
    }

    @RequestMapping(value = "/{student}", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonAjaxResponse<Boolean> deleteStudent(@PathVariable Long student) {
        studentService.delete(student);
        return new CommonAjaxResponse<>("success", true, true);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public CommonAjaxResponse<StudentEntity> saveStudent() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName("潘端端");
        studentEntity.setAge(29l);
        studentService.saveStudent(studentEntity);
        return new CommonAjaxResponse<>("success", true, studentEntity);
    }
}
