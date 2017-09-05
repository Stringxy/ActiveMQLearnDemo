package com.xy.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xy on 2017/9/5.
 */
public class AppConsumer {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");

    }
}
