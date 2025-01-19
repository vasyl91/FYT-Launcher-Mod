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

public class EngineFragment extends BaseFragment {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            EngineFragment.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        this.mText.setText(R.string.grdcherokee_engine_shotdown_option);
    }

    private void initValue() {
        this.mList.clear();
        CarInfo carInfo = new CarInfo(1, 144, R.string.jeep_headlights_off_delay);
        carInfo.setCmd(1, 64);
        carInfo.setDiplsys(new String[]{"0 sec", "30 sec", "60 sec", "90 sec"});
        carInfo.setCanCycleChange(true);
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(1, 145, R.string.jeep_power_off_delay);
        carInfo2.setCmd(1, 65);
        carInfo2.setDiplsys(new String[]{"0 sec", "45sec", "5min", "10min"});
        carInfo2.setCanCycleChange(true);
        this.mList.add(carInfo2);
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
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
    }
}
