package cn.edu.wtu.sj.smartbutlerapp.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 项目名 :SmartButlerApp
 * 创建者 :create by 黑仪想吃螃蟹了
 * 创建时间:2019/4/28 0028
 * 描述: TODO
 */
public class ToastUtils {
    public static void showToastSafe(final Context context, final String str){
        ThreadUtils.runInUIThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
