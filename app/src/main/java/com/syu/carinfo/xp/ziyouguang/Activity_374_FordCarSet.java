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
public class Activity_374_FordCarSet extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_FordCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_FordCarSet.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.str_sb_saiou3_str0);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(1, 428, R.string.str_wc_174008_str1);
        carInfo.setCmd(0, 16);
        carInfo.setDiplsys(new String[]{"alert", "aid", "aid+alert"});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(1, 429, R.string.str_lane_assist_sensitivity);
        carInfo2.setCmd(0, 17);
        carInfo2.setDiplsys(new String[]{getString(R.string.klc_air_high), getString(R.string.klc_air_middle), getString(R.string.klc_air_low)});
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, 430, R.string.bsd_klj_str9);
        carInfo3.setCmd(0, 18);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(1, 431, R.string.dj_airuize7_warning);
        carInfo4.setCmd(0, 19);
        carInfo4.setDiplsys(new String[]{getString(R.string.klc_air_high), getString(R.string.klc_air_middle), getString(R.string.klc_air_low)});
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 432, R.string.rzc_others_assist_car_assister);
        carInfo5.setCmd(0, 20);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, 433, R.string.str_rear_view_camera_delay);
        carInfo6.setCmd(0, 21);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, 434, "Evasive Steering");
        carInfo7.setCmd(0, 22);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(0, 435, "Blind Spot Information System");
        carInfo8.setCmd(0, 23);
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(0, 436, "Trailer Sway Control");
        carInfo9.setCmd(0, 24);
        this.mList.add(carInfo9);
        CarInfo carInfo10 = new CarInfo(0, 437, "Park Aid");
        carInfo10.setCmd(0, 25);
        this.mList.add(carInfo10);
        CarInfo carInfo11 = new CarInfo(0, 438, "Cross Traffic Alert");
        carInfo11.setCmd(0, 26);
        this.mList.add(carInfo11);
        CarInfo carInfo12 = new CarInfo(0, 439, "Driver Alert");
        carInfo12.setCmd(0, 27);
        this.mList.add(carInfo12);
        CarInfo carInfo13 = new CarInfo(0, 440, "30 min Max Idle");
        carInfo13.setCmd(0, 28);
        this.mList.add(carInfo13);
        CarInfo carInfo14 = new CarInfo(0, 441, "Activate remote start");
        carInfo14.setCmd(0, 29);
        this.mList.add(carInfo14);
        CarInfo carInfo15 = new CarInfo(1, 442, "Remote Start ->Climate Control");
        carInfo15.setCmd(0, 31);
        carInfo15.setDiplsys(new String[]{"AUTO", "Last"});
        this.mList.add(carInfo15);
        CarInfo carInfo16 = new CarInfo(1, 443, "Remote Start ->Duration");
        carInfo16.setCmd(0, 32);
        carInfo16.setDiplsys(new String[]{"5min", "10min", "15min"});
        this.mList.add(carInfo16);
        CarInfo carInfo17 = new CarInfo(0, 444, "Courtesy Wipe");
        carInfo17.setCmd(0, 33);
        this.mList.add(carInfo17);
        CarInfo carInfo18 = new CarInfo(0, 445, "Reverse Wipe");
        carInfo18.setCmd(0, 34);
        this.mList.add(carInfo18);
        CarInfo carInfo19 = new CarInfo(0, 446, "Mirrors Autofold");
        carInfo19.setCmd(0, 35);
        this.mList.add(carInfo19);
        CarInfo carInfo20 = new CarInfo(0, 447, "Power Liftgate");
        carInfo20.setCmd(0, 36);
        this.mList.add(carInfo20);
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
        DataCanbus.NOTIFY_EVENTS[428].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[429].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[430].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[431].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[432].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[433].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[434].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[435].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[436].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[437].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[438].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[439].addNotify(this.mNotifyCanbus, 1);
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
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[428].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[429].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[430].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[431].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[432].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[433].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[434].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[435].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[436].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[437].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[438].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[439].removeNotify(this.mNotifyCanbus);
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
    }
}