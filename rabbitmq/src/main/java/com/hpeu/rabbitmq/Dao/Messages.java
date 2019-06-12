package com.hpeu.rabbitmq.Dao;

import com.hpeu.rabbitmq.Receiver.MessagesHandler;
import com.hpeu.rabbitmq.Until.DateUntil;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * RabbitMq中的消息
 */
public class Messages {
    /**
     * 具体消息
     */
    private String message;
    /**
     * 时间sssss
     */
    private long time = System.currentTimeMillis();
    /**
     * 发送者
     */
    private String sender;
    /**
     * 发送地址
     */
    private String Address;
    /**
     * 接收者
     */
    private List<String> handler;

    public Messages(String message, long time, String sender, String address, List<String> handler) {
        this.message = message;
        this.time = time;
        this.sender = sender;
        Address = address;
        this.handler = handler;
    }

    public Messages() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public List<String> getHandler() {
        return handler;
    }

    public void setHandler(List<String> handler) {
        this.handler = handler;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "message: '" + message + '\'' +
                ", time: " + DateUntil.toDate(time) +
                ", sender: '" + sender + '\'' +
                ", Address: '" + Address + '\'' +
                ", handler: " + handler +
                '}';
    }
}
