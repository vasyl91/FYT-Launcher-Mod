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
public class Activity_374_Brakemode_beifen extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_Brakemode_beifen.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_Brakemode_beifen.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.jeep_brakemode);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(0, 133, R.string.jeep_brakemode);
        carInfo.setCmd(0, 192);
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, 134, R.string.jeep_autoparkbrake);
        carInfo2.setCmd(0, 193);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(1, 211, R.string.str_power_sidestep);
        carInfo3.setCmd(0, 196);
        carInfo3.setDiplsys(new String[]{"auto", "store"});
        this.mList.add(carInfo3);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        for (int i = 0; i < this.mList.size(); i++) {
            if (this.mList.get(i).getUpdateCode() == 133) {
                if (DataCanbus.DATA[1000] == 721270) {
                    this.mList.get(i).setShowable(false);
                } else {
                    this.mList.get(i).setShowable(true);
                }
            }
            if (this.mList.get(i).getUpdateCode() == 211) {
                if (DataCanbus.DATA[1000] == 1376630 || DataCanbus.DATA[1000] == 1442166 || DataCanbus.DATA[1000] == 1507702 || DataCanbus.DATA[1000] == 1573238 || DataCanbus.DATA[1000] == 1638774 || DataCanbus.DATA[1000] == 1704310 || DataCanbus.DATA[1000] == 2621814 || DataCanbus.DATA[1000] == 2687350 || DataCanbus.DATA[1000] == 2752886 || DataCanbus.DATA[1000] == 2818422 || DataCanbus.DATA[1000] == 1835382 || DataCanbus.DATA[1000] == 1900918 || DataCanbus.DATA[1000] == 2097526 || DataCanbus.DATA[1000] == 2163062) {
                    this.mList.get(i).setShowable(true);
                } else {
                    this.mList.get(i).setShowable(false);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
    }
}