package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCCommpassActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 119:
                    switch (value) {
                        case 1:
                            ((TextView) WCCommpassActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_244_als2);
                            break;
                        default:
                            ((TextView) WCCommpassActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_244_als1);
                            break;
                    }
                case 154:
                    WCCommpassActi.this.mUpdaterValue2();
                    break;
                case 155:
                    WCCommpassActi.this.updateRightTurnLightTime();
                    break;
                case 156:
                    if (((CheckedTextView) WCCommpassActi.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) WCCommpassActi.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                        break;
                    }
                case 166:
                    WCCommpassActi.this.mUpdaterBackCarWidth();
                    break;
                case 167:
                    WCCommpassActi.this.mUpdaterBackCarView();
                    break;
                case 168:
                    WCCommpassActi.this.mUpdaterAutoGuid();
                    break;
                case 169:
                    WCCommpassActi.this.mUpdaterStaticGuid();
                    break;
                case 173:
                    switch (value) {
                        case 1:
                            ((TextView) WCCommpassActi.this.findViewById(R.id.tv_text6)).setText(R.string.str_parallel_parking);
                            break;
                        default:
                            ((TextView) WCCommpassActi.this.findViewById(R.id.tv_text6)).setText(R.string.str_return_parking);
                            break;
                    }
                case 174:
                    if (((CheckedTextView) WCCommpassActi.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) WCCommpassActi.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                        break;
                    }
                case 209:
                    if (((CheckedTextView) WCCommpassActi.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) WCCommpassActi.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                        break;
                    }
                case 210:
                    switch (value) {
                        case 1:
                            ((TextView) WCCommpassActi.this.findViewById(R.id.tv_text3)).setText(R.string.str_previous_screen);
                            break;
                        case 2:
                            ((TextView) WCCommpassActi.this.findViewById(R.id.tv_text3)).setText(R.string.str_back_camera_wide_angle);
                            break;
                        case 3:
                            ((TextView) WCCommpassActi.this.findViewById(R.id.tv_text3)).setText(R.string.str_back_camera_standard);
                            break;
                        default:
                            ((TextView) WCCommpassActi.this.findViewById(R.id.tv_text3)).setText(R.string.str_back_screen_and_panorama);
                            break;
                    }
                case 211:
                    switch (value) {
                        case 1:
                            ((TextView) WCCommpassActi.this.findViewById(R.id.tv_text4)).setText(R.string.str_previous_screen);
                            break;
                        case 2:
                            ((TextView) WCCommpassActi.this.findViewById(R.id.tv_text4)).setText(R.string.str_forward_screen_only);
                            break;
                        case 3:
                            ((TextView) WCCommpassActi.this.findViewById(R.id.tv_text4)).setText(R.string.str_left_and_right_screen);
                            break;
                        default:
                            ((TextView) WCCommpassActi.this.findViewById(R.id.tv_text4)).setText(R.string.str_forward_screen_and_panorama);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_15crv_compass);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[119];
                int value2 = value - 1;
                if (value2 < 0) {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(110, new int[]{21, value2}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value3 = DataCanbus.DATA[119];
                int value4 = value3 + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(110, new int[]{21, value4}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value5 = DataCanbus.DATA[155];
                int value6 = value5 - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                DataCanbus.PROXY.cmd(110, 8, value6);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value7 = DataCanbus.DATA[155];
                int value8 = value7 + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(110, 8, value8);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value9 = DataCanbus.DATA[210];
                int value10 = value9 - 1;
                if (value10 < 0) {
                    value10 = 3;
                }
                DataCanbus.PROXY.cmd(110, 19, value10);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value11 = DataCanbus.DATA[210];
                int value12 = value11 + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                DataCanbus.PROXY.cmd(110, 19, value12);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value13 = DataCanbus.DATA[211];
                int value14 = value13 - 1;
                if (value14 < 0) {
                    value14 = 3;
                }
                DataCanbus.PROXY.cmd(110, 18, value14);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value15 = DataCanbus.DATA[211];
                int value16 = value15 + 1;
                if (value16 > 3) {
                    value16 = 0;
                }
                DataCanbus.PROXY.cmd(110, 18, value16);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value17 = DataCanbus.DATA[166] & 255;
                DataCanbus.PROXY.cmd(110, 13, value17 == 0 ? 7 : 6);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value18 = DataCanbus.DATA[166] & 255;
                DataCanbus.PROXY.cmd(110, 13, value18 == 0 ? 7 : 6);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value19 = DataCanbus.DATA[173] & 255;
                DataCanbus.PROXY.cmd(110, 17, value19 != 0 ? 0 : 1);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value20 = DataCanbus.DATA[173] & 255;
                DataCanbus.PROXY.cmd(110, 17, value20 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value21 = DataCanbus.DATA[154] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 12;
                iArr[1] = value21 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(110, iArr, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value22 = DataCanbus.DATA[174] & 255;
                DataCanbus.PROXY.cmd(110, 16, value22 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value23 = DataCanbus.DATA[156] & 255;
                DataCanbus.PROXY.cmd(110, 14, value23 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value24 = DataCanbus.DATA[209] & 255;
                DataCanbus.PROXY.cmd(110, 20, value24 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value25 = DataCanbus.DATA[167] & 255;
                DataCanbus.PROXY.cmd(110, 13, value25 == 0 ? 5 : 4);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value26 = DataCanbus.DATA[168] & 255;
                DataCanbus.PROXY.cmd(110, 13, value26 == 0 ? 3 : 2);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value27 = DataCanbus.DATA[169] & 255;
                DataCanbus.PROXY.cmd(110, 13, value27 != 0 ? 0 : 1);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterStaticGuid() {
        int value = DataCanbus.DATA[169] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterAutoGuid() {
        int value = DataCanbus.DATA[168] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterBackCarView() {
        int value = DataCanbus.DATA[167] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterBackCarWidth() {
        int value = DataCanbus.DATA[166] & 255;
        ((TextView) findViewById(R.id.tv_text5)).setText(value == 0 ? R.string.str_17crv_parking_spaces0 : R.string.str_17crv_parking_spaces1);
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[154] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
        }
    }

    
    public void updateRightTurnLightTime() {
        int value = DataCanbus.DATA[155] & 255;
        ((TextView) findViewById(R.id.tv_text2)).setText(value == 0 ? "0S" : "2S");
    }
}
