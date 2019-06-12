package com.hpeu.cache.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hpeu.cache.dao.UserDao;
import com.hpeu.cache.pojo.Users;
import com.hpeu.cache.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User的Service
 */
@CacheConfig(cacheManager = "cacheManager")
@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Cacheable(value = "Users",key = "'all6'",unless = "#result == null")
    public List<Users> findAll() {
        return userDao.findAll();
    }

    @Override
    @Cacheable(value = "Users",key = "#root.args[0]",unless = "#result == null")
    public Users findById(Integer id){
        return userDao.findById(id);
    }

    @Override
    @CachePut(value = "Users",key = "#root.args[0]",unless = "#result == null")
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

    @CacheEvict(value = "Users",allEntries=true)
    @Override
    public void add(Users users) {
        userDao.add(users);
    }

    @CachePut(value = "Users",key = "'all6'")
    @Override
    public List<Users> addAll(Users users) {
        return userDao.addAll(users);
    }

    @Override
    public IPage<Users> selectUserPage(Page<Users> page, Integer state) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return userDao.selectPageVo(page, state);
    }
}
