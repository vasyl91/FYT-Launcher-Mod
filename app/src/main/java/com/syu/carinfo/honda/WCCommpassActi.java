package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WCCommpassActi extends BaseActivity {
    int iCompassArea = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.WCCommpassActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 47:
                    WCCommpassActi.this.mUpdaterValue2();
                    break;
                case 48:
                    switch (value) {
                        case 1:
                            ((TextView) WCCommpassActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_244_als2);
                            break;
                        default:
                            ((TextView) WCCommpassActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_244_als1);
                            break;
                    }
                case 85:
                    WCCommpassActi.this.updateRightTurnLightTime();
                    break;
                case 91:
                    WCCommpassActi.this.updateA6D61();
                    break;
                case 92:
                    WCCommpassActi.this.updateA6D60();
                    break;
                case 105:
                    WCCommpassActi.this.mUpdaterBackCarWidth();
                    break;
                case 106:
                    WCCommpassActi.this.mUpdaterBackCarView();
                    break;
                case 107:
                    WCCommpassActi.this.mUpdaterAutoGuid();
                    break;
                case 108:
                    WCCommpassActi.this.mUpdaterStaticGuid();
                    break;
                case 112:
                    if (((CheckedTextView) WCCommpassActi.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) WCCommpassActi.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                        break;
                    }
                case 113:
                    if (((CheckedTextView) WCCommpassActi.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) WCCommpassActi.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_15crv_compass);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.WCCommpassActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[48] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(110, new int[]{21, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.WCCommpassActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[48] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(110, new int[]{21, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.WCCommpassActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[47] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(0, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.WCCommpassActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[85] & 255;
                DataCanbus.PROXY.cmd(109, value == 0 ? 1 : 0);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.WCCommpassActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[91] & 255;
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(2, 7, value);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.WCCommpassActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[91] & 255;
                if (value < 3) {
                    value++;
                }
                DataCanbus.PROXY.cmd(2, 7, value);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.WCCommpassActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[92] & 255;
                DataCanbus.PROXY.cmd(2, 8, value == 0 ? 1 : 0);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.WCCommpassActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[105] & 255;
                DataCanbus.PROXY.cmd(110, 13, value == 0 ? 7 : 6);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.WCCommpassActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[106] & 255;
                DataCanbus.PROXY.cmd(110, 13, value == 0 ? 5 : 4);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.WCCommpassActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[107] & 255;
                DataCanbus.PROXY.cmd(110, 13, value == 0 ? 3 : 2);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.WCCommpassActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[108] & 255;
                DataCanbus.PROXY.cmd(110, 13, value == 0 ? 1 : 0);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.WCCommpassActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[112] & 255;
                DataCanbus.PROXY.cmd(110, 17, value == 0 ? 1 : 0);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.WCCommpassActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] & 255;
                DataCanbus.PROXY.cmd(110, 16, value == 0 ? 1 : 0);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterStaticGuid() {
        int value = DataCanbus.DATA[108] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoGuid() {
        int value = DataCanbus.DATA[107] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBackCarView() {
        int value = DataCanbus.DATA[106] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBackCarWidth() {
        int value = DataCanbus.DATA[105] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
        }
        ((TextView) findViewById(R.id.tv_text5)).setText(value == 0 ? R.string.str_17crv_parking_spaces0 : R.string.str_17crv_parking_spaces1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[47] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRightTurnLightTime() {
        int value = DataCanbus.DATA[85] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
        ((TextView) findViewById(R.id.tv_text2)).setText(value == 0 ? "0S" : "2S");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateA6D60() {
        int value = DataCanbus.DATA[92] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
        ((TextView) findViewById(R.id.tv_text4)).setText(value == 0 ? R.string.wc_372_volumestr0 : R.string.wc_372_surroundstr0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateA6D61() {
        int value = DataCanbus.DATA[91] & 255;
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_low);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_middle);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_high);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_372_volumestr0);
                break;
        }
    }
}
