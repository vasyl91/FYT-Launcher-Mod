package com.syu.carinfo.byd.hcy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class BYDAiyingOtherSetAct extends BaseActivity implements View.OnClickListener {
    int[] ids = {124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 169, 170, 171, 172, 173, 174};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 124:
                    BYDAiyingOtherSetAct.this.uBhomeLightDelay(value);
                    break;
                case 125:
                    BYDAiyingOtherSetAct.this.uAhomeLightDelay(value);
                    break;
                case 126:
                    BYDAiyingOtherSetAct.this.setCheck((CheckedTextView) BYDAiyingOtherSetAct.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 127:
                    BYDAiyingOtherSetAct.this.uUnlockSys(value);
                    break;
                case 128:
                    BYDAiyingOtherSetAct.this.uAirMode(value);
                    break;
                case 129:
                    BYDAiyingOtherSetAct.this.setCheck((CheckedTextView) BYDAiyingOtherSetAct.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 130:
                    BYDAiyingOtherSetAct.this.setCheck((CheckedTextView) BYDAiyingOtherSetAct.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 131:
                    BYDAiyingOtherSetAct.this.uAirWinlev(value);
                    break;
                case 132:
                    BYDAiyingOtherSetAct.this.setCheck((CheckedTextView) BYDAiyingOtherSetAct.this.findViewById(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 133:
                    BYDAiyingOtherSetAct.this.uAudiomode(value);
                    break;
                case 169:
                    switch (value) {
                        case 0:
                            ((TextView) BYDAiyingOtherSetAct.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                            break;
                        default:
                            ((TextView) BYDAiyingOtherSetAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                            break;
                    }
                case 170:
                    BYDAiyingOtherSetAct.this.setCheck((CheckedTextView) BYDAiyingOtherSetAct.this.findViewById(R.id.ctv_checkedtext5), value != 0);
                    break;
                case 171:
                    BYDAiyingOtherSetAct.this.setCheck((CheckedTextView) BYDAiyingOtherSetAct.this.findViewById(R.id.ctv_checkedtext6), value != 0);
                    break;
                case 172:
                    switch (value) {
                        case 0:
                            ((TextView) BYDAiyingOtherSetAct.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                            break;
                        default:
                            ((TextView) BYDAiyingOtherSetAct.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                            break;
                    }
                case 173:
                    switch (value) {
                        case 0:
                            ((TextView) BYDAiyingOtherSetAct.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                            break;
                        default:
                            ((TextView) BYDAiyingOtherSetAct.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                            break;
                    }
                case 174:
                    switch (value) {
                        case 0:
                            ((TextView) BYDAiyingOtherSetAct.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) BYDAiyingOtherSetAct.this.findViewById(R.id.tv_text10)).setText("10min");
                            break;
                        case 2:
                            ((TextView) BYDAiyingOtherSetAct.this.findViewById(R.id.tv_text10)).setText("15min");
                            break;
                        case 3:
                            ((TextView) BYDAiyingOtherSetAct.this.findViewById(R.id.tv_text10)).setText("20min");
                            break;
                        case 4:
                            ((TextView) BYDAiyingOtherSetAct.this.findViewById(R.id.tv_text10)).setText("25min");
                            break;
                        case 5:
                            ((TextView) BYDAiyingOtherSetAct.this.findViewById(R.id.tv_text10)).setText("30min");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0455_aiying_byd_other_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value7 = DataCanbus.DATA[124] - 1;
                if (value7 < 0) {
                    value7 = 6;
                }
                DataCanbus.PROXY.cmd(5, new int[]{12, value7}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value8 = DataCanbus.DATA[124] + 1;
                if (value8 > 6) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{1, value8}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value9 = DataCanbus.DATA[125] - 1;
                if (value9 < 0) {
                    value9 = 6;
                }
                DataCanbus.PROXY.cmd(5, new int[]{2, value9}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value10 = DataCanbus.DATA[125] + 1;
                if (value10 > 6) {
                    value10 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{2, value10}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value11 = DataCanbus.DATA[127] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{4, value11}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value12 = DataCanbus.DATA[127] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{4, value12}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value13 = DataCanbus.DATA[128] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{5, value13}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value14 = DataCanbus.DATA[128] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{5, value14}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value15 = DataCanbus.DATA[131] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{8, value15}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value16 = DataCanbus.DATA[131] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{8, value16}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value17 = DataCanbus.DATA[133] - 1;
                if (value17 < 0) {
                    value17 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{10, value17}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value18 = DataCanbus.DATA[133] + 1;
                if (value18 > 1) {
                    value18 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{10, value18}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value19 = DataCanbus.DATA[169];
                if (value19 > 0) {
                    value19--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{11, value19}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value20 = DataCanbus.DATA[169];
                if (value20 < 32) {
                    value20++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{11, value20}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value21 = DataCanbus.DATA[172];
                if (value21 > 0) {
                    value21--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{14, value21}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value22 = DataCanbus.DATA[172];
                if (value22 < 8) {
                    value22++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{14, value22}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value23 = DataCanbus.DATA[173];
                if (value23 > 0) {
                    value23--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{15, value23}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value24 = DataCanbus.DATA[173];
                if (value24 < 8) {
                    value24++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{15, value24}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value25 = DataCanbus.DATA[174];
                if (value25 > 0) {
                    value25--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{17, value25}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value26 = DataCanbus.DATA[174];
                if (value26 < 5) {
                    value26++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{17, value26}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[126] == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{3, value6}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[129] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{6, value5}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[130] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{7, value4}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                if (DataCanbus.DATA[132] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{9, value3}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                if (DataCanbus.DATA[170] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{12, value2}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                if (DataCanbus.DATA[171] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{13, value}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                DataCanbus.PROXY.cmd(5, new int[]{16, 1}, null, null);
                break;
        }
    }

    @Override
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    protected void uAudiomode(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.haval_volspeed1);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text6)).setText("DTS");
                break;
        }
    }

    protected void uAirWinlev(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.distance_close);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_middle);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.distance_far);
                break;
        }
    }

    protected void uAirMode(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_driving_eco);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.wc_golf_comfort);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_intelligent);
                break;
        }
    }

    protected void uUnlockSys(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                break;
        }
    }

    protected void uAhomeLightDelay(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText("10s");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText("20s");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text2)).setText("30s");
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text2)).setText("40s");
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_text2)).setText("50s");
                break;
            case 6:
                ((TextView) findViewById(R.id.tv_text2)).setText("60s");
                break;
        }
    }

    protected void uBhomeLightDelay(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.off);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText("10s");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText("20s");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText("30s");
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text1)).setText("40s");
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_text1)).setText("50s");
                break;
            case 6:
                ((TextView) findViewById(R.id.tv_text1)).setText("60s");
                break;
        }
    }
}
