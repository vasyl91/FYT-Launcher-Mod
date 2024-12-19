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
public class Activity_374_Safety extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_Safety.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_Safety.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.wc_273_safety);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(3, 114, R.string.jeep_parksense);
        carInfo.setCmd(0, 160);
        carInfo.setDiplsys(new String[]{getString(R.string.jeep_parksense_0), getString(R.string.jeep_parksense_1)});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, 115, R.string.wc_372_parksensebreakstr);
        carInfo2.setCmd(0, 163);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, 116, R.string.wc_372_video_movestr);
        carInfo3.setCmd(0, 164);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(0, 117, R.string.wc_372_video_staticstr);
        carInfo4.setCmd(0, 165);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 118, R.string.xp_yl_lane_assist_str);
        carInfo5.setCmd(0, 166);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(1, 119, R.string.jeep_blindwarn);
        carInfo6.setCmd(0, 172);
        carInfo6.setDiplsys(new String[]{getString(R.string.off), getString(R.string.jeep_blindwarn_1), getString(R.string.jeep_blindwarn_2)});
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(1, 120, R.string.wc_372_frontsensevolstr);
        carInfo7.setCmd(0, 161);
        carInfo7.setDiplsys(new String[]{getString(R.string.wc_372_low), getString(R.string.wc_372_mid), getString(R.string.wc_372_high)});
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(1, 121, R.string.wc_372_backsensevolstr);
        carInfo8.setCmd(0, 162);
        carInfo8.setDiplsys(new String[]{getString(R.string.wc_372_low), getString(R.string.wc_372_mid), getString(R.string.wc_372_high)});
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(3, 122, R.string.jeep_forwardcollisionwarn);
        carInfo9.setCmd(0, 170);
        carInfo9.setDiplsys(new String[]{getString(R.string.jeep_forwardcollisionwarn_0), getString(R.string.jeep_forwardcollisionwarn_1)});
        this.mList.add(carInfo9);
        CarInfo carInfo10 = new CarInfo(1, 199, R.string.jeep_forwardcollisionwarn);
        carInfo10.setCmd(0, 170);
        carInfo10.setDiplsys(new String[]{getString(R.string.jeep_forwardcollisionwarn_0), getString(R.string.jeep_forwardcollisionwarn_1), getString(R.string.jeep_lanesensewarn_1)});
        this.mList.add(carInfo10);
        CarInfo carInfo11 = new CarInfo(1, 123, R.string.jeep_forwardcollisionbrake);
        carInfo11.setCmd(0, 171);
        carInfo11.setDiplsys(new String[]{getString(R.string.off), getString(R.string.wc_weilang_auto_fangzhuang_warn), getString(R.string.str_brake), getString(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong)});
        this.mList.add(carInfo11);
        CarInfo carInfo12 = new CarInfo(0, 124, R.string.str_373_parksense_brakeassist);
        carInfo12.setCmd(0, 173);
        this.mList.add(carInfo12);
        CarInfo carInfo13 = new CarInfo(1, 125, R.string.str_lanesense_strength);
        carInfo13.setCmd(0, 174);
        carInfo13.setDiplsys(new String[]{getString(R.string.wc_372_low), getString(R.string.wc_372_mid), getString(R.string.wc_372_high)});
        this.mList.add(carInfo13);
        CarInfo carInfo14 = new CarInfo(0, 126, R.string.wc_372_rainautostr);
        carInfo14.setCmd(0, 175);
        this.mList.add(carInfo14);
        CarInfo carInfo15 = new CarInfo(0, 127, R.string.jeep_rear_parksense_auto_brakeassist);
        carInfo15.setCmd(0, 240);
        this.mList.add(carInfo15);
        CarInfo carInfo16 = new CarInfo(0, 128, R.string.jeep_auto_parksense_brakeassist);
        carInfo16.setCmd(0, 241);
        this.mList.add(carInfo16);
        CarInfo carInfo17 = new CarInfo(1, 129, R.string.wc_372_lanewar);
        carInfo17.setCmd(0, 169);
        carInfo17.setDiplsys(new String[]{getString(R.string.jeep_lanesensewarn_0), getString(R.string.jeep_lanesensewarn_1), getString(R.string.jeep_lanesensewarn_2)});
        this.mList.add(carInfo17);
        CarInfo carInfo18 = new CarInfo(0, 166, R.string.str_374_hillstart);
        carInfo18.setCmd(0, 16);
        this.mList.add(carInfo18);
        CarInfo carInfo19 = new CarInfo(0, 207, R.string.wc_372_front_video_staticstr);
        carInfo19.setCmd(0, 198);
        this.mList.add(carInfo19);
        CarInfo carInfo20 = new CarInfo(0, 208, R.string.wc_372_tire_fill_assist);
        carInfo20.setCmd(0, 197);
        this.mList.add(carInfo20);
        CarInfo carInfo21 = new CarInfo(1, 206, R.string.str_deploy_step);
        carInfo21.setCmd(0, 195);
        carInfo21.setDiplsys(new String[]{"Deplo", "Retract"});
        this.mList.add(carInfo21);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        for (int i = 0; i < this.mList.size(); i++) {
            if (this.mList.get(i).getUpdateCode() == 207 || this.mList.get(i).getUpdateCode() == 208) {
                if (DataCanbus.DATA[1000] == 1376630 || DataCanbus.DATA[1000] == 1442166 || DataCanbus.DATA[1000] == 1507702 || DataCanbus.DATA[1000] == 1573238 || DataCanbus.DATA[1000] == 1638774 || DataCanbus.DATA[1000] == 1704310 || DataCanbus.DATA[1000] == 2621814 || DataCanbus.DATA[1000] == 2687350 || DataCanbus.DATA[1000] == 2752886 || DataCanbus.DATA[1000] == 2818422 || DataCanbus.DATA[1000] == 1835382 || DataCanbus.DATA[1000] == 1900918 || DataCanbus.DATA[1000] == 2097526 || DataCanbus.DATA[1000] == 2163062) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 121) {
                if (DataCanbus.DATA[1000] == 721270 || DataCanbus.DATA[1000] == 1376630 || DataCanbus.DATA[1000] == 1442166 || DataCanbus.DATA[1000] == 1507702 || DataCanbus.DATA[1000] == 1573238 || DataCanbus.DATA[1000] == 1638774 || DataCanbus.DATA[1000] == 1704310 || DataCanbus.DATA[1000] == 2621814 || DataCanbus.DATA[1000] == 2687350 || DataCanbus.DATA[1000] == 2752886 || DataCanbus.DATA[1000] == 2818422 || DataCanbus.DATA[1000] == 1835382 || DataCanbus.DATA[1000] == 1900918 || DataCanbus.DATA[1000] == 2097526 || DataCanbus.DATA[1000] == 2163062) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 122) {
                if (DataCanbus.DATA[1000] == 1376630 || DataCanbus.DATA[1000] == 1442166 || DataCanbus.DATA[1000] == 1507702 || DataCanbus.DATA[1000] == 1573238 || DataCanbus.DATA[1000] == 1638774 || DataCanbus.DATA[1000] == 1704310 || DataCanbus.DATA[1000] == 2621814 || DataCanbus.DATA[1000] == 2687350 || DataCanbus.DATA[1000] == 2752886 || DataCanbus.DATA[1000] == 2818422 || DataCanbus.DATA[1000] == 1835382 || DataCanbus.DATA[1000] == 1900918 || DataCanbus.DATA[1000] == 2097526 || DataCanbus.DATA[1000] == 2163062) {
                    this.mList.get(i).setShowable(false);
                } else {
                    this.mList.get(i).setShowable(true);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 199) {
                if (DataCanbus.DATA[1000] == 1376630 || DataCanbus.DATA[1000] == 1442166 || DataCanbus.DATA[1000] == 1507702 || DataCanbus.DATA[1000] == 1573238 || DataCanbus.DATA[1000] == 1638774 || DataCanbus.DATA[1000] == 1704310 || DataCanbus.DATA[1000] == 2621814 || DataCanbus.DATA[1000] == 2687350 || DataCanbus.DATA[1000] == 2752886 || DataCanbus.DATA[1000] == 2818422 || DataCanbus.DATA[1000] == 1835382 || DataCanbus.DATA[1000] == 1900918 || DataCanbus.DATA[1000] == 2097526 || DataCanbus.DATA[1000] == 2163062) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 116 || this.mList.get(i).getUpdateCode() == 114) {
                if (DataCanbus.DATA[1000] == 131446 || DataCanbus.DATA[1000] == 721270 || DataCanbus.DATA[1000] == 1376630 || DataCanbus.DATA[1000] == 1442166 || DataCanbus.DATA[1000] == 1507702 || DataCanbus.DATA[1000] == 1573238 || DataCanbus.DATA[1000] == 1638774 || DataCanbus.DATA[1000] == 1704310 || DataCanbus.DATA[1000] == 2621814 || DataCanbus.DATA[1000] == 2687350 || DataCanbus.DATA[1000] == 2752886 || DataCanbus.DATA[1000] == 2818422 || DataCanbus.DATA[1000] == 1835382 || DataCanbus.DATA[1000] == 1900918 || DataCanbus.DATA[1000] == 2097526 || DataCanbus.DATA[1000] == 2163062) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 126) {
                if (DataCanbus.DATA[1000] == 131446 || DataCanbus.DATA[1000] == 1376630 || DataCanbus.DATA[1000] == 1442166 || DataCanbus.DATA[1000] == 1507702 || DataCanbus.DATA[1000] == 1573238 || DataCanbus.DATA[1000] == 1638774 || DataCanbus.DATA[1000] == 1704310 || DataCanbus.DATA[1000] == 2621814 || DataCanbus.DATA[1000] == 2687350 || DataCanbus.DATA[1000] == 2752886 || DataCanbus.DATA[1000] == 2818422 || DataCanbus.DATA[1000] == 1835382 || DataCanbus.DATA[1000] == 1900918 || DataCanbus.DATA[1000] == 2097526 || DataCanbus.DATA[1000] == 2163062) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 166) {
                if (DataCanbus.DATA[1000] == 655734) {
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
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
    }
}
