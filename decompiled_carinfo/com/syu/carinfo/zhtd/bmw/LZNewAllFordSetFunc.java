package com.syu.carinfo.zhtd.bmw;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZNewAllFordSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify sNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 174:
                    Log.v("zed", "174  rev==alll 11111111111 ints[0]== " + ints[0] + "  ints[1]== " + ints[1] + "  ints[2]== " + ints[2]);
                    if (ints.length >= 2) {
                        int i = ints[1];
                        break;
                    }
            }
        }
    };
    int mileunit = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    LZNewAllFordSetFunc.this.mileunit = value;
                    break;
                case 104:
                    if (LZNewAllFordSetFunc.this.mileunit == 1) {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "mil");
                        break;
                    } else {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km");
                        break;
                    }
                case 105:
                    if (LZNewAllFordSetFunc.this.mileunit == 1) {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "mil");
                        break;
                    } else {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km");
                        break;
                    }
                case 111:
                    if (value == 255) {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text3)).setText("----");
                        break;
                    } else {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value - 40) + "℃");
                        break;
                    }
                case 112:
                    if (value == 255) {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text4)).setText("----");
                        break;
                    } else {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 113:
                    if (value == 255) {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text5)).setText("----");
                        break;
                    } else {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "L");
                        break;
                    }
                case 114:
                    if (value == 255) {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text6)).setText("----");
                        break;
                    } else {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + "V");
                        break;
                    }
                case 115:
                    ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 116:
                    ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 117:
                    ((CheckedTextView) LZNewAllFordSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 118:
                    ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 119:
                case 120:
                    int w = DataCanbus.DATA[119];
                    int h = DataCanbus.DATA[120];
                    ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text12)).setText(String.valueOf(w) + " X " + h);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_lz_ford_setfunc);
        init();
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_minus11 /* 2131427485 */:
                int value2 = DataCanbus.DATA[118] - 1;
                if (value2 < 0) {
                    value2 = 3;
                }
                setCarInfo(254, value2);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value3 = DataCanbus.DATA[118] + 1;
                if (value3 > 3) {
                    value3 = 0;
                }
                setCarInfo(254, value3);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value4 = DataCanbus.DATA[115];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(253, value4);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value5 = DataCanbus.DATA[115];
                if (value5 < 36) {
                    value5++;
                }
                setCarInfo(253, value5);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value6 = DataCanbus.DATA[116];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(252, value6);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value7 = DataCanbus.DATA[116];
                if (value7 < 36) {
                    value7++;
                }
                setCarInfo(252, value7);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[117] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(247, value);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(7, new int[]{41, 2}, null, null);
        DataCanbus.PROXY.cmd(7, new int[]{41, 3}, null, null);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
    }
}
