package com.hpeu.rabbitmq.Receiver;

import com.hpeu.rabbitmq.Dao.Messages;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 消息订阅者 接口
 */
@Component
public interface MessagesHandler {
    /**
     * 处理消息
     */
    void dispatchMessage(Messages messages);
}
