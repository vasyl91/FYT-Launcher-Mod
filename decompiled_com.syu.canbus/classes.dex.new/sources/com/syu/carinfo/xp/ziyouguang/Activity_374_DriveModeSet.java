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
public class Activity_374_DriveModeSet extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_DriveModeSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_DriveModeSet.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.driving_mode_info1);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(1, Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D0_B76, R.string.driving_mode_info1);
        carInfo.setCmd(0, 217);
        carInfo.setDiplsys(new String[]{"Default", "Track", "Sport", "Custom"});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(1, Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D0_B54, "Trans");
        carInfo2.setCmd(0, 218);
        carInfo2.setDiplsys(new String[]{"Track", "Sport", "Street"});
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D1_B5, "Paddle");
        carInfo3.setCmd(0, 219);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(1, Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D0_B32, "Traction");
        carInfo4.setCmd(0, 220);
        carInfo4.setDiplsys(new String[]{"Track", "Sport", "Street"});
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(1, Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D0_B10, "Suspension");
        carInfo5.setCmd(0, 221);
        carInfo5.setDiplsys(new String[]{"Track", "Sport", "Street"});
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(1, Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D1_B76, "Steering");
        carInfo6.setCmd(0, 222);
        carInfo6.setDiplsys(new String[]{"Track", "Sport", "Street"});
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D1_B4, "ECO");
        carInfo7.setCmd(0, 223);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(1, Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D1_B3, "Race Options");
        carInfo8.setCmd(0, 224);
        carInfo8.setDiplsys(new String[]{"Cancel Launch Control", "Activate Launch Control"});
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(1, Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D2_B70, "Race Options: LAUNCH RANGE");
        carInfo9.setCmd(0, 225);
        carInfo9.setDiplsys(new String[]{"1500", "1750", "2000", "2250", "2500", "2750", "3000", "3250", "3500"});
        this.mList.add(carInfo9);
        CarInfo carInfo10 = new CarInfo(1, Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D3_B70, "Shift Light RPM Set Up->1st Gear");
        carInfo10.setCmd(0, 226);
        carInfo10.setDiplsys(new String[]{"2000", "2250", "2500", "2750", "3000", "3250", "3500", "3750", "4000", "4250", "4500", "4750", "5000", "5250", "5500", "5750", "6000", "6250"});
        this.mList.add(carInfo10);
        CarInfo carInfo11 = new CarInfo(1, Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D4_B70, "Shift Light RPM Set Up->2nd Gear");
        carInfo11.setCmd(0, 227);
        carInfo11.setDiplsys(new String[]{"2000", "2250", "2500", "2750", "3000", "3250", "3500", "3750", "4000", "4250", "4500", "4750", "5000", "5250", "5500", "5750", "6000", "6250"});
        this.mList.add(carInfo11);
        CarInfo carInfo12 = new CarInfo(1, Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D5_B70, "Shift Light RPM Set Up->3rd Gear");
        carInfo12.setCmd(0, 228);
        carInfo12.setDiplsys(new String[]{"2000", "2250", "2500", "2750", "3000", "3250", "3500", "3750", "4000", "4250", "4500", "4750", "5000", "5250", "5500", "5750", "6000", "6250"});
        this.mList.add(carInfo12);
        CarInfo carInfo13 = new CarInfo(1, Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D6_B70, "Shift Light RPM Set Up->4th Gear");
        carInfo13.setCmd(0, 229);
        carInfo13.setDiplsys(new String[]{"2000", "2250", "2500", "2750", "3000", "3250", "3500", "3750", "4000", "4250", "4500", "4750", "5000", "5250", "5500", "5750", "6000", "6250"});
        this.mList.add(carInfo13);
        CarInfo carInfo14 = new CarInfo(1, Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D7_B70, "Shift Light RPM Set Up->5-8th Gear");
        carInfo14.setCmd(0, 230);
        carInfo14.setDiplsys(new String[]{"2000", "2250", "2500", "2750", "3000", "3250", "3500", "3750", "4000", "4250", "4500", "4750", "5000", "5250", "5500", "5750", "6000", "6250"});
        this.mList.add(carInfo14);
        CarInfo carInfo15 = new CarInfo(0, Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D1_B2, "Shift Light");
        carInfo15.setCmd(0, 231);
        this.mList.add(carInfo15);
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
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
    }
}
