package com.hpeu.elaticsearch.Entity;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;


/**
 * @Document  有点像 @entity
 * indexName 指定是存在那个索引(数据库),
 * type 指定类型(表名)
 */
@Document(indexName = "MyElTest",type = "User")
public class User implements Serializable {
    private String name;
    private String address;
    private String phone;
    private Integer id;
    private Integer age;

    public User() {
    }

    public User(String name, String address, String phone, Integer id, Integer age, String sex) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.id = id;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String sex;
}
