package com.demo.study.mq.rabbitmq.simple;

import com.demo.study.mq.rabbitmq.ConnectUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: 消息接受者
 * @author: Aaron Ma
 **/
public class Receive {

    private static final String QUEUE_NAME = "test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectUtils.getConnection();
        //创建甬道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //定义消费者
        Consumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println(msg);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, defaultConsumer);


    }
}
