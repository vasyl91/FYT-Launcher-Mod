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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Activity_374_LightSet extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_LightSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_LightSet.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.lights_set);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(1, 90, R.string.rzc_biglight_sleep_value);
        carInfo.setCmd(0, 32);
        carInfo.setDiplsys(new String[]{"0 s", "30 s", "60 s", "90 s"});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, 91, R.string.jeep_locklights);
        carInfo2.setCmd(0, 35);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(1, 92, R.string.wc_372_nearlight);
        carInfo3.setCmd(0, 33);
        carInfo3.setDiplsys(new String[]{"0 s", "30 s", "60 s", "90 s"});
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(0, 93, R.string.wc_372_daylightstr);
        carInfo4.setCmd(0, 36);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 94, R.string.str_cornering_lights);
        carInfo5.setCmd(0, 37);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, 95, R.string.str_374_lightwiper);
        carInfo6.setCmd(0, 38);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, 96, R.string.jeep_373_rearview_mirror);
        carInfo7.setCmd(0, 39);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(0, 97, R.string.jeep_autodimminghighbeams);
        carInfo8.setCmd(0, 40);
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(1, 98, R.string.str_372_headlight_sensitivity);
        carInfo9.setCmd(0, 41);
        carInfo9.setDiplsys(new String[]{"1", "2", "3"});
        this.mList.add(carInfo9);
        CarInfo carInfo10 = new CarInfo(1, 167, R.string.str_turui_str5);
        carInfo10.setCmd(0, 43);
        carInfo10.setDiplsys(new String[]{"0", "1", "2", "3", "4", "5", "6"});
        this.mList.add(carInfo10);
        CarInfo carInfo11 = new CarInfo(0, 99, R.string.str_372_greeting_light);
        carInfo11.setCmd(0, 42);
        this.mList.add(carInfo11);
        CarInfo carInfo12 = new CarInfo(0, 159, R.string.str_374_lightwiper);
        carInfo12.setCmd(0, 34);
        this.mList.add(carInfo12);
        CarInfo carInfo13 = new CarInfo(0, 374, R.string.str_adaptive_front_lights);
        carInfo13.setCmd(0, 101);
        this.mList.add(carInfo13);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{64}, null, null);
        addNotify();
        for (int i = 0; i < this.mList.size(); i++) {
            if (this.mList.get(i).getUpdateCode() == 95 || this.mList.get(i).getUpdateCode() == 96) {
                if (DataCanbus.carId == 0 || DataCanbus.carId == 1 || DataCanbus.carId == 14 || DataCanbus.carId == 15 || DataCanbus.carId == 21 || DataCanbus.carId == 22 || DataCanbus.carId == 23 || DataCanbus.carId == 24 || DataCanbus.carId == 25 || DataCanbus.carId == 26 || DataCanbus.carId == 28 || DataCanbus.carId == 29 || DataCanbus.carId == 32 || DataCanbus.carId == 33) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 92 || this.mList.get(i).getUpdateCode() == 97) {
                if (DataCanbus.carId == 0 || DataCanbus.carId == 1 || DataCanbus.carId == 14 || DataCanbus.carId == 15 || DataCanbus.carId == 21 || DataCanbus.carId == 22 || DataCanbus.carId == 23 || DataCanbus.carId == 24 || DataCanbus.carId == 25 || DataCanbus.carId == 26 || DataCanbus.carId == 28 || DataCanbus.carId == 29 || DataCanbus.carId == 32 || DataCanbus.carId == 33) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 99) {
                if (DataCanbus.carId == 2 || DataCanbus.carId == 16) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 374) {
                if (DataCanbus.carId == 21 || DataCanbus.carId == 22 || DataCanbus.carId == 23 || DataCanbus.carId == 24 || DataCanbus.carId == 25 || DataCanbus.carId == 26 || DataCanbus.carId == 28 || DataCanbus.carId == 29 || DataCanbus.carId == 32 || DataCanbus.carId == 33) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 98) {
                if (DataCanbus.carId == 2 || DataCanbus.carId == 16 || DataCanbus.carId == 21 || DataCanbus.carId == 22 || DataCanbus.carId == 23 || DataCanbus.carId == 24 || DataCanbus.carId == 25 || DataCanbus.carId == 26 || DataCanbus.carId == 28 || DataCanbus.carId == 29 || DataCanbus.carId == 32 || DataCanbus.carId == 33) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (DataCanbus.carId == 10) {
                if (this.mList.get(i).getUpdateCode() == 92 || this.mList.get(i).getUpdateCode() == 159) {
                    this.mList.get(i).setShowable(true);
                }
                if (this.mList.get(i).getUpdateCode() == 94 || this.mList.get(i).getUpdateCode() == 93) {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (DataCanbus.carId == 8) {
                if (this.mList.get(i).getUpdateCode() == 93) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 159) {
                if (DataCanbus.carId == 11 || DataCanbus.carId == 21 || DataCanbus.carId == 22 || DataCanbus.carId == 23 || DataCanbus.carId == 24 || DataCanbus.carId == 25 || DataCanbus.carId == 26 || DataCanbus.carId == 28 || DataCanbus.carId == 29 || DataCanbus.carId == 32 || DataCanbus.carId == 33) {
                    this.mList.get(i).setShowable(false);
                } else {
                    this.mList.get(i).setShowable(true);
                }
            }
        }
        this.adapter.updateList(this.mList);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[374].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[374].removeNotify(this.mNotifyCanbus);
    }
}
