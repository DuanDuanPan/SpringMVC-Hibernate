package com.cssrc.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
@Entity
@Table(name = "STUDENT")
public class StudentEntity {
    private Long id;
    private String name;
    private Long age;
    private Date birth;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "G1")
    @SequenceGenerator(name = "G1", sequenceName = "SEQ_STUDENT")
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 38)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "AGE", nullable = true, precision = 0)
    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Basic
    @Column(name = "BIRTH", nullable = true)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (birth != null ? !birth.equals(that.birth) : that.birth != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        return result;
    }
}
