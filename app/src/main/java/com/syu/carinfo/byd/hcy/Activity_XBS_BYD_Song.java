package com.syu.carinfo.byd.hcy;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.syu.adapter.AdapterCarInfo;
import com.syu.canbus.BaseActivityForFragment;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.byd.hcy.fragment.Fragment_Surui_CarSet;
import com.syu.carinfo.byd.hcy.fragment.Fragment_Surui_CarSet2;
import com.syu.carinfo.byd.hcy.fragment.Fragment_Surui_CarSet4;
import com.syu.carinfo.byd.hcy.fragment.Fragment_Surui_Pm25;
import com.syu.carinfo.byd.hcy.fragment.XBSBydSongTireAct;
import com.syu.entity.CarInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Activity_XBS_BYD_Song extends BaseActivityForFragment {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    List<Fragment> mFrags = new ArrayList();
    String[] titles = {"PM2.5", LauncherApplication.getInstance().getString(R.string.str_mrb_str1), LauncherApplication.getInstance().getString(R.string.str_driving_settings), LauncherApplication.getInstance().getString(R.string.others_settings), LauncherApplication.getInstance().getString(R.string.xp_yinglang_car_set_Second_str10)};

    @Override // com.syu.canbus.BaseActivityForFragment, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list);
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
        Fragment frag3 = new Fragment_Surui_CarSet2();
        this.mFrags.add(frag3);
        Fragment frag4 = new Fragment_Surui_CarSet4();
        this.mFrags.add(frag4);
        Fragment frag5 = new XBSBydSongTireAct();
        this.mFrags.add(frag5);
        for (int i = 0; i < this.titles.length; i++) {
            CarInfo carInfo = new CarInfo(11, 0, this.titles[i]);
            carInfo.setFragment(this.mFrags.get(i));
            this.mList.add(carInfo);
        }
    }
}