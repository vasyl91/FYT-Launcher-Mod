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
public class Activity_374_AmbientLightSet extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_AmbientLightSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_AmbientLightSet.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.wc_372_amblight);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(0, 187, R.string.str_374_ambientlight1);
        carInfo.setCmd(9, 1);
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, 188, R.string.str_374_ambientlight2);
        carInfo2.setCmd(9, 2);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, 189, R.string.str_374_ambientlight3);
        carInfo3.setCmd(9, 3);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(0, 190, R.string.str_374_ambientlight4);
        carInfo4.setCmd(9, 4);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 191, R.string.str_374_ambientlight5);
        carInfo5.setCmd(9, 5);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, 192, R.string.str_374_ambientlight6);
        carInfo6.setCmd(9, 6);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, 193, R.string.str_374_ambientlight7);
        carInfo7.setCmd(9, 7);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(0, 194, R.string.str_374_ambientlight8);
        carInfo8.setCmd(9, 8);
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(1, 195, R.string.light_color);
        carInfo9.setCmd(9, 9);
        carInfo9.setDiplsys(new String[]{getString(R.string.off), getString(R.string.str_background_blue), getString(R.string.str_403_ambient_3), getString(R.string.str_403_ambient_4), getString(R.string.str_403_ambient_7), getString(R.string.str_403_ambient_1), getString(R.string.str_403_ambient_8), getString(R.string.str_403_ambient_6), getString(R.string.str_403_ambient_2), getString(R.string.color_blue_green_str), getString(R.string.color_white_str)});
        this.mList.add(carInfo9);
        CarInfo carInfo10 = new CarInfo(1, 196, R.string.str_374_ambientlight9);
        carInfo10.setCmd(9, 10);
        carInfo10.setDiplsys(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        this.mList.add(carInfo10);
        CarInfo carInfo11 = new CarInfo(1, 197, R.string.str_374_ambientlight10);
        carInfo11.setCmd(9, 11);
        carInfo11.setDiplsys(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        this.mList.add(carInfo11);
        CarInfo carInfo12 = new CarInfo(1, 198, R.string.str_374_ambientlight11);
        carInfo12.setCmd(9, 12);
        carInfo12.setDiplsys(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        this.mList.add(carInfo12);
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
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
    }
}
