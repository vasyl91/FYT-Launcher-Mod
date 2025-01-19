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

public class Infiniti_XinCheng_DirvmodeSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 166:
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
                case 167:
                    Infiniti_XinCheng_DirvmodeSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 168:
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
                case 169:
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
                case 170:
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
                case 171:
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
                case 172:
                    Infiniti_XinCheng_DirvmodeSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_DirvmodeSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xincheng_infiniti_drivingmode_settings);
        init();
    }

    @Override
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus2 /* 2131427458 */:
                int value = DataCanbus.DATA[168] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value2 = DataCanbus.DATA[168] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value3 = DataCanbus.DATA[169] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value4 = DataCanbus.DATA[169] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value5 = DataCanbus.DATA[170] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value6 = DataCanbus.DATA[170] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value7 = DataCanbus.DATA[171] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value8 = DataCanbus.DATA[171] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(5, value8);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value9 = DataCanbus.DATA[167];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(1, value9);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value10 = DataCanbus.DATA[172];
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

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{122}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
    }
}
