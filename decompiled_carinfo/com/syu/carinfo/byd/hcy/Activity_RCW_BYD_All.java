package com.syu.carinfo.byd.hcy;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.adapter.AdapterCarInfo;
import com.syu.canbus.BaseActivityForFragment;
import com.syu.canbus.R;
import com.syu.carinfo.byd.hcy.fragment.Fragment_Surui_CarSet;
import com.syu.carinfo.byd.hcy.fragment.Fragment_Surui_Pm25;
import com.syu.entity.CarInfo;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"deprecation", "unchecked"})
public class Activity_RCW_BYD_All extends BaseActivityForFragment {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    List<Fragment> mFrags = new ArrayList();
    String[] titles = {"PM2.5", LauncherApplication.getInstance().getString(R.string.str_mrb_str1)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_list);
        this.mText = (TextView) findViewById(R.id.tv_car_title);
        this.mListView = (ListView) findViewById(R.id.list_carinfo);
        initValue();
        this.adapter = new AdapterCarInfo(this, this.mList);
        this.mListView.setAdapter((ListAdapter) this.adapter);
        this.mText.setVisibility(0);
        this.mText.setText(R.string.wc_jianianhua_settings_title);
    }

    private void initValue() {
        Fragment frag = new Fragment_Surui_Pm25();
        this.mFrags.add(frag);
        Fragment frag2 = new Fragment_Surui_CarSet();
        this.mFrags.add(frag2);
        for (int i = 0; i < this.titles.length; i++) {
            CarInfo carInfo = new CarInfo(11, 0, this.titles[i]);
            carInfo.setFragment(this.mFrags.get(i));
            this.mList.add(carInfo);
        }
    }
}
