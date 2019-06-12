package com.hpeu.cache.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface BaseService<T>{
    List<T> findAll();
    T findById(Integer id);
    void deleteById(Integer id);
    void add(T t);
}

