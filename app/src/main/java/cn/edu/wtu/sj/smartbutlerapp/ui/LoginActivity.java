package cn.edu.wtu.sj.smartbutlerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import cn.edu.wtu.sj.smartbutlerapp.R;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_registered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        btn_registered= (Button) findViewById(R.id.btn_registered1);
        btn_registered.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_registered1:
                startActivity(new Intent(this,RegisteredActivity.class));
                break;
        }
    }
}
