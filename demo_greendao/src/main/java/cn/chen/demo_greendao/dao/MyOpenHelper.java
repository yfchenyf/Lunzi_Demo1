package cn.chen.demo_greendao.dao;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * Created by chencongcong
 * on 2018/8/2
 */
public class MyOpenHelper extends DaoMaster.OpenHelper {
    public MyOpenHelper(Context context, String name) {
        super(context, name);
    }

    /**
     * 数据库升级
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
//        //操作数据库的更新，所有的表数据都填入下面
        MigrationHelper.getInstance().migrate(db, NormalDao.class);
//        MigrationHelper.getInstance().migrate(db, UserDao.class);
//        MigrationHelper.getInstance().migrate(db, PersonDao.class);
    }
}
