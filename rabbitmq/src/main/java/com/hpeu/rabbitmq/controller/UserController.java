package com.hpeu.rabbitmq.controller;
import com.hpeu.rabbitmq.Dao.Messages;
import com.hpeu.rabbitmq.Receiver.MessagesHandler;
import com.hpeu.rabbitmq.Service.UserService;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
public class UserController {

    @Autowired(required = false)
    List<MessagesHandler> handlers;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "queueWeb"), //监听那个队列
                    exchange = @Exchange(value = "exchangeWeb",type = "fanout")  //路由规则
            ))
    public void index(Messages messages) {
        if (handlers != null){
            for (MessagesHandler handler : handlers) {
                handler.dispatchMessage(messages);
            }
        }
    }
}
