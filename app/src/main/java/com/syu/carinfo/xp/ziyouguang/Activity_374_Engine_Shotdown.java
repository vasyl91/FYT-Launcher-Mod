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
public class Activity_374_Engine_Shotdown extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_Engine_Shotdown.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_Engine_Shotdown.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.grdcherokee_engine_shotdown_option);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(1, 110, R.string.jeep_headlights_off_delay);
        carInfo.setCmd(0, 64);
        carInfo.setDiplsys(new String[]{"0 sec", "30 sec", "60 sec", "90 sec"});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(1, 111, R.string.jeep_power_off_delay);
        carInfo2.setCmd(0, 65);
        carInfo2.setDiplsys(new String[]{"0 sec", "45sec", "5min", "10min"});
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, 112, R.string.str_373_seat_facilitiates_access);
        carInfo3.setCmd(0, 66);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(1, 186, R.string.str_shutdown_mode);
        carInfo4.setCmd(0, 67);
        carInfo4.setDiplsys(new String[]{"Acc off + Door open", "Acc off"});
        this.mList.add(carInfo4);
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
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
    }
}