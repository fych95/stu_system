package com.cy.store.mapper;

import com.cy.store.Mapper.UserMapper;
import com.cy.store.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest //表示标注当前的类是一个测试类，不会随项目一起打包发送
@RunWith(SpringRunner.class) //表示启动这个单元测试类，不写这个注解他不运行
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;
    //单元测试方法特点
    /*
     * 1.必须被test注解修饰
     * 2.返回值类型必须void
     * 3.方法的参数列表不能指定任何类型
     * 4.方法的访问修饰符必须是public
     * 5.单元测试方法可以独立运行
     * */
    //Mybatis动态代理实现接口的实现类
    @Test
    public void insert(){
        User user = new User();
        User result = new User();
        user.setUserName("张三丰");
        user.setPassWord("123456");
        user.setEmail("670341518@qq.com");
        user.setAvatar("AISDAOIHSEIUWEQOWEHOQ23198199ASUHDO9ASDA");
        user.setCreatedUser("admin");
        userMapper.insert(user);
        result = userMapper.findByUsername(user.getUserName());
        result.toString();
    }
    @Test
    public void findByName(){
        User user = new User();
        user.setUserName("王怜花");
        User result;
        result = userMapper.findByUsername(user.getUserName());
        System.out.println(result.toString());
    }
    @Test
    public void deleteByName(){
        User user = new User();
        user.setUserName("kasar");
        int rows = userMapper.deleteByUserName(user.getUserName());
        System.out.println("rows值test："+rows);
        if(rows == 1){
            System.out.println("删除成功");
        }

    }
}
