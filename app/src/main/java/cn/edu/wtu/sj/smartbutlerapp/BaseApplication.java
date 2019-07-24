package cn.edu.wtu.sj.smartbutlerapp;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * 项目名 :Bmob3
 * 创建者 :create by 黑仪想吃螃蟹了
 * 创建时间:2019/5/5 0005
 * 描述: TODO
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
       //Bmob.initialize(this, "0fae3882703d2df1ef46d7a328bca4db");
    }
}
