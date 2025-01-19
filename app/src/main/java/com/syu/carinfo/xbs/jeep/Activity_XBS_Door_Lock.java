package com.syu.carinfo.xbs.jeep;

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

public class Activity_XBS_Door_Lock extends Activity {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_XBS_Door_Lock.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_list);
        this.mText = (TextView) findViewById(R.id.tv_car_title);
        this.mListView = (ListView) findViewById(R.id.list_carinfo);
        initValue();
        this.adapter = new AdapterCarInfo(this, this.mList);
        this.mListView.setAdapter((ListAdapter) this.adapter);
        this.mText.setVisibility(0);
        this.mText.setText(R.string.grdcherokee_door_and_lock);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(0, 94, R.string.str_0bD077);
        carInfo.setCmd(32, 32);
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, 95, R.string.jeep_powertailgatealarm);
        carInfo2.setCmd(33, 32);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, 96, R.string.wc_372_dorrwarringstr);
        carInfo3.setCmd(34, 32);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(0, 97, R.string.str_smar_key_settings);
        carInfo4.setCmd(35, 32);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 98, R.string.jeep_keylessentry);
        carInfo5.setCmd(36, 32);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(3, 99, R.string.jeep_presskeyunlock);
        carInfo6.setCmd(37, 32);
        carInfo6.setDiplsys(new String[]{getString(R.string.klc_remote_Smart_Near_car_unlocked_only_driver), getString(R.string.klc_remote_Smart_Near_car_unlocked_all_door)});
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, 100, R.string.wc_372_offautolocktstr);
        carInfo7.setCmd(38, 32);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(0, 101, R.string.wc_372_autolocktstr);
        carInfo8.setCmd(39, 32);
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(0, 102, R.string.wc_17zhinanzhe_str4);
        carInfo9.setCmd(40, 32);
        this.mList.add(carInfo9);
        CarInfo carInfo10 = new CarInfo(3, 103, R.string.str_0bD085);
        carInfo10.setCmd(41, 32);
        carInfo10.setDiplsys(new String[]{getString(R.string.klc_remote_Smart_Near_car_unlocked_only_driver), getString(R.string.klc_remote_Smart_Near_car_unlocked_all_door)});
        this.mList.add(carInfo10);
        CarInfo carInfo11 = new CarInfo(0, 104, R.string.jeep_locklights);
        carInfo11.setCmd(42, 32);
        this.mList.add(carInfo11);
        CarInfo carInfo12 = new CarInfo(1, 105, R.string.wc_372_lock_voice);
        carInfo12.setCmd(43, 32);
        carInfo12.setDiplsys(new String[]{getString(R.string.off), getString(R.string.str_373_first_touch), getString(R.string.str_373_double_touch)});
        this.mList.add(carInfo12);
        CarInfo carInfo13 = new CarInfo(0, 106, R.string.str_0bD081);
        carInfo13.setCmd(44, 32);
        this.mList.add(carInfo13);
        CarInfo carInfo14 = new CarInfo(0, 107, R.string.str_373_seat_facilitiates_access);
        carInfo14.setCmd(45, 32);
        this.mList.add(carInfo14);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(57, new int[]{12}, null, null);
        addNotify();
        for (int i = 0; i < this.mList.size(); i++) {
            int id = this.mList.get(i).getUpdateCode();
            if (id <= 107 && id >= 94 && this.mList.get(i) != null) {
                if (DataCanbus.DATA[id - 56] == 0) {
                    this.mList.get(i).setShowable(false);
                } else {
                    this.mList.get(i).setShowable(true);
                }
            }
        }
        this.adapter.updateList(this.mList);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
    }

    public int getListID(int id) {
        for (int i = 0; i < this.mList.size(); i++) {
            if (this.mList.get(i).getUpdateCode() == id) {
                return i;
            }
        }
        return 255;
    }
}
