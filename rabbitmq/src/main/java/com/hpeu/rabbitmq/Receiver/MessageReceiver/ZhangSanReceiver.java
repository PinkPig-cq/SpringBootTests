package com.hpeu.rabbitmq.Receiver.MessageReceiver;

import com.hpeu.rabbitmq.Dao.Messages;
import com.hpeu.rabbitmq.Receiver.MessagesHandler;
import org.springframework.stereotype.Component;

/**
 *接收者张三
 */
@Component
public class ZhangSanReceiver implements MessagesHandler{
    private String name = "张三";
    @Override
    public void dispatchMessage(Messages messages) {
        for (String handler : messages.getHandler()) {
            if (name.equals(handler)) {
                System.out.println(name + "拿到了数据，师承张三丰！一个能打的都没有了么？");
                System.out.println(messages.toString());
            }
        }
    }
}
