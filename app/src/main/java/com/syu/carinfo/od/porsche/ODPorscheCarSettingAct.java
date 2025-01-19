package com.syu.carinfo.od.porsche;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODPorscheCarSettingAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 106:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(val) + " Hour");
                        break;
                    }
                case 107:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(val) + " Km");
                        break;
                    }
                case 108:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(val / 10) + "." + (val % 10) + " L/100km");
                        break;
                    }
                case 109:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(val) + " Km/H");
                        break;
                    }
                case 110:
                    ODPorscheCarSettingAct.this.setCheck((CheckedTextView) ODPorscheCarSettingAct.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 111:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(val * 10) + "S");
                        break;
                    }
                case 112:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(val * 10) + "S");
                        break;
                    }
                case 113:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(val * 10)).toString());
                        break;
                    }
                case 114:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text8)) != null) {
                        if (val == 1) {
                            ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_auto);
                            break;
                        } else {
                            ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_Manual);
                            break;
                        }
                    }
                    break;
                case 115:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text9)) != null) {
                        if (val == 1) {
                            ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text9)).setText(R.string.mateng_air_con_profile_0);
                            break;
                        } else if (val == 2) {
                            ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text9)).setText(R.string.mateng_air_con_profile_2);
                            break;
                        } else {
                            ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text9)).setText(R.string.klc_onstar_nomal_status);
                            break;
                        }
                    }
                    break;
                case 116:
                    ODPorscheCarSettingAct.this.setCheck((CheckedTextView) ODPorscheCarSettingAct.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 117:
                    ODPorscheCarSettingAct.this.setCheck((CheckedTextView) ODPorscheCarSettingAct.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 118:
                    if (((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text10)) != null) {
                        if (val == 1) {
                            ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text10)).setText(R.string.jeep_presskeyunlock_0);
                            break;
                        } else {
                            ((TextView) ODPorscheCarSettingAct.this.findViewById(R.id.tv_text10)).setText(R.string.jeep_presskeyunlock_1);
                            break;
                        }
                    }
                    break;
                case 119:
                    ODPorscheCarSettingAct.this.setCheck((CheckedTextView) ODPorscheCarSettingAct.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_od_porsche_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick(findViewById(R.id.btn_minus1), this);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_minus2), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.btn_minus3), this);
        setSelfClick(findViewById(R.id.btn_plus3), this);
        setSelfClick(findViewById(R.id.btn_minus4), this);
        setSelfClick(findViewById(R.id.btn_plus4), this);
        setSelfClick(findViewById(R.id.btn_minus5), this);
        setSelfClick(findViewById(R.id.btn_plus5), this);
        setSelfClick(findViewById(R.id.btn_minus6), this);
        setSelfClick(findViewById(R.id.btn_plus6), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[111];
                if (value > 0) {
                    value--;
                }
                setCarInfo(6, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[111];
                if (value2 < 12) {
                    value2++;
                }
                setCarInfo(6, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[112];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(7, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[112];
                if (value4 < 12) {
                    value4++;
                }
                setCarInfo(7, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[113];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(8, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[113];
                if (value6 < 12) {
                    value6++;
                }
                setCarInfo(8, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[114] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(9, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[114] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(9, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[115] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(10, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[115] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(10, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[118] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(13, (value11 << 4) & 240);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[118] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(13, (value12 << 4) & 240);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value13 = DataCanbus.DATA[110];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(5, value13);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value14 = DataCanbus.DATA[116];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(11, value14);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value15 = DataCanbus.DATA[117];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(12, value15);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value16 = DataCanbus.DATA[119];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(14, value16);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{64, 255}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
    }
}
