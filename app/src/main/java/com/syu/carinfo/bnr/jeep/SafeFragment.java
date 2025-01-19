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

public class SafeFragment extends BaseFragment {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            SafeFragment.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        this.mText.setText(R.string.wc_273_safety);
    }

    private void initValue() {
        this.mList.clear();
        CarInfo carInfo = new CarInfo(3, 148, R.string.jeep_parksense);
        carInfo.setCmd(1, 160);
        carInfo.setDiplsys(new String[]{getString(R.string.jeep_parksense_0), getString(R.string.jeep_parksense_1)});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(1, 154, R.string.wc_372_frontsensevolstr);
        carInfo2.setCmd(1, 161);
        carInfo2.setDiplsys(new String[]{getString(R.string.wc_372_low), getString(R.string.wc_372_mid), getString(R.string.wc_372_high)});
        carInfo2.setCanCycleChange(true);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(1, 155, R.string.wc_372_backsensevolstr);
        carInfo3.setCmd(1, 162);
        carInfo3.setDiplsys(new String[]{getString(R.string.wc_372_low), getString(R.string.wc_372_mid), getString(R.string.wc_372_high)});
        carInfo3.setCanCycleChange(true);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(0, 149, R.string.wc_372_parksensebreakstr);
        carInfo4.setCmd(1, 163);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 150, R.string.wc_372_video_movestr);
        carInfo5.setCmd(1, 164);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, 151, R.string.wc_372_video_staticstr);
        carInfo6.setCmd(1, 165);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, 152, R.string.xp_yl_lane_assist_str);
        carInfo7.setCmd(1, 166);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(3, 156, R.string.jeep_forwardcollisionwarn);
        carInfo8.setCmd(1, 167);
        carInfo8.setDiplsys(new String[]{getString(R.string.jeep_forwardcollisionwarn_0), getString(R.string.jeep_forwardcollisionwarn_1)});
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(0, 157, R.string.jeep_forwardcollisionbrake);
        carInfo9.setCmd(1, 168);
        this.mList.add(carInfo9);
        CarInfo carInfo10 = new CarInfo(1, 163, R.string.wc_372_lanewar);
        carInfo10.setCmd(1, 169);
        carInfo10.setDiplsys(new String[]{getString(R.string.jeep_lanesensewarn_0), getString(R.string.jeep_lanesensewarn_1), getString(R.string.jeep_lanesensewarn_2)});
        carInfo10.setCanCycleChange(true);
        this.mList.add(carInfo10);
        CarInfo carInfo11 = new CarInfo(1, 159, R.string.str_lanesense_strength);
        carInfo11.setCmd(1, 170);
        carInfo11.setDiplsys(new String[]{getString(R.string.wc_372_low), getString(R.string.wc_372_mid), getString(R.string.wc_372_high)});
        carInfo11.setCanCycleChange(true);
        this.mList.add(carInfo11);
        CarInfo carInfo12 = new CarInfo(1, 153, R.string.jeep_blindwarn);
        carInfo12.setCmd(1, 171);
        carInfo12.setDiplsys(new String[]{getString(R.string.jeep_blindwarn_0), getString(R.string.jeep_blindwarn_1), getString(R.string.jeep_blindwarn_2)});
        carInfo12.setCanCycleChange(true);
        this.mList.add(carInfo12);
        CarInfo carInfo13 = new CarInfo(0, 160, R.string.jeep_rainsensewipers);
        carInfo13.setCmd(1, 172);
        this.mList.add(carInfo13);
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
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
    }
}
