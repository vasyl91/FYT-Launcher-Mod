package com.syu.carinfo.wc.ziyouguang;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Wc_372_SafeyActi2 extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int temp = DataCanbus.DATA[updateCode] & 65535;
            switch (updateCode) {
                case 165:
                    Wc_372_SafeyActi2.this.mTx1();
                    break;
                case 166:
                    Wc_372_SafeyActi2.this.mTx2();
                    break;
                case 167:
                    Wc_372_SafeyActi2.this.mTx3();
                    break;
                case 168:
                    Wc_372_SafeyActi2.this.mTx4();
                    break;
                case 169:
                    Wc_372_SafeyActi2.this.mCtv1();
                    break;
                case 170:
                    Wc_372_SafeyActi2.this.mCtv2();
                    break;
                case 171:
                    Wc_372_SafeyActi2.this.mCtv3();
                    break;
                case 221:
                    int switchOn = temp & 255;
                    int enable = (temp & 65280) >> 8;
                    Wc_372_SafeyActi2.this.findViewById(R.id.layout_view10).setVisibility(enable != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_SafeyActi2.this.findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn == 1);
                    break;
                case 222:
                    int switchOn2 = temp & 255;
                    int enable2 = (temp & 65280) >> 8;
                    Wc_372_SafeyActi2.this.findViewById(R.id.layout_view8).setVisibility(enable2 != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_SafeyActi2.this.findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn2 == 1);
                    break;
                case 223:
                    int switchOn3 = temp & 255;
                    int enable3 = (temp & 65280) >> 8;
                    Wc_372_SafeyActi2.this.findViewById(R.id.layout_view9).setVisibility(enable3 != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_SafeyActi2.this.findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn3 == 1);
                    break;
                case 224:
                    int switchOn4 = temp & 255;
                    int enable4 = (temp & 65280) >> 8;
                    Wc_372_SafeyActi2.this.findViewById(R.id.layout_view11).setVisibility(enable4 != 0 ? 0 : 8);
                    if (switchOn4 == 0) {
                        ((TextView) Wc_372_SafeyActi2.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_forwardcollisionwarn_0);
                    } else if (switchOn4 == 1) {
                        ((TextView) Wc_372_SafeyActi2.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_forwardcollisionwarn_1);
                    } else if (switchOn4 == 2) {
                        ((TextView) Wc_372_SafeyActi2.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                    }
                    break;
                case 232:
                    int switchOn5 = temp & 255;
                    int enable5 = (temp & 65280) >> 8;
                    Wc_372_SafeyActi2.this.findViewById(R.id.layout_view12).setVisibility(enable5 != 0 ? 0 : 8);
                    if (switchOn5 == 0) {
                        ((TextView) Wc_372_SafeyActi2.this.findViewById(R.id.tv_text6)).setText(R.string.str_driving_normal);
                    } else if (switchOn5 == 1) {
                        ((TextView) Wc_372_SafeyActi2.this.findViewById(R.id.tv_text6)).setText(R.string.str_driving_sport);
                    } else if (switchOn5 == 2) {
                        ((TextView) Wc_372_SafeyActi2.this.findViewById(R.id.tv_text6)).setText(R.string.str_driving_comfort);
                    }
                    break;
                case 233:
                    int switchOn6 = temp & 255;
                    int enable6 = (temp & 65280) >> 8;
                    Wc_372_SafeyActi2.this.findViewById(R.id.layout_view13).setVisibility(enable6 != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_SafeyActi2.this.findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn6 == 1);
                    break;
                case 271:
                    int switchOn7 = temp & 255;
                    int enable7 = (temp & 65280) >> 8;
                    Wc_372_SafeyActi2.this.findViewById(R.id.layout_view14).setVisibility(enable7 != 0 ? 0 : 8);
                    if (switchOn7 == 0) {
                        ((TextView) Wc_372_SafeyActi2.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_auto);
                    } else if (switchOn7 == 1) {
                        ((TextView) Wc_372_SafeyActi2.this.findViewById(R.id.tv_text7)).setText("MAX(12m)");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_372_zyg_safetyassist2);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[165] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{19, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[165] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{19, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[166] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{20, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[166] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{20, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[167] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{21, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[167] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{21, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[168] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{22, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[168] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{22, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[224] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{28, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[224] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{28, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[232] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{31, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[232] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{31, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[271] & 255) - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{39, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[271] & 255) + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{39, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[169] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 23;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[170] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 24;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[171] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 25;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[222] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 26;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[223] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 27;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[221] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 29;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi2.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[233] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 32;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
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
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[271].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[271].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
    }

    protected void mCtv3() {
        int temp = DataCanbus.DATA[171] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view7).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn == 1);
    }

    protected void mCtv2() {
        int temp = DataCanbus.DATA[170] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view6).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn == 1);
    }

    protected void mCtv1() {
        int temp = DataCanbus.DATA[169] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view5).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mTx4() {
        int temp = DataCanbus.DATA[168] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view4).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text4)).setText("low");
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText("mid");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text4)).setText("high");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mTx3() {
        int temp = DataCanbus.DATA[167] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view3).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText("Off");
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText("sound");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText("sound + display");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mTx2() {
        int temp = DataCanbus.DATA[166] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view2).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText("near");
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText("mid");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText("far");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mTx1() {
        int temp = DataCanbus.DATA[165] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view1).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText("Only active braking");
            } else if (value == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText("Off");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText("warn+active braking");
            }
        }
    }
}
