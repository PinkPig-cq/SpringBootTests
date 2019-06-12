package com.hpeu.rabbitmq.Receiver.MessageReceiver;

import com.hpeu.rabbitmq.Dao.Messages;
import com.hpeu.rabbitmq.Receiver.MessagesHandler;
import org.springframework.stereotype.Component;

/**
 * 接收者王五
 */
@Component
public class WangWuReceiver implements MessagesHandler{
    private String name = "王五";
    @Override
    public void dispatchMessage(Messages messages) {
        for (String handler : messages.getHandler()) {
            if (name.equals(handler)) {
                System.out.println(name + "拿到了数据，我！隔壁老王！");
                System.out.println(messages.toString());
            }
        }
    }
}
