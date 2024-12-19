package com.syu.carinfo.honda;

import android.content.Intent;
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
public class RZCCommpassActi extends BaseActivity {
    int iCompassArea = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.RZCCommpassActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 18:
                    RZCCommpassActi.this.mUpdaterValue1();
                    break;
                case 50:
                    RZCCommpassActi.this.mUpdaterValue2();
                    break;
                case 188:
                    switch (value) {
                        case 0:
                            ((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_no_delay);
                            break;
                        case 1:
                            ((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_delay1);
                            break;
                        case 2:
                            ((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_delay2);
                            break;
                        case 3:
                            ((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_delay3);
                            break;
                    }
                case 227:
                    ((CheckedTextView) RZCCommpassActi.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
                case 228:
                    ((CheckedTextView) RZCCommpassActi.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 229:
                    ((CheckedTextView) RZCCommpassActi.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
                    break;
                case 230:
                    ((CheckedTextView) RZCCommpassActi.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
                    break;
                case 231:
                    ((CheckedTextView) RZCCommpassActi.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_xp_honda_compass);
        if (DataCanbus.DATA[1000] != 3014954 && DataCanbus.DATA[1000] != 3080490 && DataCanbus.DATA[1000] != 3932458 && DataCanbus.DATA[1000] != 4194602 && DataCanbus.DATA[1000] != 3997994) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 4260138) {
            findViewById(R.id.layout_view7).setVisibility(0);
        } else {
            findViewById(R.id.layout_view7).setVisibility(8);
        }
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.RZCCommpassActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[188] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(151, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.RZCCommpassActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[188] & 255) + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(151, new int[]{2, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.RZCCommpassActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[227] & 255;
                int value1 = DataCanbus.DATA[228] & 255;
                int value2 = DataCanbus.DATA[229] & 255;
                int value3 = DataCanbus.DATA[230] & 255;
                int value4 = DataCanbus.DATA[231] & 255;
                if (value0 == 0) {
                    value0 = 1;
                } else if (value0 == 1) {
                    value0 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.RZCCommpassActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[227] & 255;
                int value1 = DataCanbus.DATA[228] & 255;
                int value2 = DataCanbus.DATA[229] & 255;
                int value3 = DataCanbus.DATA[230] & 255;
                int value4 = DataCanbus.DATA[231] & 255;
                if (value1 == 0) {
                    value1 = 1;
                } else if (value1 == 1) {
                    value1 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.RZCCommpassActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[227] & 255;
                int value1 = DataCanbus.DATA[228] & 255;
                int value2 = DataCanbus.DATA[229] & 255;
                int value3 = DataCanbus.DATA[230] & 255;
                int value4 = DataCanbus.DATA[231] & 255;
                if (value2 == 0) {
                    value2 = 1;
                } else if (value2 == 1) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.RZCCommpassActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[227] & 255;
                int value1 = DataCanbus.DATA[228] & 255;
                int value2 = DataCanbus.DATA[229] & 255;
                int value3 = DataCanbus.DATA[230] & 255;
                int value4 = DataCanbus.DATA[231] & 255;
                if (value3 == 0) {
                    value3 = 1;
                } else if (value3 == 1) {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.RZCCommpassActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[227] & 255;
                int value1 = DataCanbus.DATA[228] & 255;
                int value2 = DataCanbus.DATA[229] & 255;
                int value3 = DataCanbus.DATA[230] & 255;
                int value4 = DataCanbus.DATA[231] & 255;
                if (value4 == 0) {
                    value4 = 1;
                } else if (value4 == 1) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.RZCCommpassActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(103, null, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_crv_turn_right_enter_camera)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.RZCCommpassActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[50] & 255;
                DataCanbus.PROXY.cmd(104, value == 0 ? 1 : 0);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.RZCCommpassActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int i = DataCanbus.DATA[18] & 255;
                if (RZCCommpassActi.this.iCompassArea <= 0) {
                    RZCCommpassActi.this.iCompassArea = 15;
                } else {
                    RZCCommpassActi rZCCommpassActi = RZCCommpassActi.this;
                    rZCCommpassActi.iCompassArea--;
                }
                if (((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text2)) != null) {
                    ((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(RZCCommpassActi.this.iCompassArea).toString());
                }
                int value = RZCCommpassActi.this.iCompassArea;
                DataCanbus.PROXY.cmd(102, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.RZCCommpassActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int i = DataCanbus.DATA[18] & 255;
                if (RZCCommpassActi.this.iCompassArea >= 15) {
                    RZCCommpassActi.this.iCompassArea = 0;
                } else {
                    RZCCommpassActi.this.iCompassArea++;
                }
                if (((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text2)) != null) {
                    ((TextView) RZCCommpassActi.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(RZCCommpassActi.this.iCompassArea).toString());
                }
                int value = RZCCommpassActi.this.iCompassArea;
                DataCanbus.PROXY.cmd(102, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.RZCCommpassActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent(RZCCommpassActi.this, (Class<?>) Acrivity_RZC_Aodes360Settings.class);
                RZCCommpassActi.this.startActivity(intent);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.RZCCommpassActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent(RZCCommpassActi.this, (Class<?>) Acrivity_RZC_Yage23_AmbientSettings.class);
                RZCCommpassActi.this.startActivity(intent);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.RZCCommpassActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent(RZCCommpassActi.this, (Class<?>) Acrivity_RZC_17CRVSettings.class);
                RZCCommpassActi.this.startActivity(intent);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        init();
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[18] & 255;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[50] & 255;
        if (((CheckedTextView) findViewById(R.id.xp_crv_turn_right_enter_camera)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_crv_turn_right_enter_camera)).setChecked(value == 1);
        }
    }
}
