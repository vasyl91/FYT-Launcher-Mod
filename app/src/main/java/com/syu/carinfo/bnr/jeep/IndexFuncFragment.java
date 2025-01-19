package com.syu.carinfo.bnr.jeep;

import android.app.Fragment;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.syu.adapter.AdapterCarInfo;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.entity.CarInfo;
import java.util.ArrayList;
import java.util.List;

public class IndexFuncFragment extends BaseFragment {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    int[] titles = {R.string.rzc_others_language_setting, R.string.wc_273_unit, R.string.lights_set, R.string.grdcherokee_door_and_lock, R.string.grdcherokee_engine_shotdown_option, R.string.wc_273_safety, R.string.str_guandao_amp, R.string.wc_273_other};
    List<Fragment> mFrags = new ArrayList();

    @Override
    public void initView() {
        this.mText = (TextView) findView(R.id.tv_car_title);
        this.mListView = (ListView) findView(R.id.list_carinfo);
        initValue();
        this.adapter = new AdapterCarInfo(mActivity, this.mList);
        this.mListView.setAdapter((ListAdapter) this.adapter);
        this.mText.setVisibility(0);
        this.mText.setText(R.string.vehicle_personalization);
    }

    private void initValue() {
        if (this.mFrags.size() == 0) {
            Fragment fragment = new LanguageFragment();
            this.mFrags.add(fragment);
            Fragment fragment2 = new UnitFragment();
            this.mFrags.add(fragment2);
            Fragment fragment3 = new LightFragment();
            this.mFrags.add(fragment3);
            Fragment fragment4 = new LockFragment();
            this.mFrags.add(fragment4);
            Fragment fragment5 = new EngineFragment();
            this.mFrags.add(fragment5);
            Fragment fragment6 = new SafeFragment();
            this.mFrags.add(fragment6);
            Fragment fragment7 = new AMPFragment();
            this.mFrags.add(fragment7);
            Fragment fragment8 = new OtherFragment();
            this.mFrags.add(fragment8);
        }
        if (this.mList.size() == 0) {
            for (int i = 0; i < this.titles.length; i++) {
                CarInfo carInfo = new CarInfo(11, 0, getString(this.titles[i]));
                carInfo.setFragment(this.mFrags.get(i));
                this.mList.add(carInfo);
            }
        }
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_list;
    }

    @Override
    public void addNotify() {
    }

    @Override
    public void removeNotify() {
    }
}
