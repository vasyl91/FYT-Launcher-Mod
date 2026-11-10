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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZNewAllFordSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify sNotify = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllFordSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 174:
                    Log.v("zed", "174  rev==alll 11111111111 ints[0]== " + ints[0] + "  ints[1]== " + ints[1] + "  ints[2]== " + ints[2]);
                    if (ints.length >= 2) {
                        int i = ints[1];
                    }
                    break;
            }
        }
    };
    int mileunit = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllFordSetFunc.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    LZNewAllFordSetFunc.this.mileunit = value;
                    break;
                case 104:
                    if (LZNewAllFordSetFunc.this.mileunit == 1) {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "mil");
                    } else {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km");
                    }
                    break;
                case 105:
                    if (LZNewAllFordSetFunc.this.mileunit == 1) {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "mil");
                    } else {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km");
                    }
                    break;
                case 111:
                    if (value == 255) {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text3)).setText("----");
                    } else {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value - 40) + "℃");
                    }
                    break;
                case 112:
                    if (value == 255) {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text4)).setText("----");
                    } else {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 113:
                    if (value == 255) {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text5)).setText("----");
                    } else {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "L");
                    }
                    break;
                case 114:
                    if (value == 255) {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text6)).setText("----");
                    } else {
                        ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + "V");
                    }
                    break;
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
                case 121:
                    ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text8)).setText("800*480_" + (value + 1));
                    break;
                case 122:
                    ((TextView) LZNewAllFordSetFunc.this.findViewById(R.id.tv_text7)).setText("Type" + (value + 1));
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0454_lz_ford_setfunc);
        init();
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        if (readFile("/sys/fytver/fyt_bin_version").contains("Ls18") || readFile("/sys/fytver/fyt_bin_version").contains("Lt18")) {
            DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
            findViewById(R.id.layout_view13).setVisibility(0);
            findViewById(R.id.layout_view14).setVisibility(0);
            findViewById(R.id.layout_view8).setVisibility(8);
            return;
        }
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(0);
    }

    String readFile(String path) {
        String strInfo = "";
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            while (true) {
                String str = br.readLine();
                if (str != null) {
                    sb.append(String.valueOf(str) + "\n");
                } else {
                    br.close();
                    strInfo = sb.toString();
                    return strInfo;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return strInfo;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (readFile("/sys/fytver/fyt_bin_version").contains("Ls18") || readFile("/sys/fytver/fyt_bin_version").contains("Lt18")) {
            DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_minus7 /* 2131427474 */:
                int value2 = DataCanbus.DATA[122] - 1;
                if (value2 < 0) {
                    value2 = 7;
                }
                setCarInfo(245, value2);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value3 = DataCanbus.DATA[122] + 1;
                if (value3 > 7) {
                    value3 = 0;
                }
                setCarInfo(245, value3);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value4 = DataCanbus.DATA[121] - 1;
                if (value4 < 0) {
                    value4 = 7;
                }
                setCarInfo(246, value4);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value5 = DataCanbus.DATA[121] + 1;
                if (value5 > 7) {
                    value5 = 0;
                }
                setCarInfo(246, value5);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value6 = DataCanbus.DATA[118] - 1;
                if (value6 < 0) {
                    value6 = 3;
                }
                setCarInfo(254, value6);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value7 = DataCanbus.DATA[118] + 1;
                if (value7 > 3) {
                    value7 = 0;
                }
                setCarInfo(254, value7);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value8 = DataCanbus.DATA[115];
                if (value8 > 0) {
                    value8--;
                }
                setCarInfo(253, value8);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value9 = DataCanbus.DATA[115];
                if (value9 < 36) {
                    value9++;
                }
                setCarInfo(253, value9);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value10 = DataCanbus.DATA[116];
                if (value10 > 0) {
                    value10--;
                }
                setCarInfo(252, value10);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value11 = DataCanbus.DATA[116];
                if (value11 < 36) {
                    value11++;
                }
                setCarInfo(252, value11);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
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

    @Override // com.syu.canbus.BaseActivity
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
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
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
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
    }
}
