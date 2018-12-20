package com.tt.teach.service.Impl;

import com.tt.teach.dao.StudentDao;
import com.tt.teach.pojo.Student;
import com.tt.teach.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Resource
    private StudentDao studentDao;

    public Student doLogin(Student student) {
        return studentDao.doLogin(student);
    }


    public List<Student> findStuAll() {
        return studentDao.findStuAll();
    }

    @Transactional
    public int updateStu(Student student) {
        return studentDao.updateStu(student);
    }

    @Transactional
    public int deleteStu(Integer stuNo) {
        return studentDao.deleteStu(stuNo);
    }
}
