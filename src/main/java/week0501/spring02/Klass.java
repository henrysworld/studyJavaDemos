package week0501.spring02;

import lombok.Data;
import week0501.spring01.Student;

import java.util.List;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/24 0:05
 * @Version: 1.0
 */
@Data
public class Klass {
    List<Student> students;

    public void dong() {
        System.out.println(this.getStudents());
    }
}
