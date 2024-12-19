package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.syu.adapter.AdapterCarInfo;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.entity.CarInfo;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Activity_374_Door_Lock extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_Door_Lock.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_Door_Lock.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.grdcherokee_door_and_lock);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(0, 100, R.string.str_298_auto_door_unlock);
        carInfo.setCmd(0, 48);
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, 101, R.string.wc_372_offautolocktstr);
        carInfo2.setCmd(0, 49);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, 102, R.string.wc_372_lockturnlightstr);
        carInfo3.setCmd(0, 50);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(1, 103, R.string.wc_372_lock_voice);
        carInfo4.setCmd(0, 55);
        carInfo4.setDiplsys(new String[]{LauncherApplication.getInstance().getResources().getString(R.string.off), LauncherApplication.getInstance().getResources().getString(R.string.str_372_press1), LauncherApplication.getInstance().getResources().getString(R.string.str_372_press2)});
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 104, R.string.str_smar_key_settings);
        carInfo5.setCmd(0, 56);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, 105, R.string.wc_372_dorrwarringstr);
        carInfo6.setCmd(0, 58);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(3, 106, R.string.jeep_presskeyunlock);
        carInfo7.setCmd(0, 52);
        carInfo7.setDiplsys(new String[]{getString(R.string.wc_ruiteng_string_unlock_mode_0), getString(R.string.wc_ruiteng_string_unlock_mode_1)});
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(0, 107, R.string.jeep_keylessentry);
        carInfo8.setCmd(0, 54);
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(0, 108, R.string.c_321_civic_beep_start_str);
        carInfo9.setCmd(0, 59);
        this.mList.add(carInfo9);
        CarInfo carInfo10 = new CarInfo(0, 109, R.string.str_remote_door_unlock);
        carInfo10.setCmd(0, 60);
        this.mList.add(carInfo10);
        CarInfo carInfo11 = new CarInfo(0, 160, R.string.str_374_hornlock);
        carInfo11.setCmd(0, 51);
        this.mList.add(carInfo11);
        CarInfo carInfo12 = new CarInfo(0, 161, R.string.str_374_autoclose);
        carInfo12.setCmd(0, 53);
        this.mList.add(carInfo12);
        CarInfo carInfo13 = new CarInfo(0, 210, R.string.jeep_powertailgatealarm);
        carInfo13.setCmd(0, 57);
        this.mList.add(carInfo13);
        CarInfo carInfo14 = new CarInfo(0, 207, R.string.klc_comfort_Automatic_folding_mirrors);
        carInfo14.setCmd(0, 157);
        this.mList.add(carInfo14);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        for (int i = 0; i < this.mList.size(); i++) {
            if (this.mList.get(i).getUpdateCode() == 104 || this.mList.get(i).getUpdateCode() == 106 || this.mList.get(i).getUpdateCode() == 105) {
                if (DataCanbus.DATA[1000] == 374 || DataCanbus.DATA[1000] == 65910 || DataCanbus.DATA[1000] == 917878 || DataCanbus.DATA[1000] == 983414 || DataCanbus.DATA[1000] == 1376630 || DataCanbus.DATA[1000] == 1442166 || DataCanbus.DATA[1000] == 1507702 || DataCanbus.DATA[1000] == 1573238 || DataCanbus.DATA[1000] == 1638774 || DataCanbus.DATA[1000] == 1704310 || DataCanbus.DATA[1000] == 2621814 || DataCanbus.DATA[1000] == 2687350 || DataCanbus.DATA[1000] == 2752886 || DataCanbus.DATA[1000] == 2818422 || DataCanbus.DATA[1000] == 1835382 || DataCanbus.DATA[1000] == 1900918 || DataCanbus.DATA[1000] == 2097526 || DataCanbus.DATA[1000] == 2163062) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 207) {
                if (DataCanbus.DATA[1000] == 1376630 || DataCanbus.DATA[1000] == 1442166 || DataCanbus.DATA[1000] == 1507702 || DataCanbus.DATA[1000] == 1573238 || DataCanbus.DATA[1000] == 1638774 || DataCanbus.DATA[1000] == 1704310 || DataCanbus.DATA[1000] == 2621814 || DataCanbus.DATA[1000] == 2687350 || DataCanbus.DATA[1000] == 2752886 || DataCanbus.DATA[1000] == 2818422 || DataCanbus.DATA[1000] == 1835382 || DataCanbus.DATA[1000] == 1900918 || DataCanbus.DATA[1000] == 2097526 || DataCanbus.DATA[1000] == 2163062) {
                    this.mList.get(i).setShowable(false);
                } else {
                    this.mList.get(i).setShowable(true);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 108) {
                if (DataCanbus.DATA[1000] == 131446 || DataCanbus.DATA[1000] == 1048950 || DataCanbus.DATA[1000] == 1376630 || DataCanbus.DATA[1000] == 1442166 || DataCanbus.DATA[1000] == 1507702 || DataCanbus.DATA[1000] == 1573238 || DataCanbus.DATA[1000] == 1638774 || DataCanbus.DATA[1000] == 1704310 || DataCanbus.DATA[1000] == 2621814 || DataCanbus.DATA[1000] == 2687350 || DataCanbus.DATA[1000] == 2752886 || DataCanbus.DATA[1000] == 2818422 || DataCanbus.DATA[1000] == 1835382 || DataCanbus.DATA[1000] == 1900918 || DataCanbus.DATA[1000] == 2097526 || DataCanbus.DATA[1000] == 2163062) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 109) {
                if (DataCanbus.DATA[1000] == 131446 || DataCanbus.DATA[1000] == 721270 || DataCanbus.DATA[1000] == 1048950) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 160) {
                if (DataCanbus.DATA[1000] == 374 || DataCanbus.DATA[1000] == 917878) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 101) {
                if (DataCanbus.DATA[1000] == 721270) {
                    this.mList.get(i).setShowable(false);
                } else {
                    this.mList.get(i).setShowable(true);
                }
            }
            if (DataCanbus.DATA[1000] == 655734) {
                if (this.mList.get(i).getUpdateCode() == 106 || this.mList.get(i).getUpdateCode() == 160) {
                    this.mList.get(i).setShowable(true);
                }
                if (this.mList.get(i).getUpdateCode() == 103 || this.mList.get(i).getUpdateCode() == 107 || this.mList.get(i).getUpdateCode() == 161) {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (DataCanbus.DATA[1000] == 524662) {
                if (this.mList.get(i).getUpdateCode() == 161) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
        }
        this.adapter.updateList(this.mList);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
    }
}
