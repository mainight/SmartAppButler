package cn.edu.wtu.sj.smartbutlerapp.utils;

import android.util.Log;

public class L {
    private static final Boolean DEBUG=true;
    private static String TAG="SmartButler";
    public static void d(String text){
        if (DEBUG){
            Log.d(TAG,text);
        }
    }
    public static void w(String text){
        if (DEBUG){
            Log.w(TAG,text);
        }
    }
    public static void e(String text){
        if (DEBUG){
            Log.e(TAG,text);
        }
    }
    public static void v(String text){
        if (DEBUG){
            Log.v(TAG,text);
        }
    }
}
