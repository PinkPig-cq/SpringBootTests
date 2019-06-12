package com.hpeu.rabbitmq.Receiver.MessageReceiver;

import com.hpeu.rabbitmq.Dao.Messages;
import com.hpeu.rabbitmq.Receiver.MessagesHandler;
import org.springframework.stereotype.Component;

/**
 * 接收者秦虎
 */
@Component
public class QinhuReceiver implements MessagesHandler {
    private String name = "秦虎";
    @Override
    public void dispatchMessage(Messages messages) {
        for (String handler : messages.getHandler()) {
            if (name.equals(handler)) {
                System.out.println(name + "拿到了数据，我拿起了就跑！谁也追不上我！");
                System.out.println(messages.toString());
            }
        }
    }
}
