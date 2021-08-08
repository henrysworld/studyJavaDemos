package week0501.springjms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import week0501.spring01.Student;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/1 23:39
 * @Version: 1.0
 */
public class JmsSender {

    public static void main(String[] args) {
        Student student2 = Student.create();

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springjms-sender.xml");
        SendService sendService = (SendService) context.getBean("sendService");

        sendService.send(student2);

        System.out.println("send successfully, please visit http://localhost:8161/admin to see it");
    }
}
