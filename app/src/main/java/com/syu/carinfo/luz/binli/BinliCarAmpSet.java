package com.syu.carinfo.luz.binli;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class BinliCarAmpSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 153:
                    ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                    break;
                case 154:
                    if (val > 7) {
                        ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text2)).setText("L" + (val - 7));
                        break;
                    } else if (val < 7) {
                        ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text2)).setText("R" + (7 - val));
                        break;
                    } else {
                        ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text2)).setText("0");
                        break;
                    }
                case 155:
                    if (val > 7) {
                        ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text3)).setText("F" + (val - 7));
                        break;
                    } else if (val < 7) {
                        ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text3)).setText("R" + (7 - val));
                        break;
                    } else {
                        ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text3)).setText("0");
                        break;
                    }
                case 156:
                    if (val > 7) {
                        ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text4)).setText("+" + (val - 7));
                        break;
                    } else if (val < 7) {
                        ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text4)).setText("-" + (7 - val));
                        break;
                    } else {
                        ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text4)).setText("0");
                        break;
                    }
                case 157:
                    if (val > 7) {
                        ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text5)).setText("+" + (val - 7));
                        break;
                    } else if (val < 7) {
                        ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text5)).setText("-" + (7 - val));
                        break;
                    } else {
                        ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text5)).setText("0");
                        break;
                    }
                case 158:
                    if (val > 7) {
                        ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text6)).setText("+" + (val - 7));
                        break;
                    } else if (val < 7) {
                        ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text6)).setText("-" + (7 - val));
                        break;
                    } else {
                        ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text6)).setText("0");
                        break;
                    }
                case 159:
                    switch (val) {
                        case 0:
                            ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text7)).setText("driver optimised");
                            break;
                        case 1:
                            ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text7)).setText("neutral");
                            break;
                        case 2:
                            ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text7)).setText("studio");
                            break;
                        case 3:
                            ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text7)).setText("surround");
                            break;
                        case 4:
                            ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text7)).setText("concert hall");
                            break;
                        case 5:
                            ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text7)).setText("jazz club");
                            break;
                        case 6:
                            ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text7)).setText("open air");
                            break;
                        case 7:
                            ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text7)).setText("spoken word");
                            break;
                    }
                case 160:
                    ((TextView) BinliCarAmpSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(val).toString());
                    break;
                case 161:
                    BinliCarAmpSet.this.setCheck((CheckedTextView) BinliCarAmpSet.this.findViewById(R.id.ctv_checkedtext1), val != 0);
                    break;
                case 162:
                    BinliCarAmpSet.this.setCheck((CheckedTextView) BinliCarAmpSet.this.findViewById(R.id.ctv_checkedtext2), val != 0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_luz_binli_amp_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
    }

    @Override
    public void onClick(View v) {
        int loudness;
        int dynamic;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int vol = DataCanbus.DATA[153];
                int bal = DataCanbus.DATA[154];
                int fad = DataCanbus.DATA[155];
                int treb = DataCanbus.DATA[156];
                int mid = DataCanbus.DATA[157];
                int bass = DataCanbus.DATA[158];
                int sound = DataCanbus.DATA[159];
                int sounvol = DataCanbus.DATA[160];
                int dynamic2 = DataCanbus.DATA[161];
                int loudness2 = DataCanbus.DATA[162];
                if (vol > 0) {
                    vol--;
                }
                setCarInfo(vol, bal, fad, treb, mid, bass, sound, sounvol, dynamic2, loudness2);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int vol2 = DataCanbus.DATA[153];
                int bal2 = DataCanbus.DATA[154];
                int fad2 = DataCanbus.DATA[155];
                int treb2 = DataCanbus.DATA[156];
                int mid2 = DataCanbus.DATA[157];
                int bass2 = DataCanbus.DATA[158];
                int sound2 = DataCanbus.DATA[159];
                int sounvol2 = DataCanbus.DATA[160];
                int dynamic3 = DataCanbus.DATA[161];
                int loudness3 = DataCanbus.DATA[162];
                if (vol2 < 31) {
                    vol2++;
                }
                setCarInfo(vol2, bal2, fad2, treb2, mid2, bass2, sound2, sounvol2, dynamic3, loudness3);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int vol3 = DataCanbus.DATA[153];
                int bal3 = DataCanbus.DATA[154];
                int fad3 = DataCanbus.DATA[155];
                int treb3 = DataCanbus.DATA[156];
                int mid3 = DataCanbus.DATA[157];
                int bass3 = DataCanbus.DATA[158];
                int sound3 = DataCanbus.DATA[159];
                int sounvol3 = DataCanbus.DATA[160];
                int dynamic4 = DataCanbus.DATA[161];
                int loudness4 = DataCanbus.DATA[162];
                if (bal3 > 0) {
                    bal3--;
                }
                setCarInfo(vol3, bal3, fad3, treb3, mid3, bass3, sound3, sounvol3, dynamic4, loudness4);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int vol4 = DataCanbus.DATA[153];
                int bal4 = DataCanbus.DATA[154];
                int fad4 = DataCanbus.DATA[155];
                int treb4 = DataCanbus.DATA[156];
                int mid4 = DataCanbus.DATA[157];
                int bass4 = DataCanbus.DATA[158];
                int sound4 = DataCanbus.DATA[159];
                int sounvol4 = DataCanbus.DATA[160];
                int dynamic5 = DataCanbus.DATA[161];
                int loudness5 = DataCanbus.DATA[162];
                if (bal4 < 14) {
                    bal4++;
                }
                setCarInfo(vol4, bal4, fad4, treb4, mid4, bass4, sound4, sounvol4, dynamic5, loudness5);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int vol5 = DataCanbus.DATA[153];
                int bal5 = DataCanbus.DATA[154];
                int fad5 = DataCanbus.DATA[155];
                int treb5 = DataCanbus.DATA[156];
                int mid5 = DataCanbus.DATA[157];
                int bass5 = DataCanbus.DATA[158];
                int sound5 = DataCanbus.DATA[159];
                int sounvol5 = DataCanbus.DATA[160];
                int dynamic6 = DataCanbus.DATA[161];
                int loudness6 = DataCanbus.DATA[162];
                if (fad5 > 0) {
                    fad5--;
                }
                setCarInfo(vol5, bal5, fad5, treb5, mid5, bass5, sound5, sounvol5, dynamic6, loudness6);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int vol6 = DataCanbus.DATA[153];
                int bal6 = DataCanbus.DATA[154];
                int fad6 = DataCanbus.DATA[155];
                int treb6 = DataCanbus.DATA[156];
                int mid6 = DataCanbus.DATA[157];
                int bass6 = DataCanbus.DATA[158];
                int sound6 = DataCanbus.DATA[159];
                int sounvol6 = DataCanbus.DATA[160];
                int dynamic7 = DataCanbus.DATA[161];
                int loudness7 = DataCanbus.DATA[162];
                if (fad6 < 14) {
                    fad6++;
                }
                setCarInfo(vol6, bal6, fad6, treb6, mid6, bass6, sound6, sounvol6, dynamic7, loudness7);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int vol7 = DataCanbus.DATA[153];
                int bal7 = DataCanbus.DATA[154];
                int fad7 = DataCanbus.DATA[155];
                int treb7 = DataCanbus.DATA[156];
                int mid7 = DataCanbus.DATA[157];
                int bass7 = DataCanbus.DATA[158];
                int sound7 = DataCanbus.DATA[159];
                int sounvol7 = DataCanbus.DATA[160];
                int dynamic8 = DataCanbus.DATA[161];
                int loudness8 = DataCanbus.DATA[162];
                if (treb7 > 0) {
                    treb7--;
                }
                setCarInfo(vol7, bal7, fad7, treb7, mid7, bass7, sound7, sounvol7, dynamic8, loudness8);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int vol8 = DataCanbus.DATA[153];
                int bal8 = DataCanbus.DATA[154];
                int fad8 = DataCanbus.DATA[155];
                int treb8 = DataCanbus.DATA[156];
                int mid8 = DataCanbus.DATA[157];
                int bass8 = DataCanbus.DATA[158];
                int sound8 = DataCanbus.DATA[159];
                int sounvol8 = DataCanbus.DATA[160];
                int dynamic9 = DataCanbus.DATA[161];
                int loudness9 = DataCanbus.DATA[162];
                if (treb8 < 14) {
                    treb8++;
                }
                setCarInfo(vol8, bal8, fad8, treb8, mid8, bass8, sound8, sounvol8, dynamic9, loudness9);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int vol9 = DataCanbus.DATA[153];
                int bal9 = DataCanbus.DATA[154];
                int fad9 = DataCanbus.DATA[155];
                int treb9 = DataCanbus.DATA[156];
                int mid9 = DataCanbus.DATA[157];
                int bass9 = DataCanbus.DATA[158];
                int sound9 = DataCanbus.DATA[159];
                int sounvol9 = DataCanbus.DATA[160];
                int dynamic10 = DataCanbus.DATA[161];
                int loudness10 = DataCanbus.DATA[162];
                if (mid9 > 0) {
                    mid9--;
                }
                setCarInfo(vol9, bal9, fad9, treb9, mid9, bass9, sound9, sounvol9, dynamic10, loudness10);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int vol10 = DataCanbus.DATA[153];
                int bal10 = DataCanbus.DATA[154];
                int fad10 = DataCanbus.DATA[155];
                int treb10 = DataCanbus.DATA[156];
                int mid10 = DataCanbus.DATA[157];
                int bass10 = DataCanbus.DATA[158];
                int sound10 = DataCanbus.DATA[159];
                int sounvol10 = DataCanbus.DATA[160];
                int dynamic11 = DataCanbus.DATA[161];
                int loudness11 = DataCanbus.DATA[162];
                if (mid10 < 14) {
                    mid10++;
                }
                setCarInfo(vol10, bal10, fad10, treb10, mid10, bass10, sound10, sounvol10, dynamic11, loudness11);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int vol11 = DataCanbus.DATA[153];
                int bal11 = DataCanbus.DATA[154];
                int fad11 = DataCanbus.DATA[155];
                int treb11 = DataCanbus.DATA[156];
                int mid11 = DataCanbus.DATA[157];
                int bass11 = DataCanbus.DATA[158];
                int sound11 = DataCanbus.DATA[159];
                int sounvol11 = DataCanbus.DATA[160];
                int dynamic12 = DataCanbus.DATA[161];
                int loudness12 = DataCanbus.DATA[162];
                if (bass11 > 0) {
                    bass11--;
                }
                setCarInfo(vol11, bal11, fad11, treb11, mid11, bass11, sound11, sounvol11, dynamic12, loudness12);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int vol12 = DataCanbus.DATA[153];
                int bal12 = DataCanbus.DATA[154];
                int fad12 = DataCanbus.DATA[155];
                int treb12 = DataCanbus.DATA[156];
                int mid12 = DataCanbus.DATA[157];
                int bass12 = DataCanbus.DATA[158];
                int sound12 = DataCanbus.DATA[159];
                int sounvol12 = DataCanbus.DATA[160];
                int dynamic13 = DataCanbus.DATA[161];
                int loudness13 = DataCanbus.DATA[162];
                if (bass12 < 14) {
                    bass12++;
                }
                setCarInfo(vol12, bal12, fad12, treb12, mid12, bass12, sound12, sounvol12, dynamic13, loudness13);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int vol13 = DataCanbus.DATA[153];
                int bal13 = DataCanbus.DATA[154];
                int fad13 = DataCanbus.DATA[155];
                int treb13 = DataCanbus.DATA[156];
                int mid13 = DataCanbus.DATA[157];
                int bass13 = DataCanbus.DATA[158];
                int sound13 = DataCanbus.DATA[159];
                int sounvol13 = DataCanbus.DATA[160];
                int dynamic14 = DataCanbus.DATA[161];
                int loudness14 = DataCanbus.DATA[162];
                if (sound13 > 0) {
                    sound13--;
                }
                setCarInfo(vol13, bal13, fad13, treb13, mid13, bass13, sound13, sounvol13, dynamic14, loudness14);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int vol14 = DataCanbus.DATA[153];
                int bal14 = DataCanbus.DATA[154];
                int fad14 = DataCanbus.DATA[155];
                int treb14 = DataCanbus.DATA[156];
                int mid14 = DataCanbus.DATA[157];
                int bass14 = DataCanbus.DATA[158];
                int sound14 = DataCanbus.DATA[159];
                int sounvol14 = DataCanbus.DATA[160];
                int dynamic15 = DataCanbus.DATA[161];
                int loudness15 = DataCanbus.DATA[162];
                if (sound14 < 7) {
                    sound14++;
                }
                setCarInfo(vol14, bal14, fad14, treb14, mid14, bass14, sound14, sounvol14, dynamic15, loudness15);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int vol15 = DataCanbus.DATA[153];
                int bal15 = DataCanbus.DATA[154];
                int fad15 = DataCanbus.DATA[155];
                int treb15 = DataCanbus.DATA[156];
                int mid15 = DataCanbus.DATA[157];
                int bass15 = DataCanbus.DATA[158];
                int sound15 = DataCanbus.DATA[159];
                int sounvol15 = DataCanbus.DATA[160];
                int dynamic16 = DataCanbus.DATA[161];
                int loudness16 = DataCanbus.DATA[162];
                if (sounvol15 > 0) {
                    sounvol15--;
                }
                setCarInfo(vol15, bal15, fad15, treb15, mid15, bass15, sound15, sounvol15, dynamic16, loudness16);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int vol16 = DataCanbus.DATA[153];
                int bal16 = DataCanbus.DATA[154];
                int fad16 = DataCanbus.DATA[155];
                int treb16 = DataCanbus.DATA[156];
                int mid16 = DataCanbus.DATA[157];
                int bass16 = DataCanbus.DATA[158];
                int sound16 = DataCanbus.DATA[159];
                int sounvol16 = DataCanbus.DATA[160];
                int dynamic17 = DataCanbus.DATA[161];
                int loudness17 = DataCanbus.DATA[162];
                if (sounvol16 < 6) {
                    sounvol16++;
                }
                setCarInfo(vol16, bal16, fad16, treb16, mid16, bass16, sound16, sounvol16, dynamic17, loudness17);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int vol17 = DataCanbus.DATA[153];
                int bal17 = DataCanbus.DATA[154];
                int fad17 = DataCanbus.DATA[155];
                int treb17 = DataCanbus.DATA[156];
                int mid17 = DataCanbus.DATA[157];
                int bass17 = DataCanbus.DATA[158];
                int sound17 = DataCanbus.DATA[159];
                int sounvol17 = DataCanbus.DATA[160];
                int dynamic18 = DataCanbus.DATA[161];
                int loudness18 = DataCanbus.DATA[162];
                if (dynamic18 == 0) {
                    dynamic = 1;
                } else {
                    dynamic = 0;
                }
                setCarInfo(vol17, bal17, fad17, treb17, mid17, bass17, sound17, sounvol17, dynamic, loudness18);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int vol18 = DataCanbus.DATA[153];
                int bal18 = DataCanbus.DATA[154];
                int fad18 = DataCanbus.DATA[155];
                int treb18 = DataCanbus.DATA[156];
                int mid18 = DataCanbus.DATA[157];
                int bass18 = DataCanbus.DATA[158];
                int sound18 = DataCanbus.DATA[159];
                int sounvol18 = DataCanbus.DATA[160];
                int dynamic19 = DataCanbus.DATA[161];
                int loudness19 = DataCanbus.DATA[162];
                if (loudness19 == 0) {
                    loudness = 1;
                } else {
                    loudness = 0;
                }
                setCarInfo(vol18, bal18, fad18, treb18, mid18, bass18, sound18, sounvol18, dynamic19, loudness);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4, int value5, int value6, int value7, int value8, int value9, int value10) {
        DataCanbus.PROXY.cmd(4, new int[]{value1, value2, value3, value4, value5, value6, value7, value8, value9, value10}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
    }
}
