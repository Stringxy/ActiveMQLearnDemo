package com.xy.jms.queue;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by xy on 2017/8/21.
 */
public class Producer {
    private static final String URL="tcp://localhost:61616";
    private static final String QUEUENAME="queue-test";

    public static void main(String[] args) throws JMSException {
        //创建连接工厂，jms用这个创建连接
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD,URL);
        //创建连接
        Connection connection=connectionFactory.createConnection();

        connection.start();

//paramA 取值有：
//        1、true：支持事务
//
//        为true时：paramB的值忽略， acknowledgment mode被jms服务器设置为SESSION_TRANSACTED 。 　
//
//        2、false：不支持事务
//
//        为false时：paramB的值可为Session.AUTO_ACKNOWLEDGE、Session.CLIENT_ACKNOWLEDGE、DUPS_OK_ACKNOWLEDGE其中一个。
//
//
//
//        paramB 取值有：
//
//        1、Session.AUTO_ACKNOWLEDGE：为自动确认，客户端发送和接收消息不需要做额外的工作。
//
//        2、Session.CLIENT_ACKNOWLEDGE：为客户端确认。客户端接收到消息后，必须调用javax.jms.Message的acknowledge方法。jms服务器才会删除消息。
//
//        3、DUPS_OK_ACKNOWLEDGE：允许副本的确认模式。一旦接收方应用程序的方法调用从处理消息处返回，会话对象就会确认消息的接收；而且允许重复确认。在需要考虑资源使用时，这种模式非常有效。
//
//        4、SESSION_TRANSACTED
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建消息目的地
        Destination destination=session.createQueue(QUEUENAME);
        //创建生产者
        MessageProducer producer=session.createProducer(destination);
        //不持久化（测试）
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        for(int i=0;i<3;i++){
            TextMessage textMessage=session.createTextMessage("test"+i);
            producer.send(textMessage);
            System.out.println("发送消息："+textMessage.getText());
        }
        connection.close();
    }
}
