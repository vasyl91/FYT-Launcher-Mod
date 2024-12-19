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
public class Activity_374_Trailer extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_Trailer.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_Trailer.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.str_374_trailer);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(1, 162, R.string.str_374_trailer);
        carInfo.setCmd(0, 80);
        carInfo.setDiplsys(new String[]{"Trailer 1", "Trailer 2", "Trailer 3", "Trailer 4"});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(1, 163, R.string.str_374_trailertype);
        carInfo2.setCmd(0, 81);
        carInfo2.setDiplsys(new String[]{getString(R.string.str_374_trailertype1), getString(R.string.str_374_trailertype2), getString(R.string.str_374_trailertype3), getString(R.string.str_374_trailertype4)});
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(1, 311, R.string.str_374_trailer_length);
        carInfo3.setCmd(0, 82);
        carInfo3.setDiplsys(new String[]{"Auto", "Max(39.5 ft)"});
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(1, 389, R.string.str_374_trailer_name);
        carInfo4.setCmd(0, 215);
        carInfo4.setDiplsys(new String[]{"---", "trailer", "boat", "car", "cargo", "dump", "equipment", "flatbed", "gooseneck", "livestock", "horse", "motorcycle", "snowmobile", "travel", "utility", "5th wheel"});
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(1, 390, R.string.str_374_num_of_axles);
        carInfo5.setCmd(0, 216);
        carInfo5.setDiplsys(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"});
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(1, 391, R.string.str_374_num_of_tires);
        carInfo6.setCmd(0, 217);
        carInfo6.setDiplsys(new String[]{"0", "2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30"});
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(1, 392, R.string.str_374_trailer_tire_target_pressure);
        carInfo7.setCmd(0, 218);
        carInfo7.setDiplsys(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125"});
        this.mList.add(carInfo7);
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
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[311].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[389].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[390].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[391].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[392].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[311].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[389].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[390].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[391].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[392].removeNotify(this.mNotifyCanbus);
    }
}
