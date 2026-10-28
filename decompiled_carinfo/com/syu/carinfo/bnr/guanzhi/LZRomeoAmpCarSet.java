package com.syu.carinfo.bnr.guanzhi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZRomeoAmpCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 143:
                    if (((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 10) {
                            ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text2)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text2)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 144:
                    if (((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 10) {
                            ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text3)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 145:
                    if (((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 10) {
                            ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text4)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text4)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 146:
                    if (((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (value > 10) {
                            ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text6)).setText("R" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text6)).setText("F" + (10 - value));
                            break;
                        } else {
                            ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text6)).setText("0");
                            break;
                        }
                    }
                    break;
                case 147:
                    if (((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 10) {
                            ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text5)).setText("R" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text5)).setText("L" + (10 - value));
                            break;
                        } else {
                            ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 148:
                    if (((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 149:
                    if (((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) LZRomeoAmpCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_lz_romeo_amp_settings);
        init();
    }

    @Override
    public void init() {
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int carvol = DataCanbus.DATA[148];
                int bal = DataCanbus.DATA[147];
                int fad = DataCanbus.DATA[146];
                int bass = DataCanbus.DATA[143];
                int mid = DataCanbus.DATA[144];
                int treb = DataCanbus.DATA[145];
                int speedvol = DataCanbus.DATA[149];
                if (carvol > 0) {
                    carvol--;
                }
                setCarInfo(carvol, bal, fad, bass, mid, treb, speedvol);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int carvol2 = DataCanbus.DATA[148];
                int bal2 = DataCanbus.DATA[147];
                int fad2 = DataCanbus.DATA[146];
                int bass2 = DataCanbus.DATA[143];
                int mid2 = DataCanbus.DATA[144];
                int treb2 = DataCanbus.DATA[145];
                int speedvol2 = DataCanbus.DATA[149];
                if (carvol2 < 38) {
                    carvol2++;
                }
                setCarInfo(carvol2, bal2, fad2, bass2, mid2, treb2, speedvol2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int carvol3 = DataCanbus.DATA[148];
                int bal3 = DataCanbus.DATA[147];
                int fad3 = DataCanbus.DATA[146];
                int bass3 = DataCanbus.DATA[143];
                int mid3 = DataCanbus.DATA[144];
                int treb3 = DataCanbus.DATA[145];
                int speedvol3 = DataCanbus.DATA[149];
                if (bass3 > 1) {
                    bass3--;
                }
                setCarInfo(carvol3, bal3, fad3, bass3, mid3, treb3, speedvol3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int carvol4 = DataCanbus.DATA[148];
                int bal4 = DataCanbus.DATA[147];
                int fad4 = DataCanbus.DATA[146];
                int bass4 = DataCanbus.DATA[143];
                int mid4 = DataCanbus.DATA[144];
                int treb4 = DataCanbus.DATA[145];
                int speedvol4 = DataCanbus.DATA[149];
                if (bass4 < 19) {
                    bass4++;
                }
                setCarInfo(carvol4, bal4, fad4, bass4, mid4, treb4, speedvol4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int carvol5 = DataCanbus.DATA[148];
                int bal5 = DataCanbus.DATA[147];
                int fad5 = DataCanbus.DATA[146];
                int bass5 = DataCanbus.DATA[143];
                int mid5 = DataCanbus.DATA[144];
                int treb5 = DataCanbus.DATA[145];
                int speedvol5 = DataCanbus.DATA[149];
                if (mid5 > 1) {
                    mid5--;
                }
                setCarInfo(carvol5, bal5, fad5, bass5, mid5, treb5, speedvol5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int carvol6 = DataCanbus.DATA[148];
                int bal6 = DataCanbus.DATA[147];
                int fad6 = DataCanbus.DATA[146];
                int bass6 = DataCanbus.DATA[143];
                int mid6 = DataCanbus.DATA[144];
                int treb6 = DataCanbus.DATA[145];
                int speedvol6 = DataCanbus.DATA[149];
                if (mid6 < 19) {
                    mid6++;
                }
                setCarInfo(carvol6, bal6, fad6, bass6, mid6, treb6, speedvol6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int carvol7 = DataCanbus.DATA[148];
                int bal7 = DataCanbus.DATA[147];
                int fad7 = DataCanbus.DATA[146];
                int bass7 = DataCanbus.DATA[143];
                int mid7 = DataCanbus.DATA[144];
                int treb7 = DataCanbus.DATA[145];
                int speedvol7 = DataCanbus.DATA[149];
                if (treb7 > 1) {
                    treb7--;
                }
                setCarInfo(carvol7, bal7, fad7, bass7, mid7, treb7, speedvol7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int carvol8 = DataCanbus.DATA[148];
                int bal8 = DataCanbus.DATA[147];
                int fad8 = DataCanbus.DATA[146];
                int bass8 = DataCanbus.DATA[143];
                int mid8 = DataCanbus.DATA[144];
                int treb8 = DataCanbus.DATA[145];
                int speedvol8 = DataCanbus.DATA[149];
                if (treb8 < 19) {
                    treb8++;
                }
                setCarInfo(carvol8, bal8, fad8, bass8, mid8, treb8, speedvol8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int carvol9 = DataCanbus.DATA[148];
                int bal9 = DataCanbus.DATA[147];
                int fad9 = DataCanbus.DATA[146];
                int bass9 = DataCanbus.DATA[143];
                int mid9 = DataCanbus.DATA[144];
                int treb9 = DataCanbus.DATA[145];
                int speedvol9 = DataCanbus.DATA[149];
                if (bal9 > 1) {
                    bal9--;
                }
                setCarInfo(carvol9, bal9, fad9, bass9, mid9, treb9, speedvol9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int carvol10 = DataCanbus.DATA[148];
                int bal10 = DataCanbus.DATA[147];
                int fad10 = DataCanbus.DATA[146];
                int bass10 = DataCanbus.DATA[143];
                int mid10 = DataCanbus.DATA[144];
                int treb10 = DataCanbus.DATA[145];
                int speedvol10 = DataCanbus.DATA[149];
                if (bal10 < 19) {
                    bal10++;
                }
                setCarInfo(carvol10, bal10, fad10, bass10, mid10, treb10, speedvol10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int carvol11 = DataCanbus.DATA[148];
                int bal11 = DataCanbus.DATA[147];
                int fad11 = DataCanbus.DATA[146];
                int bass11 = DataCanbus.DATA[143];
                int mid11 = DataCanbus.DATA[144];
                int treb11 = DataCanbus.DATA[145];
                int speedvol11 = DataCanbus.DATA[149];
                if (fad11 > 1) {
                    fad11--;
                }
                setCarInfo(carvol11, bal11, fad11, bass11, mid11, treb11, speedvol11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int carvol12 = DataCanbus.DATA[148];
                int bal12 = DataCanbus.DATA[147];
                int fad12 = DataCanbus.DATA[146];
                int bass12 = DataCanbus.DATA[143];
                int mid12 = DataCanbus.DATA[144];
                int treb12 = DataCanbus.DATA[145];
                int speedvol12 = DataCanbus.DATA[149];
                if (fad12 < 19) {
                    fad12++;
                }
                setCarInfo(carvol12, bal12, fad12, bass12, mid12, treb12, speedvol12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int carvol13 = DataCanbus.DATA[148];
                int bal13 = DataCanbus.DATA[147];
                int fad13 = DataCanbus.DATA[146];
                int bass13 = DataCanbus.DATA[143];
                int mid13 = DataCanbus.DATA[144];
                int treb13 = DataCanbus.DATA[145];
                int speedvol13 = DataCanbus.DATA[149];
                if (speedvol13 > 0) {
                    speedvol13--;
                }
                setCarInfo(carvol13, bal13, fad13, bass13, mid13, treb13, speedvol13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int carvol14 = DataCanbus.DATA[148];
                int bal14 = DataCanbus.DATA[147];
                int fad14 = DataCanbus.DATA[146];
                int bass14 = DataCanbus.DATA[143];
                int mid14 = DataCanbus.DATA[144];
                int treb14 = DataCanbus.DATA[145];
                int speedvol14 = DataCanbus.DATA[149];
                if (speedvol14 < 5) {
                    speedvol14++;
                }
                setCarInfo(carvol14, bal14, fad14, bass14, mid14, treb14, speedvol14);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3, int value4, int value5, int value6) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3, value4, value5, value6}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{147}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
    }
}
