package cn.chen.demo_greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by chencongcong
 * on 2018/8/2
 */
@Entity
public class User {
    @Id
    private Long id;
    private String name;
    //添加次标记之后不会生成数据库表的列
    private String sex;

    @Transient
    private int tempUsageCount;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 1265202627)
    public User(Long id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    @Override
    public String toString() {
        return "User.class" +
                "id:" + id +
                "name:" + name +
                "sex:" + sex +
                "\n";
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
