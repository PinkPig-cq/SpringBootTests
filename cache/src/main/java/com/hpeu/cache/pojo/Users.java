package com.hpeu.cache.pojo;
import java.io.Serializable;

public class Users  implements Serializable{
    private String name;
    private Integer age;
    private String classesId;
    private Integer id;
    public Users( Integer id,String name, Integer age, String classesId) {
        this.name = name;
        this.age = age;
        this.classesId = classesId;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClassesId() {
        return classesId;
    }

    public void setClassesId(String classesId) {
        this.classesId = classesId;
    }


}
