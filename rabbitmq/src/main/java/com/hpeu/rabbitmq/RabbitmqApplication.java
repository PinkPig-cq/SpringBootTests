package com.hpeu.rabbitmq;

import com.hpeu.rabbitmq.Dao.Messages;
import com.hpeu.rabbitmq.Receiver.MessageReceiver.QinhuReceiver;
import com.hpeu.rabbitmq.Receiver.MessageReceiver.WangWuReceiver;
import com.hpeu.rabbitmq.Receiver.MessagesHandler;
import com.hpeu.rabbitmq.Service.UserService;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableRabbit
public class RabbitmqApplication {
    /**
     * 初始化
     */
    public RabbitmqApplication(RabbitTemplate rabbitTemplate, AmqpAdmin amqpAdmin) throws UnknownHostException {

//        //创建路由
//        amqpAdmin.declareExchange(new DirectExchange("exchangeWeb"));
//        //创建队列
//        amqpAdmin.declareQueue(new Queue("queueWeb"));
//        //创建绑定规则  Exchange to Queue
//        amqpAdmin.declareBinding(new Binding("queueWeb",
//                Binding.DestinationType.QUEUE, "exchangeWeb", "webkey", null));
//        // rabbitTemplate.send(new Message(byte[] body, MessageProperties messageProperties));  需要将对象转换成Byte[],可传消息头
//        //发送信息
////        rabbitTemplate.convertAndSend(new UserService());
//
//        Messages messages = new Messages();
//        //构造消息对象   这个一般不在一个项目里   具体业务实现后面就发生消息
//        messages.setAddress(InetAddress.getLocalHost().getHostName());
//        messages.setMessage("后天放端午节，你又要一个人在宿舍写代码了，孤独使我强大！");
//        messages.setSender("上帝");
//
//        List<String> list = new ArrayList<>();
//        list.add("秦虎");
//        list.add("王五");
//        messages.setHandler(list);
//        //发送消息
////        rabbitTemplate.convertAndSend(messages);
////        rabbitTemplate.convertAndSend("exchangeWeb","webkey",messages);
//        //清空列队中的东西
////        amqpAdmin.purgeQueue("");
    }

    public static void main(String[] args) {

        SpringApplication.run(RabbitmqApplication.class, args);
    }

}
