package com.cy.store.Mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*用户模块持久层接口*/
@Mapper
public interface UserMapper {
    Integer insert(User user);
    /*
    * 插入用户数据
    * 返回值是收到影响的行数（增删改，都有受到影响的行数，根据返回值来判断是否成功）
    * */
    User findByUsername(String Username);
    /*如果找到则返回用户数据
    *没找到则返回null值
    * */
    //增删的方法返回的是数据库受到影响的行数
    Integer deleteByUserName(String userName);

    //分页展示所有用户
    List<User> showUsersByPage();


}
