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
public class Activity_374_RearScreenSettings extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_RearScreenSettings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_RearScreenSettings.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.str_rear_seat_ceiling_screen);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(0, 337, R.string.str_rear_seat_screen);
        carInfo.setCmd(18, 0);
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, 338, R.string.str_remote_control_lock);
        carInfo2.setCmd(18, 1);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(1, 339, R.string.str_backseat_media_source);
        carInfo3.setCmd(18, 2);
        carInfo3.setDiplsys(new String[]{"Rear Aux", "Front Source", "Front Aux"});
        this.mList.add(carInfo3);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[337].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[338].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[339].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[337].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[338].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[339].removeNotify(this.mNotifyCanbus);
    }
}