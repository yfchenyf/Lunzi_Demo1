package cn.chen.demo_greendao;

import org.junit.Test;

import java.util.List;

import cn.chen.demo_greendao.entity.User;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void insertUser() {
        User user = new User(2L, "anye3");
        MyDaoApplication.getInstances().getDaoSession().getUserDao().insert(user);
    }

    @Test
    public void deleteUser() {
        MyDaoApplication.getInstances().getDaoSession().getUserDao().deleteByKey(2L);
    }

    @Test
    public void editUser() {
        User mUser = new User(2L, "anye0908");
        MyDaoApplication.getInstances().getDaoSession().getUserDao().insertOrReplace(mUser);
    }

    @Test
    public void selectUser() {
        List<User> users = MyDaoApplication.getInstances().getDaoSession().getUserDao().loadAll();
        String userName = "";
        for (int i = 0; i < users.size(); i++) {
            userName += users.get(i).getName() + ",";
        }
        assertNotNull(userName);
    }
}