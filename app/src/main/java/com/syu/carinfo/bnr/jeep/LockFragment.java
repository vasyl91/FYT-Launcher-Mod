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

public class LockFragment extends BaseFragment {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            LockFragment.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
        }
    };

    @Override
    public void initView() {
        this.mText = (TextView) findView(R.id.tv_car_title);
        this.mListView = (ListView) findView(R.id.list_carinfo);
        initValue();
        this.adapter = new AdapterCarInfo(mActivity, this.mList);
        this.mListView.setAdapter((ListAdapter) this.adapter);
        this.mText.setVisibility(0);
        this.mText.setText(R.string.grdcherokee_door_and_lock);
    }

    @Override
    public void initListener() {
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(0, 134, R.string.str_298_auto_door_unlock);
        carInfo.setCmd(1, 48);
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, 135, R.string.wc_372_offautolocktstr);
        carInfo2.setCmd(1, 49);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, 136, R.string.wc_372_lockturnlightstr);
        carInfo3.setCmd(1, 50);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(3, 140, R.string.jeep_presskeyunlock);
        carInfo4.setCmd(1, 52);
        carInfo4.setDiplsys(new String[]{getString(R.string.wc_ruiteng_string_unlock_mode_0), getString(R.string.wc_ruiteng_string_unlock_mode_1)});
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 141, R.string.jeep_keylessentry);
        carInfo5.setCmd(1, 54);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, 139, R.string.jeep_powertailgatealarm);
        carInfo6.setCmd(1, 55);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(1, 137, R.string.wc_372_lock_voice);
        carInfo7.setCmd(1, 56);
        carInfo7.setDiplsys(new String[]{"OFF", "1st press", "2nd press"});
        carInfo7.setCanCycleChange(true);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(0, 142, R.string.c_321_civic_beep_start_str);
        carInfo8.setCmd(1, 59);
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(3, 143, R.string.str_remote_door_unlock);
        carInfo9.setCmd(1, 60);
        carInfo9.setDiplsys(new String[]{getString(R.string.wc_ruiteng_string_unlock_mode_0), getString(R.string.wc_ruiteng_string_unlock_mode_1)});
        this.mList.add(carInfo9);
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_list;
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
    }
}
