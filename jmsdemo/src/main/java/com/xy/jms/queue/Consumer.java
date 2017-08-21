package com.xy.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by xy on 2017/8/21.
 */
public class Consumer {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection=null;
        Session session;
        Destination destination;
        MessageConsumer consumer;//消费者
        connectionFactory=new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {
            connection=connectionFactory.createConnection();
            connection.start();
            session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            destination=session.createQueue("queue-test");
            consumer=session.createConsumer(destination);
            //创建监听器
            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    TextMessage textMessage= (TextMessage) message;
                    try {
                        System.out.println("接收到了："+textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
