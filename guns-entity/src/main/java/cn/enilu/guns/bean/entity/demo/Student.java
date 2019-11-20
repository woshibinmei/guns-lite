package cn.enilu.guns.bean.entity.demo;

import cn.enilu.guns.bean.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2019-11-20.
 */
@Entity
@Table(name="demo_student")
public class Student extends BaseEntity {

    @Column(name="no",nullable = true)
    private String no;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private Integer age;

    public Student() {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
