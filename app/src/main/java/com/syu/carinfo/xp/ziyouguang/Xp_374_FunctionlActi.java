package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.syu.adapter.AdapterCarInfo;
import com.syu.canbus.R;
import com.syu.entity.CarInfo;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;
import java.util.List;

public class Xp_374_FunctionlActi extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    int[] titles = {R.string.rzc_others_language_setting, R.string.wc_273_unit, R.string.lights_set, R.string.wc_372_amblight, R.string.grdcherokee_door_and_lock, R.string.grdcherokee_engine_shotdown_option, R.string.grdcherokee_engine_shotdown_option2, R.string.jeep_comfortsystems, R.string.wc_273_safety, R.string.wc_273_safety2, R.string.wc_273_luopan, R.string.jeep_brakemode, R.string.grdcherokee_suspension, R.string.str_374_trailer, R.string.wc_psa_all_factory_set, R.string.str_mic_set, R.string.str_guandao_amp, R.string.str_aux_settings, R.string.str_pitch_and_roll, R.string.str_rear_seat_ceiling_screen, R.string.others_settings, R.string.tire_pressure, R.string.str_e_hybird, R.string.str_sb_saiou3_str0, R.string.str_sb_saiou3_str1};
    Class[] clsess = {Activity_374_Language.class, Activity_374_Unit.class, Activity_374_LightSet.class, Activity_374_AmbientLightSet.class, Activity_374_Door_Lock.class, Activity_374_Engine_Shotdown.class, Activity_374_Engine_Shotdown2.class, Activity_374_ComfortSystem.class, Activity_374_Safety.class, Activity_374_Safety2.class, Activity_374_Luopan.class, Activity_374_Brakemode.class, Activity_374_Suspension.class, Activity_374_Trailer.class, Activity_374_FactorySetActivity.class, Activity_374_Other.class, Activity_374_AmpSet.class, Activity_374_AUXSettings.class, Activity_0452_PA_Ford_PitchAndRoll.class, Activity_374_RearScreenSettings.class, Activity_374_PAOtherSettings.class, Activity_374_TireInfo.class, Activity_374_HybridInfo.class, Activity_374_FordCarSet.class, Activity_374_FordCarSet2.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_list);
        initValue();
        this.adapter = new AdapterCarInfo(this, this.mList);
        ((ListView) findViewById(R.id.list_carinfo)).setAdapter((ListAdapter) this.adapter);
        ((TextView) findViewById(R.id.tv_car_title)).setVisibility(0);
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.wc_jianianhua_settings_title);
    }

    private void initValue() {
        for (int i = 0; i < this.titles.length; i++) {
            CarInfo carInfo = new CarInfo(4, 0, getString(this.titles[i]));
            carInfo.setCls(this.clsess[i]);
            this.mList.add(carInfo);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{64}, null, null);
        this.mList.get(0).setShowable(false);
        this.mList.get(1).setShowable(false);
        this.mList.get(2).setShowable(false);
        this.mList.get(3).setShowable(false);
        this.mList.get(4).setShowable(false);
        this.mList.get(5).setShowable(false);
        this.mList.get(6).setShowable(false);
        this.mList.get(7).setShowable(false);
        this.mList.get(8).setShowable(false);
        this.mList.get(9).setShowable(false);
        this.mList.get(10).setShowable(false);
        this.mList.get(11).setShowable(false);
        this.mList.get(12).setShowable(false);
        this.mList.get(13).setShowable(false);
        this.mList.get(14).setShowable(false);
        this.mList.get(15).setShowable(false);
        this.mList.get(16).setShowable(false);
        this.mList.get(17).setShowable(false);
        this.mList.get(18).setShowable(false);
        this.mList.get(19).setShowable(false);
        this.mList.get(20).setShowable(false);
        this.mList.get(21).setShowable(false);
        this.mList.get(22).setShowable(false);
        this.mList.get(23).setShowable(false);
        this.mList.get(24).setShowable(false);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_XP1_ZiYouXia /* 131446 */:
            case FinalCanbus.CAR_XP1_FAITAEGEA /* 459126 */:
            case FinalCanbus.CAR_XP1_18ZiYouXia /* 721270 */:
            case FinalCanbus.CAR_BNR_XP1_ZiYouXia /* 1048950 */:
            case FinalCanbus.CAR_ZH2_XP1_FAITAEGEA /* 2228598 */:
                this.mList.get(0).setShowable(true);
                this.mList.get(1).setShowable(true);
                this.mList.get(2).setShowable(true);
                this.mList.get(4).setShowable(true);
                this.mList.get(5).setShowable(true);
                this.mList.get(8).setShowable(true);
                this.mList.get(11).setShowable(true);
                this.mList.get(14).setShowable(true);
                this.mList.get(16).setShowable(true);
                break;
            case FinalCanbus.CAR_XP1_FAITDOBLO /* 524662 */:
                this.mList.get(0).setShowable(true);
                this.mList.get(1).setShowable(true);
                this.mList.get(2).setShowable(true);
                this.mList.get(4).setShowable(true);
                this.mList.get(14).setShowable(true);
                break;
            case FinalCanbus.CAR_XP1_RAM1500 /* 655734 */:
            case FinalCanbus.CAR_XP1_RAM1500_M /* 4063606 */:
            case FinalCanbus.CAR_XP1_RAM1500_H /* 4129142 */:
                this.mList.get(0).setShowable(true);
                this.mList.get(1).setShowable(true);
                this.mList.get(2).setShowable(true);
                this.mList.get(4).setShowable(true);
                this.mList.get(5).setShowable(true);
                this.mList.get(8).setShowable(true);
                this.mList.get(14).setShowable(true);
                this.mList.get(16).setShowable(true);
                break;
            case FinalCanbus.CAR_PA_dorango_13_18_Low /* 1376630 */:
            case FinalCanbus.CAR_PA_dorango_13_18_H /* 1442166 */:
            case FinalCanbus.CAR_PA_RAM_13_18_Low /* 1507702 */:
            case FinalCanbus.CAR_PA_RAM_13_18_H /* 1573238 */:
            case FinalCanbus.CAR_PA_Wrangler_18_20_Low /* 1638774 */:
            case FinalCanbus.CAR_PA_Wrangler_18_20_H /* 1704310 */:
            case FinalCanbus.CAR_PA_RAM_20_H /* 1835382 */:
            case FinalCanbus.CAR_PA_RAM_20_Low /* 1900918 */:
            case FinalCanbus.CAR_PA_RAM_22_H /* 2097526 */:
            case FinalCanbus.CAR_PA_RAM_22_Low /* 2163062 */:
            case FinalCanbus.CAR_PA_Cherokee_14_22 /* 2621814 */:
            case FinalCanbus.CAR_PA_GrandCherokee_14_22 /* 2687350 */:
            case FinalCanbus.CAR_PA_Chrysler_300C_11_22 /* 2752886 */:
            case FinalCanbus.CAR_PA_Dodge_Challenger_08_14 /* 2818422 */:
            case FinalCanbus.CAR_PA_RAM_13_18_Low_win4 /* 5177718 */:
            case FinalCanbus.CAR_PA_Cherokee_14_22_Amp /* 5243254 */:
            case FinalCanbus.CAR_PA_GrandCherokee_14_22_Amp /* 5308790 */:
            case FinalCanbus.CAR_PA_Gladiator_20_23 /* 5374326 */:
            case FinalCanbus.CAR_PA_Gladiator_20_23_Amp /* 5439862 */:
                this.mList.get(0).setShowable(true);
                this.mList.get(1).setShowable(true);
                this.mList.get(2).setShowable(true);
                this.mList.get(3).setShowable(true);
                this.mList.get(4).setShowable(true);
                this.mList.get(5).setShowable(true);
                this.mList.get(6).setShowable(true);
                this.mList.get(7).setShowable(true);
                this.mList.get(8).setShowable(true);
                this.mList.get(9).setShowable(true);
                this.mList.get(10).setShowable(true);
                this.mList.get(11).setShowable(true);
                this.mList.get(12).setShowable(true);
                this.mList.get(13).setShowable(true);
                this.mList.get(15).setShowable(true);
                this.mList.get(16).setShowable(true);
                this.mList.get(17).setShowable(true);
                this.mList.get(20).setShowable(true);
                break;
            case FinalCanbus.CAR_PA_dorango_10 /* 1966454 */:
            case FinalCanbus.CAR_PA_GMC_13 /* 2031990 */:
            case FinalCanbus.CAR_PA_SONOTEC_13 /* 2294134 */:
            case FinalCanbus.CAR_PA_Escalade_13 /* 2359670 */:
            case FinalCanbus.CAR_PA_Ford_F250 /* 2425206 */:
            case FinalCanbus.CAR_PA_Ford_F450 /* 2490742 */:
            case FinalCanbus.CAR_PA_Ford_F650 /* 2556278 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_08 /* 5046646 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Low /* 5112182 */:
                this.mList.get(0).setShowable(true);
                this.mList.get(1).setShowable(true);
                this.mList.get(3).setShowable(true);
                this.mList.get(15).setShowable(true);
                this.mList.get(16).setShowable(true);
                this.mList.get(18).setShowable(true);
                this.mList.get(19).setShowable(true);
                this.mList.get(21).setShowable(true);
                this.mList.get(22).setShowable(true);
                break;
            case FinalCanbus.CAR_PA_Ford_Explorer_19 /* 2883958 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22 /* 2949494 */:
            case FinalCanbus.CAR_PA_Ford_F150_14 /* 3015030 */:
            case FinalCanbus.CAR_PA_Ford_F150_20 /* 3080566 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18 /* 3146102 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21 /* 3211638 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17 /* 3277174 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21 /* 3342710 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15 /* 3932534 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_CD /* 3998070 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19_Amp /* 4260214 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_Amp /* 4325750 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_Amp /* 4391286 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_Amp /* 4456822 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_Amp /* 4522358 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_Amp /* 4587894 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_Amp /* 4653430 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_Amp /* 4718966 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_Amp /* 4784502 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16 /* 4850038 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_CD /* 4915574 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Amp /* 4981110 */:
                this.mList.get(0).setShowable(true);
                this.mList.get(1).setShowable(true);
                this.mList.get(3).setShowable(true);
                this.mList.get(15).setShowable(true);
                this.mList.get(16).setShowable(true);
                this.mList.get(18).setShowable(true);
                this.mList.get(19).setShowable(true);
                this.mList.get(23).setShowable(true);
                this.mList.get(24).setShowable(true);
                break;
            default:
                this.mList.get(0).setShowable(true);
                this.mList.get(1).setShowable(true);
                this.mList.get(2).setShowable(true);
                this.mList.get(4).setShowable(true);
                this.mList.get(5).setShowable(true);
                this.mList.get(7).setShowable(true);
                this.mList.get(8).setShowable(true);
                this.mList.get(10).setShowable(true);
                this.mList.get(11).setShowable(true);
                this.mList.get(12).setShowable(true);
                this.mList.get(14).setShowable(true);
                this.mList.get(16).setShowable(true);
                break;
        }
        this.adapter.updateList(this.mList);
    }
}
