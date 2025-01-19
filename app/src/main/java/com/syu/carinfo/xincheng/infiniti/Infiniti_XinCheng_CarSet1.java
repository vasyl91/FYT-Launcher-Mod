package com.syu.carinfo.xincheng.infiniti;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Infiniti_XinCheng_CarSet1 extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 124:
                    if (((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text1)).setText(R.string.str_rear_lens);
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text1)).setText(R.string.str_front_lens);
                                break;
                        }
                    }
                    break;
                case 125:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 126:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 127:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 128:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 129:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 130:
                    if (((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 131:
                    if (((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 132:
                    if (((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 133:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 134:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 135:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 136:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 137:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 138:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 139:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 140:
                    switch (val) {
                        case 0:
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text5)).setText(R.string.str_back_camera_depression);
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text6)).setText(R.string.str_side_camera);
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text7)).setText(R.string.str_back_camera_wide_angle);
                            break;
                        case 1:
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text5)).setText(R.string.str_back_camera_depression);
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text6)).setText(R.string.str_back_camera_wide_angle);
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text7)).setText(R.string.str_side_camera);
                            break;
                        case 2:
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text5)).setText(R.string.str_side_camera);
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text6)).setText(R.string.str_back_camera_depression);
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text7)).setText(R.string.str_back_camera_wide_angle);
                            break;
                        case 3:
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text5)).setText(R.string.str_side_camera);
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text6)).setText(R.string.str_back_camera_wide_angle);
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text7)).setText(R.string.str_back_camera_depression);
                            break;
                        case 4:
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text5)).setText(R.string.str_back_camera_wide_angle);
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text6)).setText(R.string.str_back_camera_depression);
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text7)).setText(R.string.str_side_camera);
                            break;
                        case 5:
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text5)).setText(R.string.str_back_camera_wide_angle);
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text6)).setText(R.string.str_side_camera);
                            ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text7)).setText(R.string.str_back_camera_depression);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xincheng_infiniti_settings2);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus2 /* 2131427458 */:
                setCarInfo(5);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                setCarInfo(6);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                setCarInfo(7);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setCarInfo(8);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                setCarInfo(12);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                setCarInfo(13);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value = DataCanbus.DATA[140];
                if (value == 0 || value == 1) {
                    setCarInfo(23);
                    break;
                } else if (value == 2 || value == 3) {
                    setCarInfo(21);
                    break;
                } else if (value == 4 || value == 5) {
                    setCarInfo(22);
                    break;
                }
            case R.id.btn_plus5 /* 2131427469 */:
                int value2 = DataCanbus.DATA[140];
                if (value2 == 0 || value2 == 1) {
                    setCarInfo(22);
                    break;
                } else if (value2 == 2 || value2 == 3) {
                    setCarInfo(23);
                    break;
                } else if (value2 == 4 || value2 == 5) {
                    setCarInfo(21);
                    break;
                }
            case R.id.btn_minus6 /* 2131427470 */:
                int value3 = DataCanbus.DATA[140];
                if (value3 == 0 || value3 == 5) {
                    setCarInfo(24);
                    break;
                } else if (value3 == 1 || value3 == 3) {
                    setCarInfo(25);
                    break;
                } else if (value3 == 2 || value3 == 4) {
                    setCarInfo(23);
                    break;
                }
            case R.id.btn_plus6 /* 2131427472 */:
                int value4 = DataCanbus.DATA[140];
                if (value4 == 0 || value4 == 5) {
                    setCarInfo(23);
                    break;
                } else if (value4 == 1 || value4 == 3) {
                    setCarInfo(24);
                    break;
                } else if (value4 == 2 || value4 == 4) {
                    setCarInfo(25);
                    break;
                }
            case R.id.btn_minus7 /* 2131427473 */:
                int value5 = DataCanbus.DATA[140];
                if (value5 == 0 || value5 == 2) {
                    setCarInfo(28);
                    break;
                } else if (value5 == 1 || value5 == 4) {
                    setCarInfo(27);
                    break;
                } else if (value5 == 3 || value5 == 5) {
                    setCarInfo(29);
                    break;
                }
            case R.id.btn_plus7 /* 2131427475 */:
                int value6 = DataCanbus.DATA[140];
                if (value6 == 0 || value6 == 2) {
                    setCarInfo(27);
                    break;
                } else if (value6 == 1 || value6 == 4) {
                    setCarInfo(29);
                    break;
                } else if (value6 == 3 || value6 == 5) {
                    setCarInfo(28);
                    break;
                }
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(9);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(4);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(3);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(2);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfo(1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfo(20);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfo(19);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                setCarInfo(18);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                setCarInfo(17);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                setCarInfo(14);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                setCarInfo(15);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                setCarInfo(16);
                break;
        }
    }

    public void setCarInfo(int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{117}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
    }
}
