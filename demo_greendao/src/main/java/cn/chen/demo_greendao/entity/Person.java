package cn.chen.demo_greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by chencongcong
 * on 2018/8/2
 */
@Entity
public class Person {
    @Id
    private Long id;
    private String name;

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

    @Generated(hash = 628813901)
    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1024547259)
    public Person() {
    }

    @Override
    public String toString() {
        return "Person.class" +
                "id:" + id +
                "name:" + name +
                "\n";
    }
}
