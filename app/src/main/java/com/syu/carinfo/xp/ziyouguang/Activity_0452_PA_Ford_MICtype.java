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

public class Activity_0452_PA_Ford_MICtype extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_0452_PA_Ford_MICtype.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.str_other_set_compass_set);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(1, 110, R.string.str_mic_type);
        carInfo.setCmd(10, 1);
        carInfo.setDiplsys(new String[]{getString(R.string.str_mic_type1), getString(R.string.str_mic_type2)});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, 130, R.string.str_steer_button_and_air);
        carInfo2.setCmd(10, 3);
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
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
    }
}
