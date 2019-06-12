package com.hpeu.cache.controller;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hpeu.cache.pojo.Users;
import com.hpeu.cache.service.UserService;
import com.hpeu.cache.vo.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户登录界面
 */
@RestController
@Api("用户")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("查询所有用户")
    @RequestMapping("queryAll")
    public List<Users> Index(){
        List<Users> list = userService.findAll();

        return list;
    }

    @ApiOperation("添加用户信息")
    @RequestMapping("addUser")
    public String Add(){
        Users addUsers = new Users();
        addUsers.setAge(18);
        addUsers.setName("少年阿炳");
        addUsers.setClassesId("301");
        userService.add(addUsers);
        return "成功";
    }
    @GetMapping("deleteUser")
    public String Delete(Integer id){
        userService.deleteById(id);
        return "成功";
    }

    @ApiOperation("根据ID查找用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",type = "int",paramType = "int",required = false)})
    @GetMapping("findById")
    public Users findById(@PathVariable("id") Integer id){

        return userService.findById(id);
    }

    @GetMapping("toList/{pageInfo}")
    public IPage<Users> findListByPage(@PathVariable PageInfo pageInfo){
        Page<Users> page = new Page<>();
        page.setCurrent(pageInfo.getCurrent());
        page.setSize(pageInfo.getSize());
        page.setTotal(pageInfo.getTotal());

        return userService.selectUserPage(page, 10);
    }
}
