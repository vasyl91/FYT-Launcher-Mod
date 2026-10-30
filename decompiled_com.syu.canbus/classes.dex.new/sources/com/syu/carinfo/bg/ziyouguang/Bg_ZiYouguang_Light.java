package com.syu.carinfo.bg.ziyouguang;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Bg_ZiYouguang_Light extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Light.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Log.d("LG", "MupdateCode::" + updateCode);
            switch (updateCode) {
                case 100:
                    Bg_ZiYouguang_Light.this.mDaytime_running_lights();
                    break;
                case 101:
                    Bg_ZiYouguang_Light.this.mLock_lights();
                    break;
                case 105:
                    Bg_ZiYouguang_Light.this.mHeadlights_off_delay();
                    break;
                case 106:
                    Bg_ZiYouguang_Light.this.mHeadlights_on_delay();
                    break;
                case 125:
                    Bg_ZiYouguang_Light.this.mRainAutoLight();
                    break;
                case 126:
                    Bg_ZiYouguang_Light.this.mAutoLight();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_light);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 371) {
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
        }
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Light.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[105] * 30;
                if (value2 >= 30) {
                    value = value2 - 30;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Light.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[105] * 30;
                if (value2 < 90) {
                    value = value2 + 30;
                } else {
                    value = 90;
                }
                DataCanbus.PROXY.cmd(2, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Light.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[106] * 30;
                if (value2 >= 30) {
                    value = value2 - 30;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{18, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Light.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[106] * 30;
                if (value2 < 90) {
                    value = value2 + 30;
                } else {
                    value = 90;
                }
                DataCanbus.PROXY.cmd(2, new int[]{18, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Light.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[100];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{19, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Light.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[101];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{20, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Light.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[125];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{16, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Light.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[126];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{17, value}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mDaytime_running_lights() {
        int value = DataCanbus.DATA[100];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mLock_lights() {
        int value = DataCanbus.DATA[101];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mHeadlights_off_delay() {
        int value = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText((value * 30) + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mHeadlights_on_delay() {
        int value = DataCanbus.DATA[106];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText((value * 30) + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mRainAutoLight() {
        int value = DataCanbus.DATA[125];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mAutoLight() {
        int value = DataCanbus.DATA[126];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn == 1);
    }
}
