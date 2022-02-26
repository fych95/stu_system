package com.cy.store.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/*实体类的基础类*/
public class EntityBase implements Serializable { //Serializable实现序列化
    private String createdUser; //'日志-创建人',
    private Date createdTime;//'日志-创建时间',
    private String modifiedUser;//'日志-最后修改执行人',
    private Date modifiedTime;//'日志-最后修改时间',

    //自动生成getset方法
    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
    //自动生成hascod和equals方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityBase that = (EntityBase) o;
        return Objects.equals(createdUser, that.createdUser) && Objects.equals(createdTime, that.createdTime) && Objects.equals(modifiedUser, that.modifiedUser) && Objects.equals(modifiedTime, that.modifiedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdUser, createdTime, modifiedUser, modifiedTime);
    }
    //自动生成tostring方法
    @Override
    public String toString() {
        return "EntityBase{" +
                "createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }

    //1   接下来优先开发数据持久层
    /*-2  业务层
    -  3  控制层*/

    //规划需要执行的sql
    //通过mybatis来操作数据
}
