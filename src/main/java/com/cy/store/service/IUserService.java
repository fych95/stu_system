package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.util.PageRequest;
import com.cy.store.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.List;

//业务层接口类
public interface IUserService {
    //用户注册功能接口
    void register(User user);
    //用户登录
    void login(User user);
    //根据用户输入的用户名删除用户
    void deletByUserName(User user);
    //查询所有的用户
    List<User> showUsersByPage();

}
