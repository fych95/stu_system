package com.cy.store.entity;

import java.io.Serializable;
import java.util.Objects;

//继承Serializable类实现序列化
//继承了基类获得了基类的4个私有属性
public class User extends EntityBase implements Serializable {
    private int uid;//'用户id',
    private String userName;//'用户名',
    private String passWord;//'密码',
    private String salt;//'盐值',
    private String phone;//'电话号码',
    private String email;//'电子邮箱',
    private int gender;//'性别:0-女，1-男',
    private String avatar;//'头像',
    private int isDelete;//'是否删除：0-未删除，1-已删除',

    //1.GET SET方法 2.equals和hascode重写 3.tostring

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelet(int isDelet) {
        this.isDelete = isDelet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return uid == user.uid && gender == user.gender && isDelete == user.isDelete && Objects.equals(userName, user.userName) && Objects.equals(passWord, user.passWord) && Objects.equals(salt, user.salt) && Objects.equals(phone, user.phone) && Objects.equals(email, user.email) && Objects.equals(avatar, user.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), uid, userName, passWord, salt, phone, email, gender, avatar, isDelete);
    }
    //tostring方法方便输出
    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", salt='" + salt + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", avatar='" + avatar + '\'' +
                ", isDelet=" + isDelete +
                '}';
    }
}
