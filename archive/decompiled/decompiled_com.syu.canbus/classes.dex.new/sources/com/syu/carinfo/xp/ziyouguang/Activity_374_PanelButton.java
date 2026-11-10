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
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Activity_374_PanelButton extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_PanelButton.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_PanelButton.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list);
        initValue();
        this.adapter = new AdapterCarInfo(this, this.mList);
        ((ListView) findViewById(R.id.list_carinfo)).setAdapter((ListAdapter) this.adapter);
        ((TextView) findViewById(R.id.tv_car_title)).setVisibility(0);
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.wc_psa_all_orinal_car_fuc);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(0, Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B7, R.string.str_320_h6_smart_startstop);
        carInfo.setCmd(0, 114);
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B6, R.string.str_car_stable_control);
        carInfo2.setCmd(0, 115);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B5, R.string.str_hdc);
        carInfo3.setCmd(0, 116);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(0, Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B4, R.string.radar_set);
        carInfo4.setCmd(0, 117);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B3, R.string.str_397_eco_mode);
        carInfo5.setCmd(0, 118);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B2, R.string.klc_sport_mode_Engine_sport);
        carInfo6.setCmd(0, 119);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B1, R.string.str_265_bnr_boyue_warning);
        carInfo7.setCmd(0, 120);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(0, Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B0, R.string.wc_372_lanewar);
        carInfo8.setCmd(0, 121);
        this.mList.add(carInfo8);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        this.adapter.updateList(this.mList);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[521].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[520].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[519].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[518].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[517].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[516].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[515].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[514].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[521].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[520].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[519].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[518].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[517].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[516].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[515].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[514].removeNotify(this.mNotifyCanbus);
    }
}
