package com.syu.carinfo.wc.sgmws;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class SgmwsAlarmInfoAct extends BaseActivity {
    public static int[] mStrAlarmWarningInfo = {R.string.str_sgmws_str0, R.string.str_sgmws_str1, R.string.str_sgmws_str2, R.string.str_sgmws_str3, R.string.str_sgmws_str4, R.string.str_sgmws_str5, R.string.str_sgmws_str6};
    private TextView titleview;
    private TextView[] mTvWarning = new TextView[7];
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        int value;

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 42:
                    this.value = DataCanbus.DATA[42] & 255;
                    if (this.value != 0) {
                        SgmwsAlarmInfoAct.this.setvlauedisplay(0, this.value, true);
                        break;
                    } else {
                        SgmwsAlarmInfoAct.this.setvlauedisplay(0, this.value, false);
                        break;
                    }
                case 43:
                    this.value = DataCanbus.DATA[43] & 255;
                    if (this.value != 0) {
                        SgmwsAlarmInfoAct.this.setvlauedisplay(1, this.value, true);
                        break;
                    } else {
                        SgmwsAlarmInfoAct.this.setvlauedisplay(1, this.value, false);
                        break;
                    }
                case 44:
                    this.value = DataCanbus.DATA[44] & 255;
                    if (this.value != 0) {
                        SgmwsAlarmInfoAct.this.setvlauedisplay(2, this.value, true);
                        break;
                    } else {
                        SgmwsAlarmInfoAct.this.setvlauedisplay(2, this.value, false);
                        break;
                    }
                case 45:
                    this.value = DataCanbus.DATA[45] & 255;
                    if (this.value != 0) {
                        SgmwsAlarmInfoAct.this.setvlauedisplay(3, this.value, true);
                        break;
                    } else {
                        SgmwsAlarmInfoAct.this.setvlauedisplay(3, this.value, false);
                        break;
                    }
                case 46:
                    this.value = DataCanbus.DATA[46] & 255;
                    if (this.value != 0) {
                        SgmwsAlarmInfoAct.this.setvlauedisplay(4, this.value, true);
                        break;
                    } else {
                        SgmwsAlarmInfoAct.this.setvlauedisplay(4, this.value, false);
                        break;
                    }
                case 47:
                    this.value = DataCanbus.DATA[47] & 255;
                    if (this.value != 0) {
                        SgmwsAlarmInfoAct.this.setvlauedisplay(5, this.value, true);
                        break;
                    } else {
                        SgmwsAlarmInfoAct.this.setvlauedisplay(5, this.value, false);
                        break;
                    }
                case 48:
                    this.value = DataCanbus.DATA[48] & 255;
                    if (this.value != 0) {
                        SgmwsAlarmInfoAct.this.setvlauedisplay(6, this.value, true);
                        break;
                    } else {
                        SgmwsAlarmInfoAct.this.setvlauedisplay(6, this.value, false);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_start_stop);
        init();
    }

    @Override
    public void init() {
        this.mTvWarning[0] = (TextView) findViewById(R.id.golf7_tv_start_stop_0);
        this.mTvWarning[1] = (TextView) findViewById(R.id.golf7_tv_start_stop_1);
        this.mTvWarning[2] = (TextView) findViewById(R.id.golf7_tv_start_stop_2);
        this.mTvWarning[3] = (TextView) findViewById(R.id.golf7_tv_start_stop_3);
        this.mTvWarning[4] = (TextView) findViewById(R.id.golf7_tv_start_stop_4);
        this.mTvWarning[5] = (TextView) findViewById(R.id.golf7_tv_start_stop_5);
        this.mTvWarning[6] = (TextView) findViewById(R.id.golf7_tv_start_stop_6);
        this.titleview = (TextView) findViewById(R.id.sgmws_title_dispaly);
        this.titleview.setText(R.string.alarm_record);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
    }

    
    public void setvlauedisplay(int index, int value, boolean flag) {
        if (index <= 6 && index >= 0 && value <= 7 && value >= 0) {
            if (flag) {
                this.mTvWarning[index].setText(mStrAlarmWarningInfo[value - 1]);
            } else {
                this.mTvWarning[index].setText("");
            }
        }
    }
}
