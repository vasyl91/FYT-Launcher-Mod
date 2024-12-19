package com.syu.carinfo.rzc.havalh6;

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
public class Activity439Hava18H6SetAct extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Activity439Hava18H6SetAct.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            int iAls;
            int iRainFall;
            int iPowerSave;
            int iPowerSave2;
            int iFollowHomeValue;
            int iFollowHomeValue2;
            int iDomeDelayValue;
            int iDomeDelayValue2;
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427480 */:
                    int iDomeDelayValue3 = DataCanbus.DATA[34];
                    if (iDomeDelayValue3 <= 1) {
                        iDomeDelayValue2 = 4;
                    } else {
                        iDomeDelayValue2 = iDomeDelayValue3 - 1;
                    }
                    Activity439Hava18H6SetAct.this.sendCMD(4, iDomeDelayValue2);
                    break;
                case R.id.btn_plus1 /* 2131427482 */:
                    int iDomeDelayValue4 = DataCanbus.DATA[34];
                    if (iDomeDelayValue4 > 3) {
                        iDomeDelayValue = 1;
                    } else {
                        iDomeDelayValue = iDomeDelayValue4 + 1;
                    }
                    Activity439Hava18H6SetAct.this.sendCMD(4, iDomeDelayValue);
                    break;
                case R.id.btn_minus2 /* 2131427484 */:
                    int iFollowHomeValue3 = DataCanbus.DATA[35];
                    if (iFollowHomeValue3 <= 1) {
                        iFollowHomeValue2 = 4;
                    } else {
                        iFollowHomeValue2 = iFollowHomeValue3 - 1;
                    }
                    Activity439Hava18H6SetAct.this.sendCMD(5, iFollowHomeValue2);
                    break;
                case R.id.btn_plus2 /* 2131427486 */:
                    int iFollowHomeValue4 = DataCanbus.DATA[35];
                    if (iFollowHomeValue4 > 3) {
                        iFollowHomeValue = 1;
                    } else {
                        iFollowHomeValue = iFollowHomeValue4 + 1;
                    }
                    Activity439Hava18H6SetAct.this.sendCMD(5, iFollowHomeValue);
                    break;
                case R.id.btn_minus3 /* 2131427488 */:
                    int iPowerSave3 = DataCanbus.DATA[36];
                    if (iPowerSave3 <= 1) {
                        iPowerSave2 = 3;
                    } else {
                        iPowerSave2 = iPowerSave3 - 1;
                    }
                    Activity439Hava18H6SetAct.this.sendCMD(6, iPowerSave2);
                    break;
                case R.id.btn_plus3 /* 2131427490 */:
                    int iPowerSave4 = DataCanbus.DATA[36];
                    if (iPowerSave4 > 2) {
                        iPowerSave = 1;
                    } else {
                        iPowerSave = iPowerSave4 + 1;
                    }
                    Activity439Hava18H6SetAct.this.sendCMD(6, iPowerSave);
                    break;
                case R.id.btn_minus4 /* 2131427492 */:
                case R.id.btn_plus4 /* 2131427494 */:
                    int iRainFall2 = DataCanbus.DATA[37];
                    if (iRainFall2 == 1) {
                        iRainFall = 2;
                    } else {
                        iRainFall = 1;
                    }
                    Activity439Hava18H6SetAct.this.sendCMD(7, iRainFall);
                    break;
                case R.id.btn_minus5 /* 2131427496 */:
                case R.id.btn_plus5 /* 2131427498 */:
                    int iAls2 = DataCanbus.DATA[71];
                    if (iAls2 == 1) {
                        iAls = 2;
                    } else {
                        iAls = 1;
                    }
                    Activity439Hava18H6SetAct.this.sendCMD(8, iAls);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.havalh6.Activity439Hava18H6SetAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 34:
                    Activity439Hava18H6SetAct.this.updateDomeDelay();
                    break;
                case 35:
                    Activity439Hava18H6SetAct.this.updateFollowHome();
                    break;
                case 36:
                    Activity439Hava18H6SetAct.this.updatePowerSave();
                    break;
                case 37:
                    Activity439Hava18H6SetAct.this.updateRainFall();
                    break;
                case 38:
                    Activity439Hava18H6SetAct.this.updateRearViewAuto();
                    break;
                case 47:
                    Activity439Hava18H6SetAct.this.updateScreenBright();
                    break;
                case 71:
                    Activity439Hava18H6SetAct.this.updateAls();
                    break;
                case 83:
                    if (((CheckedTextView) Activity439Hava18H6SetAct.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) Activity439Hava18H6SetAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                        break;
                    }
                case 84:
                    if (((CheckedTextView) Activity439Hava18H6SetAct.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) Activity439Hava18H6SetAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_rzc_havalh6set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus3));
        setonClick((Button) findViewById(R.id.btn_minus4));
        setonClick((Button) findViewById(R.id.btn_plus4));
        setonClick((Button) findViewById(R.id.btn_minus5));
        setonClick((Button) findViewById(R.id.btn_plus5));
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Activity439Hava18H6SetAct.3
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[38] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 9;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Activity439Hava18H6SetAct.4
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[83] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 11;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Activity439Hava18H6SetAct.5
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[84] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 28;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
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
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearViewAuto() {
        int value = DataCanbus.DATA[38];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDomeDelay() {
        int domedelay = DataCanbus.DATA[34];
        String str = "";
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (domedelay) {
                case 1:
                    str = "3s";
                    break;
                case 2:
                    str = "10s";
                    break;
                case 3:
                    str = "20s";
                    break;
                case 4:
                    str = "30s";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text1)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFollowHome() {
        int followhome = DataCanbus.DATA[35];
        String str = "";
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (followhome) {
                case 1:
                    str = "30s";
                    break;
                case 2:
                    str = "1min";
                    break;
                case 3:
                    str = "2min";
                    break;
                case 4:
                    str = "3min";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text2)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePowerSave() {
        int powersave = DataCanbus.DATA[36];
        String str = "";
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (powersave) {
                case 1:
                    str = "10min";
                    break;
                case 2:
                    str = "20min";
                    break;
                case 3:
                    str = "30min";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text3)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRainFall() {
        int rainfall = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (rainfall == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_244_rainfall2);
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_244_rainfall1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAls() {
        int als = DataCanbus.DATA[71];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (als == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_als2);
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_als1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScreenBright() {
        int bright = DataCanbus.DATA[47];
        if (((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)) != null) {
            if (DataCanbus.DATA[1000] == 458996 || DataCanbus.DATA[1000] == 1573108) {
                if (bright <= 15) {
                    ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(R.string.str_244_screenbright);
                    return;
                } else if (bright >= 95) {
                    ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(R.string.str_screen_bright_brightest);
                    return;
                } else {
                    ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(String.format("%d", Integer.valueOf(bright)));
                    return;
                }
            }
            if (bright <= 26) {
                ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(R.string.str_244_screenbright);
            } else if (bright >= 255) {
                ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(R.string.str_screen_bright_brightest);
            } else {
                ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(String.format("%d", Integer.valueOf(bright)));
            }
        }
    }
}
