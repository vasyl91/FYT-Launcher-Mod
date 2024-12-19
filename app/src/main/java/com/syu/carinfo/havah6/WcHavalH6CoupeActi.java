package com.syu.carinfo.havah6;

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
public class WcHavalH6CoupeActi extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                    WcHavalH6CoupeActi.this.mUpdaterValue7();
                    break;
                case 12:
                    WcHavalH6CoupeActi.this.mUpdaterValue6();
                    break;
                case 13:
                    WcHavalH6CoupeActi.this.mUpdaterValue1();
                    break;
                case 14:
                    WcHavalH6CoupeActi.this.mUpdaterValue2();
                    break;
                case 15:
                    WcHavalH6CoupeActi.this.mUpdaterValue3();
                    break;
                case 16:
                    WcHavalH6CoupeActi.this.mUpdaterValue4();
                    break;
                case 17:
                    WcHavalH6CoupeActi.this.mUpdaterValue5();
                    break;
                case 18:
                    WcHavalH6CoupeActi.this.mUpdaterValue8();
                    break;
                case 19:
                    WcHavalH6CoupeActi.this.mUpdaterValue9();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_havalh6_coupe);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[13] & 255) - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[13] & 255) + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[14] & 255) - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[14] & 255) + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[15] & 255) - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{18, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[15] & 255) + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{18, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[16] & 255) - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 1) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{19, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[16] & 255) + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 1) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{19, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[17] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 20;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[12] & 255) - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[12] & 255) + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[11] & 255) - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 1) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[11] & 255) + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 1) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        if ((DataCanbus.DATA[1000] == 262559 || DataCanbus.DATA[1000] == 197023) && findViewById(R.id.wc_ha_com_cal3) != null) {
            findViewById(R.id.wc_ha_com_cal3).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[18] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        if (DataCanbus.DATA[1000] != 131487 && DataCanbus.DATA[1000] != 262559 && DataCanbus.DATA[1000] != 197023 && findViewById(R.id.wc_rearview_auto) != null) {
            findViewById(R.id.wc_rearview_auto).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6CoupeActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[19] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[19] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[18] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[13] & 255;
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText("10s");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText("20s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text1)).setText("30s");
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText("3s");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[14] & 255;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText("1min");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText("2min");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text2)).setText("3min");
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText("30s");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[15] & 255;
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText("20min");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText("30min");
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText("10min");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[16] & 255;
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.light_sense2);
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.light_sense1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[17] & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[12] & 255;
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (value == 3) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_high);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_middle);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_low);
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.off);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[11] & 255;
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.haval_volspeed1);
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.wc_372_surroundstr);
            }
        }
    }
}
