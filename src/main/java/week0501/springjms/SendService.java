package week0501.springjms;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import week0501.spring01.Student;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/1 23:39
 * @Version: 1.0
 */
@Component
public class SendService {
    @Autowired
    JmsTemplate jmsTemplate;

    public void send(final Student user){
        jmsTemplate.send("test.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(JSON.toJSONString(user));
            }
        });
    }
}
