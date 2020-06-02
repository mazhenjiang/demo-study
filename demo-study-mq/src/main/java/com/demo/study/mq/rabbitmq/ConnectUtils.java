package com.demo.study.mq.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: MQ链接工具类
 * @author: Aaron Ma
 **/
public class ConnectUtils {

    public static Connection getConnection() throws IOException, TimeoutException {
        //定义工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务器地址，IP,端口
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("mark");
        factory.setPassword("7859384");

        return factory.newConnection();
    }
}
