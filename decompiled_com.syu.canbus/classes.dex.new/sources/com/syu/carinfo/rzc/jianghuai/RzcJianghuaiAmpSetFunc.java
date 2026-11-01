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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RzcJianghuaiAmpSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiAmpSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            int center = 10;
            if (DataCanbus.DATA[1000] == 8389063) {
                center = 7;
            }
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
                    }
                    break;
                case 159:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 10) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text2)).setText("R" + (value - 10));
                        } else if (value > 10) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text2)).setText("L" + (10 - value));
                        } else {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text2)).setText("0");
                        }
                    }
                    break;
                case 160:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 10) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text3)).setText("R" + (value - 10));
                        } else if (value > 10) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text3)).setText("F" + (10 - value));
                        } else {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text3)).setText("0");
                        }
                    }
                    break;
                case 161:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > center) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text4)).setText("+" + (value - center));
                        } else if (value > center) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text4)).setText("-" + (center - value));
                        } else {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
                case 162:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > center) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text5)).setText("+" + (value - center));
                        } else if (value > center) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text5)).setText("-" + (center - value));
                        } else {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 163:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text6)) != null) {
                        if (value > center) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text6)).setText("+" + (value - center));
                        } else if (value > center) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text6)).setText("-" + (center - value));
                        } else {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text6)).setText("0");
                        }
                    }
                    break;
                case 168:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text7)) != null) {
                        if (value > center) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text7)).setText("+" + (value - center));
                        } else if (value > center) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text7)).setText("-" + (center - value));
                        } else {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text7)).setText("0");
                        }
                    }
                    break;
                case 169:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text8)).setText("全车均衡");
                                break;
                            case 1:
                                ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text8)).setText("全车环绕");
                                break;
                            case 2:
                                ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text8)).setText("主驾私享");
                                break;
                            case 3:
                                ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text8)).setText("后排专享");
                                break;
                        }
                    }
                    break;
                case 170:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text9)).setText("默认");
                                break;
                            case 1:
                                ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text9)).setText("模拟俱乐部");
                                break;
                            case 2:
                                ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text9)).setText("私人影院");
                                break;
                            case 3:
                                ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text9)).setText("音乐厅");
                                break;
                        }
                    }
                    break;
                case 171:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text10)) != null) {
                        if (value > center) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text10)).setText("L" + (value - center));
                        } else if (value > center) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text10)).setText("R" + (center - value));
                        } else {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text10)).setText("0");
                        }
                    }
                    break;
                case 180:
                    if (((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text11)) != null) {
                        if (value > center) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text11)).setText("R" + (value - center));
                        } else if (value > center) {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text11)).setText("F" + (center - value));
                        } else {
                            ((TextView) RzcJianghuaiAmpSetFunc.this.findViewById(R.id.tv_text11)).setText("0");
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_jianghuai_amp_setfunc);
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
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int maxvalue = 20;
        if (DataCanbus.DATA[1000] == 8389063) {
            maxvalue = 14;
        }
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int D0B6 = DataCanbus.DATA[156];
                int D0B4 = DataCanbus.DATA[157];
                int vol = DataCanbus.DATA[158];
                int bal = DataCanbus.DATA[159];
                int fad = DataCanbus.DATA[160];
                int bass = DataCanbus.DATA[161];
                int mid = DataCanbus.DATA[162];
                int treb = DataCanbus.DATA[163];
                int D7 = DataCanbus.DATA[168];
                int D8 = DataCanbus.DATA[169];
                int D9 = DataCanbus.DATA[170];
                int D10B74 = DataCanbus.DATA[171];
                int D10B30 = DataCanbus.DATA[180];
                if (vol > 0) {
                    vol--;
                }
                setCarInfo(((D0B4 << 4) & 16) | ((D0B6 << 6) & 64), vol, bal, fad, bass, mid, treb, D7, D8, D9, (D10B30 & 15) | ((D10B74 << 4) & 240));
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int D0B7 = DataCanbus.DATA[156];
                int D0B5 = DataCanbus.DATA[157];
                int vol2 = DataCanbus.DATA[158];
                int bal2 = DataCanbus.DATA[159];
                int fad2 = DataCanbus.DATA[160];
                int bass2 = DataCanbus.DATA[161];
                int mid2 = DataCanbus.DATA[162];
                int treb2 = DataCanbus.DATA[163];
                int D10 = DataCanbus.DATA[168];
                int D11 = DataCanbus.DATA[169];
                int D12 = DataCanbus.DATA[170];
                int D10B75 = DataCanbus.DATA[171];
                int D10B31 = DataCanbus.DATA[180];
                if (vol2 < 39) {
                    vol2++;
                }
                setCarInfo(((D0B5 << 4) & 16) | ((D0B7 << 6) & 64), vol2, bal2, fad2, bass2, mid2, treb2, D10, D11, D12, (D10B31 & 15) | ((D10B75 << 4) & 240));
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int D0B8 = DataCanbus.DATA[156];
                int D0B9 = DataCanbus.DATA[157];
                int vol3 = DataCanbus.DATA[158];
                int bal3 = DataCanbus.DATA[159];
                int fad3 = DataCanbus.DATA[160];
                int bass3 = DataCanbus.DATA[161];
                int mid3 = DataCanbus.DATA[162];
                int treb3 = DataCanbus.DATA[163];
                int D13 = DataCanbus.DATA[168];
                int D14 = DataCanbus.DATA[169];
                int D15 = DataCanbus.DATA[170];
                int D10B76 = DataCanbus.DATA[171];
                int D10B32 = DataCanbus.DATA[180];
                if (bal3 > 0) {
                    bal3--;
                }
                setCarInfo(((D0B9 << 4) & 16) | ((D0B8 << 6) & 64), vol3, bal3, fad3, bass3, mid3, treb3, D13, D14, D15, (D10B32 & 15) | ((D10B76 << 4) & 240));
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int D0B10 = DataCanbus.DATA[156];
                int D0B11 = DataCanbus.DATA[157];
                int vol4 = DataCanbus.DATA[158];
                int bal4 = DataCanbus.DATA[159];
                int fad4 = DataCanbus.DATA[160];
                int bass4 = DataCanbus.DATA[161];
                int mid4 = DataCanbus.DATA[162];
                int treb4 = DataCanbus.DATA[163];
                int D16 = DataCanbus.DATA[168];
                int D17 = DataCanbus.DATA[169];
                int D18 = DataCanbus.DATA[170];
                int D10B77 = DataCanbus.DATA[171];
                int D10B33 = DataCanbus.DATA[180];
                if (bal4 < 20) {
                    bal4++;
                }
                setCarInfo(((D0B11 << 4) & 16) | ((D0B10 << 6) & 64), vol4, bal4, fad4, bass4, mid4, treb4, D16, D17, D18, (D10B33 & 15) | ((D10B77 << 4) & 240));
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int D0B12 = DataCanbus.DATA[156];
                int D0B13 = DataCanbus.DATA[157];
                int vol5 = DataCanbus.DATA[158];
                int bal5 = DataCanbus.DATA[159];
                int fad5 = DataCanbus.DATA[160];
                int bass5 = DataCanbus.DATA[161];
                int mid5 = DataCanbus.DATA[162];
                int treb5 = DataCanbus.DATA[163];
                int D19 = DataCanbus.DATA[168];
                int D20 = DataCanbus.DATA[169];
                int D21 = DataCanbus.DATA[170];
                int D10B78 = DataCanbus.DATA[171];
                int D10B34 = DataCanbus.DATA[180];
                if (fad5 > 0) {
                    fad5--;
                }
                setCarInfo(((D0B13 << 4) & 16) | ((D0B12 << 6) & 64), vol5, bal5, fad5, bass5, mid5, treb5, D19, D20, D21, (D10B34 & 15) | ((D10B78 << 4) & 240));
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int D0B14 = DataCanbus.DATA[156];
                int D0B15 = DataCanbus.DATA[157];
                int vol6 = DataCanbus.DATA[158];
                int bal6 = DataCanbus.DATA[159];
                int fad6 = DataCanbus.DATA[160];
                int bass6 = DataCanbus.DATA[161];
                int mid6 = DataCanbus.DATA[162];
                int treb6 = DataCanbus.DATA[163];
                int D22 = DataCanbus.DATA[168];
                int D23 = DataCanbus.DATA[169];
                int D24 = DataCanbus.DATA[170];
                int D10B79 = DataCanbus.DATA[171];
                int D10B35 = DataCanbus.DATA[180];
                if (fad6 < 20) {
                    fad6++;
                }
                setCarInfo(((D0B15 << 4) & 16) | ((D0B14 << 6) & 64), vol6, bal6, fad6, bass6, mid6, treb6, D22, D23, D24, (D10B35 & 15) | ((D10B79 << 4) & 240));
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int D0B16 = DataCanbus.DATA[156];
                int D0B17 = DataCanbus.DATA[157];
                int vol7 = DataCanbus.DATA[158];
                int bal7 = DataCanbus.DATA[159];
                int fad7 = DataCanbus.DATA[160];
                int bass7 = DataCanbus.DATA[161];
                int mid7 = DataCanbus.DATA[162];
                int treb7 = DataCanbus.DATA[163];
                int D25 = DataCanbus.DATA[168];
                int D26 = DataCanbus.DATA[169];
                int D27 = DataCanbus.DATA[170];
                int D10B710 = DataCanbus.DATA[171];
                int D10B36 = DataCanbus.DATA[180];
                if (bass7 > 0) {
                    bass7--;
                }
                setCarInfo(((D0B17 << 4) & 16) | ((D0B16 << 6) & 64), vol7, bal7, fad7, bass7, mid7, treb7, D25, D26, D27, (D10B36 & 15) | ((D10B710 << 4) & 240));
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int D0B18 = DataCanbus.DATA[156];
                int D0B19 = DataCanbus.DATA[157];
                int vol8 = DataCanbus.DATA[158];
                int bal8 = DataCanbus.DATA[159];
                int fad8 = DataCanbus.DATA[160];
                int bass8 = DataCanbus.DATA[161];
                int mid8 = DataCanbus.DATA[162];
                int treb8 = DataCanbus.DATA[163];
                int D28 = DataCanbus.DATA[168];
                int D29 = DataCanbus.DATA[169];
                int D30 = DataCanbus.DATA[170];
                int D10B711 = DataCanbus.DATA[171];
                int D10B37 = DataCanbus.DATA[180];
                if (bass8 < maxvalue) {
                    bass8++;
                }
                setCarInfo(((D0B19 << 4) & 16) | ((D0B18 << 6) & 64), vol8, bal8, fad8, bass8, mid8, treb8, D28, D29, D30, (D10B37 & 15) | ((D10B711 << 4) & 240));
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int D0B20 = DataCanbus.DATA[156];
                int D0B21 = DataCanbus.DATA[157];
                int vol9 = DataCanbus.DATA[158];
                int bal9 = DataCanbus.DATA[159];
                int fad9 = DataCanbus.DATA[160];
                int bass9 = DataCanbus.DATA[161];
                int mid9 = DataCanbus.DATA[162];
                int treb9 = DataCanbus.DATA[163];
                int D31 = DataCanbus.DATA[168];
                int D32 = DataCanbus.DATA[169];
                int D33 = DataCanbus.DATA[170];
                int D10B712 = DataCanbus.DATA[171];
                int D10B38 = DataCanbus.DATA[180];
                if (mid9 > 0) {
                    mid9--;
                }
                setCarInfo(((D0B21 << 4) & 16) | ((D0B20 << 6) & 64), vol9, bal9, fad9, bass9, mid9, treb9, D31, D32, D33, (D10B38 & 15) | ((D10B712 << 4) & 240));
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int D0B22 = DataCanbus.DATA[156];
                int D0B23 = DataCanbus.DATA[157];
                int vol10 = DataCanbus.DATA[158];
                int bal10 = DataCanbus.DATA[159];
                int fad10 = DataCanbus.DATA[160];
                int bass10 = DataCanbus.DATA[161];
                int mid10 = DataCanbus.DATA[162];
                int treb10 = DataCanbus.DATA[163];
                int D34 = DataCanbus.DATA[168];
                int D35 = DataCanbus.DATA[169];
                int D36 = DataCanbus.DATA[170];
                int D10B713 = DataCanbus.DATA[171];
                int D10B39 = DataCanbus.DATA[180];
                if (mid10 < maxvalue) {
                    mid10++;
                }
                setCarInfo(((D0B23 << 4) & 16) | ((D0B22 << 6) & 64), vol10, bal10, fad10, bass10, mid10, treb10, D34, D35, D36, (D10B39 & 15) | ((D10B713 << 4) & 240));
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int D0B24 = DataCanbus.DATA[156];
                int D0B25 = DataCanbus.DATA[157];
                int vol11 = DataCanbus.DATA[158];
                int bal11 = DataCanbus.DATA[159];
                int fad11 = DataCanbus.DATA[160];
                int bass11 = DataCanbus.DATA[161];
                int mid11 = DataCanbus.DATA[162];
                int treb11 = DataCanbus.DATA[163];
                int D37 = DataCanbus.DATA[168];
                int D38 = DataCanbus.DATA[169];
                int D39 = DataCanbus.DATA[170];
                int D10B714 = DataCanbus.DATA[171];
                int D10B310 = DataCanbus.DATA[180];
                if (treb11 > 0) {
                    treb11--;
                }
                setCarInfo(((D0B25 << 4) & 16) | ((D0B24 << 6) & 64), vol11, bal11, fad11, bass11, mid11, treb11, D37, D38, D39, (D10B310 & 15) | ((D10B714 << 4) & 240));
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int D0B26 = DataCanbus.DATA[156];
                int D0B27 = DataCanbus.DATA[157];
                int vol12 = DataCanbus.DATA[158];
                int bal12 = DataCanbus.DATA[159];
                int fad12 = DataCanbus.DATA[160];
                int bass12 = DataCanbus.DATA[161];
                int mid12 = DataCanbus.DATA[162];
                int treb12 = DataCanbus.DATA[163];
                int D40 = DataCanbus.DATA[168];
                int D41 = DataCanbus.DATA[169];
                int D42 = DataCanbus.DATA[170];
                int D10B715 = DataCanbus.DATA[171];
                int D10B311 = DataCanbus.DATA[180];
                if (treb12 < maxvalue) {
                    treb12++;
                }
                setCarInfo(((D0B27 << 4) & 16) | ((D0B26 << 6) & 64), vol12, bal12, fad12, bass12, mid12, treb12, D40, D41, D42, (D10B311 & 15) | ((D10B715 << 4) & 240));
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int D0B28 = DataCanbus.DATA[156];
                int D0B29 = DataCanbus.DATA[157];
                int vol13 = DataCanbus.DATA[158];
                int bal13 = DataCanbus.DATA[159];
                int fad13 = DataCanbus.DATA[160];
                int bass13 = DataCanbus.DATA[161];
                int mid13 = DataCanbus.DATA[162];
                int treb13 = DataCanbus.DATA[163];
                int D43 = DataCanbus.DATA[168];
                int D44 = DataCanbus.DATA[169];
                int D45 = DataCanbus.DATA[170];
                int D10B716 = DataCanbus.DATA[171];
                int D10B312 = DataCanbus.DATA[180];
                if (D43 > 0) {
                    D43--;
                }
                setCarInfo(((D0B29 << 4) & 16) | ((D0B28 << 6) & 64), vol13, bal13, fad13, bass13, mid13, treb13, D43, D44, D45, (D10B312 & 15) | ((D10B716 << 4) & 240));
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int D0B30 = DataCanbus.DATA[156];
                int D0B31 = DataCanbus.DATA[157];
                int vol14 = DataCanbus.DATA[158];
                int bal14 = DataCanbus.DATA[159];
                int fad14 = DataCanbus.DATA[160];
                int bass14 = DataCanbus.DATA[161];
                int mid14 = DataCanbus.DATA[162];
                int treb14 = DataCanbus.DATA[163];
                int D46 = DataCanbus.DATA[168];
                int D47 = DataCanbus.DATA[169];
                int D48 = DataCanbus.DATA[170];
                int D10B717 = DataCanbus.DATA[171];
                int D10B313 = DataCanbus.DATA[180];
                if (D46 < maxvalue) {
                    D46++;
                }
                setCarInfo(((D0B31 << 4) & 16) | ((D0B30 << 6) & 64), vol14, bal14, fad14, bass14, mid14, treb14, D46, D47, D48, (D10B313 & 15) | ((D10B717 << 4) & 240));
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int D0B32 = DataCanbus.DATA[156];
                int D0B33 = DataCanbus.DATA[157];
                int vol15 = DataCanbus.DATA[158];
                int bal15 = DataCanbus.DATA[159];
                int fad15 = DataCanbus.DATA[160];
                int bass15 = DataCanbus.DATA[161];
                int mid15 = DataCanbus.DATA[162];
                int treb15 = DataCanbus.DATA[163];
                int D49 = DataCanbus.DATA[168];
                int D50 = DataCanbus.DATA[169];
                int D51 = DataCanbus.DATA[170];
                int D10B718 = DataCanbus.DATA[171];
                int D10B314 = DataCanbus.DATA[180];
                int D52 = D50 - 1;
                if (D52 < 0) {
                    D52 = 3;
                }
                setCarInfo(((D0B33 << 4) & 16) | ((D0B32 << 6) & 64), vol15, bal15, fad15, bass15, mid15, treb15, D49, D52, D51, (D10B314 & 15) | ((D10B718 << 4) & 240));
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int D0B34 = DataCanbus.DATA[156];
                int D0B35 = DataCanbus.DATA[157];
                int vol16 = DataCanbus.DATA[158];
                int bal16 = DataCanbus.DATA[159];
                int fad16 = DataCanbus.DATA[160];
                int bass16 = DataCanbus.DATA[161];
                int mid16 = DataCanbus.DATA[162];
                int treb16 = DataCanbus.DATA[163];
                int D53 = DataCanbus.DATA[168];
                int D54 = DataCanbus.DATA[169];
                int D55 = DataCanbus.DATA[170];
                int D10B719 = DataCanbus.DATA[171];
                int D10B315 = DataCanbus.DATA[180];
                int D56 = D54 + 1;
                if (D56 > 3) {
                    D56 = 0;
                }
                setCarInfo(((D0B35 << 4) & 16) | ((D0B34 << 6) & 64), vol16, bal16, fad16, bass16, mid16, treb16, D53, D56, D55, (D10B315 & 15) | ((D10B719 << 4) & 240));
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int D0B36 = DataCanbus.DATA[156];
                int D0B37 = DataCanbus.DATA[157];
                int vol17 = DataCanbus.DATA[158];
                int bal17 = DataCanbus.DATA[159];
                int fad17 = DataCanbus.DATA[160];
                int bass17 = DataCanbus.DATA[161];
                int mid17 = DataCanbus.DATA[162];
                int treb17 = DataCanbus.DATA[163];
                int D57 = DataCanbus.DATA[168];
                int D58 = DataCanbus.DATA[169];
                int D59 = DataCanbus.DATA[170];
                int D10B720 = DataCanbus.DATA[171];
                int D10B316 = DataCanbus.DATA[180];
                int D60 = D59 - 1;
                if (D60 < 0) {
                    D60 = 3;
                }
                setCarInfo(((D0B37 << 4) & 16) | ((D0B36 << 6) & 64), vol17, bal17, fad17, bass17, mid17, treb17, D57, D58, D60, (D10B316 & 15) | ((D10B720 << 4) & 240));
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int D0B38 = DataCanbus.DATA[156];
                int D0B39 = DataCanbus.DATA[157];
                int vol18 = DataCanbus.DATA[158];
                int bal18 = DataCanbus.DATA[159];
                int fad18 = DataCanbus.DATA[160];
                int bass18 = DataCanbus.DATA[161];
                int mid18 = DataCanbus.DATA[162];
                int treb18 = DataCanbus.DATA[163];
                int D61 = DataCanbus.DATA[168];
                int D62 = DataCanbus.DATA[169];
                int D63 = DataCanbus.DATA[170];
                int D10B721 = DataCanbus.DATA[171];
                int D10B317 = DataCanbus.DATA[180];
                int D64 = D63 + 1;
                if (D64 > 3) {
                    D64 = 0;
                }
                setCarInfo(((D0B39 << 4) & 16) | ((D0B38 << 6) & 64), vol18, bal18, fad18, bass18, mid18, treb18, D61, D62, D64, (D10B317 & 15) | ((D10B721 << 4) & 240));
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int D0B40 = DataCanbus.DATA[156];
                int D0B41 = DataCanbus.DATA[157];
                int vol19 = DataCanbus.DATA[158];
                int bal19 = DataCanbus.DATA[159];
                int fad19 = DataCanbus.DATA[160];
                int bass19 = DataCanbus.DATA[161];
                int mid19 = DataCanbus.DATA[162];
                int treb19 = DataCanbus.DATA[163];
                int D65 = DataCanbus.DATA[168];
                int D66 = DataCanbus.DATA[169];
                int D67 = DataCanbus.DATA[170];
                int D10B722 = DataCanbus.DATA[171];
                int D10B318 = DataCanbus.DATA[180];
                if (D10B722 > 0) {
                    D10B722--;
                }
                setCarInfo(((D0B41 << 4) & 16) | ((D0B40 << 6) & 64), vol19, bal19, fad19, bass19, mid19, treb19, D65, D66, D67, (D10B318 & 15) | ((D10B722 << 4) & 240));
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int D0B42 = DataCanbus.DATA[156];
                int D0B43 = DataCanbus.DATA[157];
                int vol20 = DataCanbus.DATA[158];
                int bal20 = DataCanbus.DATA[159];
                int fad20 = DataCanbus.DATA[160];
                int bass20 = DataCanbus.DATA[161];
                int mid20 = DataCanbus.DATA[162];
                int treb20 = DataCanbus.DATA[163];
                int D68 = DataCanbus.DATA[168];
                int D69 = DataCanbus.DATA[169];
                int D70 = DataCanbus.DATA[170];
                int D10B723 = DataCanbus.DATA[171];
                int D10B319 = DataCanbus.DATA[180];
                if (D10B723 < maxvalue) {
                    D10B723++;
                }
                setCarInfo(((D0B43 << 4) & 16) | ((D0B42 << 6) & 64), vol20, bal20, fad20, bass20, mid20, treb20, D68, D69, D70, (D10B319 & 15) | ((D10B723 << 4) & 240));
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int D0B44 = DataCanbus.DATA[156];
                int D0B45 = DataCanbus.DATA[157];
                int vol21 = DataCanbus.DATA[158];
                int bal21 = DataCanbus.DATA[159];
                int fad21 = DataCanbus.DATA[160];
                int bass21 = DataCanbus.DATA[161];
                int mid21 = DataCanbus.DATA[162];
                int treb21 = DataCanbus.DATA[163];
                int D71 = DataCanbus.DATA[168];
                int D72 = DataCanbus.DATA[169];
                int D73 = DataCanbus.DATA[170];
                int D10B724 = DataCanbus.DATA[171];
                int D10B320 = DataCanbus.DATA[180];
                if (D10B320 > 0) {
                    D10B320--;
                }
                setCarInfo(((D0B45 << 4) & 16) | ((D0B44 << 6) & 64), vol21, bal21, fad21, bass21, mid21, treb21, D71, D72, D73, (D10B320 & 15) | ((D10B724 << 4) & 240));
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int D0B46 = DataCanbus.DATA[156];
                int D0B47 = DataCanbus.DATA[157];
                int vol22 = DataCanbus.DATA[158];
                int bal22 = DataCanbus.DATA[159];
                int fad22 = DataCanbus.DATA[160];
                int bass22 = DataCanbus.DATA[161];
                int mid22 = DataCanbus.DATA[162];
                int treb22 = DataCanbus.DATA[163];
                int D74 = DataCanbus.DATA[168];
                int D75 = DataCanbus.DATA[169];
                int D76 = DataCanbus.DATA[170];
                int D10B725 = DataCanbus.DATA[171];
                int D10B321 = DataCanbus.DATA[180];
                if (D10B321 < maxvalue) {
                    D10B321++;
                }
                setCarInfo(((D0B47 << 4) & 16) | ((D0B46 << 6) & 64), vol22, bal22, fad22, bass22, mid22, treb22, D74, D75, D76, (D10B321 & 15) | ((D10B725 << 4) & 240));
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int D0B48 = DataCanbus.DATA[156];
                int D0B49 = DataCanbus.DATA[157];
                int vol23 = DataCanbus.DATA[158];
                int bal23 = DataCanbus.DATA[159];
                int fad23 = DataCanbus.DATA[160];
                int bass23 = DataCanbus.DATA[161];
                int mid23 = DataCanbus.DATA[162];
                int treb23 = DataCanbus.DATA[163];
                int D77 = DataCanbus.DATA[168];
                int D78 = DataCanbus.DATA[169];
                int D79 = DataCanbus.DATA[170];
                int D10B726 = DataCanbus.DATA[171];
                int D10B322 = DataCanbus.DATA[180];
                if (D0B48 == 1) {
                    D0B48 = 0;
                } else if (D0B48 == 0) {
                    D0B48 = 1;
                }
                setCarInfo(((D0B49 << 4) & 16) | ((D0B48 << 6) & 64), vol23, bal23, fad23, bass23, mid23, treb23, D77, D78, D79, (D10B322 & 15) | ((D10B726 << 4) & 240));
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int D0B50 = DataCanbus.DATA[156];
                int D0B51 = DataCanbus.DATA[157];
                int vol24 = DataCanbus.DATA[158];
                int bal24 = DataCanbus.DATA[159];
                int fad24 = DataCanbus.DATA[160];
                int bass24 = DataCanbus.DATA[161];
                int mid24 = DataCanbus.DATA[162];
                int treb24 = DataCanbus.DATA[163];
                int D80 = DataCanbus.DATA[168];
                int D81 = DataCanbus.DATA[169];
                int D82 = DataCanbus.DATA[170];
                int D10B727 = DataCanbus.DATA[171];
                int D10B323 = DataCanbus.DATA[180];
                if (D0B51 == 1) {
                    D0B51 = 0;
                } else if (D0B51 == 0) {
                    D0B51 = 1;
                }
                setCarInfo(((D0B51 << 4) & 16) | ((D0B50 << 6) & 64), vol24, bal24, fad24, bass24, mid24, treb24, D80, D81, D82, (D10B323 & 15) | ((D10B727 << 4) & 240));
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3, int value4, int value5, int value6, int value7, int value8, int value9, int value10) {
        DataCanbus.PROXY.cmd(3, new int[]{value0, value1, value2, value3, value4, value5, value6, value7, value8, value9, value10}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.notifyCanbus);
    }
}
