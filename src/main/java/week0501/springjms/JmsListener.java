package week0501.springjms;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/1 23:38
 * @Version: 1.0
 */

@Component(value = "jmsListener")
public class JmsListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        ObjectMessage m = (ObjectMessage) message;

        try {
            System.out.println("收到的信息："  + ((ObjectMessage) message).getObject());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
