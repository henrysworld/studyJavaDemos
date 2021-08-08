package week0501.springjms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/1 23:39
 * @Version: 1.0
 */
public class JmsReceiver {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springjms-receiver.xml");
        try {
            System.in.read();
            System.out.println("send successfully, please visit http://localhost:8161/admin to see it");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
