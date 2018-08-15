package cn.chen.demo_greendao;

import android.app.AlertDialog;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import cn.chen.demo_greendao.entity.User;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("cn.chen.demo_greendao", appContext.getPackageName());
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
