package com.demo.study.mq.rabbitmq.simple;

import com.demo.study.mq.rabbitmq.ConnectUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: 消息发送者
 * @author: Aaron Ma
 **/
public class Send {
    private static final String QUEUE_NAME = "test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获的连接
        Connection connection = ConnectUtils.getConnection();
        //创建甬道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //发送消息
        String msg="simple queue demo!";
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());

        System.out.println(">>>>send msg>>>"+msg);
        //关闭连接
        channel.close();
        connection.clearBlockedListeners();
    }
}
