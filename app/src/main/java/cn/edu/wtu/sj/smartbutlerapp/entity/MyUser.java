package cn.edu.wtu.sj.smartbutlerapp.entity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/**
 * 项目名 :SmartButlerApp
 * 创建者 :create by 黑仪想吃螃蟹了
 * 创建时间:2019/5/1 0001
 * 描述: 用户属性
 */
public class MyUser extends BmobUser{
    private String name;
    private String password;
    private String email;
    private int age;
    private Boolean sex;
    private String desc;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

}
