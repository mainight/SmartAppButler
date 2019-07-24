package cn.edu.wtu.sj.smartbutlerapp.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.wtu.sj.smartbutlerapp.R;
import cn.edu.wtu.sj.smartbutlerapp.utils.L;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager mViewPage;
    //容器
    List<View> mList=new ArrayList<>();
    private View view1,view2 ,view3;
    //小圆点
    private ImageView point1,point2,point3;
    //跳过
    private ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
//        ThreadUtils.runInThread(new Runnable() {
//            @Override
//            public void run() {
//                SystemClock.sleep(3000);
//                startActivity(new Intent(GuideActivity.this, MainActivity.class));
//                finish();
//            }
//        });
        initView();
    }

    private void initView() {
        ivBack= (ImageView) findViewById(R.id.ivBack);
        point1= (ImageView) findViewById(R.id.point1);
        point2= (ImageView) findViewById(R.id.point2);
        point3= (ImageView) findViewById(R.id.point3);
        //设置 默认图片
        setPointImg(true,false,false);
        mViewPage= (ViewPager) findViewById(R.id.ViewPager);
        view1= View.inflate(this,R.layout.pager_item_one,null);
        view2= View.inflate(this,R.layout.pager_item_two,null);
        view3= View.inflate(this,R.layout.pager_item_three,null);
        view3.findViewById(R.id.start_view3_button).setOnClickListener(this);
        ivBack.setOnClickListener(this);
        mList.add(view1);
        mList.add(view2);
        mList.add(view3);
        //设置适配器
          mViewPage.setAdapter(new GuideAdapter());
          mViewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
              @Override
              public void onPageScrolled(int i, float v, int i1) {

              }

              @Override
              public void onPageSelected(int i) {
                 switch (i){
                     case 0:
                         setPointImg(true,false,false);
                         ivBack.setVisibility(View.VISIBLE);
                         break;
                     case 1:
                         setPointImg(false,true,false);
                         ivBack.setVisibility(View.VISIBLE);
                         break;
                     case 2:
                         setPointImg(false,false,true);
                         ivBack.setVisibility(View.VISIBLE);
                         break;
                 }
              }

              @Override
              public void onPageScrollStateChanged(int i) {

              }
          });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        case R.id.start_view3_button:
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        break;
        case R.id.ivBack:
            L.d("ivback");
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        break;}
    }

    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view==o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ((ViewPager)container).addView(mList.get(position));
            return mList.get(position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            ((ViewPager)container).removeView(mList.get(position));
        }

    }
    //设置小圆点的选中
    private void setPointImg(Boolean isCheck1,Boolean isCheck2,Boolean isCheck3){
        if (isCheck1){
            point1.setBackgroundResource(R.drawable.point);
        }else {
            point1.setBackgroundResource(R.drawable.gear);
        }
        if (isCheck2){
            point2.setBackgroundResource(R.drawable.point);
        }else {
            point2.setBackgroundResource(R.drawable.gear);
        }
        if (isCheck3){
            point3.setBackgroundResource(R.drawable.point);
        }else {
            point3.setBackgroundResource(R.drawable.gear);
        }
    }
}
