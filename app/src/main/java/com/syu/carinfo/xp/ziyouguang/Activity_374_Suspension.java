package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.syu.adapter.AdapterCarInfo;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.entity.CarInfo;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"deprecation", "unchecked"})
public class Activity_374_Suspension extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_Suspension.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.grdcherokee_suspension);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(0, 148, R.string.str_373_auto_adjust_suspension);
        carInfo.setCmd(0, 208);
        carInfo.setDiplsys(new String[]{getString(R.string.str_unit_us_imperial), getString(R.string.str_unit_metric)});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, 149, R.string.str_373_tire_jacks);
        carInfo2.setCmd(0, 209);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, 150, R.string.str_373_transport_mode);
        carInfo3.setCmd(0, 210);
        carInfo3.setDiplsys(new String[]{CamryData.MILEAGE_UNIT_KM, "MI"});
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(0, 151, R.string.str_373_wheel_alignment_mode);
        carInfo4.setCmd(0, 211);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(3, 152, R.string.str_373_display_suspension1);
        carInfo5.setCmd(0, 212);
        carInfo5.setDiplsys(new String[]{getString(R.string.str_all), getString(R.string.wc_321_warning_wan_str)});
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, 224, R.string.str_flash_Light_with_Lower);
        carInfo6.setCmd(0, 228);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, 225, R.string.str_sound_Horn_with_Lower);
        carInfo7.setCmd(0, 229);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(0, 226, R.string.str_aero_Mode);
        carInfo8.setCmd(0, 230);
        this.mList.add(carInfo8);
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
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
    }
}
