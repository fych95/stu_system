package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import com.cy.store.service.ex.deleteException;
import com.cy.store.service.ex.loginException;
import com.cy.store.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest //表示标注当前的类是一个测试类，不会随项目一起打包发送
@RunWith(SpringRunner.class) //表示启动这个单元测试类，不写这个注解他不运行
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    @Test
    public void regist(){
        try {
            User user = new User();
            user.setUserName("王怜花");
            user.setPassWord("123456");
            userService.register(user);
            System.out.println("插入成功");
        } catch (ServiceException e) {
            //输出异常信息
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void loginTest(){
        try {
            User user = new User();
            user.setUserName("王怜花");
            user.setPassWord("123456");
            userService.login(user);
        } catch (loginException e) {
            System.out.println("用户登录失败！密码错误");
        }

    }
    @Test
    public void deleteTest(){
        User user = new User();
        user.setUserName("张三丰");
        try {
            userService.deletByUserName(user);
        } catch (deleteException e) {
            System.out.println("删除失败");
        }
    }

    @Test
    public void showUsers(){
        userService.showUsersByPage();
    }
}
