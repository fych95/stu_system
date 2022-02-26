package com.cy.store.controller;

import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//控制类依赖于业务层的接口
//@Controller
@RestController //controller+responsebody
@RequestMapping("users")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping(value="reg")
    //@ResponseBody //表示此方法相应结果以json格式响应前端
    public JsonResult<Void> reg(User user){
        //创建响应结果对象
        JsonResult<Void> result= new JsonResult<>();
        try {
            userService.register(user);
            result.setState(200);
            result.setMessage("用户注册成功");
        } catch (UserNameDuplicatedException e) {
            result.setState(4000);
            result.setMessage("用户名被占用");
        }
         catch (InsertException e) {
            result.setState(4001);
            result.setMessage("插入用户时候产生了未知异常");
    }
        return result;
    }
    //控制给接口传参格式
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult<Void> login(@RequestBody User user){
        //创建结果响应器
        JsonResult<Void> result = new JsonResult<>();
        try {
            userService.login(user);
            result.setState(200);
            result.setMessage("用户登录成功");
        } catch (loginException e) {
            result.setState(404);
            result.setMessage("用户登录失败密码错误");
        }
        return result;
    }

    //删除用户控制层，这里是请求体为json格式的标注写法，注意不要忘记@RequestBody
    @RequestMapping(value = "delete", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public JsonResult<Void> deleteUser(@RequestBody User user){
        JsonResult<Void> result = new JsonResult<>();
        try {
            userService.deletByUserName(user);
            result.setState(200);
            result.setMessage("用户被成功删除");
        } catch (deleteException e) {
            result.setState(404);
            result.setMessage("用户删除时遇到异常");
        }
         return result;
    }
    //查询数据库中所有用户的信息
    @RequestMapping("showall")
    public JsonResult<List<User>> showUsers(){
        JsonResult<List<User>> result = new JsonResult<>();
        List<User> sqlResqult = new ArrayList<>();
        sqlResqult = userService.showUsers();

        try {
            result.setState(200);
            result.setMessage("查询所有用户成功！");
            result.setData(sqlResqult);
        } catch (showUsersException e) {
            result.setState(404);
            result.setMessage("没用户！滚蛋");
        }
        return result;
    }
}
