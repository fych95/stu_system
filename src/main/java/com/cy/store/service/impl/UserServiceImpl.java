package com.cy.store.service.impl;

import com.cy.store.Mapper.UserMapper;
import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
//把这个实现类交给spring管理

@Service  //Service注解将当前类的对象交给spring管理
public class UserServiceImpl implements IUserService {
    //用户模块业务层实现类
    @Autowired //mapper类自动实现接口类？反正没接口实现类？？？
    private UserMapper userMapper;
    @Override
    public void register(User user) {
        //调用mapper的findusername方法检测是否被占用
        User result = userMapper.findByUsername(user.getUserName());
        //判断结果集是否为null,b不为null则抛出异常
        if(result != null){
            throw new UserNameDuplicatedException("用户名被占用");//抛出用户名被占用异常
        }
        //密码加密处理的实现，md5加密
        //(串+passwd+串) ---------md5算法加密,连续加密三次，难以破解
        //串我们通常叫做盐值，salt
        String oldPassWord = user.getPassWord();
        //获取随机盐值（随机生成一个盐值）
        String salt = UUID.randomUUID().toString().toUpperCase();
        //密码和盐值作为整体
        //调用md5加密方法
        String newMd5PassWord = getMD5Password(oldPassWord,salt);
        //此种加密无视原密码强度
        user.setPassWord(newMd5PassWord);
        user.setSalt(salt);
        //在业务层补全前端没穿过来的数据信息,如修改者的名字时间等
        user.setIsDelet(0);
        user.setCreatedUser(user.getUserName());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedUser(user.getUserName());
        user.setModifiedTime(date);
        //执行注册业务
        int rows = userMapper.insert(user);
        if(rows !=1){
            throw new InsertException("在插入过程如产生了未知异常");
        }


    }
    //用户登录方法
    @Override
    public void login(User user) {
        User loginresult = userMapper.findByUsername(user.getUserName());
        //获取这个用户的盐值
        if(loginresult !=null){
            System.out.println("用户存在");
        }
        String newSalt;
        newSalt = loginresult.getSalt();
        //获取这个用户输入的密码，并对这个密码进行md5加密
        String password;
        String MD5password;
        password = user.getPassWord();
        MD5password = getMD5Password(password,newSalt);
        //打印md5加密密码
        System.out.println("根据用户输入的密码进行md5加密后的密码是："+MD5password);
        //java中字符串是否相等通常用equals方法比较
        if(MD5password.equals(loginresult.getPassWord())){
            System.out.println("用户登录成功");
        }else{
            throw new loginException("用户登录失败");
        }

    }


    //删除用户业务层
    @Override
    public void deletByUserName(User user) {
        int rows;
        rows = userMapper.deleteByUserName(user.getUserName());
        System.out.println("打印删除方法返回的值rows=："+rows);
        if(rows != 1){
            throw new deleteException("在删除用户的过程中发生了异常");
        }
        else{
            System.out.println(user.getUserName()+"用户被删除成功");
        }
    }

    //查找所有用户
    @Override
    public List<User> showUsers() {
        List<User> resultList =new ArrayList<>();
        resultList = userMapper.showUsers();
        if(resultList == null){
            throw new showUsersException("查询所有用户时出现了异常");
        }
        for(User user:resultList){
            System.out.println(user.toString());
            //打印所有查询到的结果
        }
        return resultList;
    }

    //md5加密方法
    private String getMD5Password(String pw,String salt){
        for (int i = 0; i < 3; i++) {
            pw = DigestUtils.md5DigestAsHex((salt+pw+salt).getBytes()).toUpperCase();//md5加密算法的调用
        }
        return pw;
    }
}
