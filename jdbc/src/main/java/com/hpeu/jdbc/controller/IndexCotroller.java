package com.hpeu.jdbc.controller;

import com.hpeu.jdbc.Mapper.UserMapper;
import com.hpeu.jdbc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexCotroller {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserMapper userMapper;

    @RequestMapping("index")
    public List<User> index() {
        List<User> list  = null;
//        list = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
        list = userMapper.getAll();
        return list;
    }

    @RequestMapping("add")
    public String add(){
        User user = new User();
        user.setAge(18);
        user.setName("王五");
        user.setClassesID("12312");
        userMapper.add(user);
        return "成功";
    }
    public String find(){
        return "";
    }
}
