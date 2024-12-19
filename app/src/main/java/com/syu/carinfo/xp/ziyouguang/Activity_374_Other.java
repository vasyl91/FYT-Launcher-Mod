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
public class Activity_374_Other extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_Other.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_Other.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.str_other_set_compass_set);
    }

    private void initValue() {
        CarInfo carInfo;
        CarInfo carInfo2 = new CarInfo(1, 205, R.string.str_mic_type);
        carInfo2.setCmd(10, 1);
        carInfo2.setDiplsys(new String[]{getString(R.string.str_mic_type1), getString(R.string.str_mic_type2)});
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, 345, R.string.str_steer_button_and_air);
        carInfo3.setCmd(10, 3);
        this.mList.add(carInfo3);
        if (DataCanbus.DATA[1000] == 2031990 || DataCanbus.DATA[1000] == 2294134 || DataCanbus.DATA[1000] == 2359670) {
            carInfo = new CarInfo(0, 346, R.string.str_open_the_door_and_shut_down);
        } else {
            carInfo = new CarInfo(0, 346, R.string.jeep_fengmingqi);
        }
        carInfo.setCmd(10, 4);
        this.mList.add(carInfo);
        if (DataCanbus.DATA[1000] == 2883958 || DataCanbus.DATA[1000] == 3932534 || DataCanbus.DATA[1000] == 2949494 || DataCanbus.DATA[1000] == 3015030 || DataCanbus.DATA[1000] == 3080566 || DataCanbus.DATA[1000] == 3146102 || DataCanbus.DATA[1000] == 3211638 || DataCanbus.DATA[1000] == 3277174 || DataCanbus.DATA[1000] == 3342710 || DataCanbus.DATA[1000] == 3408246 || DataCanbus.DATA[1000] == 3998070 || DataCanbus.DATA[1000] == 3473782 || DataCanbus.DATA[1000] == 3539318 || DataCanbus.DATA[1000] == 3604854 || DataCanbus.DATA[1000] == 3670390 || DataCanbus.DATA[1000] == 3735926 || DataCanbus.DATA[1000] == 3801462 || DataCanbus.DATA[1000] == 3866998) {
            CarInfo carInfo4 = new CarInfo(1, 404, R.string.klc_air_Air_conditioning);
            carInfo4.setCmd(10, 16);
            carInfo4.setDiplsys(new String[]{"14 Hand", "14 Auto", "16 Hand", "16 Auto"});
            this.mList.add(carInfo4);
        }
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
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[345].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[346].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[404].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[345].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[346].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[404].removeNotify(this.mNotifyCanbus);
    }
}
