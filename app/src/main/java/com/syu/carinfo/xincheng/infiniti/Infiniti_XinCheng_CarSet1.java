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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Infiniti_XinCheng_CarSet1 extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_CarSet1.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 57:
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
                case 58:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 59:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 60:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 61:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 62:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 63:
                    if (((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 64:
                    if (((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 65:
                    if (((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 66:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 67:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 68:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 69:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 70:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 71:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 72:
                    Infiniti_XinCheng_CarSet1.this.setCheck((CheckedTextView) Infiniti_XinCheng_CarSet1.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 73:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_xincheng_infiniti_settings2);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                setCarInfo(9);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                setCarInfo(5);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                setCarInfo(6);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                setCarInfo(7);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                setCarInfo(8);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                setCarInfo(12);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                setCarInfo(13);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value = DataCanbus.DATA[73];
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
            case R.id.btn_plus5 /* 2131427498 */:
                int value2 = DataCanbus.DATA[73];
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
            case R.id.btn_minus6 /* 2131427501 */:
                int value3 = DataCanbus.DATA[73];
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
            case R.id.btn_plus6 /* 2131427503 */:
                int value4 = DataCanbus.DATA[73];
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
            case R.id.btn_minus7 /* 2131427505 */:
                int value5 = DataCanbus.DATA[73];
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
            case R.id.btn_plus7 /* 2131427507 */:
                int value6 = DataCanbus.DATA[73];
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
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                setCarInfo(4);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                setCarInfo(3);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                setCarInfo(2);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                setCarInfo(1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                setCarInfo(20);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                setCarInfo(19);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                setCarInfo(18);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                setCarInfo(17);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                setCarInfo(14);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                setCarInfo(15);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                setCarInfo(16);
                break;
        }
    }

    public void setCarInfo(int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{117}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
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
    }
}
