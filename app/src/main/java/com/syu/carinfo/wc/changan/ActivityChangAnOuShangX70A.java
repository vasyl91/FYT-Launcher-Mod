package com.syu.carinfo.wc.changan;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.syu.adapter.AdapterCarInfo;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.entity.CarInfo;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityChangAnOuShangX70A extends BaseActivity {
    AdapterCarInfo adapter;
    ListView mListView;
    List<CarInfo> mList = new ArrayList();
    int[] ids = {24, 26, 27, 28, 29, 30, 34, 35, 36, 37, 32, 65, 66};
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.changan.ActivityChangAnOuShangX70A.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            for (int j = 0; j < ActivityChangAnOuShangX70A.this.mList.size(); j++) {
                CarInfo carInfo = ActivityChangAnOuShangX70A.this.mList.get(j);
                if (carInfo.getUpdateCode() == updateCode) {
                    carInfo.setShowable(((DataCanbus.DATA[updateCode] >> 8) & 1) != 0);
                    ActivityChangAnOuShangX70A.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode] & 255);
                    ActivityChangAnOuShangX70A.this.adapter.updateList(ActivityChangAnOuShangX70A.this.mList);
                    return;
                }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list);
        this.mListView = (ListView) findViewById(R.id.list_carinfo);
        initValue();
        this.adapter = new AdapterCarInfo(this, this.mList);
        this.mListView.setAdapter((ListAdapter) this.adapter);
        ((TextView) findViewById(R.id.tv_car_title)).setVisibility(0);
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.app_name);
    }

    private void initValue() {
        this.mList.clear();
        this.mList.add(newCarInfoSwitch(24, R.string.str_unlock_autoair, 1, 8));
        CarInfo carInfo = newCarInfoButton(27, R.string.lane_change_flash, 1, 5, new String[]{getString(R.string.str_xp_mzd_cx5_auto_door_lock_mode_0), getString(R.string.str_three_times), getString(R.string.str_five_times), getString(R.string.str_seven_times)});
        carInfo.setHasDiableOptionForWC(true);
        this.mList.add(carInfo);
        CarInfo carInfo2 = newCarInfoButton(28, R.string.str_light_forntdelay, 1, 4, new String[]{getString(R.string.str_xp_mzd_cx5_auto_door_lock_mode_0), getString(R.string.str_wc_jy_str8), getString(R.string.klc_light_Lasuo_headlight_delay_1), getString(R.string.klc_light_Lasuo_headlight_delay_2), getString(R.string.klc_light_Lasuo_headlight_delay_3)});
        carInfo2.setHasDiableOptionForWC(true);
        this.mList.add(carInfo2);
        this.mList.add(newCarInfoSwitch(29, R.string.str_accoff_autolock, 1, 3));
        this.mList.add(newCarInfoSwitch(26, R.string.rzc_klc_comfort_rear_wiper_auto_start, 1, 6));
        this.mList.add(newCarInfoSwitch(30, R.string.jeep_runautolock, 1, 2));
        CarInfo carInfo3 = newCarInfoButton(34, R.string.klc_dianlaba_str, 1, 13, new String[]{getString(R.string.str_findcar_door_unlock), getString(R.string.str_mingjuezs_str1), getString(R.string.str_door_unlock), getString(R.string.off)});
        carInfo3.setHasDiableOptionForWC(true);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = newCarInfoButton(35, R.string.klc_window_Delay_time, 1, 11, new String[]{getString(R.string.off), getString(R.string.str_227_headlight_1), getString(R.string.str_227_headlight_2), getString(R.string.str_227_headlight_3), getString(R.string.wc_ruiteng_string_time_1), getString(R.string.wc_ruiteng_string_time_3)});
        carInfo4.setHasDiableOptionForWC(true);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = newCarInfoButton(66, R.string.str_128_oushangx7a, 1, 10, new String[]{getString(R.string.klc_remote_Remote_control_latch_light_Speaker), getString(R.string.klc_remote_Remote_control_latch_only_light), getString(R.string.klc_remote_Remote_control_latch_speaker)});
        carInfo5.setHasDiableOptionForWC(true);
        this.mList.add(carInfo5);
        this.mList.add(newCarInfoSwitch(36, R.string.wc_weilang_remote_car_window, 1, 15));
        this.mList.add(newCarInfoSwitch(37, R.string.str_keylongpress_auto_air, 1, 14));
        this.mList.add(newCarInfoSwitch(32, R.string.str_128_oushangx7a1, 1, 9));
        this.mList.add(newCarInfoSwitch(65, R.string.window_light, 1, 12));
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }
}
