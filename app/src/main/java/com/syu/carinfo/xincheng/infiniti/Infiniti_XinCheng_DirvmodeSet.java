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
public class Infiniti_XinCheng_DirvmodeSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_DirvmodeSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 103:
                    if (val == 0) {
                        Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.layout_view2).setVisibility(0);
                        Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.layout_view3).setVisibility(0);
                        Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.layout_view4).setVisibility(0);
                        Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.layout_view5).setVisibility(0);
                        Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.layout_view6).setVisibility(0);
                        Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.layout_view7).setVisibility(0);
                    } else {
                        Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.layout_view2).setVisibility(8);
                        Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.layout_view3).setVisibility(8);
                        Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.layout_view4).setVisibility(8);
                        Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.layout_view5).setVisibility(8);
                        Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.layout_view6).setVisibility(8);
                        Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.layout_view7).setVisibility(8);
                    }
                    if (((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_252_sound_selection5);
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text1)).setText(R.string.driver_system_sports);
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text1)).setText(R.string.carema_type_1);
                                break;
                            case 3:
                                ((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_17_snow);
                                break;
                        }
                    }
                    break;
                case 104:
                    Infiniti_XinCheng_DirvmodeSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 105:
                    if (((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text2)).setText(R.string.driver_system_sports);
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text2)).setText(R.string.carema_type_1);
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_17_snow);
                                break;
                        }
                    }
                    break;
                case 106:
                    if (((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text3)).setText(R.string.driver_system_sports);
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text3)).setText(R.string.carema_type_1);
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_light_state);
                                break;
                        }
                    }
                    break;
                case 107:
                    if (((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text4)).setText(R.string.driver_system_sports);
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text4)).setText(R.string.carema_type_1);
                                break;
                            case 2:
                                ((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_comfort);
                                break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 109:
                    Infiniti_XinCheng_DirvmodeSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_xincheng_infiniti_drivingmode_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[104];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value2 = DataCanbus.DATA[105] - 1;
                if (value2 < 0) {
                    value2 = 2;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value3 = DataCanbus.DATA[105] + 1;
                if (value3 > 2) {
                    value3 = 0;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value4 = DataCanbus.DATA[106] - 1;
                if (value4 < 0) {
                    value4 = 2;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value5 = DataCanbus.DATA[106] + 1;
                if (value5 > 2) {
                    value5 = 0;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value6 = DataCanbus.DATA[107] - 1;
                if (value6 < 0) {
                    value6 = 2;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value7 = DataCanbus.DATA[107] + 1;
                if (value7 > 2) {
                    value7 = 0;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value8 = DataCanbus.DATA[108] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value9 = DataCanbus.DATA[108] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(5, value9);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value10 = DataCanbus.DATA[109];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(6, value10);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(5, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{122}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }
}
