package cn.enjoy.vo;

import java.io.Serializable;

/**
 * @author xujianhao
 * @version 1.0
 * @description: 用户实体类
 * @date 2021/8/26 22:23
 */

public class User implements Serializable {
    private String name;
    private int age;
    private String sex;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}
