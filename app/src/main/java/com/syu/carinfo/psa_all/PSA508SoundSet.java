package com.syu.carinfo.psa_all;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PSA508SoundSet extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.psa_all.PSA508SoundSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 188:
                    PSA508SoundSet.this.updateBalance(value);
                    break;
                case 189:
                    PSA508SoundSet.this.updateFade(value);
                    break;
                case 190:
                    PSA508SoundSet.this.updateDistribution(value);
                    break;
                case 191:
                    PSA508SoundSet.this.updateLoudness(value);
                    break;
                case 192:
                    PSA508SoundSet.this.updateVolumeSpeed(value);
                    break;
                case 193:
                    PSA508SoundSet.this.updateSelection(value);
                    break;
                case 194:
                    PSA508SoundSet.this.updateTweeter(value);
                    break;
                case 195:
                    PSA508SoundSet.this.updateBass(value);
                    break;
                case 231:
                    if (((CheckedTextView) PSA508SoundSet.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) PSA508SoundSet.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
                        break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_252_psa508_sound_set);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        int value8;
        int value9;
        int value10;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                setCmd(12, DataCanbus.DATA[191] != 0 ? 0 : 1);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value11 = DataCanbus.DATA[188];
                if (value11 > 0) {
                    value10 = value11 - 1;
                } else {
                    value10 = 14;
                }
                setCmd(2, value10);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value12 = DataCanbus.DATA[188];
                if (value12 < 14) {
                    value9 = value12 + 1;
                } else {
                    value9 = 0;
                }
                setCmd(2, value9);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value13 = DataCanbus.DATA[189];
                if (value13 > 0) {
                    value8 = value13 - 1;
                } else {
                    value8 = 14;
                }
                setCmd(3, value8);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value14 = DataCanbus.DATA[189];
                if (value14 < 14) {
                    value7 = value14 + 1;
                } else {
                    value7 = 0;
                }
                setCmd(3, value7);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
            case R.id.btn_plus3 /* 2131427490 */:
                setCmd(11, DataCanbus.DATA[190] != 0 ? 0 : 1);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value15 = DataCanbus.DATA[193];
                if (value15 > 0) {
                    value6 = value15 - 1;
                } else {
                    value6 = 5;
                }
                setCmd(14, value6);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value16 = DataCanbus.DATA[193];
                if (value16 < 5) {
                    value5 = value16 + 1;
                } else {
                    value5 = 0;
                }
                setCmd(14, value5);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value17 = DataCanbus.DATA[194];
                if (value17 > 0) {
                    value4 = value17 - 1;
                } else {
                    value4 = 14;
                }
                setCmd(15, value4);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value18 = DataCanbus.DATA[194];
                if (value18 < 14) {
                    value3 = value18 + 1;
                } else {
                    value3 = 0;
                }
                setCmd(15, value3);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value19 = DataCanbus.DATA[195];
                if (value19 > 0) {
                    value2 = value19 - 1;
                } else {
                    value2 = 14;
                }
                setCmd(16, value2);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value20 = DataCanbus.DATA[195];
                if (value20 < 14) {
                    value = value20 + 1;
                } else {
                    value = 0;
                }
                setCmd(16, value);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                setCmd(13, DataCanbus.DATA[192] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                DataCanbus.PROXY.cmd(101, 24, DataCanbus.DATA[231] != 0 ? 0 : 1);
                break;
        }
    }

    private void setCmd(int type, int value) {
        DataCanbus.PROXY.cmd(104, type, value);
    }

    protected void updateLoudness(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    protected void updateVolumeSpeed(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }

    protected void updateBalance(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value - 7).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText("-" + (7 - value));
            }
        }
    }

    protected void updateFade(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value - 7).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText("-" + (7 - value));
            }
        }
    }

    protected void updateDistribution(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_252_sound_distribution0);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_252_sound_distribution1);
                    break;
            }
        }
    }

    protected void updateSelection(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_252_sound_selection0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_252_sound_selection1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_252_sound_selection2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_252_sound_selection3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_252_sound_selection4);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_252_sound_selection5);
                    break;
            }
        }
    }

    protected void updateTweeter(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value - 7).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText("-" + (7 - value));
            }
        }
    }

    protected void updateBass(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value - 7).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText("-" + (7 - value));
            }
        }
    }
}
