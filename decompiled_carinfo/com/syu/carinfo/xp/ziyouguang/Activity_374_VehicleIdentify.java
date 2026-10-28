package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.content.SharedPreferences;
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

@SuppressWarnings({"deprecation", "unchecked"})
public class Activity_374_VehicleIdentify extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_VehicleIdentify.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    private SharedPreferences sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_list);
        this.sp1 = getSharedPreferences("type_button2", 0);
        initValue();
        this.adapter = new AdapterCarInfo(this, this.mList);
        ((ListView) findViewById(R.id.list_carinfo)).setAdapter((ListAdapter) this.adapter);
        ((TextView) findViewById(R.id.tv_car_title)).setVisibility(0);
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.str_374_vehicleidentify);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(10, 170, R.string.str_374_vehicleidentify);
        carInfo.setCmd(3, 0);
        carInfo.setDiplsys(new String[]{getString(R.string.str_374_vehicleidentify1), getString(R.string.str_374_vehicleidentify2), getString(R.string.str_374_vehicleidentify3)});
        carInfo.setSharedPreferences(this.sp1);
        carInfo.setVehicleIdentifyValue(this.sp1.getInt("vehicleidentify", 1));
        this.mList.add(carInfo);
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
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
    }
}
