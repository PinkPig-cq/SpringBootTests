package com.hpeu.rabbitmq.Receiver.MessageReceiver;

import com.hpeu.rabbitmq.Dao.Messages;
import com.hpeu.rabbitmq.Receiver.MessagesHandler;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 接收者李四
 */
@Component
public class LiSiReceiver implements MessagesHandler {
    private String name = "李四";

    @Override
    public void dispatchMessage(Messages messages) {
        for (String handler : messages.getHandler()) {
            if (name.equals(handler)) {
                System.out.println(name + "拿到了数据，我跳了一下！！！");
                System.out.println(messages.toString());
            }
        }

    }
}
