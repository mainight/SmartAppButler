package cn.edu.wtu.sj.smartbutlerapp.utils;

import android.os.Handler;

public class ThreadUtils {
   public static Handler handler=new Handler();
   public static void runInUIThread(Runnable task){
        handler.post(task);
   }
   public  static void runInThread(Runnable task){
       new Thread(task).start();
   }
}
