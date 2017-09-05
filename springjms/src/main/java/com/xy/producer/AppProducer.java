package com.xy.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xy on 2017/9/5.
 */
public class AppProducer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("producer.xml");
        ProducerService service=context.getBean(ProducerService.class);
        for(int i=0;i<10;i++){
            service.sendMessage("消息"+i);
        }
        context.close();
    }
}
