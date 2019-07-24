package cn.edu.wtu.sj.smartbutlerapp.frament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.wtu.sj.smartbutlerapp.R;

/**
 * 项目名：
 * 包含：
 * 文件名：
 * 创建者：CC
 * Created by Administrator on 2019/3/17 0017.
 * 描述：
 */

public class GirlFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.girl,null);
        return view;
    }
}
