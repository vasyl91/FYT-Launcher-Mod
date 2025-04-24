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

@SuppressWarnings({"deprecation", "unchecked"})
public class Activity_374_FordCarSet extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_FordCarSet.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.str_sb_saiou3_str0);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(1, 440, R.string.str_wc_174008_str1);
        carInfo.setCmd(0, 16);
        carInfo.setDiplsys(new String[]{"alert", "aid", "aid+alert"});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(1, 441, R.string.str_lane_assist_sensitivity);
        carInfo2.setCmd(0, 17);
        carInfo2.setDiplsys(new String[]{getString(R.string.klc_air_high), getString(R.string.klc_air_middle), getString(R.string.klc_air_low)});
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, 442, R.string.bsd_klj_str9);
        carInfo3.setCmd(0, 18);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(1, 443, R.string.dj_airuize7_warning);
        carInfo4.setCmd(0, 19);
        carInfo4.setDiplsys(new String[]{getString(R.string.klc_air_high), getString(R.string.klc_air_middle), getString(R.string.klc_air_low)});
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 444, R.string.rzc_others_assist_car_assister);
        carInfo5.setCmd(0, 20);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, 445, R.string.str_rear_view_camera_delay);
        carInfo6.setCmd(0, 21);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, 446, "Evasive Steering");
        carInfo7.setCmd(0, 22);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(0, 447, "Blind Spot Information System");
        carInfo8.setCmd(0, 23);
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(0, 448, "Trailer Sway Control");
        carInfo9.setCmd(0, 24);
        this.mList.add(carInfo9);
        CarInfo carInfo10 = new CarInfo(0, 449, "Park Aid");
        carInfo10.setCmd(0, 25);
        this.mList.add(carInfo10);
        CarInfo carInfo11 = new CarInfo(0, 450, "Cross Traffic Alert");
        carInfo11.setCmd(0, 26);
        this.mList.add(carInfo11);
        CarInfo carInfo12 = new CarInfo(0, 451, "Driver Alert");
        carInfo12.setCmd(0, 27);
        this.mList.add(carInfo12);
        CarInfo carInfo13 = new CarInfo(0, 452, "30 min Max Idle");
        carInfo13.setCmd(0, 28);
        this.mList.add(carInfo13);
        CarInfo carInfo14 = new CarInfo(0, 453, "Activate remote start");
        carInfo14.setCmd(0, 29);
        this.mList.add(carInfo14);
        CarInfo carInfo15 = new CarInfo(1, 454, "Remote Start ->Climate Control");
        carInfo15.setCmd(0, 31);
        carInfo15.setDiplsys(new String[]{"AUTO", "Last"});
        this.mList.add(carInfo15);
        CarInfo carInfo16 = new CarInfo(1, 455, "Remote Start ->Duration");
        carInfo16.setCmd(0, 32);
        carInfo16.setDiplsys(new String[]{"5min", "10min", "15min"});
        this.mList.add(carInfo16);
        CarInfo carInfo17 = new CarInfo(0, 456, "Courtesy Wipe");
        carInfo17.setCmd(0, 33);
        this.mList.add(carInfo17);
        CarInfo carInfo18 = new CarInfo(0, 457, "Reverse Wipe");
        carInfo18.setCmd(0, 34);
        this.mList.add(carInfo18);
        CarInfo carInfo19 = new CarInfo(0, 458, "Mirrors Autofold");
        carInfo19.setCmd(0, 35);
        this.mList.add(carInfo19);
        CarInfo carInfo20 = new CarInfo(0, 459, "Power Liftgate");
        carInfo20.setCmd(0, 36);
        this.mList.add(carInfo20);
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
