package com.syu.carinfo.rzc.biaozhi408;

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
public class RZC_BZ408AmpSettingAct extends BaseActivity implements View.OnClickListener {
    int AmpType = 1;
    int cntvalue = 7;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408AmpSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 237:
                    if (((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > RZC_BZ408AmpSettingAct.this.cntvalue) {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text1)).setText("+" + (value - RZC_BZ408AmpSettingAct.this.cntvalue));
                        } else if (value < RZC_BZ408AmpSettingAct.this.cntvalue) {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text1)).setText("-" + (RZC_BZ408AmpSettingAct.this.cntvalue - value));
                        } else {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text1)).setText("0");
                        }
                    }
                    break;
                case 238:
                    if (((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > RZC_BZ408AmpSettingAct.this.cntvalue) {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text2)).setText("+" + (value - RZC_BZ408AmpSettingAct.this.cntvalue));
                        } else if (value < RZC_BZ408AmpSettingAct.this.cntvalue) {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text2)).setText("-" + (RZC_BZ408AmpSettingAct.this.cntvalue - value));
                        } else {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text2)).setText("0");
                        }
                    }
                    break;
                case 239:
                    if (((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > RZC_BZ408AmpSettingAct.this.cntvalue) {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text3)).setText("+" + (value - RZC_BZ408AmpSettingAct.this.cntvalue));
                        } else if (value < RZC_BZ408AmpSettingAct.this.cntvalue) {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text3)).setText("-" + (RZC_BZ408AmpSettingAct.this.cntvalue - value));
                        } else {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text3)).setText("0");
                        }
                    }
                    break;
                case 240:
                    if (((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > RZC_BZ408AmpSettingAct.this.cntvalue) {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text5)).setText("+" + (value - RZC_BZ408AmpSettingAct.this.cntvalue));
                        } else if (value < RZC_BZ408AmpSettingAct.this.cntvalue) {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text5)).setText("-" + (RZC_BZ408AmpSettingAct.this.cntvalue - value));
                        } else {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 241:
                    if (((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > RZC_BZ408AmpSettingAct.this.cntvalue) {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text4)).setText("+" + (value - RZC_BZ408AmpSettingAct.this.cntvalue));
                        } else if (value < RZC_BZ408AmpSettingAct.this.cntvalue) {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text4)).setText("-" + (RZC_BZ408AmpSettingAct.this.cntvalue - value));
                        } else {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
                case 242:
                    ((CheckedTextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 243:
                    ((CheckedTextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 244:
                    if (((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text6)).setText("User");
                                break;
                            case 1:
                                ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text6)).setText("Classical");
                                break;
                            case 2:
                                ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text6)).setText("Jazz-Blues");
                                break;
                            case 3:
                                ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text6)).setText("Pop-Rock");
                                break;
                            case 4:
                                ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text6)).setText("Vocal");
                                break;
                            case 5:
                                ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text6)).setText("Techno");
                                break;
                        }
                    }
                    break;
                case 245:
                    if (((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text7)) != null) {
                        if (value > 3) {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text7)).setText("+" + (value - 3));
                        } else if (value < 3) {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text7)).setText("-" + (3 - value));
                        } else {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text7)).setText("0");
                        }
                    }
                    break;
                case 246:
                    if (((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text8)) != null) {
                        if (value > 3) {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text8)).setText("+" + (value - 3));
                        } else if (value < 3) {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text8)).setText("-" + (3 - value));
                        } else {
                            ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text8)).setText("0");
                        }
                    }
                    break;
                case 247:
                    RZC_BZ408AmpSettingAct.this.AmpType = value;
                    if (((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 2:
                                RZC_BZ408AmpSettingAct.this.cntvalue = 9;
                                ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text9)).setText("Type2");
                                break;
                            default:
                                RZC_BZ408AmpSettingAct.this.cntvalue = 7;
                                ((TextView) RZC_BZ408AmpSettingAct.this.findViewById(R.id.tv_text9)).setText("Type1");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0339_rzc_amp_carsetting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
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
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
        int d7;
        int d5_b6;
        int d5_b7;
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int d0 = DataCanbus.DATA[237];
                int d1 = DataCanbus.DATA[238];
                int d2 = DataCanbus.DATA[239];
                int d3 = DataCanbus.DATA[240];
                int d4 = DataCanbus.DATA[241];
                int d5_b8 = DataCanbus.DATA[242];
                int d5_b9 = DataCanbus.DATA[243];
                int d5_b30 = DataCanbus.DATA[244];
                int d6_b74 = DataCanbus.DATA[245];
                int d6_b30 = DataCanbus.DATA[246];
                int d8 = DataCanbus.DATA[247];
                if (d0 > 0) {
                    d0--;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d0, d1, d2, d3, d4, ((d5_b8 << 7) & 128) | ((d5_b9 << 6) & 64) | (d5_b30 & 15), ((d6_b74 << 4) & 240) | (d6_b30 & 15), d8}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int d5 = DataCanbus.DATA[237];
                int d6 = DataCanbus.DATA[238];
                int d9 = DataCanbus.DATA[239];
                int d10 = DataCanbus.DATA[240];
                int d11 = DataCanbus.DATA[241];
                int d5_b10 = DataCanbus.DATA[242];
                int d5_b11 = DataCanbus.DATA[243];
                int d5_b31 = DataCanbus.DATA[244];
                int d6_b75 = DataCanbus.DATA[245];
                int d6_b31 = DataCanbus.DATA[246];
                int d12 = DataCanbus.DATA[247];
                if (d5 < this.cntvalue * 2) {
                    d5++;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d5, d6, d9, d10, d11, ((d5_b10 << 7) & 128) | ((d5_b11 << 6) & 64) | (d5_b31 & 15), ((d6_b75 << 4) & 240) | (d6_b31 & 15), d12}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int d13 = DataCanbus.DATA[237];
                int d14 = DataCanbus.DATA[238];
                int d15 = DataCanbus.DATA[239];
                int d16 = DataCanbus.DATA[240];
                int d17 = DataCanbus.DATA[241];
                int d5_b12 = DataCanbus.DATA[242];
                int d5_b13 = DataCanbus.DATA[243];
                int d5_b32 = DataCanbus.DATA[244];
                int d6_b76 = DataCanbus.DATA[245];
                int d6_b32 = DataCanbus.DATA[246];
                int d18 = DataCanbus.DATA[247];
                if (d14 > 0) {
                    d14--;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d13, d14, d15, d16, d17, ((d5_b12 << 7) & 128) | ((d5_b13 << 6) & 64) | (d5_b32 & 15), ((d6_b76 << 4) & 240) | (d6_b32 & 15), d18}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int d19 = DataCanbus.DATA[237];
                int d20 = DataCanbus.DATA[238];
                int d21 = DataCanbus.DATA[239];
                int d22 = DataCanbus.DATA[240];
                int d23 = DataCanbus.DATA[241];
                int d5_b14 = DataCanbus.DATA[242];
                int d5_b15 = DataCanbus.DATA[243];
                int d5_b33 = DataCanbus.DATA[244];
                int d6_b77 = DataCanbus.DATA[245];
                int d6_b33 = DataCanbus.DATA[246];
                int d24 = DataCanbus.DATA[247];
                if (d20 < this.cntvalue * 2) {
                    d20++;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d19, d20, d21, d22, d23, ((d5_b14 << 7) & 128) | ((d5_b15 << 6) & 64) | (d5_b33 & 15), ((d6_b77 << 4) & 240) | (d6_b33 & 15), d24}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int d25 = DataCanbus.DATA[237];
                int d26 = DataCanbus.DATA[238];
                int d27 = DataCanbus.DATA[239];
                int d28 = DataCanbus.DATA[240];
                int d29 = DataCanbus.DATA[241];
                int d5_b16 = DataCanbus.DATA[242];
                int d5_b17 = DataCanbus.DATA[243];
                int d5_b34 = DataCanbus.DATA[244];
                int d6_b78 = DataCanbus.DATA[245];
                int d6_b34 = DataCanbus.DATA[246];
                int d30 = DataCanbus.DATA[247];
                if (d27 > 0) {
                    d27--;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d25, d26, d27, d28, d29, ((d5_b16 << 7) & 128) | ((d5_b17 << 6) & 64) | (d5_b34 & 15), ((d6_b78 << 4) & 240) | (d6_b34 & 15), d30}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int d31 = DataCanbus.DATA[237];
                int d32 = DataCanbus.DATA[238];
                int d33 = DataCanbus.DATA[239];
                int d34 = DataCanbus.DATA[240];
                int d35 = DataCanbus.DATA[241];
                int d5_b18 = DataCanbus.DATA[242];
                int d5_b19 = DataCanbus.DATA[243];
                int d5_b35 = DataCanbus.DATA[244];
                int d6_b79 = DataCanbus.DATA[245];
                int d6_b35 = DataCanbus.DATA[246];
                int d36 = DataCanbus.DATA[247];
                if (d33 < this.cntvalue * 2) {
                    d33++;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d31, d32, d33, d34, d35, ((d5_b18 << 7) & 128) | ((d5_b19 << 6) & 64) | (d5_b35 & 15), ((d6_b79 << 4) & 240) | (d6_b35 & 15), d36}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int d37 = DataCanbus.DATA[237];
                int d38 = DataCanbus.DATA[238];
                int d39 = DataCanbus.DATA[239];
                int d40 = DataCanbus.DATA[240];
                int d41 = DataCanbus.DATA[241];
                int d5_b20 = DataCanbus.DATA[242];
                int d5_b21 = DataCanbus.DATA[243];
                int d5_b36 = DataCanbus.DATA[244];
                int d6_b710 = DataCanbus.DATA[245];
                int d6_b36 = DataCanbus.DATA[246];
                int d42 = DataCanbus.DATA[247];
                if (d41 > 0) {
                    d41--;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d37, d38, d39, d40, d41, ((d5_b20 << 7) & 128) | ((d5_b21 << 6) & 64) | (d5_b36 & 15), ((d6_b710 << 4) & 240) | (d6_b36 & 15), d42}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int d43 = DataCanbus.DATA[237];
                int d44 = DataCanbus.DATA[238];
                int d45 = DataCanbus.DATA[239];
                int d46 = DataCanbus.DATA[240];
                int d47 = DataCanbus.DATA[241];
                int d5_b22 = DataCanbus.DATA[242];
                int d5_b23 = DataCanbus.DATA[243];
                int d5_b37 = DataCanbus.DATA[244];
                int d6_b711 = DataCanbus.DATA[245];
                int d6_b37 = DataCanbus.DATA[246];
                int d48 = DataCanbus.DATA[247];
                if (d47 < this.cntvalue * 2) {
                    d47++;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d43, d44, d45, d46, d47, ((d5_b22 << 7) & 128) | ((d5_b23 << 6) & 64) | (d5_b37 & 15), ((d6_b711 << 4) & 240) | (d6_b37 & 15), d48}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int d49 = DataCanbus.DATA[237];
                int d50 = DataCanbus.DATA[238];
                int d51 = DataCanbus.DATA[239];
                int d52 = DataCanbus.DATA[240];
                int d53 = DataCanbus.DATA[241];
                int d5_b24 = DataCanbus.DATA[242];
                int d5_b25 = DataCanbus.DATA[243];
                int d5_b38 = DataCanbus.DATA[244];
                int d6_b712 = DataCanbus.DATA[245];
                int d6_b38 = DataCanbus.DATA[246];
                int d54 = DataCanbus.DATA[247];
                if (d52 > 0) {
                    d52--;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d49, d50, d51, d52, d53, ((d5_b24 << 7) & 128) | ((d5_b25 << 6) & 64) | (d5_b38 & 15), ((d6_b712 << 4) & 240) | (d6_b38 & 15), d54}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int d55 = DataCanbus.DATA[237];
                int d56 = DataCanbus.DATA[238];
                int d57 = DataCanbus.DATA[239];
                int d58 = DataCanbus.DATA[240];
                int d59 = DataCanbus.DATA[241];
                int d5_b26 = DataCanbus.DATA[242];
                int d5_b27 = DataCanbus.DATA[243];
                int d5_b39 = DataCanbus.DATA[244];
                int d6_b713 = DataCanbus.DATA[245];
                int d6_b39 = DataCanbus.DATA[246];
                int d60 = DataCanbus.DATA[247];
                if (d58 < this.cntvalue * 2) {
                    d58++;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d55, d56, d57, d58, d59, ((d5_b26 << 7) & 128) | ((d5_b27 << 6) & 64) | (d5_b39 & 15), ((d6_b713 << 4) & 240) | (d6_b39 & 15), d60}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int d61 = DataCanbus.DATA[237];
                int d62 = DataCanbus.DATA[238];
                int d63 = DataCanbus.DATA[239];
                int d64 = DataCanbus.DATA[240];
                int d65 = DataCanbus.DATA[241];
                int d5_b28 = DataCanbus.DATA[242];
                int d5_b29 = DataCanbus.DATA[243];
                int d5_b310 = DataCanbus.DATA[244];
                int d6_b714 = DataCanbus.DATA[245];
                int d6_b310 = DataCanbus.DATA[246];
                int d66 = DataCanbus.DATA[247];
                if (d5_b310 > 0) {
                    d5_b310--;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d61, d62, d63, d64, d65, ((d5_b28 << 7) & 128) | ((d5_b29 << 6) & 64) | (d5_b310 & 15), ((d6_b714 << 4) & 240) | (d6_b310 & 15), d66}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int d67 = DataCanbus.DATA[237];
                int d68 = DataCanbus.DATA[238];
                int d69 = DataCanbus.DATA[239];
                int d70 = DataCanbus.DATA[240];
                int d71 = DataCanbus.DATA[241];
                int d5_b40 = DataCanbus.DATA[242];
                int d5_b41 = DataCanbus.DATA[243];
                int d5_b311 = DataCanbus.DATA[244];
                int d6_b715 = DataCanbus.DATA[245];
                int d6_b311 = DataCanbus.DATA[246];
                int d72 = DataCanbus.DATA[247];
                if (d5_b311 < 5) {
                    d5_b311++;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d67, d68, d69, d70, d71, ((d5_b40 << 7) & 128) | ((d5_b41 << 6) & 64) | (d5_b311 & 15), ((d6_b715 << 4) & 240) | (d6_b311 & 15), d72}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int d73 = DataCanbus.DATA[237];
                int d74 = DataCanbus.DATA[238];
                int d75 = DataCanbus.DATA[239];
                int d76 = DataCanbus.DATA[240];
                int d77 = DataCanbus.DATA[241];
                int d5_b42 = DataCanbus.DATA[242];
                int d5_b43 = DataCanbus.DATA[243];
                int d5_b312 = DataCanbus.DATA[244];
                int d6_b716 = DataCanbus.DATA[245];
                int d6_b312 = DataCanbus.DATA[246];
                int d78 = DataCanbus.DATA[247];
                if (d6_b716 > 0) {
                    d6_b716--;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d73, d74, d75, d76, d77, ((d5_b42 << 7) & 128) | ((d5_b43 << 6) & 64) | (d5_b312 & 15), ((d6_b716 << 4) & 240) | (d6_b312 & 15), d78}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int d79 = DataCanbus.DATA[237];
                int d80 = DataCanbus.DATA[238];
                int d81 = DataCanbus.DATA[239];
                int d82 = DataCanbus.DATA[240];
                int d83 = DataCanbus.DATA[241];
                int d5_b44 = DataCanbus.DATA[242];
                int d5_b45 = DataCanbus.DATA[243];
                int d5_b313 = DataCanbus.DATA[244];
                int d6_b717 = DataCanbus.DATA[245];
                int d6_b313 = DataCanbus.DATA[246];
                int d84 = DataCanbus.DATA[247];
                if (d6_b717 < 6) {
                    d6_b717++;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d79, d80, d81, d82, d83, ((d5_b44 << 7) & 128) | ((d5_b45 << 6) & 64) | (d5_b313 & 15), ((d6_b717 << 4) & 240) | (d6_b313 & 15), d84}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int d85 = DataCanbus.DATA[237];
                int d86 = DataCanbus.DATA[238];
                int d87 = DataCanbus.DATA[239];
                int d88 = DataCanbus.DATA[240];
                int d89 = DataCanbus.DATA[241];
                int d5_b46 = DataCanbus.DATA[242];
                int d5_b47 = DataCanbus.DATA[243];
                int d5_b314 = DataCanbus.DATA[244];
                int d6_b718 = DataCanbus.DATA[245];
                int d6_b314 = DataCanbus.DATA[246];
                int d90 = DataCanbus.DATA[247];
                if (d6_b314 > 0) {
                    d6_b314--;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d85, d86, d87, d88, d89, ((d5_b46 << 7) & 128) | ((d5_b47 << 6) & 64) | (d5_b314 & 15), ((d6_b718 << 4) & 240) | (d6_b314 & 15), d90}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int d91 = DataCanbus.DATA[237];
                int d92 = DataCanbus.DATA[238];
                int d93 = DataCanbus.DATA[239];
                int d94 = DataCanbus.DATA[240];
                int d95 = DataCanbus.DATA[241];
                int d5_b48 = DataCanbus.DATA[242];
                int d5_b49 = DataCanbus.DATA[243];
                int d5_b315 = DataCanbus.DATA[244];
                int d6_b719 = DataCanbus.DATA[245];
                int d6_b315 = DataCanbus.DATA[246];
                int d96 = DataCanbus.DATA[247];
                if (d6_b315 < 6) {
                    d6_b315++;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d91, d92, d93, d94, d95, ((d5_b48 << 7) & 128) | ((d5_b49 << 6) & 64) | (d5_b315 & 15), ((d6_b719 << 4) & 240) | (d6_b315 & 15), d96}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
            case R.id.btn_plus9 /* 2131427482 */:
                int d97 = DataCanbus.DATA[237];
                int d98 = DataCanbus.DATA[238];
                int d99 = DataCanbus.DATA[239];
                int d100 = DataCanbus.DATA[240];
                int d101 = DataCanbus.DATA[241];
                int d5_b50 = DataCanbus.DATA[242];
                int d5_b51 = DataCanbus.DATA[243];
                int d5_b316 = DataCanbus.DATA[244];
                int d6_b720 = DataCanbus.DATA[245];
                int d6_b316 = DataCanbus.DATA[246];
                int d102 = DataCanbus.DATA[247];
                if (d102 == 1) {
                    d7 = 2;
                } else {
                    d7 = 1;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d97, d98, d99, d100, d101, ((d5_b50 << 7) & 128) | ((d5_b51 << 6) & 64) | (d5_b316 & 15), ((d6_b720 << 4) & 240) | (d6_b316 & 15), d7}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int d103 = DataCanbus.DATA[237];
                int d104 = DataCanbus.DATA[238];
                int d105 = DataCanbus.DATA[239];
                int d106 = DataCanbus.DATA[240];
                int d107 = DataCanbus.DATA[241];
                int d5_b52 = DataCanbus.DATA[242];
                int d5_b53 = DataCanbus.DATA[243];
                int d5_b317 = DataCanbus.DATA[244];
                int d6_b721 = DataCanbus.DATA[245];
                int d6_b317 = DataCanbus.DATA[246];
                int d108 = DataCanbus.DATA[247];
                if (d5_b52 == 1) {
                    d5_b7 = 0;
                } else {
                    d5_b7 = 1;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d103, d104, d105, d106, d107, ((d5_b7 << 7) & 128) | ((d5_b53 << 6) & 64) | (d5_b317 & 15), ((d6_b721 << 4) & 240) | (d6_b317 & 15), d108}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int d109 = DataCanbus.DATA[237];
                int d110 = DataCanbus.DATA[238];
                int d111 = DataCanbus.DATA[239];
                int d112 = DataCanbus.DATA[240];
                int d113 = DataCanbus.DATA[241];
                int d5_b54 = DataCanbus.DATA[242];
                int d5_b55 = DataCanbus.DATA[243];
                int d5_b318 = DataCanbus.DATA[244];
                int d6_b722 = DataCanbus.DATA[245];
                int d6_b318 = DataCanbus.DATA[246];
                int d114 = DataCanbus.DATA[247];
                if (d5_b55 == 1) {
                    d5_b6 = 0;
                } else {
                    d5_b6 = 1;
                }
                DataCanbus.PROXY.cmd(91, new int[]{d109, d110, d111, d112, d113, ((d5_b54 << 7) & 128) | ((d5_b6 << 6) & 64) | (d5_b318 & 15), ((d6_b722 << 4) & 240) | (d6_b318 & 15), d114}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[243].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[244].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[245].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[246].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[247].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[243].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[244].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[245].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[246].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[247].removeNotify(this.mNotifyCanbus);
    }
}
