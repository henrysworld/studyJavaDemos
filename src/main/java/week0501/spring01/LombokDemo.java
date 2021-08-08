package week0501.spring01;

import lombok.extern.java.Log;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/3 0:04
 * @Version: 1.0
 */
@Log
public class LombokDemo {
    public static void main(String[] args) {
        new LombokDemo().demo();

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("CC01");

        System.out.println(student1.toString());

        Student student2 = Student.create();
        System.out.println(student2.toString());
    }

    private void demo(){
        log.info("demo in log.");
    }
}
