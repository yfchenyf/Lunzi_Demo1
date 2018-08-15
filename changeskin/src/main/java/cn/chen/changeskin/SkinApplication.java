package cn.chen.changeskin;

import android.app.Application;

import skin.support.SkinCompatManager;
import skin.support.app.SkinCardViewInflater;
import skin.support.constraint.app.SkinConstraintViewInflater;
import skin.support.design.app.SkinMaterialViewInflater;

/**
 * Author by chencongcong,Date on 2018/8/9
 */
public class SkinApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //基础空间切换皮肤初始化
        SkinCompatManager.withoutActivity(this)
                //material design控件换肤初始化（可选）
                .addInflater(new SkinMaterialViewInflater())
                //ConstraintLayout 控件换肤初始化（可选）
        .addInflater(new SkinConstraintViewInflater())
                //CardView v7控件换肤初始化（可选）
        .addInflater(new SkinCardViewInflater())
                //关闭状态栏换肤，默认打开（可选）
        .setSkinStatusBarColorEnable(false)
                //关闭windowBackground换肤，默认打开（可选）
        .loadSkin();
    }
}
