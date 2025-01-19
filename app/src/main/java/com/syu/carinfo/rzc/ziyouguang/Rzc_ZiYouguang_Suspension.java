package com.syu.carinfo.rzc.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Rzc_ZiYouguang_Suspension extends Activity implements View.OnClickListener {
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 108:
                    if (((TextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 0) {
                            ((TextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.tv_text2)).setText("0s");
                            break;
                        } else if (value == 1) {
                            ((TextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.tv_text2)).setText("45s");
                            break;
                        } else if (value == 2) {
                            ((TextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.tv_text2)).setText("5Min");
                            break;
                        } else if (value == 3) {
                            ((TextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.tv_text2)).setText("10Min");
                            break;
                        }
                    }
                    break;
                case 146:
                    ((CheckedTextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 147:
                    ((CheckedTextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 148:
                    ((CheckedTextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 149:
                    ((CheckedTextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
                case 150:
                    ((CheckedTextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 183:
                    if (((TextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 1) {
                            ((TextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_sport);
                            break;
                        } else if (value == 2) {
                            ((TextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_comfort);
                            break;
                        } else {
                            ((TextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_normal);
                            break;
                        }
                    }
                    break;
                case 184:
                    ((CheckedTextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
                case 200:
                    ((CheckedTextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 202:
                    if (((TextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 0) {
                            ((TextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.tv_text3)).setText("0s");
                            break;
                        } else if (value == 1) {
                            ((TextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.tv_text3)).setText("45s");
                            break;
                        } else if (value == 2) {
                            ((TextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.tv_text3)).setText("5Min");
                            break;
                        } else if (value == 3) {
                            ((TextView) Rzc_ZiYouguang_Suspension.this.findViewById(R.id.tv_text3)).setText("10Min");
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
        //setContentView(R.layout.layout_jeep_rzc_suspension);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[183] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{70, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[183] - 1;
                if (value2 < 0) {
                    value2 = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{70, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[108];
                switch (value3) {
                    case 0:
                        value3 = 40;
                        break;
                    case 1:
                        value3 = 0;
                        break;
                    case 2:
                        value3 = 3;
                        break;
                    case 3:
                        value3 = 20;
                        break;
                }
                DataCanbus.PROXY.cmd(2, new int[]{50, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[108];
                switch (value4) {
                    case 0:
                        value4 = 3;
                        break;
                    case 1:
                        value4 = 20;
                        break;
                    case 2:
                        value4 = 40;
                        break;
                    case 3:
                        value4 = 0;
                        break;
                }
                DataCanbus.PROXY.cmd(2, new int[]{50, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[202];
                switch (value5) {
                    case 0:
                        value5 = 40;
                        break;
                    case 1:
                        value5 = 0;
                        break;
                    case 2:
                        value5 = 3;
                        break;
                    case 3:
                        value5 = 20;
                        break;
                }
                DataCanbus.PROXY.cmd(2, new int[]{161, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[202];
                switch (value6) {
                    case 0:
                        value6 = 3;
                        break;
                    case 1:
                        value6 = 20;
                        break;
                    case 2:
                        value6 = 40;
                        break;
                    case 3:
                        value6 = 0;
                        break;
                }
                DataCanbus.PROXY.cmd(2, new int[]{161, value6}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value7 = DataCanbus.DATA[146];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 65;
                iArr[1] = value7 == 1 ? 1 : 2;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value8 = DataCanbus.DATA[147];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 66;
                iArr2[1] = value8 == 1 ? 1 : 2;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value9 = DataCanbus.DATA[148];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 67;
                iArr3[1] = value9 == 1 ? 1 : 2;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value10 = DataCanbus.DATA[149];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 68;
                iArr4[1] = value10 == 1 ? 1 : 2;
                remoteModuleProxy4.cmd(2, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value11 = DataCanbus.DATA[150];
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 69;
                iArr5[1] = value11 == 1 ? 1 : 2;
                remoteModuleProxy5.cmd(2, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value12 = DataCanbus.DATA[184];
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 71;
                iArr6[1] = value12 == 1 ? 1 : 2;
                remoteModuleProxy6.cmd(2, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value13 = DataCanbus.DATA[200];
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[2];
                iArr7[0] = 72;
                iArr7[1] = value13 == 1 ? 1 : 2;
                remoteModuleProxy7.cmd(2, iArr7, null, null);
                break;
        }
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

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mCanbusNotify);
    }
}
