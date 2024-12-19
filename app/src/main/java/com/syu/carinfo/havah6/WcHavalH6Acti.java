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
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WcHavalH6Acti extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.havah6.WcHavalH6Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 0:
                    WcHavalH6Acti.this.mUpdaterValue2();
                    break;
                case 1:
                    WcHavalH6Acti.this.mUpdaterValue1();
                    break;
                case 2:
                    WcHavalH6Acti.this.mUpdaterValue3();
                    break;
                case 111:
                    if (((TextView) WcHavalH6Acti.this.findViewById(R.id.tv_text4)) != null) {
                        if (value == 1) {
                            ((TextView) WcHavalH6Acti.this.findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                        } else if (value == 2) {
                            ((TextView) WcHavalH6Acti.this.findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Remote_control_latch_speaker);
                            break;
                        } else if (value == 3) {
                            ((TextView) WcHavalH6Acti.this.findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                        } else {
                            ((TextView) WcHavalH6Acti.this.findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                        }
                    }
                    break;
                case 112:
                    if (((CheckedTextView) WcHavalH6Acti.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) WcHavalH6Acti.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_havalh6);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WeiChi2_Changcheng_Jingangpao /* 1376576 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_Jingangpao_H /* 1442112 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                break;
        }
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6Acti.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[111] - 1;
                if (value < 1) {
                    value = 1;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(9, 3, value);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6Acti.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[111] + 1;
                if (value < 1) {
                    value = 1;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(9, 3, value);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6Acti.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[112];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 4;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(9, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6Acti.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[1] - 1;
                if (value < 1) {
                    value = 1;
                } else if (value > 4) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(2, value);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6Acti.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[1] + 1;
                if (value < 1) {
                    value = 1;
                } else if (value > 4) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(2, value);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6Acti.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[0] - 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WeiChi2_Changcheng_Jingangpao /* 1376576 */:
                    case FinalCanbus.CAR_WeiChi2_ChangCheng_Jingangpao_H /* 1442112 */:
                        if (value >= 1) {
                            if (value > 5) {
                                value = 5;
                                break;
                            }
                        } else {
                            value = 1;
                            break;
                        }
                        break;
                    default:
                        if (value < 1) {
                            value = 1;
                            break;
                        } else if (value > 4) {
                            value = 4;
                            break;
                        }
                }
                DataCanbus.PROXY.cmd(1, value);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6Acti.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[0] + 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WeiChi2_Changcheng_Jingangpao /* 1376576 */:
                    case FinalCanbus.CAR_WeiChi2_ChangCheng_Jingangpao_H /* 1442112 */:
                        if (value >= 1) {
                            if (value > 5) {
                                value = 5;
                                break;
                            }
                        } else {
                            value = 1;
                            break;
                        }
                        break;
                    default:
                        if (value < 1) {
                            value = 1;
                            break;
                        } else if (value > 4) {
                            value = 4;
                            break;
                        }
                }
                DataCanbus.PROXY.cmd(1, value);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6Acti.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[2] - 1;
                if (value < 1) {
                    value = 1;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(3, value);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHavalH6Acti.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[2] + 1;
                if (value < 1) {
                    value = 1;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(3, value);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[1];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText("10s");
                return;
            }
            if (value == 3) {
                ((TextView) findViewById(R.id.tv_text1)).setText("20s");
            } else if (value == 4) {
                ((TextView) findViewById(R.id.tv_text1)).setText("30s");
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText("3s");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[0];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_WeiChi2_Changcheng_Jingangpao /* 1376576 */:
                case FinalCanbus.CAR_WeiChi2_ChangCheng_Jingangpao_H /* 1442112 */:
                    if (value == 1) {
                        ((TextView) findViewById(R.id.tv_text2)).setText("30s");
                        break;
                    } else if (value == 2) {
                        ((TextView) findViewById(R.id.tv_text2)).setText("1min");
                        break;
                    } else if (value == 3) {
                        ((TextView) findViewById(R.id.tv_text2)).setText("2min");
                        break;
                    } else if (value == 4) {
                        ((TextView) findViewById(R.id.tv_text2)).setText("3min");
                        break;
                    } else if (value == 5) {
                        ((TextView) findViewById(R.id.tv_text2)).setText("90s");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_text2)).setText("0s");
                        break;
                    }
                default:
                    if (value == 2) {
                        ((TextView) findViewById(R.id.tv_text2)).setText("1min");
                        break;
                    } else if (value == 3) {
                        ((TextView) findViewById(R.id.tv_text2)).setText("2min");
                        break;
                    } else if (value == 4) {
                        ((TextView) findViewById(R.id.tv_text2)).setText("3min");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_text2)).setText("30s");
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[2];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_WeiChi2_Changcheng_Jingangpao /* 1376576 */:
                case FinalCanbus.CAR_WeiChi2_ChangCheng_Jingangpao_H /* 1442112 */:
                    if (value == 2) {
                        ((TextView) findViewById(R.id.tv_text3)).setText("5min");
                        break;
                    } else if (value == 3) {
                        ((TextView) findViewById(R.id.tv_text3)).setText("8min");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_text3)).setText("2min");
                        break;
                    }
                default:
                    if (value == 2) {
                        ((TextView) findViewById(R.id.tv_text3)).setText("20min");
                        break;
                    } else if (value == 3) {
                        ((TextView) findViewById(R.id.tv_text3)).setText("30min");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_text3)).setText("10min");
                        break;
                    }
            }
        }
    }
}
