package com.xy.jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by xy on 2017/8/24.
 */
public class Producer {
    private static final String URL="tcp://localhost:61616";
    private static final String TOPICNAME="topic-test";
    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection=null;
        Session session;
        Destination destination;
        MessageProducer producer;
        connectionFactory=new ActiveMQConnectionFactory(URL);
        try {
            connection=connectionFactory.createConnection();
            connection.start();
            session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            destination=session.createTopic(TOPICNAME);
            producer=session.createProducer(destination);
            //不持久化（测试）
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            for(int i=1;i<10;i++){
                TextMessage textMessage=session.createTextMessage("消息"+i);
                producer.send(textMessage);
            }
            System.out.println("已发送");
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
