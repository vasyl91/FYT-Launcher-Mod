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
public class Activity_374_PAOtherSettings extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_PAOtherSettings.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.others_settings);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(0, 377, R.string.str_fuel_saver_display_in_cluster);
        carInfo.setCmd(0, 2);
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(1, 378, R.string.str_fwd_collision_sensitivity);
        carInfo2.setCmd(0, 96);
        carInfo2.setDiplsys(new String[]{"OFF", "NEAR", "FAR"});
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(1, 379, R.string.str_park_assist);
        carInfo3.setCmd(0, 97);
        carInfo3.setDiplsys(new String[]{"OFF", "Sound", "Sound+display"});
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(0, 380, R.string.str_steering_directed_headlights);
        carInfo4.setCmd(0, 98);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 381, R.string.str_auto_on_driver_heated);
        carInfo5.setCmd(0, 99);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, 382, R.string.str_srt_mode);
        carInfo6.setCmd(0, 100);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(1, 414, R.string.rzc_side_stop_assit_str);
        carInfo7.setCmd(0, 102);
        carInfo7.setDiplsys(new String[]{"OFF", "Sound", "Sound+display"});
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(1, 415, R.string.rzc_side_stop_assit_str);
        carInfo8.setCmd(0, 103);
        carInfo8.setDiplsys(new String[]{getString(R.string.klc_air_low), getString(R.string.klc_air_middle), getString(R.string.klc_air_high)});
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(1, 417, R.string.str_107_str1);
        carInfo9.setCmd(0, 14);
        carInfo9.setDiplsys(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218", "219", "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230", "231", "232", "233", "234", "235", "236", "237", "238", "239", "240", "241", "242", "243", "244", "245", "246", "247", "248", "249", "250", "251", "252", "253", "254", "255"});
        this.mList.add(carInfo9);
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
        DataCanbus.NOTIFY_EVENTS[377].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[378].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[379].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[380].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[381].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[382].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[414].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[415].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[417].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[377].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[378].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[379].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[380].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[381].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[382].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[414].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[415].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[417].removeNotify(this.mNotifyCanbus);
    }
}
