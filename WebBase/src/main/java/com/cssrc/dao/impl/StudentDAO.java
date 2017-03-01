package com.cssrc.dao.impl;

import com.cssrc.dao.IStudentDAO;
import com.cssrc.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
@Repository
@Transactional
public class StudentDAO implements IStudentDAO {

    @Autowired
    HibernateTemplate hibernateTemplate;

    public List<StudentEntity> getAllStudents() {
        String hql = "FROM StudentEntity";
        return (List<StudentEntity>) hibernateTemplate.find(hql);
    }

    public Boolean saveStudent(StudentEntity studentEntity) {
        hibernateTemplate.save(studentEntity);
        return true;
    }

    @Override
    public StudentEntity getById(Long student) {
        return hibernateTemplate.get(StudentEntity.class, student);
    }

    @Override
    public void delete(Long student) {
        StudentEntity studentEntity = hibernateTemplate.get(StudentEntity.class, student);
        hibernateTemplate.delete(studentEntity);
    }
}
