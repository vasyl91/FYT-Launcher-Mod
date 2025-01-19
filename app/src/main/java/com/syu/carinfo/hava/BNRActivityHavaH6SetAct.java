package com.syu.carinfo.hava;

import android.content.Intent;
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

public class BNRActivityHavaH6SetAct extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            int value;
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                    int iDomeDelayValue = DataCanbus.DATA[98] - 1;
                    if (iDomeDelayValue < 0) {
                        iDomeDelayValue = 3;
                    }
                    BNRActivityHavaH6SetAct.this.sendCMD(0, iDomeDelayValue);
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    int iDomeDelayValue2 = DataCanbus.DATA[98] + 1;
                    if (iDomeDelayValue2 > 3) {
                        iDomeDelayValue2 = 0;
                    }
                    BNRActivityHavaH6SetAct.this.sendCMD(0, iDomeDelayValue2);
                    break;
                case R.id.btn_minus2 /* 2131427458 */:
                    int iFollowHomeValue = DataCanbus.DATA[99] - 1;
                    if (iFollowHomeValue < 0) {
                        iFollowHomeValue = 3;
                    }
                    BNRActivityHavaH6SetAct.this.sendCMD(1, iFollowHomeValue);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    int iFollowHomeValue2 = DataCanbus.DATA[99] + 1;
                    if (iFollowHomeValue2 > 3) {
                        iFollowHomeValue2 = 0;
                    }
                    BNRActivityHavaH6SetAct.this.sendCMD(1, iFollowHomeValue2);
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                    int iPowerSave = DataCanbus.DATA[100] - 1;
                    if (iPowerSave < 0) {
                        iPowerSave = 2;
                    }
                    BNRActivityHavaH6SetAct.this.sendCMD(2, iPowerSave);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    int iPowerSave2 = DataCanbus.DATA[100] + 1;
                    if (iPowerSave2 > 2) {
                        iPowerSave2 = 0;
                    }
                    BNRActivityHavaH6SetAct.this.sendCMD(2, iPowerSave2);
                    break;
                case R.id.btn_minus4 /* 2131427464 */:
                case R.id.btn_plus4 /* 2131427466 */:
                    int value2 = DataCanbus.DATA[101];
                    if (value2 == 0) {
                        value2 = 1;
                    } else if (value2 == 1) {
                        value2 = 0;
                    }
                    BNRActivityHavaH6SetAct.this.sendCMD(3, value2);
                    break;
                case R.id.btn_minus5 /* 2131427467 */:
                case R.id.btn_plus5 /* 2131427469 */:
                    if (DataCanbus.DATA[102] == 0) {
                        value = 1;
                    } else {
                        value = 0;
                    }
                    BNRActivityHavaH6SetAct.this.sendCMD(4, value);
                    break;
                case R.id.btn_minus6 /* 2131427470 */:
                case R.id.btn_plus6 /* 2131427472 */:
                    int value3 = DataCanbus.DATA[104];
                    if (value3 == 1) {
                        value3 = 0;
                    } else if (value3 == 0) {
                        value3 = 1;
                    }
                    BNRActivityHavaH6SetAct.this.sendCMD(6, value3);
                    break;
                case R.id.btn_minus7 /* 2131427473 */:
                    int value4 = DataCanbus.DATA[103] - 1;
                    if (value4 < 0) {
                        value4 = 3;
                    }
                    BNRActivityHavaH6SetAct.this.sendCMD(5, value4);
                    break;
                case R.id.btn_plus7 /* 2131427475 */:
                    int value5 = DataCanbus.DATA[103] + 1;
                    if (value5 > 3) {
                        value5 = 0;
                    }
                    BNRActivityHavaH6SetAct.this.sendCMD(5, value5);
                    break;
                case R.id.btn_minus8 /* 2131427476 */:
                case R.id.btn_plus8 /* 2131427478 */:
                    int value6 = DataCanbus.DATA[106];
                    if (value6 == 1) {
                        value6 = 0;
                    } else if (value6 == 0) {
                        value6 = 1;
                    }
                    BNRActivityHavaH6SetAct.this.sendCMD(8, value6);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    BNRActivityHavaH6SetAct.this.updateDomeDelay();
                    break;
                case 99:
                    BNRActivityHavaH6SetAct.this.updateFollowHome();
                    break;
                case 100:
                    BNRActivityHavaH6SetAct.this.updatePowerSave();
                    break;
                case 101:
                    BNRActivityHavaH6SetAct.this.updateRainFall();
                    break;
                case 102:
                    BNRActivityHavaH6SetAct.this.updateFrontLight();
                    break;
                case 103:
                    BNRActivityHavaH6SetAct.this.mUpdaterAntisheftset();
                    break;
                case 104:
                    BNRActivityHavaH6SetAct.this.mUpdaterParkset();
                    break;
                case 105:
                    BNRActivityHavaH6SetAct.this.updateRearViewAuto();
                    break;
                case 106:
                    BNRActivityHavaH6SetAct.this.mUpdaterDoorlockset();
                    break;
                case 107:
                    BNRActivityHavaH6SetAct.this.mUpdaterSeatmemory();
                    break;
                case 109:
                    BNRActivityHavaH6SetAct.this.mUpdaterCetaset();
                    break;
                case 110:
                    BNRActivityHavaH6SetAct.this.mUpdaterCartopset();
                    break;
                case 111:
                    BNRActivityHavaH6SetAct.this.mUpdaterAllterrainset();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_bnr_havalh6set);
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
        setonClick((Button) findViewById(R.id.btn_minus6));
        setonClick((Button) findViewById(R.id.btn_plus6));
        setonClick((Button) findViewById(R.id.btn_minus7));
        setonClick((Button) findViewById(R.id.btn_plus7));
        setonClick((Button) findViewById(R.id.btn_minus8));
        setonClick((Button) findViewById(R.id.btn_plus8));
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[105] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 7;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[107] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 9;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[109] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 11;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[110] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 12;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[111] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 13;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_439_BNR_HAVAL_H8 /* 16318903 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    BNRActivityHavaH6SetAct.this.startActivity(new Intent(BNRActivityHavaH6SetAct.this, (Class<?>) BNRActivityHavaH8SeatSetAct.class));
                }
            });
        }
    }

    
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(0, new int[]{cmd, val}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAllterrainset() {
        int value = DataCanbus.DATA[111];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterCartopset() {
        int value = DataCanbus.DATA[110];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterCetaset() {
        int value = DataCanbus.DATA[109];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterSeatmemory() {
        int value = DataCanbus.DATA[107];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterDoorlockset() {
        int value = DataCanbus.DATA[106];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_unlockall_set);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_unlockdriver_set);
                break;
        }
    }

    
    public void updateRearViewAuto() {
        int value = DataCanbus.DATA[105];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterParkset() {
        int value = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.klc_air_auto);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.klc_air_Manual);
                    break;
            }
        }
    }

    
    public void mUpdaterAntisheftset() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText("10min");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text7)).setText("20min");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text7)).setText("30min");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.off);
                    break;
            }
        }
    }

    
    public void updateFrontLight() {
        int frontlight = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (frontlight == 0) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_frontlight1);
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_frontlight2);
            }
        }
    }

    
    public void updateRainFall() {
        int rainfall = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (rainfall == 0) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_244_rainfall2);
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_244_rainfall1);
            }
        }
    }

    
    public void updateDomeDelay() {
        int domedelay = DataCanbus.DATA[98];
        String str = "";
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (domedelay) {
                case 0:
                    str = "3s";
                    break;
                case 1:
                    str = "10s";
                    break;
                case 2:
                    str = "20s";
                    break;
                case 3:
                    str = "30s";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text1)).setText(str);
        }
    }

    
    public void updateFollowHome() {
        int followhome = DataCanbus.DATA[99];
        String str = "";
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (followhome) {
                case 0:
                    str = "30s";
                    break;
                case 1:
                    str = "1min";
                    break;
                case 2:
                    str = "2min";
                    break;
                case 3:
                    str = "3min";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text2)).setText(str);
        }
    }

    
    public void updatePowerSave() {
        int powersave = DataCanbus.DATA[100];
        String str = "";
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (powersave) {
                case 0:
                    str = "10min";
                    break;
                case 1:
                    str = "20min";
                    break;
                case 2:
                    str = "30min";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text3)).setText(str);
        }
    }
}
