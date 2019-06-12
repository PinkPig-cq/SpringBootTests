package com.hpeu.jdbc.Mapper;

import com.hpeu.jdbc.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> getAll();
    @Insert("insert into user(Id,Name,ClassesID,Age) value(#{Id},#{Name},#{ClassesID},#{Age})")
    void add(User user);
}
