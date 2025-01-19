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

public class Activity_374_Safety2 extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_Safety2.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.wc_273_safety2);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(0, 212, R.string.str_paddle_shifting);
        carInfo.setCmd(0, 167);
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(1, 213, R.string.str_steering_settings);
        carInfo2.setCmd(0, 168);
        carInfo2.setDiplsys(new String[]{getString(R.string.driver_system_standard), getString(R.string.driver_system_sports), getString(R.string.wc_gs4_driver_help_turn_mode_comfort)});
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(1, 214, R.string.str_offset_distance_alarm);
        carInfo3.setCmd(0, 158);
        carInfo3.setDiplsys(new String[]{getString(R.string.off), getString(R.string.jeep_parksense_0), getString(R.string.jeep_parksense_1)});
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(1, 215, R.string.str_offset_distance_alarm_vol);
        carInfo4.setCmd(0, 159);
        carInfo4.setDiplsys(new String[]{getString(R.string.klc_air_low), getString(R.string.klc_air_middle), getString(R.string.klc_air_high)});
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(1, 216, R.string.str_pedestrian_safety_aid);
        carInfo5.setCmd(0, 194);
        carInfo5.setDiplsys(new String[]{getString(R.string.off), getString(R.string.str_brake), getString(R.string.wc_weilang_auto_fangzhuang_warn), getString(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong)});
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, 324, R.string.str_cargo_camera_dynamic_centerline);
        carInfo6.setCmd(0, 83);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, 325, R.string.str_surround_view_camera_guidelines);
        carInfo7.setCmd(0, 84);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(0, 326, R.string.str_rear_guidance_lights_w_cargo_lights);
        carInfo8.setCmd(0, 85);
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(4, 212, R.string.str_headrest_fold);
        carInfo9.setCmd(0, 213);
        this.mList.add(carInfo9);
        CarInfo carInfo10 = new CarInfo(4, 8, R.string.str_374_rear_sunshade);
        carInfo10.setCmd(0, 214);
        this.mList.add(carInfo10);
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
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[324].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[325].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[326].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[324].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[325].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[326].removeNotify(this.mNotifyCanbus);
    }
}
