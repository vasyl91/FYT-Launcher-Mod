package com.syu.carinfo.qiya.kx7;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityKX7CameraSet extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ActivityKX7CameraSet.this.updateTrackDisplay(value);
                    break;
                case 100:
                    ActivityKX7CameraSet.this.updateRadarDisplay(value);
                    break;
                case 101:
                    ActivityKX7CameraSet.this.updateFrontViewInit(value);
                    break;
                case 102:
                    ActivityKX7CameraSet.this.updateRearViewInit(value);
                    break;
                case 105:
                    if (((CheckedTextView) ActivityKX7CameraSet.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) ActivityKX7CameraSet.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_394_qiya_kx7_camera_set);
        setListener();
    }

    private void setListener() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda /* 3473851 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda_H /* 3867067 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
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

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[101] - 1;
                if (value < 0) {
                    value = 0;
                }
                setCmd(4, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[101] + 1;
                if (value2 > 3) {
                    value2 = 3;
                }
                setCmd(4, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[102] - 1;
                if (value3 < 0) {
                    value3 = 0;
                }
                setCmd(5, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[102] + 1;
                if (value4 > 3) {
                    value4 = 3;
                }
                setCmd(5, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value5 = DataCanbus.DATA[100];
                setCmd(3, value5 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value6 = DataCanbus.DATA[99];
                setCmd(2, value6 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value7 = DataCanbus.DATA[105];
                DataCanbus.PROXY.cmd(2, value7 != 0 ? 0 : 1);
                break;
        }
    }

    private void setCmd(int type, int value) {
        DataCanbus.PROXY.cmd(1, type, value);
    }

    protected void updateTrackDisplay(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }

    protected void updateRadarDisplay(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    protected void updateRearViewInit(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_all_view);
                    break;
            }
        }
    }

    protected void updateFrontViewInit(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_all_view);
                    break;
            }
        }
    }
}
