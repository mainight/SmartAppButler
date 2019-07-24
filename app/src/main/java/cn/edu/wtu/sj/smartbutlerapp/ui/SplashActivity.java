package cn.edu.wtu.sj.smartbutlerapp.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//import com.tencent.bugly.crashreport.CrashReport;

import cn.edu.wtu.sj.smartbutlerapp.R;
import cn.edu.wtu.sj.smartbutlerapp.utils.ShareUtils;
import cn.edu.wtu.sj.smartbutlerapp.utils.StaticClass;

public class SplashActivity extends AppCompatActivity {
    /**
     * 延时2000ms
     * 判断是否是第一次运行
     * 自定义字体
     * Activity全屏主题
     */
    private TextView tv_splash;
    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case StaticClass.HANDLER_SPLASH:
                    //判断程序是否是第一次运行
                    if (isFirst()){
                        startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                    }
                    else{
                        startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                    }
                    finish();
                   break;
            }
        }
    };

    private boolean isFirst() {
        //标记位SHARE_IS_FIRST是默认值第一次进入，默认为true，当第二次调用，有一个初始值false，所以不能赋值true
        boolean isFirst=ShareUtils.getBoolean(this,StaticClass.SHARE_IS_FIRST,false);
        if(isFirst){
            ShareUtils.putBoolean(this,StaticClass.SHARE_IS_FIRST,true);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //实现页面跳转
//        ThreadUtils.runInThread(new Runnable() {
//            @Override
//            public void run() {
//                SystemClock.sleep(3000);
//                startActivity(new Intent(SplashActivity.this, MainActivity.class));
//            }
//        });
        initView();

    }

    private void initView() {
        //延时2000ms
       handler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH, 2000);
        tv_splash= (TextView) findViewById(R.id.tv_splash);

    }
}
