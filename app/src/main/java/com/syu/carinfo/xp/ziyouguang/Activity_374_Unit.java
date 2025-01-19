package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.syu.adapter.AdapterCarInfo;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.entity.CarInfo;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;
import java.util.List;

public class Activity_374_Unit extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_Unit.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.wc_273_unit);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(3, 97, R.string.str_dongjian_wc2_ds5_car_computer_unit_set);
        carInfo.setCmd(0, 1);
        carInfo.setDiplsys(new String[]{getString(R.string.str_unit_us_imperial), getString(R.string.str_unit_metric)});
        this.mList.add(carInfo);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
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
                CarInfo carInfo2 = new CarInfo(1, 98, R.string.str_372_oil_unit);
                carInfo2.setCmd(0, 2);
                carInfo2.setDiplsys(new String[]{"Miles&MPG", "km&L/100km", "km&km/L"});
                this.mList.add(carInfo2);
                break;
            default:
                CarInfo carInfo3 = new CarInfo(1, 98, R.string.str_372_oil_unit);
                carInfo3.setCmd(0, 5);
                carInfo3.setDiplsys(new String[]{"L/100KM", "KM/L", "MPG(US)", "MPG(UK)"});
                this.mList.add(carInfo3);
                break;
        }
        CarInfo carInfo4 = new CarInfo(3, 99, R.string.jeep_format_set);
        carInfo4.setCmd(0, 3);
        carInfo4.setDiplsys(new String[]{CamryData.MILEAGE_UNIT_KM, "MI"});
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(3, 221, R.string.str_speed_unit);
        carInfo5.setCmd(0, 8);
        carInfo5.setDiplsys(new String[]{"km/h", CamryData.SPEED_UNIT_MILE});
        this.mList.add(carInfo5);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
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
                CarInfo carInfo6 = new CarInfo(3, 100, R.string.str_372_temp_unit);
                carInfo6.setCmd(0, 4);
                carInfo6.setDiplsys(new String[]{getString(R.string.wc_15ruijie_temp_unit_c_set), getString(R.string.wc_15ruijie_temp_unit_f_set)});
                this.mList.add(carInfo6);
                break;
            default:
                CarInfo carInfo7 = new CarInfo(3, 100, R.string.str_372_temp_unit);
                carInfo7.setCmd(0, 4);
                carInfo7.setDiplsys(new String[]{getString(R.string.wc_15ruijie_temp_unit_c_set), getString(R.string.wc_15ruijie_temp_unit_f_set)});
                this.mList.add(carInfo7);
                break;
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
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
                CarInfo carInfo8 = new CarInfo(1, 101, R.string.str_373_unit_tpms);
                carInfo8.setCmd(0, 3);
                carInfo8.setDiplsys(new String[]{"kPa", "bar", "psi"});
                this.mList.add(carInfo8);
                break;
            default:
                CarInfo carInfo9 = new CarInfo(1, 101, R.string.str_373_unit_tpms);
                carInfo9.setCmd(0, 7);
                carInfo9.setDiplsys(new String[]{"psi", "kpa", "bar"});
                this.mList.add(carInfo9);
                break;
        }
        CarInfo carInfo10 = new CarInfo(9, 166, R.string.str_tripa_reset);
        carInfo10.setCmd(0, 10);
        carInfo10.setDiplsys(new String[2]);
        this.mList.add(carInfo10);
        CarInfo carInfo11 = new CarInfo(9, 166, R.string.str_tripb_reset);
        carInfo11.setCmd(0, 11);
        carInfo11.setDiplsys(new String[2]);
        this.mList.add(carInfo11);
        CarInfo carInfo12 = new CarInfo(0, 168, R.string.str_tripb_display);
        carInfo12.setCmd(0, 6);
        this.mList.add(carInfo12);
        CarInfo carInfo13 = new CarInfo(1, 360, R.string.str_power);
        carInfo13.setCmd(0, 12);
        carInfo13.setDiplsys(new String[]{"hp(US)", "KW", "hp(UK)"});
        this.mList.add(carInfo13);
        CarInfo carInfo14 = new CarInfo(1, 361, R.string.str_torque);
        carInfo14.setCmd(0, 13);
        carInfo14.setDiplsys(new String[]{"lb-ft", "Nm"});
        this.mList.add(carInfo14);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_XP1_FAITAEGEA /* 459126 */:
            case FinalCanbus.CAR_ZH2_XP1_FAITAEGEA /* 2228598 */:
                this.mList.get(0).setShowable(true);
                this.mList.get(1).setShowable(true);
                this.mList.get(2).setShowable(true);
                this.mList.get(3).setShowable(true);
                this.mList.get(4).setShowable(true);
                this.mList.get(5).setShowable(true);
                this.mList.get(6).setShowable(true);
                this.mList.get(7).setShowable(true);
                break;
            case FinalCanbus.CAR_XP1_FAITDOBLO /* 524662 */:
                this.mList.get(1).setShowable(true);
                this.mList.get(2).setShowable(true);
                this.mList.get(3).setShowable(true);
                this.mList.get(4).setShowable(true);
                this.mList.get(5).setShowable(true);
                this.mList.get(6).setShowable(true);
                this.mList.get(7).setShowable(true);
                this.mList.get(8).setShowable(true);
                break;
            case FinalCanbus.CAR_XP1_RAM1500 /* 655734 */:
            case FinalCanbus.CAR_XP1_RAM1500_M /* 4063606 */:
            case FinalCanbus.CAR_XP1_RAM1500_H /* 4129142 */:
                this.mList.get(0).setShowable(true);
                this.mList.get(1).setShowable(true);
                this.mList.get(3).setShowable(true);
                this.mList.get(5).setShowable(true);
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
                this.mList.get(9).setShowable(true);
                this.mList.get(10).setShowable(true);
                break;
            case FinalCanbus.CAR_PA_dorango_10 /* 1966454 */:
            case FinalCanbus.CAR_PA_GMC_13 /* 2031990 */:
            case FinalCanbus.CAR_PA_SONOTEC_13 /* 2294134 */:
            case FinalCanbus.CAR_PA_Escalade_13 /* 2359670 */:
            case FinalCanbus.CAR_PA_Ford_F250 /* 2425206 */:
            case FinalCanbus.CAR_PA_Ford_F450 /* 2490742 */:
            case FinalCanbus.CAR_PA_Ford_F650 /* 2556278 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19 /* 2883958 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22 /* 2949494 */:
            case FinalCanbus.CAR_PA_Ford_F150_14 /* 3015030 */:
            case FinalCanbus.CAR_PA_Ford_F150_20 /* 3080566 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18 /* 3146102 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21 /* 3211638 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17 /* 3277174 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21 /* 3342710 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15 /* 3932534 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_08 /* 5046646 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Low /* 5112182 */:
                this.mList.get(0).setShowable(true);
                break;
            case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
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
                this.mList.get(4).setShowable(true);
                this.mList.get(5).setShowable(true);
                break;
            default:
                this.mList.get(0).setShowable(true);
                this.mList.get(1).setShowable(true);
                this.mList.get(2).setShowable(true);
                this.mList.get(3).setShowable(true);
                this.mList.get(4).setShowable(true);
                this.mList.get(5).setShowable(true);
                break;
        }
        this.adapter.updateList(this.mList);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[360].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[361].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[360].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[361].removeNotify(this.mNotifyCanbus);
    }
}
