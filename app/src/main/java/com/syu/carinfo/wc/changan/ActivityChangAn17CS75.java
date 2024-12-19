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
public class ActivityChangAn17CS75 extends BaseActivity {
    AdapterCarInfo adapter;
    ListView mListView;
    List<CarInfo> mList = new ArrayList();
    int[] ids = {24, 25, 26, 27, 28, 29, 30, 31, 32, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 57, 58, 59, 60, 61, 62, 63, 64};
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.changan.ActivityChangAn17CS75.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            for (int j = 0; j < ActivityChangAn17CS75.this.mList.size(); j++) {
                CarInfo carInfo = ActivityChangAn17CS75.this.mList.get(j);
                if (carInfo.getUpdateCode() == updateCode) {
                    carInfo.setShowable(((DataCanbus.DATA[updateCode] >> 8) & 1) != 0);
                    ActivityChangAn17CS75.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode] & 255);
                    ActivityChangAn17CS75.this.adapter.updateList(ActivityChangAn17CS75.this.mList);
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
        CarInfo carInfo = newCarInfoSwitch(24, R.string.str_unlock_autoair, 1, 8);
        this.mList.add(carInfo);
        CarInfo carInfo2 = newCarInfoSwitch(25, R.string.klc_comfort_Automatic_folding_mirrors, 1, 7);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = newCarInfoSwitch(26, R.string.rzc_klc_comfort_rear_wiper_auto_start, 1, 6);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = newCarInfoButton(27, R.string.str_light_onekeyturn, 1, 5, new String[]{getString(R.string.str_xp_mzd_cx5_auto_door_lock_mode_0), getString(R.string.str_three_times), getString(R.string.str_five_times), getString(R.string.str_seven_times)});
        carInfo4.setHasDiableOptionForWC(true);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = newCarInfoButton(28, R.string.str_light_forntdelay, 1, 4, new String[]{getString(R.string.str_xp_mzd_cx5_auto_door_lock_mode_0), getString(R.string.str_wc_jy_str8), getString(R.string.klc_light_Lasuo_headlight_delay_1), getString(R.string.klc_light_Lasuo_headlight_delay_2), getString(R.string.klc_light_Lasuo_headlight_delay_3)});
        carInfo5.setHasDiableOptionForWC(true);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = newCarInfoSwitch(29, R.string.str_accoff_autolock, 1, 3);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = newCarInfoSwitch(30, R.string.jeep_runautolock, 1, 2);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = newCarInfoSwitch(32, R.string.str_airauto_dry, 1, 9);
        this.mList.add(carInfo8);
        CarInfo carInfo9 = newCarInfoSwitchDisplay(31, R.string.klc_Remote_control_Unlock, 1, 1, new String[]{getString(R.string.wc_ruiteng_string_unlock_mode_0), getString(R.string.wc_ruiteng_string_unlock_mode_1)});
        carInfo9.setHasDiableOptionForWC(true);
        this.mList.add(carInfo9);
        CarInfo carInfo10 = newCarInfoButton(34, R.string.klc_dianlaba_str, 1, 13, new String[]{getString(R.string.str_findcar_door_unlock), getString(R.string.str_mingjuezs_str1), getString(R.string.str_door_unlock), getString(R.string.off)});
        carInfo10.setHasDiableOptionForWC(true);
        this.mList.add(carInfo10);
        CarInfo carInfo11 = newCarInfoButton(35, R.string.klc_window_Delay_time, 1, 11, new String[]{getString(R.string.off), getString(R.string.str_227_headlight_1), getString(R.string.str_227_headlight_2), getString(R.string.str_227_headlight_3), getString(R.string.wc_ruiteng_string_time_1), getString(R.string.wc_ruiteng_string_time_3)});
        carInfo11.setHasDiableOptionForWC(true);
        this.mList.add(carInfo11);
        CarInfo carInfo12 = newCarInfoSwitch(36, R.string.wc_weilang_remote_car_window, 1, 15);
        this.mList.add(carInfo12);
        CarInfo carInfo13 = newCarInfoSwitch(37, R.string.str_keylongpress_auto_air, 1, 14);
        this.mList.add(carInfo13);
        CarInfo carInfo14 = newCarInfoSwitch(38, R.string.str_voice_control_sunroof, 1, 18);
        this.mList.add(carInfo14);
        CarInfo carInfo15 = newCarInfoSwitch(39, R.string.str_remote_control_sunroof, 1, 19);
        this.mList.add(carInfo15);
        CarInfo carInfo16 = newCarInfoSwitch(40, R.string.str_rain_sensing_sunroof, 1, 20);
        this.mList.add(carInfo16);
        CarInfo carInfo17 = newCarInfoButton(41, R.string.bsd_klj_str5, 1, 21, new String[]{"0", "1", "2", "3", "4", "5", "6"});
        carInfo17.setHasDiableOptionForWC(true);
        this.mList.add(carInfo17);
        CarInfo carInfo18 = newCarInfoButton(42, R.string.bsd_klj_str6, 1, 22, new String[]{"0", "1", "2", "3", "4", "5", "6"});
        carInfo18.setHasDiableOptionForWC(true);
        this.mList.add(carInfo18);
        CarInfo carInfo19 = newCarInfoSwitch(43, R.string.wc_ruiteng_string_day_light, 1, 23);
        this.mList.add(carInfo19);
        CarInfo carInfo20 = newCarInfoSwitch(44, R.string.str_419_phone_auto_wind, 1, 24);
        this.mList.add(carInfo20);
        CarInfo carInfo21 = newCarInfoSwitch(60, R.string.str_boyue_str1, 1, 26);
        this.mList.add(carInfo21);
        CarInfo carInfo22 = newCarInfoSwitch(61, R.string.str_gs4_setting29, 1, 27);
        this.mList.add(carInfo22);
        CarInfo carInfo23 = newCarInfoButton(62, R.string.klc_sport_mode_Engine_sport, 1, 28, new String[]{getString(R.string.str_driving_comfort), getString(R.string.str_driving_sport), getString(R.string.str_driving_eco)});
        carInfo23.setHasDiableOptionForWC(true);
        this.mList.add(carInfo23);
        CarInfo carInfo24 = newCarInfoButton(63, R.string.str_steering_settings, 1, 29, new String[]{getString(R.string.str_driving_comfort), getString(R.string.str_driving_sport), getString(R.string.str_light_state)});
        carInfo24.setHasDiableOptionForWC(true);
        this.mList.add(carInfo24);
        CarInfo carInfo25 = newCarInfoSwitch(57, R.string.wc_372_lanewar, 1, 30);
        this.mList.add(carInfo25);
        CarInfo carInfo26 = newCarInfoButton(58, R.string.str_lane_assist_warning_type, 1, 31, new String[]{"仅振动", "仅声音", "振动+声音"});
        carInfo26.setHasDiableOptionForWC(true);
        this.mList.add(carInfo26);
        CarInfo carInfo27 = newCarInfoButton(59, R.string.str_vibration_intensity, 1, 32, new String[]{getString(R.string.klc_air_low), getString(R.string.klc_air_middle), getString(R.string.klc_air_high)});
        carInfo27.setHasDiableOptionForWC(true);
        this.mList.add(carInfo27);
        CarInfo carInfo28 = newCarInfoSwitch(64, R.string.str_106_str1, 1, 240);
        this.mList.add(carInfo28);
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
