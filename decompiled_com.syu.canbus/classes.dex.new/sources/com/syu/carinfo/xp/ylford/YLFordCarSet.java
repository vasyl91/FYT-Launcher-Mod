package com.syu.carinfo.xp.ylford;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class YLFordCarSet extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 121:
                    YLFordCarSet.this.mTowsystem();
                    break;
                case 122:
                    YLFordCarSet.this.mInformation();
                    break;
                case 123:
                    YLFordCarSet.this.mWarning();
                    break;
                case 124:
                    YLFordCarSet.this.mBrightness();
                    break;
                case 125:
                    YLFordCarSet.this.mUnit();
                    break;
                case 126:
                    YLFordCarSet.this.mVoicemode();
                    break;
                case 127:
                    YLFordCarSet.this.mTurnlight();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0380_xp_yl_carset);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[124] & 255;
                if (value2 == 0) {
                    value = 17;
                } else {
                    value = 16;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[124] & 255;
                if (value2 == 0) {
                    value = 17;
                } else {
                    value = 16;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[125] & 255;
                if (value2 == 0) {
                    value = 15;
                } else {
                    value = 14;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[125] & 255;
                if (value2 == 0) {
                    value = 15;
                } else {
                    value = 14;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.6
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[121] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.7
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[122] & 255;
                if (value2 == 0) {
                    value = 6;
                } else {
                    value = 5;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.8
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[123] & 255;
                if (value2 == 0) {
                    value = 8;
                } else {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[127] & 255;
                if (value2 == 0) {
                    value = 4;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[127] & 255;
                if (value2 == 0) {
                    value = 4;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[126] & 255;
                if (value2 < 4) {
                    value = value2 + 10;
                } else {
                    value = 9;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[126] & 255;
                if (value2 > 0) {
                    value = value2 + 8;
                } else {
                    value = 13;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mTowsystem() {
        int temp = DataCanbus.DATA[121] & 65535;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mInformation() {
        int temp = DataCanbus.DATA[122] & 65535;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mWarning() {
        int temp = DataCanbus.DATA[123] & 65535;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mVoicemode() {
        int temp = DataCanbus.DATA[126] & 65535;
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_onstar_close);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_ylford_set_voice_mode1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_ylford_set_voice_mode2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_ylford_set_voice_mode3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_auto);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mBrightness() {
        int temp = DataCanbus.DATA[124] & 65535;
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_Manual);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_auto);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mTurnlight() {
        int temp = DataCanbus.DATA[127] & 65535;
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.wc_jianianhua_show_turnlights_point_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.wc_jianianhua_show_turnlights_point_1);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUnit() {
        int temp = DataCanbus.DATA[125] & 65535;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_show__metric_unit_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_show__metric_unit_1);
                    break;
            }
        }
    }
}
