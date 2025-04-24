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

@SuppressWarnings({"deprecation", "unchecked"})
public class Activity439Hava18H6SetAct extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
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
                case R.id.btn_minus1 /* 2131427455 */:
                    int iDomeDelayValue3 = DataCanbus.DATA[101];
                    if (iDomeDelayValue3 <= 1) {
                        iDomeDelayValue2 = 4;
                    } else {
                        iDomeDelayValue2 = iDomeDelayValue3 - 1;
                    }
                    Activity439Hava18H6SetAct.this.sendCMD(4, iDomeDelayValue2);
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    int iDomeDelayValue4 = DataCanbus.DATA[101];
                    if (iDomeDelayValue4 > 3) {
                        iDomeDelayValue = 1;
                    } else {
                        iDomeDelayValue = iDomeDelayValue4 + 1;
                    }
                    Activity439Hava18H6SetAct.this.sendCMD(4, iDomeDelayValue);
                    break;
                case R.id.btn_minus2 /* 2131427458 */:
                    int iFollowHomeValue3 = DataCanbus.DATA[102];
                    if (iFollowHomeValue3 <= 1) {
                        iFollowHomeValue2 = 4;
                    } else {
                        iFollowHomeValue2 = iFollowHomeValue3 - 1;
                    }
                    Activity439Hava18H6SetAct.this.sendCMD(5, iFollowHomeValue2);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    int iFollowHomeValue4 = DataCanbus.DATA[102];
                    if (iFollowHomeValue4 > 3) {
                        iFollowHomeValue = 1;
                    } else {
                        iFollowHomeValue = iFollowHomeValue4 + 1;
                    }
                    Activity439Hava18H6SetAct.this.sendCMD(5, iFollowHomeValue);
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                    int iPowerSave3 = DataCanbus.DATA[103];
                    if (iPowerSave3 <= 1) {
                        iPowerSave2 = 3;
                    } else {
                        iPowerSave2 = iPowerSave3 - 1;
                    }
                    Activity439Hava18H6SetAct.this.sendCMD(6, iPowerSave2);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    int iPowerSave4 = DataCanbus.DATA[103];
                    if (iPowerSave4 > 2) {
                        iPowerSave = 1;
                    } else {
                        iPowerSave = iPowerSave4 + 1;
                    }
                    Activity439Hava18H6SetAct.this.sendCMD(6, iPowerSave);
                    break;
                case R.id.btn_minus4 /* 2131427464 */:
                case R.id.btn_plus4 /* 2131427466 */:
                    int iRainFall2 = DataCanbus.DATA[104];
                    if (iRainFall2 == 1) {
                        iRainFall = 2;
                    } else {
                        iRainFall = 1;
                    }
                    Activity439Hava18H6SetAct.this.sendCMD(7, iRainFall);
                    break;
                case R.id.btn_minus5 /* 2131427467 */:
                case R.id.btn_plus5 /* 2131427469 */:
                    int iAls2 = DataCanbus.DATA[131];
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
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 101:
                    Activity439Hava18H6SetAct.this.updateDomeDelay();
                    break;
                case 102:
                    Activity439Hava18H6SetAct.this.updateFollowHome();
                    break;
                case 103:
                    Activity439Hava18H6SetAct.this.updatePowerSave();
                    break;
                case 104:
                    Activity439Hava18H6SetAct.this.updateRainFall();
                    break;
                case 105:
                    Activity439Hava18H6SetAct.this.updateRearViewAuto();
                    break;
                case 114:
                    Activity439Hava18H6SetAct.this.updateScreenBright();
                    break;
                case 131:
                    Activity439Hava18H6SetAct.this.updateAls();
                    break;
                case 151:
                    if (((CheckedTextView) Activity439Hava18H6SetAct.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) Activity439Hava18H6SetAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                        break;
                    }
                case 152:
                    if (((CheckedTextView) Activity439Hava18H6SetAct.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) Activity439Hava18H6SetAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_havalh6set);
        init();
    }

    @Override
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
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[105] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 9;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[151] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 11;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[152] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 28;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
    }

    
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateRearViewAuto() {
        int value = DataCanbus.DATA[105];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
        }
    }

    
    public void updateDomeDelay() {
        int domedelay = DataCanbus.DATA[101];
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

    
    public void updateFollowHome() {
        int followhome = DataCanbus.DATA[102];
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

    
    public void updatePowerSave() {
        int powersave = DataCanbus.DATA[103];
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

    
    public void updateRainFall() {
        int rainfall = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (rainfall == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_244_rainfall2);
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_244_rainfall1);
            }
        }
    }

    
    public void updateAls() {
        int als = DataCanbus.DATA[131];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (als == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_als2);
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_als1);
            }
        }
    }

    
    public void updateScreenBright() {
        int bright = DataCanbus.DATA[114];
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
