package com.hpeu.rabbitmq.Service;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 这里测试Rabbitmq，所以不会直接在controller中 new UserService()
 */
@Service
public class UserService implements Serializable {
    public String sayHolle(){
        return "我的实体对象,将从Queue中来";
    }
}
