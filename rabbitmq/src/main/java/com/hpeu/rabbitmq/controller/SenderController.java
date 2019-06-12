package com.hpeu.rabbitmq.controller;

import com.hpeu.rabbitmq.Dao.Messages;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SenderController {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;
    @RequestMapping("sender")
    public String sendMessages(){
        //创建路由
        amqpAdmin.declareExchange(new FanoutExchange("exchangeWeb"));
        //创建队列
        amqpAdmin.declareQueue(new Queue("queueWeb"));
        //创建绑定规则  Exchange to Queue
        amqpAdmin.declareBinding(new Binding("queueWeb",
                Binding.DestinationType.QUEUE, "exchangeWeb", "webkey", null));
        // rabbitTemplate.send(new Message(byte[] body, MessageProperties messageProperties));  需要将对象转换成Byte[],可传消息头
        //发送信息
//        rabbitTemplate.convertAndSend(new UserService());

        Messages messages = new Messages();
        //构造消息对象   这个一般不在一个项目里   具体业务实现后面就发生消息
        messages.setAddress("127.0.0.1");
        messages.setMessage("后天放端午节，你又要一个人在宿舍写代码了，孤独使我强大！");
        messages.setSender("上帝");

        List<String> list = new ArrayList<>();
        list.add("秦虎");
        list.add("王五");
        messages.setHandler(list);
        //发送消息
//        rabbitTemplate.convertAndSend(messages);
        rabbitTemplate.convertAndSend("exchangeWeb","webkey",messages);
        //清空列队中的东西
//        amqpAdmin.purgeQueue("");

        return "发送成功";
    }
}
