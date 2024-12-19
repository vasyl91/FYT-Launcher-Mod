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
public class Activity_XBS_Unit extends Activity {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.jeep.Activity_XBS_Unit.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 116) {
                if (DataCanbus.DATA[updateCode] == 0) {
                    Activity_XBS_Unit.this.mList.get(Activity_XBS_Unit.this.getListID(115)).setDiplsys(new String[]{"L/100KM", "KM/L"});
                } else {
                    Activity_XBS_Unit.this.mList.get(Activity_XBS_Unit.this.getListID(115)).setDiplsys(new String[]{"MPG"});
                }
            }
            Activity_XBS_Unit.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        this.mText.setText(R.string.wc_273_unit);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(3, 117, R.string.str_dongjian_wc2_ds5_car_computer_unit_set);
        carInfo.setCmd(55, 1);
        carInfo.setDiplsys(new String[]{getString(R.string.str_unit_us_imperial), getString(R.string.str_unit_metric)});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(3, 116, R.string.jeep_format_set);
        carInfo2.setCmd(54, 3);
        carInfo2.setDiplsys(new String[]{getString(R.string.jeep_format_set1), getString(R.string.jeep_format_set0)});
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(1, 115, R.string.str_372_oil_unit);
        carInfo3.setCmd(53, 5);
        carInfo3.setDiplsys(new String[]{"L/100KM", "KM/L"});
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(1, 114, R.string.str_373_unit_tpms);
        carInfo4.setCmd(52, 7);
        carInfo4.setDiplsys(new String[]{"bar", "kpa", "psi"});
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(3, 113, R.string.str_372_temp_unit);
        carInfo5.setCmd(51, 4);
        carInfo5.setDiplsys(new String[]{getString(R.string.wc_15ruijie_temp_unit_c_set), getString(R.string.wc_15ruijie_temp_unit_f_set)});
        this.mList.add(carInfo5);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(57, new int[]{12}, null, null);
        addNotify();
        for (int i = 0; i < this.mList.size(); i++) {
            int id = this.mList.get(i).getUpdateCode();
            if (id <= 117 && id >= 113 && this.mList.get(i) != null) {
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
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
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
