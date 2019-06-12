package com.hpeu.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class JdbcApplication {

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {

        SpringApplication.run(JdbcApplication.class, args);

    }

}
