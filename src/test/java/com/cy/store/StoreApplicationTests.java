package com.cy.store;

import com.cy.store.entity.EntityBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {
    //先声明数据库连接类
    @Autowired//自动装配
    private DataSource dataSource;
    @Test
    void contextLoads() {
    }

    //数据库连接测试类
    @Test
    //获取连接对象的时候抛出可能出现的异常
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
    //数据库连接池
    //    1.DBCP
    //    2.C3P0
    //    3.Hikar(鬼子开发的)：管理数据库的连接对象
    //HikariProxyConnection@1623670360 wrapping com.mysql.cj.jdbc.ConnectionImpl@5984feef

    @Test
    void testbaseclass(){
        EntityBase e = new EntityBase();
        e.setCreatedUser("王大胖");
        e.setModifiedUser("王大胖");

        EntityBase e2 = new EntityBase();
        e2.setCreatedUser("王大胖");
        e2.setModifiedUser("王大胖");
        //测试tostring方法
        System.out.println(e.toString());
        //基本类中重写的equals方法测试
        if(e.equals(e2)){
            System.out.println("基本类对象e与基本类对象e2相等");
        }else
        {
            System.out.println("基本类对象e与基本类对象e2不相等");
        }


    }

}
