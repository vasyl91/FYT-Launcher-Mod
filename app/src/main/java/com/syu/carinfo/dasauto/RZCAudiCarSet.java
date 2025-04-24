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

@SuppressWarnings({"deprecation", "unchecked"})
public class RZCAudiCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    if (((CheckedTextView) RZCAudiCarSet.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) RZCAudiCarSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                        break;
                    }
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
                case 123:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 124:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 125:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    break;
                case 126:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    break;
                case 127:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    break;
                case 128:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 129:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                    break;
                case 130:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 131:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    break;
                case 132:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
                case 133:
                    ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    break;
                case 134:
                    switch (value) {
                        case 0:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_vertical_parking);
                            break;
                        case 1:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_horizontal_parking);
                            break;
                    }
                case 137:
                    switch (value) {
                        case 1:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text14)).setText("Normal");
                            break;
                        case 2:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text14)).setText("Draw");
                            break;
                    }
                case 138:
                    switch (value) {
                        case 6:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text15)).setText("1280x720@30Hz");
                            break;
                        case 7:
                            ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text15)).setText("1280x720@25Hz");
                            break;
                    }
                case 151:
                    if ((value & 128) != 0) {
                        ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text16)).setText("-" + (256 - value));
                        break;
                    } else {
                        ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 152:
                    if ((value & 128) != 0) {
                        ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text17)).setText("-" + (256 - value));
                        break;
                    } else {
                        ((TextView) RZCAudiCarSet.this.findViewById(R.id.tv_text17)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0051_rzc_audi_settings);
        init();
    }

    @Override
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
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[130];
                if (value > 0) {
                    value--;
                }
                setCarInfo(65, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[130];
                if (value2 < 9) {
                    value2++;
                }
                setCarInfo(65, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[131];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(66, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[131];
                if (value4 < 9) {
                    value4++;
                }
                setCarInfo(66, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[132];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(67, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[132];
                if (value6 < 9) {
                    value6++;
                }
                setCarInfo(67, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[133];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(68, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[133];
                if (value8 < 9) {
                    value8++;
                }
                setCarInfo(68, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[134] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(2, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[134] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(2, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[123];
                if (value11 > 0) {
                    value11--;
                }
                setCarAmpInfo(0, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[123];
                if (value12 < 30) {
                    value12++;
                }
                setCarAmpInfo(0, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[124];
                if (value13 > -9) {
                    value13--;
                }
                setCarAmpInfo(1, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[124];
                if (value14 < 9) {
                    value14++;
                }
                setCarAmpInfo(1, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[125];
                if (value15 > -9) {
                    value15--;
                }
                setCarAmpInfo(2, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[125];
                if (value16 < 9) {
                    value16++;
                }
                setCarAmpInfo(2, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[126];
                if (value17 > -9) {
                    value17--;
                }
                setCarAmpInfo(3, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[126];
                if (value18 < 9) {
                    value18++;
                }
                setCarAmpInfo(3, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[127];
                if (value19 > -9) {
                    value19--;
                }
                setCarAmpInfo(4, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[127];
                if (value20 < 9) {
                    value20++;
                }
                setCarAmpInfo(4, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[128];
                if (value21 > -9) {
                    value21--;
                }
                setCarAmpInfo(5, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[128];
                if (value22 < 9) {
                    value22++;
                }
                setCarAmpInfo(5, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[129];
                if (value23 > 0) {
                    value23--;
                }
                setCarAmpInfo(6, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[129];
                if (value24 < 7) {
                    value24++;
                }
                setCarAmpInfo(6, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[120];
                if (value25 > 0) {
                    value25--;
                }
                setCarInfo1(3, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[120];
                if (value26 < 3) {
                    value26++;
                }
                setCarInfo1(3, value26);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[137] - 1;
                if (value27 < 1) {
                    value27 = 2;
                }
                setCarInfo1(5, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[137] + 1;
                if (value28 > 2) {
                    value28 = 1;
                }
                setCarInfo1(5, value28);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[138] - 1;
                if (value29 < 6) {
                    value29 = 7;
                }
                setCarInfo1(6, value29);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[138] + 1;
                if (value30 > 7) {
                    value30 = 6;
                }
                setCarInfo1(6, value30);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                setCarInfo1(7, 1);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                setCarInfo1(7, 2);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
                setCarInfo1(8, 1);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                setCarInfo1(8, 2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value31 = DataCanbus.DATA[118];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo1(0, value31);
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
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
    }
}
