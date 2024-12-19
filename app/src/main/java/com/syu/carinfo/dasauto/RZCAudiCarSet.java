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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZCAudiCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dasauto.RZCAudiCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 57:
                    if (((CheckedTextView) RZCAudiCarSet.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) RZCAudiCarSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                        break;
                    }
                case 59:
                    switch (value) {
                        case 1:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text13)).setText("Screen 6.5");
                            break;
                        case 2:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text13)).setText("Screen 8.8");
                            break;
                        case 3:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text13)).setText("Screen 10.25");
                            break;
                        default:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text13)).setText("----");
                            break;
                    }
                case 62:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 63:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 64:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    break;
                case 65:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    break;
                case 66:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    break;
                case 67:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 68:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                    break;
                case 69:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 70:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    break;
                case 71:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
                case 72:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    break;
                case 73:
                    switch (value) {
                        case 0:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_vertical_parking);
                            break;
                        case 1:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_horizontal_parking);
                            break;
                    }
                case 76:
                    switch (value) {
                        case 1:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text14)).setText("Normal");
                            break;
                        case 2:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text14)).setText("Draw");
                            break;
                    }
                case 77:
                    switch (value) {
                        case 6:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text15)).setText("1280x720@30Hz");
                            break;
                        case 7:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text15)).setText("1280x720@25Hz");
                            break;
                    }
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[59];
                if (value > 0) {
                    value--;
                }
                setCarInfo1(3, value);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value2 = DataCanbus.DATA[59];
                if (value2 < 3) {
                    value2++;
                }
                setCarInfo1(3, value2);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value3 = DataCanbus.DATA[76] - 1;
                if (value3 < 1) {
                    value3 = 2;
                }
                setCarInfo1(5, value3);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value4 = DataCanbus.DATA[76] + 1;
                if (value4 > 2) {
                    value4 = 1;
                }
                setCarInfo1(5, value4);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value5 = DataCanbus.DATA[77] - 1;
                if (value5 < 6) {
                    value5 = 7;
                }
                setCarInfo1(6, value5);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value6 = DataCanbus.DATA[77] + 1;
                if (value6 > 7) {
                    value6 = 6;
                }
                setCarInfo1(6, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value7 = DataCanbus.DATA[57];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo1(0, value7);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value8 = DataCanbus.DATA[69];
                if (value8 > 0) {
                    value8--;
                }
                setCarInfo(65, value8);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value9 = DataCanbus.DATA[69];
                if (value9 < 9) {
                    value9++;
                }
                setCarInfo(65, value9);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value10 = DataCanbus.DATA[70];
                if (value10 > 0) {
                    value10--;
                }
                setCarInfo(66, value10);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value11 = DataCanbus.DATA[70];
                if (value11 < 9) {
                    value11++;
                }
                setCarInfo(66, value11);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value12 = DataCanbus.DATA[71];
                if (value12 > 0) {
                    value12--;
                }
                setCarInfo(67, value12);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value13 = DataCanbus.DATA[71];
                if (value13 < 9) {
                    value13++;
                }
                setCarInfo(67, value13);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value14 = DataCanbus.DATA[72];
                if (value14 > 0) {
                    value14--;
                }
                setCarInfo(68, value14);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value15 = DataCanbus.DATA[72];
                if (value15 < 9) {
                    value15++;
                }
                setCarInfo(68, value15);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value16 = DataCanbus.DATA[73] - 1;
                if (value16 < 0) {
                    value16 = 1;
                }
                setCarInfo(2, value16);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value17 = DataCanbus.DATA[73] + 1;
                if (value17 > 1) {
                    value17 = 0;
                }
                setCarInfo(2, value17);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value18 = DataCanbus.DATA[62];
                if (value18 > 0) {
                    value18--;
                }
                setCarAmpInfo(0, value18);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value19 = DataCanbus.DATA[62];
                if (value19 < 30) {
                    value19++;
                }
                setCarAmpInfo(0, value19);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value20 = DataCanbus.DATA[63];
                if (value20 > -9) {
                    value20--;
                }
                setCarAmpInfo(1, value20);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value21 = DataCanbus.DATA[63];
                if (value21 < 9) {
                    value21++;
                }
                setCarAmpInfo(1, value21);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value22 = DataCanbus.DATA[64];
                if (value22 > -9) {
                    value22--;
                }
                setCarAmpInfo(2, value22);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value23 = DataCanbus.DATA[64];
                if (value23 < 9) {
                    value23++;
                }
                setCarAmpInfo(2, value23);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value24 = DataCanbus.DATA[65];
                if (value24 > -9) {
                    value24--;
                }
                setCarAmpInfo(3, value24);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value25 = DataCanbus.DATA[65];
                if (value25 < 9) {
                    value25++;
                }
                setCarAmpInfo(3, value25);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value26 = DataCanbus.DATA[66];
                if (value26 > -9) {
                    value26--;
                }
                setCarAmpInfo(4, value26);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value27 = DataCanbus.DATA[66];
                if (value27 < 9) {
                    value27++;
                }
                setCarAmpInfo(4, value27);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value28 = DataCanbus.DATA[67];
                if (value28 > -9) {
                    value28--;
                }
                setCarAmpInfo(5, value28);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value29 = DataCanbus.DATA[67];
                if (value29 < 9) {
                    value29++;
                }
                setCarAmpInfo(5, value29);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value30 = DataCanbus.DATA[68];
                if (value30 > 0) {
                    value30--;
                }
                setCarAmpInfo(6, value30);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value31 = DataCanbus.DATA[68];
                if (value31 < 7) {
                    value31++;
                }
                setCarAmpInfo(6, value31);
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
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
    }
}
