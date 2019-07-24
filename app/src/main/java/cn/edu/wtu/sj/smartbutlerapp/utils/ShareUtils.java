package cn.edu.wtu.sj.smartbutlerapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 项目名 :SmartButlerApp
 * 创建者 :create by 黑仪想吃螃蟹了
 * 创建时间:2019/4/28 0028
 * 描述: TODO
 */
public class ShareUtils {
    private  static final String NAME="date";
    public static  void putString(Context mContext,String key,String value){
        SharedPreferences sp=mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }
    //键默认值
    public static String getString(Context mContext,String key,String deValue){
        SharedPreferences sp=mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getString(key,deValue);
    }
    //Boolean默认值
    public static  void putBoolean(Context mContext,String key,Boolean value){
        SharedPreferences sp=mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).commit();
    }
    //键默认值
    public static boolean getBoolean(Context mContext, String key, Boolean deValue){
        SharedPreferences sp=mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key,deValue);
    }
    //int默认值
    public static  void putInt(Context mContext,String key,int value){
        SharedPreferences sp=mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(key,value).commit();
    }
    //键默认值
    public static int getInt(Context mContext, String key, int deValue){
        SharedPreferences sp=mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getInt(key,deValue);
    }
    //删除单个
    public static  void deleShare(Context mContext ,String key){
        SharedPreferences sp=mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().remove(key).commit();
    }
    //删除全部
    public static void deleAll(Context mContext){
        SharedPreferences sp=mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().clear();
    }
}
