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
public class Activity_XBS_Safety extends Activity {
    AdapterCarInfo adapter;
    ListView mListView;
    TextView mText;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.jeep.Activity_XBS_Safety.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_XBS_Safety.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
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
        this.mText.setText(R.string.wc_273_safety);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(3, 63, R.string.jeep_parksense);
        carInfo.setCmd(1, 32);
        carInfo.setDiplsys(new String[]{getString(R.string.jeep_parksense_0), getString(R.string.jeep_parksense_1)});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(1, 64, R.string.wc_372_lan);
        carInfo2.setCmd(2, 32);
        carInfo2.setDiplsys(new String[]{getString(R.string.wc_372_low), getString(R.string.wc_372_mid), getString(R.string.wc_372_high)});
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(1, 65, R.string.wc_372_lanewar);
        carInfo3.setCmd(3, 32);
        carInfo3.setDiplsys(new String[]{getString(R.string.jeep_lanesensewarn_0), getString(R.string.jeep_lanesensewarn_1), getString(R.string.jeep_lanesensewarn_2)});
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(3, 66, R.string.jeep_forwardcollisionbrake);
        carInfo4.setCmd(4, 32);
        carInfo4.setDiplsys(new String[]{getString(R.string.cancel), getString(R.string.str_40_od_select)});
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(3, 67, R.string.jeep_forwardcollisionwarn);
        carInfo5.setCmd(5, 32);
        carInfo5.setDiplsys(new String[]{getString(R.string.jeep_forwardcollisionwarn_0), getString(R.string.jeep_forwardcollisionwarn_1)});
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, 68, R.string.jeep_autoparkbrake);
        carInfo6.setCmd(6, 32);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(0, 69, R.string.xp_yl_lane_assist_str);
        carInfo7.setCmd(7, 32);
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(0, 70, R.string.wc_372_rainautostr);
        carInfo8.setCmd(8, 32);
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(0, 71, R.string.str_373_parksense_brakeassist);
        carInfo9.setCmd(9, 32);
        this.mList.add(carInfo9);
        CarInfo carInfo10 = new CarInfo(0, 72, R.string.wc_372_video_movestr);
        carInfo10.setCmd(10, 32);
        this.mList.add(carInfo10);
        CarInfo carInfo11 = new CarInfo(0, 73, R.string.wc_372_video_staticstr);
        carInfo11.setCmd(11, 32);
        this.mList.add(carInfo11);
        CarInfo carInfo12 = new CarInfo(1, 74, R.string.jeep_blindwarn);
        carInfo12.setCmd(12, 32);
        carInfo12.setDiplsys(new String[]{getString(R.string.jeep_blindwarn_0), getString(R.string.jeep_blindwarn_1), getString(R.string.jeep_blindwarn_2)});
        this.mList.add(carInfo12);
        CarInfo carInfo13 = new CarInfo(1, 75, R.string.jeep_comfortsystems);
        carInfo13.setCmd(13, 32);
        carInfo13.setDiplsys(new String[]{getString(R.string.jeep_comfortsystems_0), getString(R.string.jeep_comfortsystems_1), getString(R.string.jeep_comfortsystems_2)});
        this.mList.add(carInfo13);
        CarInfo carInfo14 = new CarInfo(0, 76, R.string.wc_372_parksystemstr);
        carInfo14.setCmd(14, 32);
        this.mList.add(carInfo14);
        CarInfo carInfo15 = new CarInfo(0, 77, R.string.jeep_rear_parksense_auto_brakeassist);
        carInfo15.setCmd(15, 32);
        this.mList.add(carInfo15);
        CarInfo carInfo16 = new CarInfo(1, 78, R.string.jeep_rearparksensevol);
        carInfo16.setCmd(16, 32);
        carInfo16.setDiplsys(new String[]{getString(R.string.wc_372_low), getString(R.string.wc_372_mid), getString(R.string.wc_372_high)});
        this.mList.add(carInfo16);
        CarInfo carInfo17 = new CarInfo(1, 79, R.string.jeep_frontparksensevol);
        carInfo17.setCmd(17, 32);
        carInfo17.setDiplsys(new String[]{getString(R.string.wc_372_low), getString(R.string.wc_372_mid), getString(R.string.wc_372_high)});
        this.mList.add(carInfo17);
        CarInfo carInfo18 = new CarInfo(0, 80, R.string.wc_17zhinanzhe_str3);
        carInfo18.setCmd(18, 32);
        this.mList.add(carInfo18);
        CarInfo carInfo19 = new CarInfo(0, 81, R.string.str_373_electronic_pack_brake);
        carInfo19.setCmd(19, 32);
        this.mList.add(carInfo19);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(57, new int[]{12}, null, null);
        for (int i = 0; i < this.mList.size(); i++) {
            int id = this.mList.get(i).getUpdateCode();
            if (id <= 81 && id >= 63 && this.mList.get(i) != null) {
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
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
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
