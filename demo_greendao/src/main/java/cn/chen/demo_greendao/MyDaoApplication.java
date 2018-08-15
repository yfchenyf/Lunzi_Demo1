package cn.chen.demo_greendao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import cn.chen.demo_greendao.dao.DaoMaster;
import cn.chen.demo_greendao.dao.DaoSession;
import cn.chen.demo_greendao.dao.DbManager;

/**
 * Created by chencongcong
 * on 2018/8/2
 */
public class MyDaoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化数据库
        DbManager.getInstance(this);
    }

}
