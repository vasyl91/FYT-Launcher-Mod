package com.syu.carinfo.bnr;

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
public class Acti_Nissan_Sanwu extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.bnr.Acti_Nissan_Sanwu.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427456 */:
                    Acti_Nissan_Sanwu.this.sendCMD(33, 49);
                    break;
                case R.id.btn_plus1 /* 2131427458 */:
                    Acti_Nissan_Sanwu.this.sendCMD(33, 33);
                    break;
                case R.id.btn_minus2 /* 2131427459 */:
                    Acti_Nissan_Sanwu.this.sendCMD(35, 49);
                    break;
                case R.id.btn_plus2 /* 2131427461 */:
                    Acti_Nissan_Sanwu.this.sendCMD(35, 33);
                    break;
                case R.id.btn_minus3 /* 2131427462 */:
                    Acti_Nissan_Sanwu.this.sendCMD(34, 49);
                    break;
                case R.id.btn_plus3 /* 2131427464 */:
                    Acti_Nissan_Sanwu.this.sendCMD(34, 33);
                    break;
                case R.id.btn_minus4 /* 2131427465 */:
                    Acti_Nissan_Sanwu.this.sendCMD(36, 49);
                    break;
                case R.id.btn_plus4 /* 2131427467 */:
                    Acti_Nissan_Sanwu.this.sendCMD(36, 33);
                    break;
                case R.id.btn_minus5 /* 2131427468 */:
                    Acti_Nissan_Sanwu.this.sendCMD(37, 49);
                    break;
                case R.id.btn_plus5 /* 2131427470 */:
                    Acti_Nissan_Sanwu.this.sendCMD(37, 33);
                    break;
                case R.id.btn_minus6 /* 2131427471 */:
                    Acti_Nissan_Sanwu.this.sendCMD(38, 49);
                    break;
                case R.id.btn_plus6 /* 2131427473 */:
                    Acti_Nissan_Sanwu.this.sendCMD(38, 33);
                    break;
                case R.id.btn_minus7 /* 2131427474 */:
                    Acti_Nissan_Sanwu.this.sendCMD(40, 49);
                    break;
                case R.id.btn_plus7 /* 2131427476 */:
                    Acti_Nissan_Sanwu.this.sendCMD(40, 33);
                    break;
                case R.id.ctv_checkedtext1 /* 2131427554 */:
                    Acti_Nissan_Sanwu.this.sendCMD(41, DataCanbus.DATA[106] != 0 ? 0 : 1);
                    break;
                case R.id.ctv_checkedtext2 /* 2131427576 */:
                    Acti_Nissan_Sanwu.this.sendCMD(39, DataCanbus.DATA[104] != 0 ? 0 : 1);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.Acti_Nissan_Sanwu.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    Acti_Nissan_Sanwu.this.uCarSound(val);
                    break;
                case 99:
                    Acti_Nissan_Sanwu.this.uCarSoundL(val);
                    break;
                case 100:
                    Acti_Nissan_Sanwu.this.uCarSoundH(val);
                    break;
                case 101:
                    Acti_Nissan_Sanwu.this.uCarFieldLR(val);
                    break;
                case 102:
                    Acti_Nissan_Sanwu.this.uCarFieldFB(val);
                    break;
                case 103:
                    Acti_Nissan_Sanwu.this.uCarSpeedLink(val);
                    break;
                case 104:
                    Acti_Nissan_Sanwu.this.uCarBose(val);
                    break;
                case 105:
                    Acti_Nissan_Sanwu.this.uCarRoundVol(val);
                    break;
                case 106:
                    Acti_Nissan_Sanwu.this.uCarFieldDriver(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_324_bnr_nissan);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus3));
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus4));
        setonClick((Button) findViewById(R.id.btn_plus4));
        setonClick((Button) findViewById(R.id.btn_minus5));
        setonClick((Button) findViewById(R.id.btn_plus5));
        setonClick((Button) findViewById(R.id.btn_minus6));
        setonClick((Button) findViewById(R.id.btn_plus6));
        setonClick((Button) findViewById(R.id.btn_minus7));
        setonClick((Button) findViewById(R.id.btn_plus7));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2));
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
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
    }

    protected void uCarSoundL(int val) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarSound(int val) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarSoundH(int val) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarRoundVol(int val) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarSpeedLink(int val) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarFieldLR(int val) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarFieldFB(int val) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarBose(int val) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(val == 1);
        }
    }

    protected void uCarFieldDriver(int val) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(val == 1);
        }
    }
}
