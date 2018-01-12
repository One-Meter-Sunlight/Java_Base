package com.base.socket.io.byteIo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象输出流
 * ObjectInputStream:只能反序列化一个对象并且读取出来
 *
 * @author ck
 * @date 2018/1/11 15:06
 */
public class ObjectStreamTest {

    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/test.text"));
        // User对象必须序列化
        User user = new User();
        user.setName("张三");
        user.setAge(15);
        oos.writeObject(user);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/test.text"));
        User u = (User) ois.readObject();
        System.out.println(u.getName());
        System.out.println(u.getAge());
        ois.close();

        /**
         * 部分属性序列化
         */
        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("d:/test2.text"));
        // User对象必须序列化
        UserPart user2 = new UserPart();
        user2.setName("赵四");
        user2.setAge(18);
        oos2.writeObject(user2);
        oos2.close();

        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("d:/test2.text"));
        UserPart u2 = (UserPart) ois2.readObject();
        System.out.println(u2.getName());
        System.out.println(u2.getAge());
        ois2.close();

        /**
         * transient关键字修饰不序列化字段
         */
        ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("d:/test3.text"));
        // User对象必须序列化
        UserTransient user3 = new UserTransient();
        user3.setName("王五");
        user3.setAge(28);
        oos3.writeObject(user3);
        oos3.close();

        ObjectInputStream ois3 = new ObjectInputStream(new FileInputStream("d:/test3.text"));
        UserTransient u3 = (UserTransient) ois3.readObject();
        System.out.println(u3.getName());
        System.out.println(u3.getAge());
        ois3.close();
    }

}
