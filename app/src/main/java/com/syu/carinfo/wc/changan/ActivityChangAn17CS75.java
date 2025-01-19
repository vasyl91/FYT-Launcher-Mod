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

public class ActivityChangAn17CS75 extends BaseActivity {
    AdapterCarInfo adapter;
    ListView mListView;
    List<CarInfo> mList = new ArrayList();
    int[] ids = {101, 102, 103, 104, 105, 106, 107, 108, 109, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 132, 133, 134, 135, 136, 137, 138, 139};
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_list);
        this.mListView = (ListView) findViewById(R.id.list_carinfo);
        initValue();
        this.adapter = new AdapterCarInfo(this, this.mList);
        this.mListView.setAdapter((ListAdapter) this.adapter);
        ((TextView) findViewById(R.id.tv_car_title)).setVisibility(0);
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.app_name);
    }

    private void initValue() {
        this.mList.clear();
        CarInfo carInfo = newCarInfoSwitch(101, R.string.str_unlock_autoair, 1, 8);
        this.mList.add(carInfo);
        CarInfo carInfo2 = newCarInfoSwitch(102, R.string.klc_comfort_Automatic_folding_mirrors, 1, 7);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = newCarInfoSwitch(103, R.string.rzc_klc_comfort_rear_wiper_auto_start, 1, 6);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = newCarInfoButton(104, R.string.str_light_onekeyturn, 1, 5, new String[]{getString(R.string.str_xp_mzd_cx5_auto_door_lock_mode_0), getString(R.string.str_three_times), getString(R.string.str_five_times), getString(R.string.str_seven_times)});
        carInfo4.setHasDiableOptionForWC(true);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = newCarInfoButton(105, R.string.str_light_forntdelay, 1, 4, new String[]{getString(R.string.str_xp_mzd_cx5_auto_door_lock_mode_0), getString(R.string.str_wc_jy_str8), getString(R.string.klc_light_Lasuo_headlight_delay_1), getString(R.string.klc_light_Lasuo_headlight_delay_2), getString(R.string.klc_light_Lasuo_headlight_delay_3)});
        carInfo5.setHasDiableOptionForWC(true);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = newCarInfoSwitch(106, R.string.str_accoff_autolock, 1, 3);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = newCarInfoSwitch(107, R.string.jeep_runautolock, 1, 2);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = newCarInfoSwitch(109, R.string.str_airauto_dry, 1, 9);
        this.mList.add(carInfo8);
        CarInfo carInfo9 = newCarInfoSwitchDisplay(108, R.string.klc_Remote_control_Unlock, 1, 1, new String[]{getString(R.string.wc_ruiteng_string_unlock_mode_0), getString(R.string.wc_ruiteng_string_unlock_mode_1)});
        carInfo9.setHasDiableOptionForWC(true);
        this.mList.add(carInfo9);
        CarInfo carInfo10 = newCarInfoButton(111, R.string.klc_dianlaba_str, 1, 13, new String[]{getString(R.string.str_findcar_door_unlock), getString(R.string.str_mingjuezs_str1), getString(R.string.str_door_unlock), getString(R.string.off)});
        carInfo10.setHasDiableOptionForWC(true);
        this.mList.add(carInfo10);
        CarInfo carInfo11 = newCarInfoButton(112, R.string.klc_window_Delay_time, 1, 11, new String[]{getString(R.string.off), getString(R.string.str_227_headlight_1), getString(R.string.str_227_headlight_2), getString(R.string.str_227_headlight_3), getString(R.string.wc_ruiteng_string_time_1), getString(R.string.wc_ruiteng_string_time_3)});
        carInfo11.setHasDiableOptionForWC(true);
        this.mList.add(carInfo11);
        CarInfo carInfo12 = newCarInfoSwitch(113, R.string.wc_weilang_remote_car_window, 1, 15);
        this.mList.add(carInfo12);
        CarInfo carInfo13 = newCarInfoSwitch(114, R.string.str_keylongpress_auto_air, 1, 14);
        this.mList.add(carInfo13);
        CarInfo carInfo14 = newCarInfoSwitch(115, R.string.str_voice_control_sunroof, 1, 18);
        this.mList.add(carInfo14);
        CarInfo carInfo15 = newCarInfoSwitch(116, R.string.str_remote_control_sunroof, 1, 19);
        this.mList.add(carInfo15);
        CarInfo carInfo16 = newCarInfoSwitch(117, R.string.str_rain_sensing_sunroof, 1, 20);
        this.mList.add(carInfo16);
        CarInfo carInfo17 = newCarInfoButton(118, R.string.bsd_klj_str5, 1, 21, new String[]{"0", "1", "2", "3", "4", "5", "6"});
        carInfo17.setHasDiableOptionForWC(true);
        this.mList.add(carInfo17);
        CarInfo carInfo18 = newCarInfoButton(119, R.string.bsd_klj_str6, 1, 22, new String[]{"0", "1", "2", "3", "4", "5", "6"});
        carInfo18.setHasDiableOptionForWC(true);
        this.mList.add(carInfo18);
        CarInfo carInfo19 = newCarInfoSwitch(120, R.string.wc_ruiteng_string_day_light, 1, 23);
        this.mList.add(carInfo19);
        CarInfo carInfo20 = newCarInfoSwitch(121, R.string.str_419_phone_auto_wind, 1, 24);
        this.mList.add(carInfo20);
        CarInfo carInfo21 = newCarInfoSwitch(135, R.string.str_boyue_str1, 1, 26);
        this.mList.add(carInfo21);
        CarInfo carInfo22 = newCarInfoSwitch(136, R.string.str_gs4_setting29, 1, 27);
        this.mList.add(carInfo22);
        CarInfo carInfo23 = newCarInfoButton(137, R.string.klc_sport_mode_Engine_sport, 1, 28, new String[]{getString(R.string.str_driving_comfort), getString(R.string.str_driving_sport), getString(R.string.str_driving_eco)});
        carInfo23.setHasDiableOptionForWC(true);
        this.mList.add(carInfo23);
        CarInfo carInfo24 = newCarInfoButton(138, R.string.str_steering_settings, 1, 29, new String[]{getString(R.string.str_driving_comfort), getString(R.string.str_driving_sport), getString(R.string.str_light_state)});
        carInfo24.setHasDiableOptionForWC(true);
        this.mList.add(carInfo24);
        CarInfo carInfo25 = newCarInfoSwitch(132, R.string.wc_372_lanewar, 1, 30);
        this.mList.add(carInfo25);
        CarInfo carInfo26 = newCarInfoButton(133, R.string.str_lane_assist_warning_type, 1, 31, new String[]{"仅振动", "仅声音", "振动+声音"});
        carInfo26.setHasDiableOptionForWC(true);
        this.mList.add(carInfo26);
        CarInfo carInfo27 = newCarInfoButton(134, R.string.str_vibration_intensity, 1, 32, new String[]{getString(R.string.klc_air_low), getString(R.string.klc_air_middle), getString(R.string.klc_air_high)});
        carInfo27.setHasDiableOptionForWC(true);
        this.mList.add(carInfo27);
        CarInfo carInfo28 = newCarInfoSwitch(139, R.string.str_106_str1, 1, 240);
        this.mList.add(carInfo28);
    }

    @Override
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }
}
