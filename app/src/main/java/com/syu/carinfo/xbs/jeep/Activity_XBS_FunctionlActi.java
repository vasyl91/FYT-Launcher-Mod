package com.syu.carinfo.xbs.jeep;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.syu.adapter.AdapterCarInfo;
import com.syu.canbus.R;
import com.syu.entity.CarInfo;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;
import java.util.List;

public class Activity_XBS_FunctionlActi extends Activity {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    int[] titles = {R.string.rzc_others_language_setting, R.string.wc_273_unit, R.string.lights_set, R.string.grdcherokee_door_and_lock, R.string.wc_273_safety, R.string.grdcherokee_suspension};
    Class[] clsess = {Activity_XBS_Language.class, Activity_XBS_Unit.class, Activity_XBS_LightSet.class, Activity_XBS_Door_Lock.class, Activity_XBS_Safety.class, Activity_XBS_Suspension.class};

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
        for (int i = 0; i < this.titles.length; i++) {
            CarInfo carInfo = new CarInfo(4, 0, getString(this.titles[i]));
            carInfo.setCls(this.clsess[i]);
            this.mList.add(carInfo);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(57, new int[]{11}, null, null);
    }
}
