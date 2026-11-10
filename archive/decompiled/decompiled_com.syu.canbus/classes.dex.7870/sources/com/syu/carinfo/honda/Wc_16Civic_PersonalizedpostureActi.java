package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Wc_16Civic_PersonalizedpostureActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Wc_16Civic_PersonalizedpostureActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 37:
                    if (((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text3)).setText("℃");
                                break;
                            case 1:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text3)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 159:
                    ((CheckedTextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val == 1);
                    break;
                case 160:
                    ((CheckedTextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.ctv_checkedtext2)).setChecked(val == 1);
                    break;
                case 170:
                    ((CheckedTextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.ctv_checkedtext4)).setChecked(val == 1);
                    break;
                case 171:
                    ((CheckedTextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.ctv_checkedtext5)).setChecked(val == 1);
                    break;
                case 172:
                    if (((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text1)).setText("Type1");
                                break;
                            case 1:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text1)).setText("Type2");
                                break;
                            case 2:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text1)).setText("Type3");
                                break;
                        }
                    }
                    break;
                case 188:
                    ((CheckedTextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.ctv_checkedtext3)).setChecked(val == 1);
                    break;
                case 189:
                    ((CheckedTextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.ctv_checkedtext6)).setChecked(val == 1);
                    break;
                case 190:
                    ((CheckedTextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.ctv_checkedtext7)).setChecked(val == 1);
                    break;
                case 191:
                    ((CheckedTextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.ctv_checkedtext8)).setChecked(val == 1);
                    break;
                case 192:
                    ((CheckedTextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.ctv_checkedtext9)).setChecked(val == 1);
                    break;
                case 193:
                    ((CheckedTextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.ctv_checkedtext10)).setChecked(val == 1);
                    break;
                case 194:
                    if (((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text2)).setText("+0km/h");
                                break;
                            case 1:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text2)).setText("+5km/h");
                                break;
                            case 2:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text2)).setText("+10km/h");
                                break;
                            case 3:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text2)).setText("+15km/h");
                                break;
                        }
                    }
                    break;
                case 196:
                    if (((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text4)).setText("-5℉");
                                break;
                            case 2:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text4)).setText("-4℉");
                                break;
                            case 3:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text4)).setText("-3℉");
                                break;
                            case 4:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text4)).setText("-2℉");
                                break;
                            case 5:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text4)).setText("-1℉");
                                break;
                            case 6:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text4)).setText("0℉");
                                break;
                            case 7:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text4)).setText("+1℉");
                                break;
                            case 8:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text4)).setText("+2℉");
                                break;
                            case 9:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text4)).setText("+3℉");
                                break;
                            case 10:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text4)).setText("+4℉");
                                break;
                            case 11:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text4)).setText("+5℉");
                                break;
                            default:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text4)).setText("--");
                                break;
                        }
                    }
                    break;
                case 197:
                    if (((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text5)).setText("km/h-km");
                                break;
                            case 1:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text5)).setText("mph-miles");
                                break;
                        }
                    }
                    break;
                case 213:
                    if (((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text6)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                                break;
                            case 1:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text6)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                                break;
                        }
                    }
                    break;
                case 224:
                    if (((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text7)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text7)).setText(R.string.str_driving_sport);
                                break;
                            case 2:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text7)).setText(R.string.str_driving_eco);
                                break;
                        }
                    }
                    break;
                case 225:
                    if (((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text8)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text8)).setText(R.string.str_driving_sport);
                                break;
                        }
                    }
                    break;
                case 226:
                    if (((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text9)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text9)).setText(R.string.str_driving_sport);
                                break;
                        }
                    }
                    break;
                case 227:
                    if (((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text10)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text10)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) Wc_16Civic_PersonalizedpostureActi.this.findViewById(R.id.tv_text10)).setText(R.string.str_driving_sport);
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
        setContentView(R.layout.layout_321_civic_driving_posture_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
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
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[172] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(106, new int[]{14, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[172] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(106, new int[]{14, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[194] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                DataCanbus.PROXY.cmd(106, new int[]{23, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[194] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(106, new int[]{23, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[37] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{26, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[37] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(106, new int[]{26, value6}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[196] + 1;
                if (value7 > 11) {
                    value7 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{24, value7}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[197] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(106, new int[]{25, value8}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value9 = DataCanbus.DATA[213] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                DataCanbus.PROXY.cmd(106, new int[]{27, value9}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value10 = DataCanbus.DATA[224] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                DataCanbus.PROXY.cmd(106, new int[]{38, value10}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value11 = DataCanbus.DATA[225] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                DataCanbus.PROXY.cmd(106, new int[]{39, value11}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value12 = DataCanbus.DATA[226] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                DataCanbus.PROXY.cmd(106, new int[]{40, value12}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                int value13 = DataCanbus.DATA[227] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                DataCanbus.PROXY.cmd(106, new int[]{41, value13}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value14 = DataCanbus.DATA[196] - 1;
                if (value14 < 1) {
                    value14 = 11;
                }
                DataCanbus.PROXY.cmd(106, new int[]{24, value14}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value15 = DataCanbus.DATA[197] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{25, value15}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value16 = DataCanbus.DATA[213] - 1;
                if (value16 < 0) {
                    value16 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{27, value16}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value17 = DataCanbus.DATA[224] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                DataCanbus.PROXY.cmd(106, new int[]{38, value17}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value18 = DataCanbus.DATA[225] - 1;
                if (value18 < 0) {
                    value18 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{39, value18}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value19 = DataCanbus.DATA[226] - 1;
                if (value19 < 0) {
                    value19 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{40, value19}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[227] - 1;
                if (value20 < 0) {
                    value20 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{41, value20}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value21 = DataCanbus.DATA[159] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 11;
                iArr[1] = value21 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                int value22 = DataCanbus.DATA[170] & 255;
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 16;
                iArr2[1] = value22 == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(106, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                int value23 = DataCanbus.DATA[171] & 255;
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 15;
                iArr3[1] = value23 == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(106, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int value24 = DataCanbus.DATA[160] & 255;
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 12;
                iArr4[1] = value24 == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(106, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int value25 = DataCanbus.DATA[188] & 255;
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 18;
                iArr5[1] = value25 == 0 ? 1 : 0;
                remoteModuleProxy5.cmd(106, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                int value26 = DataCanbus.DATA[189] & 255;
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 20;
                iArr6[1] = value26 == 0 ? 1 : 0;
                remoteModuleProxy6.cmd(106, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                int value27 = DataCanbus.DATA[190] & 255;
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[2];
                iArr7[0] = 17;
                iArr7[1] = value27 == 0 ? 1 : 0;
                remoteModuleProxy7.cmd(106, iArr7, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427615 */:
                int value28 = DataCanbus.DATA[191] & 255;
                RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                int[] iArr8 = new int[2];
                iArr8[0] = 19;
                iArr8[1] = value28 == 0 ? 1 : 0;
                remoteModuleProxy8.cmd(106, iArr8, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427616 */:
                int value29 = DataCanbus.DATA[192] & 255;
                RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                int[] iArr9 = new int[2];
                iArr9[0] = 21;
                iArr9[1] = value29 == 0 ? 1 : 0;
                remoteModuleProxy9.cmd(106, iArr9, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427617 */:
                int value30 = DataCanbus.DATA[193] & 255;
                RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                int[] iArr10 = new int[2];
                iArr10[0] = 22;
                iArr10[1] = value30 == 0 ? 1 : 0;
                remoteModuleProxy10.cmd(106, iArr10, null, null);
                break;
        }
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
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
    }
}
