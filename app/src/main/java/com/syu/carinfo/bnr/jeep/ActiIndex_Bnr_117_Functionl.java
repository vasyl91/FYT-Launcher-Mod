package com.syu.carinfo.bnr.jeep;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.syu.adapter.AdapterCarInfo;
import com.syu.canbus.BaseActivityForFragment;
import com.syu.canbus.R;
import com.syu.entity.CarInfo;

import java.util.ArrayList;
import java.util.List;

public class ActiIndex_Bnr_117_Functionl extends BaseActivityForFragment {
    List<CarInfo> mList = new ArrayList();
    List<Fragment> mFrags = new ArrayList();
    int[] titles = {R.string.jeep_carcd, R.string.vehicle_personalization};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_list);
        initValue();
        ((ListView) findViewById(R.id.list_carinfo)).setAdapter((ListAdapter) new AdapterCarInfo(this, this.mList));
        ((TextView) findViewById(R.id.tv_car_title)).setVisibility(0);
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.wc_jianianhua_settings_title);
    }

    private void initValue() {
        Fragment frag = new CDFragment();
        this.mFrags.add(frag);
        Fragment frag2 = new IndexFuncFragment();
        this.mFrags.add(frag2);
        for (int i = 0; i < this.titles.length; i++) {
            CarInfo carInfo = new CarInfo(11, 0, getString(this.titles[i]));
            carInfo.setFragment(this.mFrags.get(i));
            this.mList.add(carInfo);
        }
    }
}
