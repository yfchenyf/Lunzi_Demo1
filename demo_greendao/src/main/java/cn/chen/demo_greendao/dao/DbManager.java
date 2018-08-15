package cn.chen.demo_greendao.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by chencongcong
 * on 2018/8/2
 */
public class DbManager {
    //是否加密
    public static final boolean ENCYPTED = true;
    private static final String DB_NAME = "test_db";
    private static DbManager mDbManager;
    private static DaoMaster.DevOpenHelper mDevOpenHelper;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;
    private Context mContext;

    private DbManager(Context context) {
        this.mContext = context;
        //初始化数据库信息
        mDevOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        getDaoMaster(context);
        getDaoSession(context);
    }

    public static DbManager getInstance(Context context) {
        if (null == mDbManager) {
            synchronized (DbManager.class) {
                if (null == mDbManager) {
                    mDbManager = new DbManager(context);
                }
            }
        }
        return mDbManager;
    }

    /**
     * 获取可读数据库
     *
     * @param context
     * @return
     */
    public static SQLiteDatabase getReadableDatabase(Context context) {
        if (null == mDevOpenHelper) {
            getInstance(context);
        }
        return mDevOpenHelper.getReadableDatabase();
    }

    /**
     * 获取可写数据库
     *
     * @param context
     * @return
     */
    public static SQLiteDatabase getWriteableDatabase(Context context) {
        if (null == mDevOpenHelper) {
            getInstance(context);
        }
        return mDevOpenHelper.getWritableDatabase();
    }

    public static DaoMaster getDaoMaster(Context context) {
        if (null == mDaoMaster) {
            synchronized (DbManager.class) {
                if (null == mDaoMaster) {
                    MyOpenHelper openHelper = new MyOpenHelper(context, DB_NAME);
                    mDaoMaster = new DaoMaster(openHelper.getWritableDatabase());
                }
            }
        }
        return mDaoMaster;
    }

    public static DaoSession getDaoSession(Context context) {
        if (null == mDaoSession) {
            synchronized (DbManager.class) {
                mDaoSession = getDaoMaster(context).newSession();
            }
        }
        return mDaoSession;
    }

}
