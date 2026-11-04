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
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Activity_374_EVHybird extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_EVHybird.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_EVHybird.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.str_e_hybird);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(0, Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D80_D2_B7, R.string.str_max_regeneration);
        carInfo.setCmd(0, 130);
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(1, Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D80_D2_B6, R.string.str_e_savecharging);
        carInfo2.setCmd(0, 131);
        carInfo2.setDiplsys(new String[]{"Battery Save", "Battery Charge"});
        this.mList.add(carInfo2);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(25, new int[]{64, 128, 0, 0}, null, null);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[522].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[523].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[522].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[523].removeNotify(this.mNotifyCanbus);
    }
}
