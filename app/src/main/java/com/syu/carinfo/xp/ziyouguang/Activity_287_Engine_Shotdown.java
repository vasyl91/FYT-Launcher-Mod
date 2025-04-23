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

public class Activity_287_Engine_Shotdown extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_287_Engine_Shotdown.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.vehicle_personalization);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(1, 7, R.string.str_shutdown_mode);
        carInfo.setCmd(0, 67);
        carInfo.setDiplsys(new String[]{"Acc off + Door open", "Acc off"});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, 8, R.string.str_151_amp);
        carInfo2.setCmd(1, 1);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(1, 9, R.string.str_sbd_x80_yuanche_vol);
        carInfo3.setCmd(1, 2);
        carInfo3.setDiplsys(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38"});
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(1, 10, R.string.str_388_sound_fade);
        carInfo4.setCmd(1, 3);
        carInfo4.setDiplsys(new String[]{"-", "F9", "F8", "F7", "F6", "F5", "F4", "F3", "F2", "F1", "0", "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9"});
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(1, 11, R.string.str_388_sound_balance);
        carInfo5.setCmd(1, 4);
        carInfo5.setDiplsys(new String[]{"-", "R9", "R8", "R7", "R6", "R5", "R4", "R3", "R2", "R1", "0", "L1", "L2", "L3", "L4", "L5", "L6", "L7", "L8", "L9"});
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(1, 12, R.string.str_388_sound_bass);
        carInfo6.setCmd(1, 5);
        carInfo6.setDiplsys(new String[]{"-", "-9", "-8", "-7", "-6", "-5", "-4", "-3", "-2", "-1", "0", "+1", "+2", "+3", "+4", "+5", "+6", "+7", "+8", "+9"});
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(1, 14, R.string.str_388_sound_Middle);
        carInfo7.setCmd(1, 7);
        carInfo7.setDiplsys(new String[]{"-", "-9", "-8", "-7", "-6", "-5", "-4", "-3", "-2", "-1", "0", "+1", "+2", "+3", "+4", "+5", "+6", "+7", "+8", "+9"});
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(1, 13, R.string.str_388_sound_treble);
        carInfo8.setCmd(1, 6);
        carInfo8.setDiplsys(new String[]{"-", "-9", "-8", "-7", "-6", "-5", "-4", "-3", "-2", "-1", "0", "+1", "+2", "+3", "+4", "+5", "+6", "+7", "+8", "+9"});
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(4, 8, R.string.rzc_qicheng_t70_default);
        carInfo9.setCmd(1, 8);
        this.mList.add(carInfo9);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        this.adapter.updateList(this.mList);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
    }
}
