package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Wc_16Civic_LightActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Wc_16Civic_LightActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 49:
                    Wc_16Civic_LightActi.this.m67D03();
                    break;
                case 50:
                    Wc_16Civic_LightActi.this.m67D00();
                    break;
                case 51:
                    Wc_16Civic_LightActi.this.m67D14();
                    break;
                case 52:
                    Wc_16Civic_LightActi.this.m67D12();
                    break;
                case 53:
                    Wc_16Civic_LightActi.this.m67D10();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_321_civic_light);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_LightActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[49] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(102, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_LightActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[49] & 255;
                if (value2 < 1) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(102, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_LightActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[50] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(102, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_LightActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[50] & 255;
                if (value2 < 4) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(102, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_LightActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[51] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(102, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_LightActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[51] & 255;
                if (value2 < 4) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(102, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_LightActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[52] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(102, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_LightActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[52] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(102, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_LightActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[53] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(102, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_LightActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[53] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(102, new int[]{1, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        if (DataCanbus.DATA[1000] == 328001 || DataCanbus.DATA[1000] == 393537) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
        } else {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m67D03() {
        int temp = DataCanbus.DATA[49] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_close);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_open);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m67D00() {
        int temp = DataCanbus.DATA[50] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_accord9_auto_light_0lowest);
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_accord9_auto_light_1lower);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_accord9_auto_light_2middle);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_accord9_auto_light_3higher);
            } else if (value == 4) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_accord9_auto_light_4highest);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m67D14() {
        int temp = DataCanbus.DATA[51] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_accord9_auto_light_0lowest);
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_accord9_auto_light_1lower);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_accord9_auto_light_2middle);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_accord9_auto_light_3higher);
            } else if (value == 4) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_accord9_auto_light_4highest);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m67D12() {
        int temp = DataCanbus.DATA[52] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text4)).setText("0 S");
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText("15 S");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text4)).setText("30 S");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text4)).setText("60 S");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m67D10() {
        int temp = DataCanbus.DATA[53] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.jeep_playstate11);
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText("15 S");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text5)).setText("30 S");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text5)).setText("60 S");
            }
        }
    }
}
