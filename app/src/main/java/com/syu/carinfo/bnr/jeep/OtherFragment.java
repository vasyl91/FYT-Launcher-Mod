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
public class OtherFragment extends BaseFragment {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.jeep.OtherFragment.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            OtherFragment.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
        }
    };

    @Override // com.syu.canbus.BaseFragment
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
        CarInfo carInfo = new CarInfo(2, 96, R.string.wc_372_anglestr);
        carInfo.setCmd(1, 177);
        carInfo.setDiplsys(new String[]{getString(R.string.str_pack_complete), getString(R.string.str_compass_checking)});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(2, 97, R.string.str_compass_deviation_value);
        carInfo2.setCmd(1, 176);
        String[] strs = new String[16];
        for (int i = 0; i < 16; i++) {
            strs[i] = new StringBuilder().append(i).toString();
        }
        carInfo2.setDiplsys(strs);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(1, 78, R.string.jeep_headlights_off_delay);
        carInfo3.setCmd(1, 144);
        carInfo3.setDiplsys(new String[]{getString(R.string.jeep_comfortsystems_0), getString(R.string.jeep_comfortsystems_1), getString(R.string.jeep_comfortsystems_2)});
        carInfo3.setCanCycleChange(true);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(0, 108, R.string.wc_17zhinanzhe_str4);
        carInfo4.setCmd(1, 145);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 99, R.string.jeep_autoparkbrake);
        carInfo5.setCmd(1, 192);
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(1, 109, R.string.jeep_speedvolume);
        carInfo6.setCmd(1, 208);
        carInfo6.setDiplsys(new String[]{"OFF", "1", "2", "3"});
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, 110, R.string.jeep_surroundsound);
        carInfo7.setCmd(1, 209);
        this.mList.add(carInfo7);
    }

    @Override // com.syu.canbus.BaseFragment
    public void initListener() {
    }

    @Override // com.syu.canbus.BaseFragment
    public int getViewLayout() {
        return R.layout.layout_list;
    }

    @Override // com.syu.canbus.BaseFragment
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseFragment
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }
}
