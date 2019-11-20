package cn.enilu.guns.service.demo;

import cn.enilu.guns.bean.entity.demo.Student;
import cn.enilu.guns.dao.demo.StudentRepository;
import cn.enilu.guns.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019-11-20.
 */
@Service
public class StudentService extends BaseService<Student,Long,StudentRepository> {

    @Autowired
    private StudentRepository studentRepository;

}
