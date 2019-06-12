package com.hpeu.jdbc.pojo;

public class User {
    private String Id;
    private String Name;
    private String ClassesID;
    private Integer Age;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getClassesID() {
        return ClassesID;
    }

    public void setClassesID(String classesID) {
        ClassesID = classesID;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }
}
