package com.xy.jms.producer.impl;

import com.xy.jms.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created by xy on 2017/8/24.
 */
@Service
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    JmsTemplate jmsTemplate;
    @Resource(name="queueDestination")
    Destination destination;
    public void sendMessage(final String message) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage=session.createTextMessage(message);
                System.out.println("发送消息："+message);
                return textMessage;
            }
        });
    }
}
