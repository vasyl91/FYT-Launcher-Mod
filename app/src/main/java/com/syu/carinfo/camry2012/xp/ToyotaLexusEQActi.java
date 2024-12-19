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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ToyotaLexusEQActi extends BaseActivity implements View.OnClickListener {
    private SeekBar.OnSeekBarChangeListener mseekbarClick = new SeekBar.OnSeekBarChangeListener() { // from class: com.syu.carinfo.camry2012.xp.ToyotaLexusEQActi.1
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar v) {
            switch (v.getId()) {
                case R.id.bnr_crow_amp_carvol_seekview /* 2131427552 */:
                    ToyotaLexusEQActi.this.setCarInfo(7, v.getProgress());
                    break;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar arg0) {
        }
    };
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry2012.xp.ToyotaLexusEQActi.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
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
                case 191:
                    if (((TextView) ToyotaLexusEQActi.this.findViewById(R.id.bnr_crow_amp_carvol_text)) != null) {
                        ((TextView) ToyotaLexusEQActi.this.findViewById(R.id.bnr_crow_amp_carvol_text)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    if (((SeekBar) ToyotaLexusEQActi.this.findViewById(R.id.bnr_crow_amp_carvol_seekview)) != null) {
                        ((SeekBar) ToyotaLexusEQActi.this.findViewById(R.id.bnr_crow_amp_carvol_seekview)).setProgress(value);
                        break;
                    }
                case 203:
                    ToyotaLexusEQActi.this.setCheck((CheckedTextView) ToyotaLexusEQActi.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0112_rzc_lexus_eq_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
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
        seekbaronClick((SeekBar) findViewById(R.id.bnr_crow_amp_carvol_seekview));
        if (DataCanbus.DATA[1000] == 8126903 || DataCanbus.DATA[1000] == 8192439 || DataCanbus.DATA[1000] == 7274935 || DataCanbus.DATA[1000] == 7340471 || DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 12714436 || DataCanbus.DATA[1000] == 5177797 || DataCanbus.DATA[1000] == 5243333) {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
        }
    }

    private void seekbaronClick(SeekBar v) {
        if (v != null) {
            v.setOnSeekBarChangeListener(this.mseekbarClick);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[188] == 8) {
                    value = 1;
                } else {
                    value = 8;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[183];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[183];
                if (value3 < 14) {
                    value3++;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[184];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[184];
                if (value5 < 14) {
                    value5++;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[185];
                if (value6 > 2) {
                    value6--;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[185];
                if (value7 < 12) {
                    value7++;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[187];
                if (value8 > 2) {
                    value8--;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[187];
                if (value9 < 12) {
                    value9++;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[186];
                if (value10 > 2) {
                    value10--;
                }
                setCarInfo(5, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[186];
                if (value11 < 12) {
                    value11++;
                }
                setCarInfo(5, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                if (DataCanbus.DATA[1000] == 8126903 || DataCanbus.DATA[1000] == 8192439 || DataCanbus.DATA[1000] == 7274935 || DataCanbus.DATA[1000] == 7340471 || DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 12714436 || DataCanbus.DATA[1000] == 5177797 || DataCanbus.DATA[1000] == 5243333) {
                    setCarInfo(10, 0);
                    break;
                } else {
                    int value12 = DataCanbus.DATA[189];
                    if (value12 > 0) {
                        value12--;
                    }
                    setCarInfo(7, value12);
                    break;
                }
            case R.id.btn_plus6 /* 2131427503 */:
                if (DataCanbus.DATA[1000] == 8126903 || DataCanbus.DATA[1000] == 8192439 || DataCanbus.DATA[1000] == 7274935 || DataCanbus.DATA[1000] == 7340471 || DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 12714436 || DataCanbus.DATA[1000] == 5177797 || DataCanbus.DATA[1000] == 5243333) {
                    setCarInfo(10, 1);
                    break;
                } else {
                    int value13 = DataCanbus.DATA[189];
                    if (value13 < 63) {
                        value13++;
                    }
                    setCarInfo(7, value13);
                    break;
                }
            case R.id.btn_minus7 /* 2131427505 */:
                if (DataCanbus.DATA[1000] == 8126903 || DataCanbus.DATA[1000] == 8192439 || DataCanbus.DATA[1000] == 7274935 || DataCanbus.DATA[1000] == 7340471 || DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 12714436 || DataCanbus.DATA[1000] == 5177797 || DataCanbus.DATA[1000] == 5243333) {
                    int value14 = DataCanbus.DATA[191];
                    if (value14 > 0) {
                        value14--;
                    }
                    setCarInfo(7, value14);
                    break;
                }
            case R.id.btn_plus7 /* 2131427507 */:
                if (DataCanbus.DATA[1000] == 8126903 || DataCanbus.DATA[1000] == 8192439 || DataCanbus.DATA[1000] == 7274935 || DataCanbus.DATA[1000] == 7340471 || DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 12714436 || DataCanbus.DATA[1000] == 5177797 || DataCanbus.DATA[1000] == 5243333) {
                    int value15 = DataCanbus.DATA[191];
                    if (value15 < 127) {
                        value15++;
                    }
                    setCarInfo(7, value15);
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value16 = DataCanbus.DATA[190];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(9, value16);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                setCarInfo(96, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value17 = DataCanbus.DATA[203];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(97, value17);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(44, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(43, new int[]{49}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.DATA[1000] == 8126903 || DataCanbus.DATA[1000] == 8192439 || DataCanbus.DATA[1000] == 7274935 || DataCanbus.DATA[1000] == 7340471 || DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 12714436 || DataCanbus.DATA[1000] == 5177797 || DataCanbus.DATA[1000] == 5243333) {
            DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.DATA[1000] == 8126903 || DataCanbus.DATA[1000] == 8192439 || DataCanbus.DATA[1000] == 7274935 || DataCanbus.DATA[1000] == 7340471 || DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 12714436 || DataCanbus.DATA[1000] == 5177797 || DataCanbus.DATA[1000] == 5243333) {
            DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        }
    }
}
