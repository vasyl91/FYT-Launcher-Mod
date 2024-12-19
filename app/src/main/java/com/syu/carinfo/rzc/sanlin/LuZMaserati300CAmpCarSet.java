package com.syu.carinfo.rzc.sanlin;

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
public class LuZMaserati300CAmpCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LuZMaserati300CAmpCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 144:
                    if (((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 10) {
                            ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text2)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text2)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 145:
                    if (((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 10) {
                            ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text3)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 146:
                    if (((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 10) {
                            ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text4)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text4)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 147:
                    if (((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (value > 10) {
                            ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text6)).setText("R" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text6)).setText("F" + (10 - value));
                            break;
                        } else {
                            ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text6)).setText("0");
                            break;
                        }
                    }
                    break;
                case 148:
                    if (((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 10) {
                            ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text5)).setText("R" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text5)).setText("L" + (10 - value));
                            break;
                        } else {
                            ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 149:
                    if (((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 150:
                    LuZMaserati300CAmpCarSet.this.setCheck((CheckedTextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 151:
                    if (((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) LuZMaserati300CAmpCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_maserati300c_amp_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
                int carvol = DataCanbus.DATA[149];
                int bal = DataCanbus.DATA[148];
                int fad = DataCanbus.DATA[147];
                int bass = DataCanbus.DATA[144];
                int mid = DataCanbus.DATA[145];
                int treb = DataCanbus.DATA[146];
                int suround = DataCanbus.DATA[150];
                int speedvol = DataCanbus.DATA[151];
                if (suround == 1) {
                    suround = 0;
                } else if (suround == 0) {
                    suround = 1;
                }
                setCarInfo(carvol, bal, fad, bass, mid, treb, suround, speedvol);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int carvol2 = DataCanbus.DATA[149];
                int bal2 = DataCanbus.DATA[148];
                int fad2 = DataCanbus.DATA[147];
                int bass2 = DataCanbus.DATA[144];
                int mid2 = DataCanbus.DATA[145];
                int treb2 = DataCanbus.DATA[146];
                int suround2 = DataCanbus.DATA[150];
                int speedvol2 = DataCanbus.DATA[151];
                if (carvol2 > 0) {
                    carvol2--;
                }
                setCarInfo(carvol2, bal2, fad2, bass2, mid2, treb2, suround2, speedvol2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int carvol3 = DataCanbus.DATA[149];
                int bal3 = DataCanbus.DATA[148];
                int fad3 = DataCanbus.DATA[147];
                int bass3 = DataCanbus.DATA[144];
                int mid3 = DataCanbus.DATA[145];
                int treb3 = DataCanbus.DATA[146];
                int suround3 = DataCanbus.DATA[150];
                int speedvol3 = DataCanbus.DATA[151];
                if (carvol3 < 38) {
                    carvol3++;
                }
                setCarInfo(carvol3, bal3, fad3, bass3, mid3, treb3, suround3, speedvol3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int carvol4 = DataCanbus.DATA[149];
                int bal4 = DataCanbus.DATA[148];
                int fad4 = DataCanbus.DATA[147];
                int bass4 = DataCanbus.DATA[144];
                int mid4 = DataCanbus.DATA[145];
                int treb4 = DataCanbus.DATA[146];
                int suround4 = DataCanbus.DATA[150];
                int speedvol4 = DataCanbus.DATA[151];
                if (bass4 > 1) {
                    bass4--;
                }
                setCarInfo(carvol4, bal4, fad4, bass4, mid4, treb4, suround4, speedvol4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int carvol5 = DataCanbus.DATA[149];
                int bal5 = DataCanbus.DATA[148];
                int fad5 = DataCanbus.DATA[147];
                int bass5 = DataCanbus.DATA[144];
                int mid5 = DataCanbus.DATA[145];
                int treb5 = DataCanbus.DATA[146];
                int suround5 = DataCanbus.DATA[150];
                int speedvol5 = DataCanbus.DATA[151];
                if (bass5 < 19) {
                    bass5++;
                }
                setCarInfo(carvol5, bal5, fad5, bass5, mid5, treb5, suround5, speedvol5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int carvol6 = DataCanbus.DATA[149];
                int bal6 = DataCanbus.DATA[148];
                int fad6 = DataCanbus.DATA[147];
                int bass6 = DataCanbus.DATA[144];
                int mid6 = DataCanbus.DATA[145];
                int treb6 = DataCanbus.DATA[146];
                int suround6 = DataCanbus.DATA[150];
                int speedvol6 = DataCanbus.DATA[151];
                if (mid6 > 1) {
                    mid6--;
                }
                setCarInfo(carvol6, bal6, fad6, bass6, mid6, treb6, suround6, speedvol6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int carvol7 = DataCanbus.DATA[149];
                int bal7 = DataCanbus.DATA[148];
                int fad7 = DataCanbus.DATA[147];
                int bass7 = DataCanbus.DATA[144];
                int mid7 = DataCanbus.DATA[145];
                int treb7 = DataCanbus.DATA[146];
                int suround7 = DataCanbus.DATA[150];
                int speedvol7 = DataCanbus.DATA[151];
                if (mid7 < 19) {
                    mid7++;
                }
                setCarInfo(carvol7, bal7, fad7, bass7, mid7, treb7, suround7, speedvol7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int carvol8 = DataCanbus.DATA[149];
                int bal8 = DataCanbus.DATA[148];
                int fad8 = DataCanbus.DATA[147];
                int bass8 = DataCanbus.DATA[144];
                int mid8 = DataCanbus.DATA[145];
                int treb8 = DataCanbus.DATA[146];
                int suround8 = DataCanbus.DATA[150];
                int speedvol8 = DataCanbus.DATA[151];
                if (treb8 > 1) {
                    treb8--;
                }
                setCarInfo(carvol8, bal8, fad8, bass8, mid8, treb8, suround8, speedvol8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int carvol9 = DataCanbus.DATA[149];
                int bal9 = DataCanbus.DATA[148];
                int fad9 = DataCanbus.DATA[147];
                int bass9 = DataCanbus.DATA[144];
                int mid9 = DataCanbus.DATA[145];
                int treb9 = DataCanbus.DATA[146];
                int suround9 = DataCanbus.DATA[150];
                int speedvol9 = DataCanbus.DATA[151];
                if (treb9 < 19) {
                    treb9++;
                }
                setCarInfo(carvol9, bal9, fad9, bass9, mid9, treb9, suround9, speedvol9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int carvol10 = DataCanbus.DATA[149];
                int bal10 = DataCanbus.DATA[148];
                int fad10 = DataCanbus.DATA[147];
                int bass10 = DataCanbus.DATA[144];
                int mid10 = DataCanbus.DATA[145];
                int treb10 = DataCanbus.DATA[146];
                int suround10 = DataCanbus.DATA[150];
                int speedvol10 = DataCanbus.DATA[151];
                if (bal10 > 1) {
                    bal10--;
                }
                setCarInfo(carvol10, bal10, fad10, bass10, mid10, treb10, suround10, speedvol10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int carvol11 = DataCanbus.DATA[149];
                int bal11 = DataCanbus.DATA[148];
                int fad11 = DataCanbus.DATA[147];
                int bass11 = DataCanbus.DATA[144];
                int mid11 = DataCanbus.DATA[145];
                int treb11 = DataCanbus.DATA[146];
                int suround11 = DataCanbus.DATA[150];
                int speedvol11 = DataCanbus.DATA[151];
                if (bal11 < 19) {
                    bal11++;
                }
                setCarInfo(carvol11, bal11, fad11, bass11, mid11, treb11, suround11, speedvol11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int carvol12 = DataCanbus.DATA[149];
                int bal12 = DataCanbus.DATA[148];
                int fad12 = DataCanbus.DATA[147];
                int bass12 = DataCanbus.DATA[144];
                int mid12 = DataCanbus.DATA[145];
                int treb12 = DataCanbus.DATA[146];
                int suround12 = DataCanbus.DATA[150];
                int speedvol12 = DataCanbus.DATA[151];
                if (fad12 > 1) {
                    fad12--;
                }
                setCarInfo(carvol12, bal12, fad12, bass12, mid12, treb12, suround12, speedvol12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int carvol13 = DataCanbus.DATA[149];
                int bal13 = DataCanbus.DATA[148];
                int fad13 = DataCanbus.DATA[147];
                int bass13 = DataCanbus.DATA[144];
                int mid13 = DataCanbus.DATA[145];
                int treb13 = DataCanbus.DATA[146];
                int suround13 = DataCanbus.DATA[150];
                int speedvol13 = DataCanbus.DATA[151];
                if (fad13 < 19) {
                    fad13++;
                }
                setCarInfo(carvol13, bal13, fad13, bass13, mid13, treb13, suround13, speedvol13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int carvol14 = DataCanbus.DATA[149];
                int bal14 = DataCanbus.DATA[148];
                int fad14 = DataCanbus.DATA[147];
                int bass14 = DataCanbus.DATA[144];
                int mid14 = DataCanbus.DATA[145];
                int treb14 = DataCanbus.DATA[146];
                int suround14 = DataCanbus.DATA[150];
                int speedvol14 = DataCanbus.DATA[151];
                if (speedvol14 > 0) {
                    speedvol14--;
                }
                setCarInfo(carvol14, bal14, fad14, bass14, mid14, treb14, suround14, speedvol14);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int carvol15 = DataCanbus.DATA[149];
                int bal15 = DataCanbus.DATA[148];
                int fad15 = DataCanbus.DATA[147];
                int bass15 = DataCanbus.DATA[144];
                int mid15 = DataCanbus.DATA[145];
                int treb15 = DataCanbus.DATA[146];
                int suround15 = DataCanbus.DATA[150];
                int speedvol15 = DataCanbus.DATA[151];
                if (speedvol15 < 3) {
                    speedvol15++;
                }
                setCarInfo(carvol15, bal15, fad15, bass15, mid15, treb15, suround15, speedvol15);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3, int value4, int value5, int value6, int value7) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3, value4, value5, value6, value7}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{147}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
    }
}
