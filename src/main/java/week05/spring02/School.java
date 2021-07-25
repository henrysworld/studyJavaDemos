package week05.spring02;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.*;
//import javax.annotation.Resource;
import week05.aop.ISchool;
import week05.spring01.Student;

import javax.annotation.Resource;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/24 0:05
 * @Version: 1.0
 */
@Data
public class School implements ISchool {
    @Autowired(required = true)
    Klass class1;

    @Resource(name = "student100")
    Student student100;

    @Override
    public void ding() {
        System.out.println("Class1 have " + this.class1.getStudents().size() + "students and one is " + this.student100);
    }
}
