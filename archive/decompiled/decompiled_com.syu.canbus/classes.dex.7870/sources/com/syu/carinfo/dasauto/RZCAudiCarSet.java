package com.syu.carinfo.dasauto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class RZCAudiCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dasauto.RZCAudiCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    if (((CheckedTextView) RZCAudiCarSet.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) RZCAudiCarSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                    }
                    break;
                case 120:
                    switch (value) {
                        case 1:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text13)).setText("Screen 6.5");
                            break;
                        case 2:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text13)).setText("Screen 7.0");
                            break;
                        case 3:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text13)).setText("Screen 8.3");
                            break;
                        default:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text13)).setText("----");
                            break;
                    }
                    break;
                case 124:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 125:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 126:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    break;
                case 127:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    break;
                case 128:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    break;
                case 129:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 130:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                    break;
                case 131:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 132:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    break;
                case 133:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
                case 134:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    break;
                case 135:
                    switch (value) {
                        case 0:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_vertical_parking);
                            break;
                        case 1:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_horizontal_parking);
                            break;
                    }
                    break;
                case 138:
                    switch (value) {
                        case 1:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text14)).setText("Normal");
                            break;
                        case 2:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text14)).setText("Draw");
                            break;
                    }
                    break;
                case 139:
                    switch (value) {
                        case 4:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text15)).setText("1920x1080@30Hz");
                            break;
                        case 5:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text15)).setText("1920x1080@25Hz");
                            break;
                        case 6:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text15)).setText("1280x720@30Hz");
                            break;
                        case 7:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text15)).setText("1280x720@25Hz");
                            break;
                    }
                    break;
                case 151:
                    if ((value & 128) != 0) {
                        ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text16)).setText("-" + (256 - value));
                    } else {
                        ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 152:
                    if ((value & 128) != 0) {
                        ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text17)).setText("-" + (256 - value));
                    } else {
                        ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text17)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 161:
                    if (value == 2) {
                        ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text18)).setText(R.string.str_android_volume);
                    } else {
                        ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text18)).setText(R.string.str_sbd_x80_yuanche_vol);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0051_rzc_audi_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        setSelfClick((Button) findViewById(R.id.btn_minus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
        setSelfClick((Button) findViewById(R.id.btn_minus18), this);
        setSelfClick((Button) findViewById(R.id.btn_plus18), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[131];
                if (value > 0) {
                    value--;
                }
                setCarInfo(65, value);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[131];
                if (value2 < 9) {
                    value2++;
                }
                setCarInfo(65, value2);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[132];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(66, value3);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[132];
                if (value4 < 9) {
                    value4++;
                }
                setCarInfo(66, value4);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[133];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(67, value5);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[133];
                if (value6 < 9) {
                    value6++;
                }
                setCarInfo(67, value6);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[134];
                if (value7 < 9) {
                    value7++;
                }
                setCarInfo(68, value7);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[135] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(2, value8);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value9 = DataCanbus.DATA[124];
                if (value9 < 30) {
                    value9++;
                }
                setCarAmpInfo(0, value9);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value10 = DataCanbus.DATA[125];
                if (value10 < 9) {
                    value10++;
                }
                setCarAmpInfo(1, value10);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value11 = DataCanbus.DATA[126];
                if (value11 < 9) {
                    value11++;
                }
                setCarAmpInfo(2, value11);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value12 = DataCanbus.DATA[127];
                if (value12 < 9) {
                    value12++;
                }
                setCarAmpInfo(3, value12);
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                int value13 = DataCanbus.DATA[128];
                if (value13 < 9) {
                    value13++;
                }
                setCarAmpInfo(4, value13);
                break;
            case R.id.btn_plus11 /* 2131427435 */:
                int value14 = DataCanbus.DATA[129];
                if (value14 < 9) {
                    value14++;
                }
                setCarAmpInfo(5, value14);
                break;
            case R.id.btn_plus12 /* 2131427436 */:
                int value15 = DataCanbus.DATA[130];
                if (value15 < 7) {
                    value15++;
                }
                setCarAmpInfo(6, value15);
                break;
            case R.id.btn_plus13 /* 2131427437 */:
                int value16 = DataCanbus.DATA[120];
                if (value16 < 3) {
                    value16++;
                }
                setCarInfo1(3, value16);
                break;
            case R.id.btn_plus14 /* 2131427438 */:
                int value17 = DataCanbus.DATA[138] + 1;
                if (value17 > 2) {
                    value17 = 1;
                }
                setCarInfo1(5, value17);
                break;
            case R.id.btn_plus15 /* 2131427439 */:
                int value18 = DataCanbus.DATA[139] + 1;
                if (value18 > 7) {
                    value18 = 4;
                }
                setCarInfo1(6, value18);
                break;
            case R.id.btn_plus16 /* 2131427440 */:
                setCarInfo1(7, 2);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value19 = DataCanbus.DATA[134];
                if (value19 > 0) {
                    value19--;
                }
                setCarInfo(68, value19);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value20 = DataCanbus.DATA[135] - 1;
                if (value20 < 0) {
                    value20 = 1;
                }
                setCarInfo(2, value20);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value21 = DataCanbus.DATA[124];
                if (value21 > 0) {
                    value21--;
                }
                setCarAmpInfo(0, value21);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value22 = DataCanbus.DATA[125];
                if (value22 > -9) {
                    value22--;
                }
                setCarAmpInfo(1, value22);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value23 = DataCanbus.DATA[126];
                if (value23 > -9) {
                    value23--;
                }
                setCarAmpInfo(2, value23);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value24 = DataCanbus.DATA[127];
                if (value24 > -9) {
                    value24--;
                }
                setCarAmpInfo(3, value24);
                break;
            case R.id.btn_minus10 /* 2131427484 */:
                int value25 = DataCanbus.DATA[128];
                if (value25 > -9) {
                    value25--;
                }
                setCarAmpInfo(4, value25);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value26 = DataCanbus.DATA[129];
                if (value26 > -9) {
                    value26--;
                }
                setCarAmpInfo(5, value26);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value27 = DataCanbus.DATA[130];
                if (value27 > 0) {
                    value27--;
                }
                setCarAmpInfo(6, value27);
                break;
            case R.id.btn_minus13 /* 2131427490 */:
                int value28 = DataCanbus.DATA[120];
                if (value28 > 0) {
                    value28--;
                }
                setCarInfo1(3, value28);
                break;
            case R.id.btn_minus14 /* 2131427492 */:
                int value29 = DataCanbus.DATA[138] - 1;
                if (value29 < 1) {
                    value29 = 2;
                }
                setCarInfo1(5, value29);
                break;
            case R.id.btn_minus15 /* 2131427494 */:
                int value30 = DataCanbus.DATA[139] - 1;
                if (value30 < 4) {
                    value30 = 7;
                }
                setCarInfo1(6, value30);
                break;
            case R.id.btn_minus16 /* 2131427496 */:
                setCarInfo1(7, 1);
                break;
            case R.id.btn_minus17 /* 2131427498 */:
                setCarInfo1(8, 1);
                break;
            case R.id.btn_plus17 /* 2131427500 */:
                setCarInfo1(8, 2);
                break;
            case R.id.btn_minus18 /* 2131427501 */:
                int value31 = DataCanbus.DATA[161] - 1;
                if (value31 < 1) {
                    value31 = 2;
                }
                setCarInfo1(9, value31);
                break;
            case R.id.btn_plus18 /* 2131427503 */:
                int value32 = DataCanbus.DATA[161] + 1;
                if (value32 > 2) {
                    value32 = 1;
                }
                setCarInfo1(9, value32);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value33 = DataCanbus.DATA[118];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo1(0, value33);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                DataCanbus.PROXY.cmd(5, new int[]{161}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                DataCanbus.PROXY.cmd(5, new int[]{177}, null, null);
                break;
        }
    }

    public void setCarInfo1(int value1, int value2) {
        DataCanbus.PROXY.cmd(7, new int[]{value1, value2}, null, null);
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(9, new int[]{value1, value2}, null, null);
    }

    public void setCarAmpInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(8, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
    }
}
