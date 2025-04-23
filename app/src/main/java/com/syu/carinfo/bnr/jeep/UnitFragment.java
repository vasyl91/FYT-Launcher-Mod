package com.syu.carinfo.bnr.jeep;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.syu.adapter.AdapterCarInfo;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.entity.CarInfo;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

import java.util.ArrayList;
import java.util.List;

public class UnitFragment extends BaseFragment {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UnitFragment.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
        }
    };

    @Override
    public void initView() {
        initValue();
        this.mText = (TextView) findView(R.id.tv_car_title);
        this.mListView = (ListView) findView(R.id.list_carinfo);
        this.adapter = new AdapterCarInfo(mActivity, this.mList);
        this.mListView.setAdapter((ListAdapter) this.adapter);
        this.mText.setVisibility(0);
        this.mText.setText(R.string.wc_273_unit);
    }

    @Override
    public void initListener() {
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_list;
    }

    private void initValue() {
        this.mList.clear();
        CarInfo carInfo = new CarInfo(3, 119, R.string.str_dongjian_wc2_ds5_car_computer_unit_set);
        carInfo.setCmd(1, 1);
        carInfo.setDiplsys(new String[]{getString(R.string.str_unit_us_imperial), getString(R.string.str_unit_metric)});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(3, 121, R.string.jeep_format_set);
        carInfo2.setCmd(1, 3);
        carInfo2.setDiplsys(new String[]{CamryData.MILEAGE_UNIT_KM, "MI"});
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(3, 122, R.string.str_372_temp_unit);
        carInfo3.setCmd(1, 4);
        carInfo3.setDiplsys(new String[]{getString(R.string.wc_15ruijie_temp_unit_c_set), getString(R.string.wc_15ruijie_temp_unit_f_set)});
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(1, 120, R.string.str_372_oil_unit);
        carInfo4.setCmd(1, 5);
        carInfo4.setDiplsys(new String[]{"L/100KM", "KM/L", "MPG(US)", "MPG(UK)"});
        carInfo4.setCanCycleChange(true);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(1, 123, R.string.str_373_unit_tpms);
        carInfo5.setCmd(1, 7);
        carInfo5.setDiplsys(new String[]{"psi", "kpa", "bar"});
        carInfo5.setCanCycleChange(true);
        this.mList.add(carInfo5);
    }

    @Override
    public void onResume() {
        super.onResume();
        addNotify();
        this.adapter.updateList(this.mList);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
    }
}
