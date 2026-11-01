package com.syu.carinfo.psa_all;

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
public class PSAFuncLightActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.psa_all.PSAFuncLightActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 110:
                    PSAFuncLightActi.this.mUpdaterValue11();
                    break;
                case 111:
                    PSAFuncLightActi.this.mUpdaterValue12();
                    break;
                case 116:
                    PSAFuncLightActi.this.mUpdaterValue8();
                    break;
                case 117:
                    PSAFuncLightActi.this.mUpdaterValue13();
                    break;
                case 119:
                    PSAFuncLightActi.this.mUpdaterValue9();
                    break;
                case 121:
                    PSAFuncLightActi.this.mUpdaterValue10();
                    break;
                case 124:
                    PSAFuncLightActi.this.mUpdaterValue4();
                    break;
                case 125:
                    PSAFuncLightActi.this.mUpdaterValue5();
                    break;
                case 126:
                    PSAFuncLightActi.this.mUpdaterValue6();
                    break;
                case 132:
                    PSAFuncLightActi.this.mUpdaterValue1();
                    break;
                case 133:
                    PSAFuncLightActi.this.mUpdaterValue7();
                    break;
                case 135:
                    PSAFuncLightActi.this.mUpdaterValue2();
                    break;
                case 137:
                    PSAFuncLightActi.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_psa_all_func_light);
        registerListener();
    }

    public void registerListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSAFuncLightActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[132];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(13, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSAFuncLightActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[135];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(22, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSAFuncLightActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[137];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(25, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSAFuncLightActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[124] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(16, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSAFuncLightActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[124] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(16, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSAFuncLightActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value1;
                int value2 = DataCanbus.DATA[125];
                if (value2 == 0) {
                    value1 = 1;
                } else {
                    value1 = 0;
                }
                int value3 = DataCanbus.DATA[126];
                int value = (value1 << 7) | value3;
                DataCanbus.PROXY.cmd(26, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSAFuncLightActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value1 = DataCanbus.DATA[125];
                int value2 = DataCanbus.DATA[126] - 1;
                if (value2 < 0) {
                    value2 = 0;
                } else if (value2 > 6) {
                    value2 = 6;
                }
                int value = (value1 << 7) | value2;
                DataCanbus.PROXY.cmd(17, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSAFuncLightActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value1 = DataCanbus.DATA[125];
                int value2 = DataCanbus.DATA[126] + 1;
                if (value2 < 0) {
                    value2 = 0;
                } else if (value2 > 6) {
                    value2 = 6;
                }
                int value = (value1 << 7) | value2;
                DataCanbus.PROXY.cmd(17, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSAFuncLightActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[133] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(14, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSAFuncLightActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[133] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(14, new int[]{value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[132];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[135];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[137];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[124];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText("15s");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText("30s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text1)).setText("60s");
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.off);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[125];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[126];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[133];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText("15s");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText("30s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text3)).setText("60s");
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.off);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[116];
        if (findViewById(R.id.layout_view1) != null) {
            if (value == 1) {
                findViewById(R.id.layout_view1).setVisibility(0);
            } else {
                findViewById(R.id.layout_view1).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[119];
        if (findViewById(R.id.layout_view2) != null) {
            if (value == 1) {
                findViewById(R.id.layout_view2).setVisibility(0);
            } else {
                findViewById(R.id.layout_view2).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue10() {
        int value = DataCanbus.DATA[121];
        if (findViewById(R.id.layout_view3) != null) {
            if (value == 1) {
                findViewById(R.id.layout_view3).setVisibility(0);
            } else {
                findViewById(R.id.layout_view3).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue11() {
        int value = DataCanbus.DATA[110];
        if (findViewById(R.id.layout_view4) != null) {
            if (value == 1) {
                findViewById(R.id.layout_view4).setVisibility(0);
            } else {
                findViewById(R.id.layout_view4).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue12() {
        int value = DataCanbus.DATA[111];
        if (findViewById(R.id.layout_view5) != null) {
            if (value == 1) {
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
            } else {
                findViewById(R.id.layout_view5).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue13() {
        int value = DataCanbus.DATA[117];
        if (findViewById(R.id.layout_view7) != null) {
            if (value == 1) {
                findViewById(R.id.layout_view7).setVisibility(0);
            } else {
                findViewById(R.id.layout_view7).setVisibility(8);
            }
        }
    }
}
