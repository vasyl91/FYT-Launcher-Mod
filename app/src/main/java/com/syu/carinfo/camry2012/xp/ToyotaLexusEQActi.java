package com.syu.carinfo.camry2012.xp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ToyotaLexusEQActi extends BaseActivity implements View.OnClickListener {
    private SeekBar.OnSeekBarChangeListener mseekbarClick = new SeekBar.OnSeekBarChangeListener() { 
        @Override
        public void onStopTrackingTouch(SeekBar v) {
            switch (v.getId()) {
                case R.id.bnr_crow_amp_carvol_seekview /* 2131428113 */:
                    ToyotaLexusEQActi.this.setCarInfo(7, v.getProgress());
                    break;
            }
        }

        @Override
        public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        }

        @Override
        public void onStartTrackingTouch(SeekBar arg0) {
        }
    };
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 136:
                    if (((TextView) ToyotaLexusEQActi.this.findViewById(R.id.bnr_crow_amp_carvol_text)) != null) {
                        ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.bnr_crow_amp_carvol_text)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    if (((SeekBar) ToyotaLexusEQActi.this.findViewById(R.id.bnr_crow_amp_carvol_seekview)) != null) {
                        ((SeekBar) ToyotaLexusEQActi.this.findViewById(R.id.bnr_crow_amp_carvol_seekview)).setProgress(value);
                        break;
                    }
                case 183:
                    if (((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 7) {
                            ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text1)).setText("R" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text1)).setText("F" + (7 - value));
                            break;
                        } else {
                            ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        }
                    }
                    break;
                case 184:
                    if (((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 7) {
                            ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text2)).setText("R" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text2)).setText("L" + (7 - value));
                            break;
                        } else {
                            ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 185:
                    if (((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 7) {
                            ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text3)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text3)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 186:
                    if (((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 7) {
                            ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text5)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text5)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 187:
                    if (((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 7) {
                            ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text4)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text4)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 188:
                    ToyotaLexusEQActi.this.setCheck((CheckedTextView) ToyotaLexusEQActi.this.findViewById(R.id.ctv_checkedtext1), value == 8);
                    break;
                case 189:
                    if (((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 190:
                    ToyotaLexusEQActi.this.setCheck((CheckedTextView) ToyotaLexusEQActi.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0112_rzc_lexus_eq_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        seekbaronClick((SeekBar) findViewById(R.id.bnr_crow_amp_carvol_seekview));
    }

    private void seekbaronClick(SeekBar v) {
        if (v != null) {
            v.setOnSeekBarChangeListener(this.mseekbarClick);
        }
    }

    @Override
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value2 = DataCanbus.DATA[183];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value3 = DataCanbus.DATA[183];
                if (value3 < 14) {
                    value3++;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value4 = DataCanbus.DATA[184];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value5 = DataCanbus.DATA[184];
                if (value5 < 14) {
                    value5++;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value6 = DataCanbus.DATA[185];
                if (value6 > 2) {
                    value6--;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value7 = DataCanbus.DATA[185];
                if (value7 < 12) {
                    value7++;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value8 = DataCanbus.DATA[187];
                if (value8 > 2) {
                    value8--;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value9 = DataCanbus.DATA[187];
                if (value9 < 12) {
                    value9++;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value10 = DataCanbus.DATA[186];
                if (value10 > 2) {
                    value10--;
                }
                setCarInfo(5, value10);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value11 = DataCanbus.DATA[186];
                if (value11 < 12) {
                    value11++;
                }
                setCarInfo(5, value11);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value12 = DataCanbus.DATA[189];
                if (value12 > 0) {
                    value12--;
                }
                setCarInfo(7, value12);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value13 = DataCanbus.DATA[189];
                if (value13 < 63) {
                    value13++;
                }
                setCarInfo(7, value13);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[188] == 8) {
                    value = 1;
                } else {
                    value = 8;
                }
                setCarInfo(3, value);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value14 = DataCanbus.DATA[190];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(9, value14);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(44, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(43, new int[]{49}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
    }
}
