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

public class OtherFragment extends BaseFragment {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            OtherFragment.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        this.mText.setText(R.string.wc_273_other);
    }

    private void initValue() {
        this.mList.clear();
        CarInfo carInfo = new CarInfo(2, 165, R.string.wc_372_anglestr);
        carInfo.setCmd(1, 177);
        carInfo.setDiplsys(new String[]{getString(R.string.str_pack_complete), getString(R.string.str_compass_checking)});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(2, 166, R.string.str_compass_deviation_value);
        carInfo2.setCmd(1, 176);
        String[] strs = new String[16];
        for (int i = 0; i < 16; i++) {
            strs[i] = new StringBuilder().append(i).toString();
        }
        carInfo2.setDiplsys(strs);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(1, 147, R.string.jeep_headlights_off_delay);
        carInfo3.setCmd(1, 144);
        carInfo3.setDiplsys(new String[]{getString(R.string.jeep_comfortsystems_0), getString(R.string.jeep_comfortsystems_1), getString(R.string.jeep_comfortsystems_2)});
        carInfo3.setCanCycleChange(true);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(0, 177, R.string.wc_17zhinanzhe_str4);
        carInfo4.setCmd(1, 145);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 168, R.string.jeep_autoparkbrake);
        carInfo5.setCmd(1, 192);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(1, 178, R.string.jeep_speedvolume);
        carInfo6.setCmd(1, 208);
        carInfo6.setDiplsys(new String[]{"OFF", "1", "2", "3"});
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, 179, R.string.jeep_surroundsound);
        carInfo7.setCmd(1, 209);
        this.mList.add(carInfo7);
    }

    @Override
    public void initListener() {
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_list;
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
    }
}
