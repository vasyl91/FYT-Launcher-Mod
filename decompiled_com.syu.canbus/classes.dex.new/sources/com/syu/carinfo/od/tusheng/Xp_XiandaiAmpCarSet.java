package com.syu.carinfo.od.tusheng;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Xp_XiandaiAmpCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.tusheng.Xp_XiandaiAmpCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 112:
                    ((CheckedTextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 0);
                    break;
                case 113:
                    if (((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 10) {
                            ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text2)).setText("+" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text2)).setText("-" + (10 - value));
                        } else {
                            ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                        }
                    }
                    break;
                case 114:
                    if (((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 10) {
                            ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text3)).setText("+" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                        } else {
                            ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text3)).setText("0");
                        }
                    }
                    break;
                case 115:
                    if (((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 10) {
                            ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text4)).setText("+" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text4)).setText("-" + (10 - value));
                        } else {
                            ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
                case 116:
                    if (((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (value > 10) {
                            ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text6)).setText("R" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text6)).setText("F" + (10 - value));
                        } else {
                            ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text6)).setText("0");
                        }
                    }
                    break;
                case 117:
                    if (((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 10) {
                            ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text5)).setText("R" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text5)).setText("L" + (10 - value));
                        } else {
                            ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 118:
                    if (((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 119:
                    ((CheckedTextView) Xp_XiandaiAmpCarSet.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0355_xp_xiandai_amp_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int carvol = DataCanbus.DATA[118];
                int mute = DataCanbus.DATA[119];
                if (carvol > 0) {
                    carvol--;
                }
                setCarVolInfo(carvol, mute);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int carvol2 = DataCanbus.DATA[118];
                int mute2 = DataCanbus.DATA[119];
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_XP_XIANDAI_ALl_IX45_H /* 1114467 */:
                    case FinalCanbus.CAR_XP_18QiYaK5_H /* 1638755 */:
                    case FinalCanbus.CAR_XP_16QiYaKX5_H /* 1835363 */:
                        if (carvol2 < 45) {
                            carvol2++;
                        }
                        break;
                    default:
                        if (carvol2 < 35) {
                            carvol2++;
                        }
                        break;
                }
                setCarVolInfo(carvol2, mute2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int power = DataCanbus.DATA[112];
                int bal = DataCanbus.DATA[117];
                int fad = DataCanbus.DATA[116];
                int bass = DataCanbus.DATA[113];
                int mid = DataCanbus.DATA[114];
                int treb = DataCanbus.DATA[115];
                if (bass > 1) {
                    bass--;
                }
                setCarInfo(power, fad, bal, treb, mid, bass);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int power2 = DataCanbus.DATA[112];
                int bal2 = DataCanbus.DATA[117];
                int fad2 = DataCanbus.DATA[116];
                int bass2 = DataCanbus.DATA[113];
                int mid2 = DataCanbus.DATA[114];
                int treb2 = DataCanbus.DATA[115];
                if (bass2 < 20) {
                    bass2++;
                }
                setCarInfo(power2, fad2, bal2, treb2, mid2, bass2);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int power3 = DataCanbus.DATA[112];
                int bal3 = DataCanbus.DATA[117];
                int fad3 = DataCanbus.DATA[116];
                int bass3 = DataCanbus.DATA[113];
                int mid3 = DataCanbus.DATA[114];
                int treb3 = DataCanbus.DATA[115];
                if (mid3 > 1) {
                    mid3--;
                }
                setCarInfo(power3, fad3, bal3, treb3, mid3, bass3);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int power4 = DataCanbus.DATA[112];
                int bal4 = DataCanbus.DATA[117];
                int fad4 = DataCanbus.DATA[116];
                int bass4 = DataCanbus.DATA[113];
                int mid4 = DataCanbus.DATA[114];
                int treb4 = DataCanbus.DATA[115];
                if (mid4 < 20) {
                    mid4++;
                }
                setCarInfo(power4, fad4, bal4, treb4, mid4, bass4);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int power5 = DataCanbus.DATA[112];
                int bal5 = DataCanbus.DATA[117];
                int fad5 = DataCanbus.DATA[116];
                int bass5 = DataCanbus.DATA[113];
                int mid5 = DataCanbus.DATA[114];
                int treb5 = DataCanbus.DATA[115];
                if (treb5 > 1) {
                    treb5--;
                }
                setCarInfo(power5, fad5, bal5, treb5, mid5, bass5);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int power6 = DataCanbus.DATA[112];
                int bal6 = DataCanbus.DATA[117];
                int fad6 = DataCanbus.DATA[116];
                int bass6 = DataCanbus.DATA[113];
                int mid6 = DataCanbus.DATA[114];
                int treb6 = DataCanbus.DATA[115];
                if (treb6 < 20) {
                    treb6++;
                }
                setCarInfo(power6, fad6, bal6, treb6, mid6, bass6);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int power7 = DataCanbus.DATA[112];
                int bal7 = DataCanbus.DATA[117];
                int fad7 = DataCanbus.DATA[116];
                int bass7 = DataCanbus.DATA[113];
                int mid7 = DataCanbus.DATA[114];
                int treb7 = DataCanbus.DATA[115];
                if (bal7 > 1) {
                    bal7--;
                }
                setCarInfo(power7, fad7, bal7, treb7, mid7, bass7);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int power8 = DataCanbus.DATA[112];
                int bal8 = DataCanbus.DATA[117];
                int fad8 = DataCanbus.DATA[116];
                int bass8 = DataCanbus.DATA[113];
                int mid8 = DataCanbus.DATA[114];
                int treb8 = DataCanbus.DATA[115];
                if (bal8 < 20) {
                    bal8++;
                }
                setCarInfo(power8, fad8, bal8, treb8, mid8, bass8);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int power9 = DataCanbus.DATA[112];
                int bal9 = DataCanbus.DATA[117];
                int fad9 = DataCanbus.DATA[116];
                int bass9 = DataCanbus.DATA[113];
                int mid9 = DataCanbus.DATA[114];
                int treb9 = DataCanbus.DATA[115];
                if (fad9 > 1) {
                    fad9--;
                }
                setCarInfo(power9, fad9, bal9, treb9, mid9, bass9);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int power10 = DataCanbus.DATA[112];
                int bal10 = DataCanbus.DATA[117];
                int fad10 = DataCanbus.DATA[116];
                int bass10 = DataCanbus.DATA[113];
                int mid10 = DataCanbus.DATA[114];
                int treb10 = DataCanbus.DATA[115];
                if (fad10 < 20) {
                    fad10++;
                }
                setCarInfo(power10, fad10, bal10, treb10, mid10, bass10);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int power11 = DataCanbus.DATA[112];
                int fad11 = DataCanbus.DATA[116];
                int bal11 = DataCanbus.DATA[117];
                int treb11 = DataCanbus.DATA[115];
                int mid11 = DataCanbus.DATA[114];
                int bass11 = DataCanbus.DATA[113];
                if (power11 == 0) {
                    power11 = 1;
                } else if (power11 == 1) {
                    power11 = 0;
                }
                setCarInfo(power11, fad11, bal11, treb11, mid11, bass11);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int carvol3 = DataCanbus.DATA[118];
                int mute3 = DataCanbus.DATA[119];
                if (mute3 == 0) {
                    mute3 = 1;
                } else if (mute3 == 1) {
                    mute3 = 0;
                }
                setCarVolInfo(carvol3, mute3);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3, int value4, int value5) {
        DataCanbus.PROXY.cmd(4, new int[]{value0, value1, value2, value3, value4, value5}, null, null);
    }

    public void setCarVolInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(3, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }
}
