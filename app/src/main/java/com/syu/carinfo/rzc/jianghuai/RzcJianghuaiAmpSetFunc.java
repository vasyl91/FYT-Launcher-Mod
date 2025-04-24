package com.syu.carinfo.rzc.jianghuai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RzcJianghuaiAmpSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 156:
                    ((CheckedTextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 157:
                    ((CheckedTextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 158:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 159:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 10) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text2)).setText("R" + (value - 10));
                            break;
                        } else if (value > 10) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text2)).setText("L" + (10 - value));
                            break;
                        } else {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 160:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 10) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text3)).setText("R" + (value - 10));
                            break;
                        } else if (value > 10) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text3)).setText("F" + (10 - value));
                            break;
                        } else {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 161:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 10) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text4)).setText("+" + (value - 10));
                            break;
                        } else if (value > 10) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text4)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 162:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 10) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text5)).setText("+" + (value - 10));
                            break;
                        } else if (value > 10) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text5)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 163:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text6)) != null) {
                        if (value > 10) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text6)).setText("+" + (value - 10));
                            break;
                        } else if (value > 10) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text6)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text6)).setText("0");
                            break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_jianghuai_amp_setfunc);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int D0B6 = DataCanbus.DATA[156];
                int D0B4 = DataCanbus.DATA[157];
                int vol = DataCanbus.DATA[158];
                int bal = DataCanbus.DATA[159];
                int fad = DataCanbus.DATA[160];
                int bass = DataCanbus.DATA[161];
                int mid = DataCanbus.DATA[162];
                int treb = DataCanbus.DATA[163];
                if (vol > 0) {
                    vol--;
                }
                setCarInfo(((D0B4 << 4) & 16) | ((D0B6 << 6) & 64), vol, bal, fad, bass, mid, treb);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int D0B62 = DataCanbus.DATA[156];
                int D0B42 = DataCanbus.DATA[157];
                int vol2 = DataCanbus.DATA[158];
                int bal2 = DataCanbus.DATA[159];
                int fad2 = DataCanbus.DATA[160];
                int bass2 = DataCanbus.DATA[161];
                int mid2 = DataCanbus.DATA[162];
                int treb2 = DataCanbus.DATA[163];
                if (vol2 < 39) {
                    vol2++;
                }
                setCarInfo(((D0B42 << 4) & 16) | ((D0B62 << 6) & 64), vol2, bal2, fad2, bass2, mid2, treb2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int D0B63 = DataCanbus.DATA[156];
                int D0B43 = DataCanbus.DATA[157];
                int vol3 = DataCanbus.DATA[158];
                int bal3 = DataCanbus.DATA[159];
                int fad3 = DataCanbus.DATA[160];
                int bass3 = DataCanbus.DATA[161];
                int mid3 = DataCanbus.DATA[162];
                int treb3 = DataCanbus.DATA[163];
                if (bal3 > 0) {
                    bal3--;
                }
                setCarInfo(((D0B43 << 4) & 16) | ((D0B63 << 6) & 64), vol3, bal3, fad3, bass3, mid3, treb3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int D0B64 = DataCanbus.DATA[156];
                int D0B44 = DataCanbus.DATA[157];
                int vol4 = DataCanbus.DATA[158];
                int bal4 = DataCanbus.DATA[159];
                int fad4 = DataCanbus.DATA[160];
                int bass4 = DataCanbus.DATA[161];
                int mid4 = DataCanbus.DATA[162];
                int treb4 = DataCanbus.DATA[163];
                if (bal4 < 20) {
                    bal4++;
                }
                setCarInfo(((D0B44 << 4) & 16) | ((D0B64 << 6) & 64), vol4, bal4, fad4, bass4, mid4, treb4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int D0B65 = DataCanbus.DATA[156];
                int D0B45 = DataCanbus.DATA[157];
                int vol5 = DataCanbus.DATA[158];
                int bal5 = DataCanbus.DATA[159];
                int fad5 = DataCanbus.DATA[160];
                int bass5 = DataCanbus.DATA[161];
                int mid5 = DataCanbus.DATA[162];
                int treb5 = DataCanbus.DATA[163];
                if (fad5 > 0) {
                    fad5--;
                }
                setCarInfo(((D0B45 << 4) & 16) | ((D0B65 << 6) & 64), vol5, bal5, fad5, bass5, mid5, treb5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int D0B66 = DataCanbus.DATA[156];
                int D0B46 = DataCanbus.DATA[157];
                int vol6 = DataCanbus.DATA[158];
                int bal6 = DataCanbus.DATA[159];
                int fad6 = DataCanbus.DATA[160];
                int bass6 = DataCanbus.DATA[161];
                int mid6 = DataCanbus.DATA[162];
                int treb6 = DataCanbus.DATA[163];
                if (fad6 < 20) {
                    fad6++;
                }
                setCarInfo(((D0B46 << 4) & 16) | ((D0B66 << 6) & 64), vol6, bal6, fad6, bass6, mid6, treb6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int D0B67 = DataCanbus.DATA[156];
                int D0B47 = DataCanbus.DATA[157];
                int vol7 = DataCanbus.DATA[158];
                int bal7 = DataCanbus.DATA[159];
                int fad7 = DataCanbus.DATA[160];
                int bass7 = DataCanbus.DATA[161];
                int mid7 = DataCanbus.DATA[162];
                int treb7 = DataCanbus.DATA[163];
                if (bass7 > 0) {
                    bass7--;
                }
                setCarInfo(((D0B47 << 4) & 16) | ((D0B67 << 6) & 64), vol7, bal7, fad7, bass7, mid7, treb7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int D0B68 = DataCanbus.DATA[156];
                int D0B48 = DataCanbus.DATA[157];
                int vol8 = DataCanbus.DATA[158];
                int bal8 = DataCanbus.DATA[159];
                int fad8 = DataCanbus.DATA[160];
                int bass8 = DataCanbus.DATA[161];
                int mid8 = DataCanbus.DATA[162];
                int treb8 = DataCanbus.DATA[163];
                if (bass8 < 20) {
                    bass8++;
                }
                setCarInfo(((D0B48 << 4) & 16) | ((D0B68 << 6) & 64), vol8, bal8, fad8, bass8, mid8, treb8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int D0B69 = DataCanbus.DATA[156];
                int D0B49 = DataCanbus.DATA[157];
                int vol9 = DataCanbus.DATA[158];
                int bal9 = DataCanbus.DATA[159];
                int fad9 = DataCanbus.DATA[160];
                int bass9 = DataCanbus.DATA[161];
                int mid9 = DataCanbus.DATA[162];
                int treb9 = DataCanbus.DATA[163];
                if (mid9 > 0) {
                    mid9--;
                }
                setCarInfo(((D0B49 << 4) & 16) | ((D0B69 << 6) & 64), vol9, bal9, fad9, bass9, mid9, treb9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int D0B610 = DataCanbus.DATA[156];
                int D0B410 = DataCanbus.DATA[157];
                int vol10 = DataCanbus.DATA[158];
                int bal10 = DataCanbus.DATA[159];
                int fad10 = DataCanbus.DATA[160];
                int bass10 = DataCanbus.DATA[161];
                int mid10 = DataCanbus.DATA[162];
                int treb10 = DataCanbus.DATA[163];
                if (mid10 < 20) {
                    mid10++;
                }
                setCarInfo(((D0B410 << 4) & 16) | ((D0B610 << 6) & 64), vol10, bal10, fad10, bass10, mid10, treb10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int D0B611 = DataCanbus.DATA[156];
                int D0B411 = DataCanbus.DATA[157];
                int vol11 = DataCanbus.DATA[158];
                int bal11 = DataCanbus.DATA[159];
                int fad11 = DataCanbus.DATA[160];
                int bass11 = DataCanbus.DATA[161];
                int mid11 = DataCanbus.DATA[162];
                int treb11 = DataCanbus.DATA[163];
                if (treb11 > 0) {
                    treb11--;
                }
                setCarInfo(((D0B411 << 4) & 16) | ((D0B611 << 6) & 64), vol11, bal11, fad11, bass11, mid11, treb11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int D0B612 = DataCanbus.DATA[156];
                int D0B412 = DataCanbus.DATA[157];
                int vol12 = DataCanbus.DATA[158];
                int bal12 = DataCanbus.DATA[159];
                int fad12 = DataCanbus.DATA[160];
                int bass12 = DataCanbus.DATA[161];
                int mid12 = DataCanbus.DATA[162];
                int treb12 = DataCanbus.DATA[163];
                if (treb12 < 20) {
                    treb12++;
                }
                setCarInfo(((D0B412 << 4) & 16) | ((D0B612 << 6) & 64), vol12, bal12, fad12, bass12, mid12, treb12);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int D0B613 = DataCanbus.DATA[156];
                int D0B413 = DataCanbus.DATA[157];
                int vol13 = DataCanbus.DATA[158];
                int bal13 = DataCanbus.DATA[159];
                int fad13 = DataCanbus.DATA[160];
                int bass13 = DataCanbus.DATA[161];
                int mid13 = DataCanbus.DATA[162];
                int treb13 = DataCanbus.DATA[163];
                if (D0B613 == 1) {
                    D0B613 = 0;
                } else if (D0B613 == 0) {
                    D0B613 = 1;
                }
                setCarInfo(((D0B413 << 4) & 16) | ((D0B613 << 6) & 64), vol13, bal13, fad13, bass13, mid13, treb13);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int D0B614 = DataCanbus.DATA[156];
                int D0B414 = DataCanbus.DATA[157];
                int vol14 = DataCanbus.DATA[158];
                int bal14 = DataCanbus.DATA[159];
                int fad14 = DataCanbus.DATA[160];
                int bass14 = DataCanbus.DATA[161];
                int mid14 = DataCanbus.DATA[162];
                int treb14 = DataCanbus.DATA[163];
                if (D0B414 == 1) {
                    D0B414 = 0;
                } else if (D0B414 == 0) {
                    D0B414 = 1;
                }
                setCarInfo(((D0B414 << 4) & 16) | ((D0B614 << 6) & 64), vol14, bal14, fad14, bass14, mid14, treb14);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3, int value4, int value5, int value6) {
        DataCanbus.PROXY.cmd(3, new int[]{value0, value1, value2, value3, value4, value5, value6}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.notifyCanbus);
    }
}
