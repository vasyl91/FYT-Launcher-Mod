package com.syu.carinfo.bnr.jeep;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.syu.adapter.AdapterCarInfo;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.entity.CarInfo;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LightFragment extends BaseFragment {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.jeep.LightFragment.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            LightFragment.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
        }
    };

    @Override // com.syu.canbus.BaseFragment
    public void initView() {
        initValue();
        this.mText = (TextView) findView(R.id.tv_car_title);
        this.mListView = (ListView) findView(R.id.list_carinfo);
        this.adapter = new AdapterCarInfo(mActivity, this.mList);
        this.mListView.setAdapter((ListAdapter) this.adapter);
        this.mText.setVisibility(0);
        this.mText.setText(R.string.lights_set);
    }

    @Override // com.syu.canbus.BaseFragment
    public void initListener() {
    }

    private void initValue() {
        this.mList.clear();
        CarInfo carInfo = new CarInfo(1, 55, R.string.rzc_biglight_sleep_value);
        carInfo.setCmd(1, 32);
        carInfo.setDiplsys(new String[]{"0 sec", "30 sec", "60 sec", "90 sec"});
        carInfo.setCanCycleChange(true);
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(1, 57, R.string.wc_372_nearlight);
        carInfo2.setCmd(1, 33);
        carInfo2.setDiplsys(new String[]{"0 sec", "30 sec", "60 sec", "90 sec"});
        carInfo2.setCanCycleChange(true);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, 56, R.string.jeep_locklights);
        carInfo3.setCmd(1, 35);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(0, 58, R.string.wc_372_daylightstr);
        carInfo4.setCmd(1, 36);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 59, R.string.str_cornering_lights);
        carInfo5.setCmd(1, 37);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, 60, R.string.wc_372_rainautolightstr);
        carInfo6.setCmd(1, 38);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, 62, R.string.jeep_autodimminghighbeams);
        carInfo7.setCmd(1, 39);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(0, 61, R.string.jeep_373_rearview_mirror);
        carInfo8.setCmd(1, 40);
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(1, 63, R.string.str_372_headlight_sensitivity);
        carInfo9.setCmd(1, 41);
        carInfo9.setDiplsys(new String[]{"1", "2", "3"});
        this.mList.add(carInfo9);
        CarInfo carInfo10 = new CarInfo(0, 64, R.string.str_373_unlock_turn_light);
        carInfo10.setCmd(1, 42);
        this.mList.add(carInfo10);
        CarInfo carInfo11 = new CarInfo(1, 106, R.string.wc_372_amblight);
        carInfo11.setCmd(1, 43);
        carInfo11.setDiplsys(new String[]{"0", "1", "2", "3", "4", "5", "6"});
        this.mList.add(carInfo11);
    }

    @Override // com.syu.canbus.BaseFragment
    public int getViewLayout() {
        return R.layout.layout_list;
    }

    @Override // com.syu.canbus.BaseFragment
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseFragment
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
    }
}
