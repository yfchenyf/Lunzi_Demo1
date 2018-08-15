package cn.chen.demo_greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by chencongcong
 * on 2018/8/2
 */
@Entity
public class Normal {
    @Id
    private Long id;
    private String name;
    private int testInt;
    private String testStr;
    private String testInt1;
    private String a;
    private String b;
    private String c;
    private Integer d;

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

    public int getTestInt() {
        return this.testInt;
    }

    public void setTestInt(int testInt) {
        this.testInt = testInt;
    }

    public String getTestStr() {
        return this.testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public String getTestInt1() {
        return this.testInt1;
    }

    public void setTestInt1(String testInt1) {
        this.testInt1 = testInt1;
    }

    public String getA() {
        return this.a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return this.b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return this.c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public Integer getD() {
        return this.d;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    @Generated(hash = 1800009939)
    public Normal(Long id, String name, int testInt, String testStr, String testInt1, String a, String b, String c,
            Integer d) {
        this.id = id;
        this.name = name;
        this.testInt = testInt;
        this.testStr = testStr;
        this.testInt1 = testInt1;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Generated(hash = 1098000133)
    public Normal() {
    }
}
