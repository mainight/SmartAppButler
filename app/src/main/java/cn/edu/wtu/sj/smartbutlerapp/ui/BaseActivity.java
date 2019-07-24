package cn.edu.wtu.sj.smartbutlerapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * 项目名 :SmartButlerApp
 * 创建者 :create by 黑仪想吃螃蟹了
 * 创建时间:2019/4/27
 * 描述:
 * 主要做的事
 * 统一的属性
 * 统一的接口
 * 统一的函数
 * 统一的方法
 *
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //显示返回键
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //菜单栏操作

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
