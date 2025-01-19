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

public class Activity_XBS_Suspension extends Activity {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_XBS_Suspension.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_list);
        this.mText = (TextView) findViewById(R.id.tv_car_title);
        this.mListView = (ListView) findViewById(R.id.list_carinfo);
        initValue();
        this.adapter = new AdapterCarInfo(this, this.mList);
        this.mListView.setAdapter((ListAdapter) this.adapter);
        this.mText.setVisibility(0);
        this.mText.setText(R.string.grdcherokee_suspension);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(0, 108, R.string.str_373_wheel_alignment_mode);
        carInfo.setCmd(46, 32);
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(0, 109, R.string.str_373_transport_mode);
        carInfo2.setCmd(47, 32);
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, 110, R.string.str_373_tire_jacks);
        carInfo3.setCmd(48, 32);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(0, 111, R.string.str_373_display_suspension);
        carInfo4.setCmd(49, 32);
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(0, 112, R.string.str_373_auto_adjust_suspension);
        carInfo5.setCmd(50, 32);
        this.mList.add(carInfo5);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(57, new int[]{12}, null, null);
        for (int i = 0; i < this.mList.size(); i++) {
            int id = this.mList.get(i).getUpdateCode();
            if (id <= 112 && id >= 108 && this.mList.get(i) != null) {
                if (DataCanbus.DATA[id - 56] == 0) {
                    this.mList.get(i).setShowable(false);
                } else {
                    this.mList.get(i).setShowable(true);
                }
            }
        }
        this.adapter.updateList(this.mList);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
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
