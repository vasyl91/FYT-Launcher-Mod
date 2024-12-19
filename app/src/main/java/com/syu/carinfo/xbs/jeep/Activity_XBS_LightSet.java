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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Activity_XBS_LightSet extends Activity {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.jeep.Activity_XBS_LightSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_XBS_LightSet.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list);
        this.mText = (TextView) findViewById(R.id.tv_car_title);
        this.mListView = (ListView) findViewById(R.id.list_carinfo);
        initValue();
        this.adapter = new AdapterCarInfo(this, this.mList);
        this.mListView.setAdapter((ListAdapter) this.adapter);
        this.mText.setVisibility(0);
        this.mText.setText(R.string.lights_set);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(0, 82, R.string.str_0bD047);
        carInfo.setCmd(20, 32);
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, 83, R.string.wc_372_assiatlight);
        carInfo2.setCmd(21, 32);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, 84, R.string.jeep_locklights);
        carInfo3.setCmd(22, 32);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(0, 85, R.string.wc_ruiteng_string_day_light);
        carInfo4.setCmd(23, 32);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 86, R.string.str_0bD042);
        carInfo5.setCmd(24, 32);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, 87, R.string.wc_372_autolightstr);
        carInfo6.setCmd(25, 32);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, 88, R.string.wc_372_rainautolightstr);
        carInfo7.setCmd(26, 32);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(1, 89, R.string.jeep_power_off_delay);
        carInfo8.setCmd(27, 33);
        carInfo8.setDiplsys(new String[]{"0 sec", "45 sec", "5 min", "10 min"});
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(1, 90, R.string.wc_372_nearlight);
        carInfo9.setCmd(28, 33);
        carInfo9.setDiplsys(new String[]{"0 sec", "30 sec", "60 sec", "90 sec"});
        this.mList.add(carInfo9);
        CarInfo carInfo10 = new CarInfo(1, 91, R.string.jeep_headlights_off_delay);
        carInfo10.setCmd(29, 33);
        carInfo10.setDiplsys(new String[]{"0 sec", "30 sec", "60 sec", "90 sec"});
        this.mList.add(carInfo10);
        CarInfo carInfo11 = new CarInfo(1, 92, R.string.wc_372_amblight);
        carInfo11.setCmd(30, 33);
        carInfo11.setDiplsys(new String[]{"0", "1", "2", "3", "4", "5", "6"});
        this.mList.add(carInfo11);
        CarInfo carInfo12 = new CarInfo(1, 93, R.string.str_373_headlight_sensi);
        carInfo12.setCmd(31, 33);
        carInfo12.setDiplsys(new String[]{"0", "1", "2", "3", "4", "5", "6"});
        this.mList.add(carInfo12);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(57, new int[]{12}, null, null);
        for (int i = 0; i < this.mList.size(); i++) {
            int id = this.mList.get(i).getUpdateCode();
            if (id <= 92 && id >= 88 && this.mList.get(i) != null) {
                if (DataCanbus.DATA[id - 56] == 0) {
                    this.mList.get(i).setShowable(false);
                } else {
                    this.mList.get(i).setShowable(true);
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
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
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
