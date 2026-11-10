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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Activity_374_FordCarSet2 extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_FordCarSet2.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_FordCarSet2.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.str_sb_saiou3_str1);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(0, 460, "Auto Highbeam");
        carInfo.setCmd(0, 37);
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, 461, "Daytime Running Lights");
        carInfo2.setCmd(0, 38);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(1, 462, "Autolamp Delay");
        carInfo3.setCmd(0, 39);
        carInfo3.setDiplsys(new String[]{"off", "10s", "20s", "120s"});
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(0, 463, "Autounlock");
        carInfo4.setCmd(0, 40);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 464, "Mislock Chirp");
        carInfo5.setCmd(0, 41);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, 465, "Switches Inhibit");
        carInfo6.setCmd(0, 42);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, 466, "Audible feedback");
        carInfo7.setCmd(0, 43);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(1, 467, "Remote Unlock");
        carInfo8.setCmd(0, 44);
        carInfo8.setDiplsys(new String[]{"All doors", "Driver's door"});
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(0, 468, "Auto hold");
        carInfo9.setCmd(0, 45);
        this.mList.add(carInfo9);
        CarInfo carInfo10 = new CarInfo(0, 469, "Key Detection Alert");
        carInfo10.setCmd(0, 46);
        this.mList.add(carInfo10);
        CarInfo carInfo11 = new CarInfo(0, 470, "Seat Adjustment");
        carInfo11.setCmd(0, 47);
        this.mList.add(carInfo11);
        CarInfo carInfo12 = new CarInfo(0, 471, "Ask on Exit");
        carInfo12.setCmd(0, 48);
        this.mList.add(carInfo12);
        CarInfo carInfo13 = new CarInfo(0, 472, "Motion Sensors");
        carInfo13.setCmd(0, 49);
        this.mList.add(carInfo13);
        CarInfo carInfo14 = new CarInfo(0, 473, "Seats and Steering Wheel");
        carInfo14.setCmd(0, 50);
        this.mList.add(carInfo14);
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
        DataCanbus.NOTIFY_EVENTS[440].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[441].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[442].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[443].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[444].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[445].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[446].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[447].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[448].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[449].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[450].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[451].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[452].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[453].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[454].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[455].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[456].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[457].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[458].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[459].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[460].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[461].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[462].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[463].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[464].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[465].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[466].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[467].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[468].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[469].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[470].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[471].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[472].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[473].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[440].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[441].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[442].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[443].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[444].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[445].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[446].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[447].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[448].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[449].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[450].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[451].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[452].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[453].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[454].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[455].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[456].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[457].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[458].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[459].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[460].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[461].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[462].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[463].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[464].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[465].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[466].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[467].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[468].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[469].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[470].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[471].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[472].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[473].removeNotify(this.mNotifyCanbus);
    }
}
