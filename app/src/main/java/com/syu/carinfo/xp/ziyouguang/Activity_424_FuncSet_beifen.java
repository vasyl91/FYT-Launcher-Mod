package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.syu.adapter.AdapterCarInfo;
import com.syu.canbus.R;
import com.syu.entity.CarInfo;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;
import java.util.List;

public class Activity_424_FuncSet_beifen extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_424_FuncSet_beifen.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_list);
        initValue();
        this.adapter = new AdapterCarInfo(this, this.mList);
        ((ListView) findViewById(R.id.list_carinfo)).setAdapter((ListAdapter) this.adapter);
        ((TextView) findViewById(R.id.tv_car_title)).setVisibility(0);
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.str_car_settings);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(1, 105, R.string.rzc_others_language_setting);
        carInfo.setCmd(0, 3);
        carInfo.setDiplsys(new String[]{"English", "Françai", "Espanol", "Pyccknn", "Turkce", "Portugues", "Italiano", "Deutsh", "Hebrew", "Japanese", "Korean", "中文", "Farsi", "Portugues", "Espanol", "Greek", "Polshi", "Romana", "Norsk", "Nederlans", "Dansk", "CesKy", "Suomi"});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, 106, R.string.radar_set);
        carInfo2.setCmd(0, 1);
        this.mList.add(carInfo2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
    }
}
