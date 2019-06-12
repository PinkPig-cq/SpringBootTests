package com.hpeu.cache.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hpeu.cache.pojo.Users;

import java.util.List;

public interface UserService extends BaseService<Users> {
    List<Users> addAll(Users users);
    public IPage<Users> selectUserPage(Page<Users> page, Integer state);
}
