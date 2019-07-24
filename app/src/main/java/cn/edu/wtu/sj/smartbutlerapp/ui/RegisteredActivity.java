package cn.edu.wtu.sj.smartbutlerapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.edu.wtu.sj.smartbutlerapp.R;
import cn.edu.wtu.sj.smartbutlerapp.entity.MyUser;
import cn.edu.wtu.sj.smartbutlerapp.utils.L;
import cn.edu.wtu.sj.smartbutlerapp.utils.ThreadUtils;
import cn.edu.wtu.sj.smartbutlerapp.utils.ToastUtils;

/**
*@author  :黑仪想吃螃蟹了
*版本     : 1.0
*创建日期 : 
*
*/
public class RegisteredActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_user;
    private EditText ut_age;
    private EditText ut_desc;
    private RadioGroup mRadioGroup;
    private EditText ut_email;
    private EditText ut_pass;
    private EditText ut_password;
    private Button BtnRegistered;
    //性别
    private Boolean isGender=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        initView();
    }

    private void initView() {
        et_user= (EditText) findViewById(R.id.ut_user);
        ut_age= (EditText) findViewById(R.id.ut_age);
        ut_desc= (EditText) findViewById(R.id.ut_desc);
        mRadioGroup= (RadioGroup) findViewById(R.id.mRadioGroup);
        ut_email= (EditText) findViewById(R.id.ut_email);
        ut_pass= (EditText) findViewById(R.id.ut_pass);
        ut_password= (EditText) findViewById(R.id.ut_password);
        BtnRegistered= (Button) findViewById(R.id.BtnRegistered);
        BtnRegistered.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.BtnRegistered:
                //获取输入框的值
                String name=et_user.getText().toString().trim();
                String age=ut_age.getText().toString().trim();
                String desc=ut_desc.getText().toString().trim();
                String email=ut_email.getText().toString().trim();
                String pass=ut_pass.getText().toString().trim();
                String password=ut_password.getText().toString().trim();
                if(!TextUtils.isEmpty(name)
                        &&!TextUtils.isEmpty(age)
                        &&!TextUtils.isEmpty(email)
                        &&!TextUtils.isEmpty(pass)
                        &&!TextUtils.isEmpty(password)){
                    //判断两次输入的密码是否一致
                    if (pass.equals(password)){
                        //先判断性别
                        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                if(checkedId==R.id.rb_boy){
                                    isGender=true;
                                }else if(checkedId==R.id.rb_girl) {
                                    isGender=false;
                                }
                            }
                        });
                        //判断简介是否为空
                        if (!TextUtils.isEmpty(desc)){
                            desc="这个人很懒，什么都没有留下";
                        }

                        //注册
                        MyUser user=new MyUser();
                        user.setUsername(name);
                        user.setPassword(password);
                        user.setEmail(email);
                        user.setAge(Integer.parseInt(age));
                        user.setSex(isGender);
                        user.setDesc(desc);
                        user.signUp(new SaveListener<MyUser>() {
                            @Override
                            public void done(MyUser o, BmobException e) {
                                if(e==null){
                                    ToastUtils.showToastSafe(RegisteredActivity.this,"注册成功"+e.toString());
                                }else {
                                    ToastUtils.showToastSafe(RegisteredActivity.this,"注册失败"+e.toString());
                                }
                            }
                        });
//                        user.save(new SaveListener<MyUser>() {
//                            @Override
//                            public void done(MyUser myUser, BmobException e) {
//                                if(e==null){
//                                    ToastUtils.showToastSafe(RegisteredActivity.this,"注册成功"+e.toString());
//                                    finish();
//                                }else {
//                                    ToastUtils.showToastSafe(RegisteredActivity.this,"注册失败"+e.toString());
//                                }
//                            }
//                        });


                    }else {
                        ToastUtils.showToastSafe(this,"两次输入的不一致");
                    }

                }else {
                    ToastUtils.showToastSafe(this,"输入框不能为空");
                }
                break;
        }
    }
}
