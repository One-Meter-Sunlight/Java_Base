package com.base.socket.io.byteIo;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author ck
 * @date 2018/1/11 15:06
 */
public class UserTransient implements Serializable {

    private String name;
    private transient int age;

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
}
