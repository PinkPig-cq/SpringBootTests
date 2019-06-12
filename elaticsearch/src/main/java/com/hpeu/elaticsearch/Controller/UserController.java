package com.hpeu.elaticsearch.Controller;

import com.hpeu.elaticsearch.Entity.User;
import com.hpeu.elaticsearch.UserService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    static Integer id = 0;
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("addUser")
    public String index(){
        User user = new User("张三","北京五环","18883586866",id,18,"男");
        id++;
        userService.addUser(user);
        return "成功";
    }
    @RequestMapping("queryAll")
    public List<User> query(){
        return userService.findAll();
    }
}
